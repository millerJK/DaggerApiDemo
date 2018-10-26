package com.cnepay.dragger2.di.components;

import com.cnepay.dragger2.bean.SomeClassA1;
import com.cnepay.dragger2.di.modules.SomeClassModule;
import com.cnepay.dragger2.di.scopes.ActivityScope;

import dagger.Component;

/**
 * Created by master on 2018/5/25.
 */

@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = SomeClassModule.class)
public interface SubParentComponent {

    SomeClassA1 getSomeClassA1(); //这个方法也只能在Dependence 形式的时候起作用,在SubComponent形式不起作用

    SubSonComponent.Builder sonComponent();    // 用来创建 Subcomponent

}
