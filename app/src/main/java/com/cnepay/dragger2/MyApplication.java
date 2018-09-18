package com.cnepay.dragger2;

import android.app.Application;
import android.util.Log;

import com.cnepay.dragger2.bean.SomeClassD1;
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

/**
 * Created by master on 2018/5/23.
 * Dependence 和 subComponent 而SubComponent的只是父Component中的一部分，在Scope上和父Component并没有什么限制
 */

public class MyApplication extends Application {

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
    Student student;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        mAppComponent.injectMainApp(this);

        DaggerAppComponent.create();
        app = this;

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Student st = mStudentProvider.get();
            st.setName("yes" + i);
            students.add(st);
        }
        Log.e(TAG, "onCreate: "+students.toString() );
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }


    public static MyApplication getApp() {
        return app;
    }


}
