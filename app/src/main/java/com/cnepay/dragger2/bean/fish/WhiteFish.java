package com.cnepay.dragger2.bean.fish;

import javax.inject.Inject;

/**
 * Created by wangning on 2018/5/24.
 */

public class WhiteFish extends Fish {

    @Inject
    public WhiteFish() {

    }

    @Override
    public String color() {
        return "white";
    }
}
