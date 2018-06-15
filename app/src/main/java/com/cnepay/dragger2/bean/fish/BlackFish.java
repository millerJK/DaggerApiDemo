package com.cnepay.dragger2.bean.fish;

import javax.inject.Inject;

/**
 * Created by master on 2018/5/24.
 */

public class BlackFish extends Fish {

    @Inject
    public BlackFish(){

    }

    @Override
    public String color() {
        return "black";
    }
}
