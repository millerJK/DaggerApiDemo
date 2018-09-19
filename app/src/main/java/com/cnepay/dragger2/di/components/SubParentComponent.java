package com.cnepay.dragger2.di.components;

import com.cnepay.dragger2.bean.SomeClassA1;
import com.cnepay.dragger2.di.modules.AbsBindModule;
import com.cnepay.dragger2.di.modules.SomeClassModule;

import dagger.Component;

/**
 * Created by master on 2018/5/25.
 */

@Component(modules = {SomeClassModule.class, AbsBindModule.class})
public interface SubParentComponent {

    SomeClassA1 getSomeClassA1();

    SubSonComponent.Builder sonComponent();    // 用来创建 Subcomponent

}
