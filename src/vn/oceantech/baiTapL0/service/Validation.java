package vn.oceantech.baiTapL0.service;

import vn.oceantech.baiTapL0.entity.Student;
import vn.oceantech.baiTapL0.util.AppConstants;
import vn.oceantech.baiTapL0.util.AppUtil;
import vn.oceantech.baiTapL0.util.InputPool;
import vn.oceantech.baiTapL0.util.StringPool;
import java.text.ParseException;
import java.util.*;
import java.util.stream.IntStream;

public class Validation {
    // input value: int, double, code
    private static Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) {
        int n;
        while(true) {
            try {
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine());
                if(min <= n && n <= max) break;
                throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                if(max != min) {
                    System.out.println(StringPool.PLEASE_INTEGER_RANGE + min + StringPool.RIGHT_ARROW + max);
                } else {
                    System.out.println(StringPool.PLEASE_INTEGER_EQUAL + min);
                }
            }
        }
        return n;
    }

    public static double getDouble(String msg, double min, double max) {
        double n;
        while (true) {
            try {
                System.out.print(msg);
                n = Double.parseDouble(sc.nextLine());
                if (min <= n && n <= max) break;
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println(StringPool.PLEASE_REAL_RANGE + min + StringPool.RIGHT_ARROW +max);
            }
        }
        return n;
    }

    public static String getString(String msg,int minLength, int maxLength) {
        String s;
        while (true) {
            System.out.print(msg);
            s = sc.nextLine();
            if(s.isEmpty()) {
                System.out.println(StringPool.ERROR_EMPTY);
            } else if(s.length() <= maxLength) {
                if(AppConstants.SPECIAL_CHARACTER_PATTERN.matcher(s).find()) {
                    System.out.println(StringPool.ERROR_SPECIAL_CHARACtERS);
                    continue;
                }
                break;
            } else {
                System.out.println(StringPool.PLEASE_STRING_LENGTH_RANGE + minLength + StringPool.RIGHT_ARROW  + maxLength);
            }
        }
        return s;
    }

    public static String getString(String msg,int length) {
        String s;
        while (true) {
            System.out.print(msg);
            s = sc.nextLine();
            if(s.isEmpty()) {
                System.out.println(StringPool.ERROR_EMPTY);
            } else if(s.length() == length) {
                if(AppConstants.SPECIAL_CHARACTER_PATTERN.matcher(s).find()) {
                    System.out.println(StringPool.ERROR_SPECIAL_CHARACtERS);
                    continue;
                }
                break;
            } else {
                System.out.println(StringPool.PLEASE_STRING_LENGTH_EQUAL + length);
            }
        }
        return s;
    }

    public static int getIndexOfStudentById(int id, List<Student> students, int count) {
            return IntStream.range(0, count)
                    .filter(i -> id == students.get(i).getId())
                    .findFirst().orElse(AppConstants.NOT_FOUND);
    }

    public static Date getDate(String msg, Date startDate, Date endDate, String dateFormat){
        Date date;
        String dateStr;
        while (true) {
            System.out.print(msg);
            dateStr = sc.nextLine();
            if(AppUtil.isValidFormat(dateStr)) {
                // perform the validation on the date
                date = AppUtil.parse(dateStr, dateFormat);
                if(date != null) { // valid
                    if(date.before(startDate)) {
                        System.out.println(StringPool.ERROR_START_DATE + AppUtil.convertDateToString(startDate));
                        continue;
                    }
                    if(date.after(endDate)) {
                        System.out.println(StringPool.ERROR_END_DATE_BEFORE_CURRENT_DATE + AppUtil.convertDateToString(endDate));
                        continue;
                    }
                } else { // invalid
                    System.out.println(StringPool.ERROR_DATE_NOT_EXIST);
                    continue;
                }
            } else {
                System.out.println(StringPool.ERROR_DATE_NOT_FORMAT + dateFormat);
                continue;
            }
            return date;
        }
    }
    public static String getCode(int mode, List<Student> listStudent, int counter) throws ParseException {
        while(true) {
            String studentCode= (String) InputPool.STUDENT_CODE.input();
            // mode 1 -> nhập mới
            // mode 2 -> update
            if(counter == AppConstants.INIT_COUNTER) {
                return studentCode;
            }

            Student result = listStudent.stream().filter(st->st.getStudentCode().equals(studentCode)).findFirst().orElse(null);
            if(result == null || (mode == AppConstants.UPDATE_MODE_CODE && result != null)) { 
                return studentCode;                                                           
            }                                                                                
            System.out.println(StringPool.ERROR_DUPLICATE_CODE);
        }
    }
}
