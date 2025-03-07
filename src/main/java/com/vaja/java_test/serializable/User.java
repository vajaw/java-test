package com.vaja.java_test.serializable;

import java.io.Serializable;

import java.io.Serializable;

public class User implements Serializable {
    // 为什么有serialVersionUID？
    //      如果指定了serialVersionUID，则说明类新增字段是可以兼容的
    //      如果没指定serialVersionUID，则说明类新增字段是不兼容
    // 可以简单测试一下 （不设置serialVersionUID）
    //      1、先序列化User
    //      2、User代码中新增字段
    //      3、反序列化 代码将会报错

    private static final long serialVersionUID = 1L;
    private String name;

    private String sex;
    private transient int age; // `transient` 关键字表示此属性不会被序列化

    // 构造器、Getter 和 Setter 省略


    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

