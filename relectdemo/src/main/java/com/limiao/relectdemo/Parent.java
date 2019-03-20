package com.limiao.relectdemo;

/**
 * Created by miao on 2019/3/18.
 */
public class Parent {
    private String name;
    private String age;

    public Parent(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public Parent setAge(String age) {
        this.age = age;
        return this;
    }

    public String getName() {

        return name;
    }

    public Parent setName(String name) {
        this.name = name;
        return this;
    }
}
