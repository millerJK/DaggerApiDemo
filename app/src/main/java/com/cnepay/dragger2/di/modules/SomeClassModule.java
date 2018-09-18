package com.cnepay.dragger2.di.modules;

import com.cnepay.dragger2.bean.SomeClassA1;
import com.cnepay.dragger2.bean.SomeClassB1;
import com.cnepay.dragger2.di.components.SubSonComponent;

import dagger.Module;
import dagger.Provides;

/**
 * Created by master on 2018/5/25.
 */

@Module(subcomponents = SubSonComponent.class)
public abstract class SomeClassModule {

    @Provides
    static SomeClassA1 getClassA1() {
        return new SomeClassA1();
    }

    @Provides
    static SomeClassB1 getClassB1() {
        return new SomeClassB1();
    }

}
