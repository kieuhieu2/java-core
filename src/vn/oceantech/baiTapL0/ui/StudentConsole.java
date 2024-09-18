package vn.oceantech.baiTapL0.ui;

import vn.oceantech.baiTapL0.service.StudentService;
import vn.oceantech.baiTapL0.service.Validation;
import vn.oceantech.baiTapL0.entity.Student;
import vn.oceantech.baiTapL0.util.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudentConsole {
    private StudentService sm;
    private Scanner sc;

    public StudentConsole() {
        this.sc = new Scanner(System.in);
    }

    private static void displayMainHeader() {
        System.out.print("-------------------------------------------------------------------------------");
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("           ** WELCOME TO STUDENT MANAGEMENT SYSTEM**      ");
        System.out.println("\n-----------------------------------------------------------------------------");

    }

    private static void displayOption() {
        System.out.println("\n                                OPTIONS");
        System.out.println("-----------------------------------------------------------------------------------");
        IntStream.range(0, OptionsUtil.values().length).forEach(index-> System.out.print(String.valueOf(index + 1)
                + CharPool.DOT + OptionsUtil.values()[index].getKey() + StringPool.DOUBLE_TAB));
        System.out.println("\n-----------------------------------------------------------------------------");
    }

    private static void displayMainMenu() {
        IntStream.range(0, MenuUtil.values().length)
                .forEach(index-> {
                    System.out.printf(String.format("%" +AppConstants.FORMAT_SIZE+ "s",String.valueOf(index)
                            + CharPool.DOT + MenuUtil.values()[index].getValue()));
                    System.out.print(index % AppConstants.DEFAULT_COLUMN_MENU == 0 ?
                            CharPool.NEW_LINE : StringPool.EMPTY);
                });
        System.out.println("\n-----------------------------------------------------------------------");
    }

    private static void displayMenuUpdate() {
        // 1.Name 2...
        IntStream.range(0, InputPool.values().length).forEach(index-> System.out.print(String.valueOf(index + 1)
                + CharPool.DOT +  InputPool.values()[index].getValue() + CharPool.TAB));
    }

    private static void displayMenuLevel() {
        IntStream.range(0, LevelPool.values().length).forEach(index-> System.out.print(String.valueOf(index + 1)
                + CharPool.DOT + LevelPool.values()[index].getKey() + CharPool.TAB));;
    }
    public static void displaySectionHeader(String section) {
        System.out.println("\t--------------------------------------------");
        System.out.println("\t             **"+section+"**       ");
        System.out.println("\t--------------------------------------------");
    }

    public static void displayPercent(Map<String, Integer> mapPercent,int counter, String criteria) {
        System.out.println(String.format("%-10s  %-5s", " ", StringPool.PERCENT + "(" + CharPool.PERCENT + ")"));
        System.out.println(String.format("%-10s  %-5s", criteria, "(" + StringPool.DESC + ")"));
        System.out.println("------     -----------");
        for (String key : mapPercent.keySet() ) {
            System.out.println(String.format("%-10s  %2$.1f", key,  (float)mapPercent.get(key) * 100 / counter));
            System.out.println("----------------------");
        }
    }

    public static int getSelect(String msg, int min, int max) {
        return Validation.getInt(msg, min, max);
    }

    public void start() throws ParseException, IOException {
        displayMainHeader();
        int status = AppConstants.DEFAULT_STATUS, s1, s3, s4, s6, s8;
        while (true) {
            option: {
            displayOption();
            int selectedOption = getSelect(StringPool.OPTION, AppConstants.NUMBER_1, OptionsUtil.values().length);
            this.initArrayOrListStudent(selectedOption - 1);
            if(OptionsUtil.values()[selectedOption - 1].getKey().equals(OptionsUtil.EXIT_PROGRAM.getKey())) {
                System.out.print(StringPool.TO_LEAVE);
                String reply = sc.nextLine();
                if (reply.equalsIgnoreCase(StringPool.NO)) {
                    continue ;
                }
                System.exit(0);
            }
            while (status == AppConstants.CONTINUE) {
                displayMainMenu();
                int selectedMainMenu = Validation.getInt(StringPool.CHOICE,
                        AppConstants.NUMBER_0, MenuUtil.values().length);
                switch (MenuUtil.values()[selectedMainMenu]) {
                    case EXIT:
                        this.writeToFile();
                        break option;
                    case ADD:
                        s1 = AppConstants.INIT_STATUS;
                        while (s1 == AppConstants.CONTINUE) {
                            this.addNewStudent();
                            s1 = Validation.getInt(StringPool.TO_BACK_MAIN_MENU,
                                    AppConstants.NUMBER_0, AppConstants.NUMBER_1);
                        }
                        break;
                    case SHOW_ALL:
                        this.showAll();
                        break;
                    case REMOVE_STUDENT:
                        s3 = AppConstants.INIT_STATUS;
                        while (s3 == AppConstants.CONTINUE) {
                            this.removeStudent();
                            s3 = Validation.getInt(StringPool.TO_BACK_MAIN_MENU,
                                    AppConstants.NUMBER_0, AppConstants.NUMBER_1);
                        }
                        break;
                    case FIND_STUDENT:
                        s4 = AppConstants.INIT_STATUS;
                        while (s4 == AppConstants.CONTINUE) {
                            this.findStudentById();
                            s4 = Validation.getInt(StringPool.TO_BACK_MAIN_MENU,
                                    AppConstants.NUMBER_0, AppConstants.NUMBER_1);
                        }
                        break;
                    case PERCENTAGE_BY_LEVEL:
                        this.showPercentageByLevel();
                        break;
                    case LIST_STUDENT_BY_LEVEL:
                        s6 = AppConstants.INIT_STATUS;
                        while (s6 == AppConstants.CONTINUE) {
                            this.displayStudentByLevel();
                            s6 = Validation.getInt(StringPool.TO_BACK_MAIN_MENU,
                                    AppConstants.NUMBER_0, AppConstants.NUMBER_1);
                        }
                        break;
                    case PERCENTAGE_BY_GPA:
                        this.showPercentageByGPA();
                        break;
                    case UPDATE:
                        s8 = AppConstants.INIT_STATUS;
                        while (s8 == AppConstants.CONTINUE) {
                            this.updateStudent();
                            s8 = Validation.getInt(StringPool.UPDATE_TO_BACK_MAIN_MENU,
                                    AppConstants.NUMBER_0, AppConstants.NUMBER_1);
                        }
                        break;
                }

                status = Validation.getInt(StringPool.TO_MAIN_MENU, AppConstants.NUMBER_1, AppConstants.NUMBER_1);
            }
        }
        }
    }

    public void initArrayOrListStudent(int index) {
        this.sm = (StudentService) OptionsUtil.values()[index].getDesc();
        displaySectionHeader(OptionsUtil.values()[index].getKey());
    }
    public void addNewStudent() throws ParseException {
        // nhap ban phim
        Student newStudent = new Student();
        newStudent.setId(this.generateID());
        newStudent.setName((String) InputPool.NAME.input());
        newStudent.setDateOfBirth((Date) InputPool.DATE_OF_BIRTH.input());
        newStudent.setAddress((String) InputPool.ADDRESS.input());
        newStudent.setHeight((Double) InputPool.HEIGHT.input());
        newStudent.setWeight((Double) InputPool.WEIGHT.input());
        newStudent.setStudentCode(Validation.getCode(AppConstants.INPUT_MODE_CODE,
                this.sm.getAllStudent(), this.sm.getCounter()));
        newStudent.setUniversity((String) InputPool.UNIVERSITY.input());
        newStudent.setStartCourse((Integer) InputPool.START_COURSE.input());
        newStudent.setGpa((Double) InputPool.GPA.input());

        this.sm.addStudent(newStudent);
        this.updateMaxID();
    }

    private void showAll() {
        System.out.println("---All student---");
        List<Student> listStudent = this.sm.getAllStudent();

        if(listStudent.size()==AppConstants.NUMBER_0) {
            System.out.println(StringPool.DATA_EMPTY);
            return;
        }
        listStudent.forEach(System.out::println);
    }

    private void removeStudent() {
        if(this.sm.getCounter() == AppConstants.NUMBER_0) {
            System.out.println(StringPool.DATA_EMPTY);
            return;
        }
        int id = Validation.getInt(StringPool.FIND_STUDENT_BY_ID_TO_DELETE, AppConstants.NUMBER_0, Integer.MAX_VALUE);
        if(!this.sm.deleteStudent(id)) {
            System.out.println(StringPool.DELETE_FAILED);
            return;
        }

        System.out.println(StringPool.DELETE_SUCCESS);
    }

    private void showPercentageByLevel() {
        List<String> levels =
                this.sm.getAllStudent().stream().map(st->st.getLevel().toString()).collect(Collectors.toList());
        Map<String, Integer> mapPercent =  AppUtil.findFrequencyUtil(levels, this.sm.getCounter());

        displayPercent(mapPercent, this.sm.getCounter(), StringPool.LEVEL);
    }

    private void showPercentageByGPA() {
        List<String> listGPA =
                this.sm.getAllStudent().stream().map(st->String.valueOf(st.getGpa())).collect(Collectors.toList());
        Map<String, Integer> mapPercent = AppUtil.findFrequencyUtil(listGPA, this.sm.getCounter());

        displayPercent(mapPercent, this.sm.getCounter(), StringPool.GPA);
    }

    private void findStudentById() {
        if(this.sm.getCounter() == AppConstants.INIT_COUNTER) {
            System.out.println(StringPool.DATA_EMPTY);
            return;
        }
        int id = Validation.getInt(StringPool.FIND_STUDENT_BY_ID, AppConstants.NUMBER_0, Integer.MAX_VALUE);
        Optional<Student> st = this.sm.findStudentById(id);
        if(!st.isPresent()) {
            System.out.println(StringPool.NOT_FOUND);
        } else {
            System.out.println(StringPool.FOUND_RESULT);
            System.out.println(st);
        }
    }
    private void displayStudentByLevel() {
        if(this.sm.getCounter() == AppConstants.NUMBER_0) {
            System.out.println(StringPool.DATA_EMPTY);
            return;
        }
        displayMenuLevel();

        int numLevel = Validation.getInt(String.format("\nChọn level(%d-%d):", AppConstants.NUMBER_1, LevelPool.values().length), AppConstants.NUMBER_1, LevelPool.values().length);

        String level = Arrays.stream(LevelPool.values()).collect(Collectors.toList()).get(numLevel - 1).getKey();
        List<Student> listStudent = this.sm.getAllStudent().stream().filter(st->st.getLevel().equals(level)).collect(Collectors.toList());

        if(listStudent == null || listStudent.size() == AppConstants.NUMBER_0){
            System.out.println(StringPool.NOT_FOUND);
            return;
        }
        System.out.println(StringPool.FOUND_RESULT + listStudent.size() + StringPool.RECORD);
        listStudent.forEach(System.out::println);
    }
    private void updateStudent() throws ParseException {
        if(this.sm.getCounter() == AppConstants.NUMBER_0) {
            System.out.println(StringPool.DATA_EMPTY);
            return;
        }
        int id = Validation.getInt(StringPool.FIND_STUDENT_BY_ID_TO_UPDATE, AppConstants.NUMBER_0, Integer.MAX_VALUE);

        int  index = Validation.getIndexOfStudentById(id, this.sm.getAllStudent(), this.sm.getCounter());

            if(index == AppConstants.NOT_FOUND) {
                System.out.println(StringPool.NOT_FOUND);
            } else {
                int continueUpdate = AppConstants.CONTINUE;
                while (continueUpdate == AppConstants.CONTINUE) {
                    displayMenuUpdate();
                    System.out.println();
                    int selectedUpdate = Validation.getInt(StringPool.CHOICE_UPDATE, AppConstants.NUMBER_1, InputPool.values().length);
                    this.sm.updateStudentById(index, InputPool.values()[selectedUpdate - 1]);
                    continueUpdate = Validation.getInt(StringPool.CONTINUE_UPDATE, AppConstants.NUMBER_0, AppConstants.NUMBER_1);
                }
                System.out.println(StringPool.UPDATE_SUCCESS);
                System.out.println(this.sm.findStudentById(id));
        }
    }

    private  int generateID() {
        int id = 1;
        int maxID = this.sm.getMaxID();
        if(maxID != 0)
            id = maxID + 1;
        return id;
    }

    public void updateMaxID() {
        int maxID = sm.getMaxID() + 1;
        this.sm.setMaxID(maxID);
    }

    public void writeToFile(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nEnter the name of the file you want to write: ");

        // Ignore blank space and empty lines
        String fileName = keyboard.nextLine().trim();
        while (fileName.length() < 1) {
            fileName = keyboard.nextLine();
        }

        int numOfLines = sm.getCounter();

        StringBuilder stringBuilder = new StringBuilder();
        for (int x = 0; x < numOfLines; x++) {
            String line = this.sm.getAllStudent().get(x).toString();
            stringBuilder.append(line);

            // Don't add a new line to the last line
            if (x < numOfLines - 1) {
                stringBuilder.append(CharPool.NEW_LINE);
            }
        }

        // Should probably prompt the user if he wants to overwrite or
        // append if the file exists.
        if (FileUtil.doesFileExist(fileName)) {
            // append to file
            try {
                FileUtil.appendToFile(fileName, stringBuilder.toString());
            } catch (IOException e) {
                System.out.printf("\nAn error occurred while writing to file %s.\n", fileName);
                System.out.printf("Error message: %s.\n", e.getMessage());
            }
        } else {
            try {
                FileUtil.writeToFile(fileName, stringBuilder.toString());
            } catch (IOException e) {
                System.out.printf("\nAn error occurred while writing to file %s.\n", fileName);
                System.out.printf("Error message: %s.\n", e.getMessage());
            }
        }
    }
}