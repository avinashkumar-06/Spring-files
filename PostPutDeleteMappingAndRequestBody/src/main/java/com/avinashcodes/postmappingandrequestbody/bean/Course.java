package com.avinashcodes.postmappingandrequestbody.bean;



public class Course {

    private Integer id;
    private String name;

    public Course() {
    }

    public Course(Integer roll, String name) {
        this.id = roll;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
