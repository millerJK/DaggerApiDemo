package com.cnepay.dragger2.di.components;

import com.cnepay.dragger2.InjectActivity;

import dagger.Component;

/**
 * Created by master on 2018/10/25.
 */

@Component
public interface InjectComponent {

    void injectInjectActivity(InjectActivity activity);
}
