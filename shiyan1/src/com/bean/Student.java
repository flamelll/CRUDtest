package com.bean;

public class Student {
    private String num;
    private String name;

    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Student( String name, String num) {
        super();
        this.num = num;
        this.name = name;
    }
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
