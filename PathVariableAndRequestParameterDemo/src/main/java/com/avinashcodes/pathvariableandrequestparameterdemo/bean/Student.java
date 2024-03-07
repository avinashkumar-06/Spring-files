package com.avinashcodes.pathvariableandrequestparameterdemo.bean;

public class Student {

    private Integer roll;

    private String name;

    private String city;

    public Student() {
    }

    public Student(Integer roll, String name, String city) {
        this.roll = roll;
        this.name = name;
        this.city = city;
    }


    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
