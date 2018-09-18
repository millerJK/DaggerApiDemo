package com.cnepay.dragger2;

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

/**
 * Created by master on 2018/5/23.
 * <p>
 * 首先尽量不要修改该类component和其依赖的module ，通过查 DaggerAppComponent，十分便于理解Dagger机制
 * AppComponent中依赖了两个 module(AppModule和AppModule2)
 * 为防止遗忘，记录查看源码心得：
 * 1. module + provider 是为了解决引入第三方源码无法修改问题（我们要初始化一个三方类由于源码类无法添加inject注解）
 * 2. dagger 查找实体类会先从component 依赖的module进行查找实体类，若果module中未查找到实体类，再查找类中的inject 注解来实例化对象
 * 3. 在本机中对该类做了细节分析，参考笔记：3.一个示例理解Provider/Module/Inject/Component
 * 4.
 * 5.
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

        DaggerAppComponent.create();
        app = this;

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Student st = mStudentProvider.get();
            st.setName("yes" + i);
            students.add(st);
        }
        Log.e(TAG, "onCreate: " + students.toString());

        Log.e(TAG, "onCreate: "+(someHc1 == someHc11) );
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }


    public static MyApplication getApp() {
        return app;
    }


}
