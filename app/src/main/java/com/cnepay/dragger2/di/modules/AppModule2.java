package com.cnepay.dragger2.di.modules;

import com.cnepay.dragger2.bean.SomeHC1;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by master on 2018/6/17.
 */

@Module
public class AppModule2 {

    @Singleton
    @Provides
    SomeHC1 provideSomeHc1() {
        return new SomeHC1();
    }

}
