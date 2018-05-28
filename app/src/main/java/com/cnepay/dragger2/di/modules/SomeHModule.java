package com.cnepay.dragger2.di.modules;

import com.cnepay.dragger2.bean.SomeHC1;

import dagger.Module;
import dagger.Provides;

/**
 * Created by master on 2018/5/25.
 */

@Module
public class SomeHModule {

    @Provides
    SomeHC1 getSomeH(){
        return new SomeHC1();
    }
}
