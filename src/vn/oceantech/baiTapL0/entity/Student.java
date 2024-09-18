package vn.oceantech.baiTapL0.entity;
import vn.oceantech.baiTapL0.util.LevelPool;

import java.util.Date;

public class Student extends Person {
    private String studentCode;
    private String university;
    private int startCourse;
    private double gpa;
    private String level;

    public Student() {

        super();
    }

    public Student(int id, String name, Date dateOfBirth, String address, double height, double weight, String studentCode, String university, int startCourse, double gpa) {
        super(id, name, dateOfBirth, address, height, weight);
        this.studentCode = studentCode;
        this.university = university;
        this.startCourse = startCourse;
        this.gpa = gpa;
    }

    public String getStudentCode() {

        return studentCode;
    }

    public void setStudentCode(String studentCode) {

        this.studentCode = studentCode;
    }

    public String getUniversity() {

        return university;
    }

    public void setUniversity(String university) {

        this.university = university;
    }

    public int getStartCourse() {

        return startCourse;
    }

    public void setStartCourse(int startCourse) {

        this.startCourse = startCourse;
    }

    public double getGpa() {

        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
        setLevel(this.gpa);
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setLevel(double gpa) { // kem -> yeu -> trung binh -> kha -> gioi -> xuat sac
        if(gpa < LevelPool.YEU.getDesc()) {
            setLevel(LevelPool.KEM.getKey());
        } else if(gpa < LevelPool.TRUNG_BINH.getDesc()) {
            setLevel(LevelPool.YEU.getKey());
        } else if(gpa < LevelPool.KHA.getDesc()) {
            setLevel(LevelPool.TRUNG_BINH.getKey());
        } else if(gpa < LevelPool.GIOI.getDesc()) {
            setLevel(LevelPool.KHA.getKey());
        } else if(gpa < LevelPool.XUAT_SAC.getDesc()) {
            setLevel(LevelPool.GIOI.getKey());
        } else {
            setLevel(LevelPool.XUAT_SAC.getKey());
        }
    }
    @Override
    public String toString() {
        return super.toString() +
                ", studentCode='" + studentCode + '\'' +
                ", university='" + university + '\'' +
                ", startCourse=" + startCourse +
                ", gpa=" + gpa +
                ", Level='" + level + '\'';
    }
}
