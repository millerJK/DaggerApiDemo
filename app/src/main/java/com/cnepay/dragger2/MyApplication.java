package com.cnepay.dragger2;

import android.app.Application;

import com.cnepay.dragger2.bean.SomeHC2;
import com.cnepay.dragger2.bean.Student;
import com.cnepay.dragger2.di.components.AppComponent;
import com.cnepay.dragger2.di.components.DaggerAppComponent;
import com.cnepay.dragger2.di.modules.AppModule;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Inject;

/**
 * Created by master on 2018/5/23.
 * Dependence 和 subComponent 而SubComponent的只是父Component中的一部分，在Scope上和父Component并没有什么限制
 */

public class MyApplication extends Application {

    private static final String TAG = "MyApplication";

    private static MyApplication app;

    AppComponent mAppComponent;

    @Inject
    OkHttpClient okHttpClient;

    @Inject
    Student student;

    @Inject
    SomeHC2 someHc2;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        mAppComponent.injectMainApp(this);
        app = this;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }


    public static MyApplication getApp() {
        return app;
    }


}
