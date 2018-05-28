package com.cnepay.dragger2;

import android.app.Application;

import com.cnepay.dragger2.bean.Student;
import com.cnepay.dragger2.di.components.AppComponent;
import com.cnepay.dragger2.di.components.DaggerAppComponent;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Inject;

/**
 * Created by master on 2018/5/23.
 */

public class MyApplication extends Application {

    private static final String TAG = "MyApplication";

    AppComponent mAppComponent;

    @Inject
    OkHttpClient okHttpClient;

    @Inject
    Student student;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.create();
        mAppComponent.injectMainApp(this);
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
