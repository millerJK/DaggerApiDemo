package com.cnepay.dragger2.di.components;

import com.cnepay.dragger2.QualiferActivity;
import com.cnepay.dragger2.di.modules.QualiferModule;

import dagger.Component;

/**
 * Created by master on 2018/9/18.
 */

@Component(modules = {QualiferModule.class})
public interface QualiferComponent {


    void injectQualiferActivity(QualiferActivity activity);
}
