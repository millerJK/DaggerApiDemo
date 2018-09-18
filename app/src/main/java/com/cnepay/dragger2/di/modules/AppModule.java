package com.cnepay.dragger2.di.modules;

import com.cnepay.dragger2.MyApplication;
import com.cnepay.dragger2.bean.SomeClassD1;
import com.cnepay.dragger2.bean.SomeHC1;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by master on 2018/5/24.
 * <p>
 * module 主要是为第三方module设计
 */

@Module
public class AppModule {

    private MyApplication mApplication;

    public AppModule() {
    }

    public AppModule(MyApplication context) {
        this.mApplication = context;
    }


    @Provides
    SomeClassD1 provideSomeClassD1(SomeHC1 someHC1) {
        return new SomeClassD1(someHC1);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    MyApplication getApplication() {
        return mApplication;
    }
}
