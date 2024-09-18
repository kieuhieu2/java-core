package vn.oceantech.baiTapL0.entity;

import vn.oceantech.baiTapL0.util.AppUtil;

import java.util.Date;

public class Person {
    protected int id;
    protected String name;
    protected Date dateOfBirth;
    protected String address;
    protected double height;
    protected double weight;

    public Person() {

    }

    public Person(int id, String name, Date dateOfBirth, String address, double height, double weight) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.height = height;
        this.weight = weight;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Date getDateOfBirth() {

        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public double getHeight() {

        return height;
    }

    public void setHeight(double height) {

        this.height = height;
    }

    public double getWeight() {

        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + AppUtil.convertDateToString(this.dateOfBirth) +
                ", address='" + address + '\'' +
                ", height=" + height +
                ", weight=" + weight;
    }
}
