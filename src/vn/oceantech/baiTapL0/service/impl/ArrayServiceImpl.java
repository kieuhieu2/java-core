package vn.oceantech.baiTapL0.service.impl;

import vn.oceantech.baiTapL0.entity.Student;
import vn.oceantech.baiTapL0.service.StudentService;
import vn.oceantech.baiTapL0.entity.Student;
import vn.oceantech.baiTapL0.service.Validation;
import vn.oceantech.baiTapL0.util.*;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayServiceImpl implements StudentService {

    private Student[] arrStudent;
    private int counter;
    private int sizeOfArray;
    static int maxID = AppConstants.NUMBER_0; // chua co sinh vien nao.

    // khoi tao mang ban dau de nhap 1 doi tuong
    public ArrayServiceImpl() {
        this.sizeOfArray = AppConstants.DEFAULT_SIZE_ARRAY;
        this.arrStudent = new Student[this.sizeOfArray];
        this.counter = AppConstants.INIT_COUNTER;
    }

    @Override
    public void addStudent(Student newStudent) {
        System.out.println(StringPool.ADD_SUCCESS);
        if (this.counter == this.sizeOfArray) {
            this.growSize();
        }

        this.arrStudent[this.counter] = newStudent;
        this.counter++;
    }

    @Override
    public Optional<Student> findStudentById(int studentId) {
        return this.getAllStudent().stream().filter(st->st.getId() == studentId).findFirst();
    }

    @Override
    public void updateStudentById(int indexOfStudentUpdate, InputPool ipPool) throws ParseException {
        if(ipPool.equals(InputPool.NAME))
            this.arrStudent[indexOfStudentUpdate].setName((String)ipPool.input());
        if(ipPool.equals(InputPool.DATE_OF_BIRTH))
            this.arrStudent[indexOfStudentUpdate].setDateOfBirth((Date)ipPool.input());
        if(ipPool.equals(InputPool.STUDENT_CODE)) {
            while (true) {
                String studentCode = Validation.getCode(AppConstants.UPDATE_MODE_CODE, this.getAllStudent(), this.counter);
                int result = IntStream.range(0, this.counter).filter(i->this.arrStudent[i].getStudentCode().equals(studentCode)).findFirst().orElse(-1);
                if(result != -1 && result != indexOfStudentUpdate) {
                    System.out.println(StringPool.ERROR_DUPLICATE_CODE);
                    continue;
                }
                this.arrStudent[indexOfStudentUpdate].setStudentCode(studentCode);
                break;
            }

        }
        if(ipPool.equals(InputPool.GPA))
            this.arrStudent[indexOfStudentUpdate].setGpa((Double)ipPool.input());
        if(ipPool.equals(InputPool.ADDRESS))
            this.arrStudent[indexOfStudentUpdate].setAddress((String)ipPool.input());
        if(ipPool.equals(InputPool.HEIGHT))
            this.arrStudent[indexOfStudentUpdate].setHeight((double)ipPool.input());
        if(ipPool.equals(InputPool.WEIGHT))
            this.arrStudent[indexOfStudentUpdate].setWeight((double)ipPool.input());
        if(ipPool.equals(InputPool.START_COURSE))
            this.arrStudent[indexOfStudentUpdate].setStartCourse((int)ipPool.input());
        if(ipPool.equals(InputPool.UNIVERSITY))
            this.arrStudent[indexOfStudentUpdate].setUniversity((String)ipPool.input());
    }

    @Override
    public boolean deleteStudent(int deletedStudentId) {
        int index = IntStream.range(0, this.counter).filter(i->this.arrStudent[i].getId()==deletedStudentId).findFirst().orElse(AppConstants.NOT_FOUND);
        if(index == AppConstants.NOT_FOUND) {
            return false;
        }
        for (int i = index; i < this.counter - 1; i++) {
            this.arrStudent[i] = this.arrStudent[i + 1];
        }
        this.arrStudent[this.counter - 1] = null;

        // update counter and size of array;
        this.counter--;
        this.sizeOfArray--;
        return true;
    }

    @Override
    public int getCounter() {
        return this.counter;
    }

    @Override
    public List<Student> getAllStudent() {
        return Arrays.stream(this.arrStudent).filter(st->st!=null).collect(Collectors.toList());
    }

    @Override
    public int getMaxID() {
        return this.maxID;
    }

    @Override
    public void setMaxID(int newMaxID) {
        this.maxID = newMaxID;
    }

    public void growSize()
    {
        //declares a temp[] array
        Student temp[] = null;
        if (this.counter == this.sizeOfArray)
        {
            //initialize a size array of array
            temp = new Student[this.sizeOfArray + AppConstants.AUTO_INCREMENT_SIZE];
            {
                for (int i = 0; i < this.sizeOfArray; i++)
                {
                    //copies all the elements of the old array
                    temp[i] = this.arrStudent[i];
                }
            }
        }
        this.arrStudent = temp;
        this.sizeOfArray= sizeOfArray + AppConstants.AUTO_INCREMENT_SIZE;
    }
}
