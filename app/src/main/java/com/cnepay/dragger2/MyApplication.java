package com.cnepay.dragger2;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import com.cnepay.dragger2.bean.SomeClassD1;
import com.cnepay.dragger2.bean.SomeHC1;
import com.cnepay.dragger2.bean.SomeHC2;
import com.cnepay.dragger2.bean.Student;
import com.cnepay.dragger2.di.components.AppComponent;
import com.cnepay.dragger2.di.components.DaggerAppComponent;
import com.cnepay.dragger2.di.modules.AppModule;
import com.squareup.okhttp.OkHttpClient;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.Lazy;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


public class MyApplication extends Application implements HasActivityInjector{

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    private String TAG = MyApplication.class.getSimpleName();

    private static MyApplication app;

    AppComponent mAppComponent;

    @Inject
    OkHttpClient okHttpClient;

    @Inject
    Provider<Student> mStudentProvider;


    @Inject
    Lazy<Student> mStudentLazy;

    @Inject
    SomeHC2 someHc2;

    @Inject
    SomeClassD1 someClassD1;

    @Inject
    SomeHC1 someHc1;

    @Inject
    SomeHC1 someHc11;


    @Inject
    Student student;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        mAppComponent.injectMainApp(this);

        app = this;

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Student st = mStudentProvider.get();
            st.setName("yes" + i);
            students.add(st);
        }
        Log.e(TAG, "onCreate: " + students.toString());

        Log.e(TAG, "onCreate: " + (someHc1 == someHc11));
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
