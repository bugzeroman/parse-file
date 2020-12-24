package com.google.gson.entity;

import com.google.gson.annotations.Expose;

public class Person {
    private int age = 18;
    @Expose
    private String name = "王小二";
    // 使用transient修饰的字段不会被序列化
    private transient int sex = 1;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }
}
