package vn.oceantech.baiTapL0.service;

import vn.oceantech.baiTapL0.entity.Student;
import vn.oceantech.baiTapL0.entity.Student;
import vn.oceantech.baiTapL0.util.InputPool;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    void addStudent(Student st);
    Optional<Student> findStudentById(int id);
    void updateStudentById(int index, InputPool ipPool) throws ParseException;
    boolean deleteStudent(int id);
    int getCounter();
    List<Student> getAllStudent();
    int getMaxID();
    void setMaxID(int newMaxID);
}
