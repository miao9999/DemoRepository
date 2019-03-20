package com.limiao.daggerdemo;

/**
 * Created by miao on 2019/3/11.
 */
public class Student extends Person{
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }
}
