package com.cnepay.dragger2.di.modules;

import android.content.Context;

import com.cnepay.dragger2.MyApplication;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by master on 2018/5/24.
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
    @Singleton
    MyApplication provideApplication() {
        return MyApplication.getApp();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    Context getApplication() {
        return mApplication;
    }
}
