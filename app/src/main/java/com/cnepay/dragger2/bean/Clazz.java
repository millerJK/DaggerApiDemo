package com.cnepay.dragger2.bean;

import javax.inject.Inject;

/**
 * Created by master on 2018/5/23.
 */

public class Clazz {

    @Inject
    public Clazz() {
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
