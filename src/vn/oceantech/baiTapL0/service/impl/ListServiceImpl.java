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

public class ListServiceImpl implements StudentService {
    private List<Student> listStudent;
    static int maxID = AppConstants.NUMBER_0; // chua co sinh vien nao.

    public ListServiceImpl() {
        this.listStudent = new ArrayList();
    }

    @Override
    public void addStudent(Student st) {
        this.listStudent.add(st);

        System.out.println(StringPool.ADD_SUCCESS);
    }

    @Override
    public Optional<Student> findStudentById(int id) {
        return this.listStudent.stream().filter(st->st.getId() == id).findFirst();
    }

    @Override
    public void updateStudentById(int indexOfStudentUpdate, InputPool udPool) throws ParseException {
        if(udPool.equals(InputPool.NAME))
            this.listStudent.get(indexOfStudentUpdate).setName((String)udPool.input());
        if(udPool.equals(InputPool.DATE_OF_BIRTH))
            this.listStudent.get(indexOfStudentUpdate).setDateOfBirth((Date)udPool.input());
        if(udPool.equals(InputPool.STUDENT_CODE)) {
            while (true) {
                String studentCode = Validation.getCode(AppConstants.UPDATE_MODE_CODE, this.getAllStudent(), this.getCounter());
                int result = IntStream.range(0, this.getCounter()).filter(i->this.listStudent.get(i).getStudentCode().equals(studentCode)).findFirst().orElse(AppConstants.NOT_FOUND);
                if(result != -1 && result != indexOfStudentUpdate) {
                    System.out.println(StringPool.ERROR_DUPLICATE_CODE);
                    continue;
                }
                this.listStudent.get(indexOfStudentUpdate).setStudentCode(studentCode);
                break;
            }
        }
        if(udPool.equals(InputPool.GPA))
            this.listStudent.get(indexOfStudentUpdate).setGpa((Double)udPool.input());
        if(udPool.equals(InputPool.ADDRESS))
            this.listStudent.get(indexOfStudentUpdate).setAddress((String)udPool.input());
        if(udPool.equals(InputPool.HEIGHT))
            this.listStudent.get(indexOfStudentUpdate).setHeight((double)udPool.input());
        if(udPool.equals(InputPool.WEIGHT))
            this.listStudent.get(indexOfStudentUpdate).setWeight((double)udPool.input());
        if(udPool.equals(InputPool.START_COURSE))
            this.listStudent.get(indexOfStudentUpdate).setStartCourse((int)udPool.input());
        if(udPool.equals(InputPool.UNIVERSITY))
            this.listStudent.get(indexOfStudentUpdate).setUniversity((String)udPool.input());
    }

    @Override
    public boolean deleteStudent(int deletedId) {
        Student result = this.listStudent.stream().filter(st->st.getId()==deletedId).findFirst().orElse(null);
        if(result == null) {
            return false;
        }
        this.listStudent.remove(result);
        return true;
    }

    @Override
    public int getCounter() {
        return this.listStudent.size();
    }

    @Override
    public List<Student> getAllStudent() {
        return this.listStudent.stream().filter(st->st!=null).collect(Collectors.toList());
    }

    @Override
    public int getMaxID() {
        return this.maxID;
    }

    @Override
    public void setMaxID(int newMaxID) {
        this.maxID = newMaxID;
    }
}
