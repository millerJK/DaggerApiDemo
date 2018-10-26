package com.cnepay.dragger2.lifecycle;

import com.cnepay.dragger2.mvp.IModel;

import javax.inject.Inject;

/**
 * Created by master on 2018/9/26.
 */

public class UserModel implements IModel {

    @Inject
    public UserModel() {
    }

    @Override
    public void onDestroy() {

    }
}
