package com.cnepay.dragger2;

import android.app.Activity;
import android.app.Application;

import com.cnepay.dragger2.bean.SomeHC1;
import com.cnepay.dragger2.bean.Student;
import com.cnepay.dragger2.di.components.AppComponent;
import com.cnepay.dragger2.di.components.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


/**
 * Application中主要阐述SubComponent和Dependencies 使用
 */
public class MyApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    private String TAG = MyApplication.class.getSimpleName();

    private static MyApplication app;

    AppComponent mAppComponent;

    @Inject
    SomeHC1 someHc1;

    @Inject
    SomeHC1 someHc11;

    @Inject
    Student student;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().application(this).build();
        mAppComponent.injectMainApp(this);

        app = this;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }


    public static MyApplication getApp() {
        return app;
    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
}
