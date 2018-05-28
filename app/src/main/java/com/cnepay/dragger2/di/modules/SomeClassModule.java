package com.cnepay.dragger2.di.modules;

import com.cnepay.dragger2.bean.SomeClassA1;
import com.cnepay.dragger2.bean.SomeClassB1;
import com.cnepay.dragger2.di.components.MainComponent;

import dagger.Module;
import dagger.Provides;

/**
 * Created by master on 2018/5/25.
 */

@Module(subcomponents = MainComponent.class)
public class SomeClassModule {

    @Provides
    SomeClassA1 getClassA1() {
        return new SomeClassA1();
    }

    @Provides
    SomeClassB1 getClassB1() {
        return new SomeClassB1();
    }
}
