package com.cnepay.dragger2.bean;

import javax.inject.Inject;

/**
 * Created by master on 2018/5/23.
 */

public class Human {

    private String name;
    private int age;

    @Inject
    public Human() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
