package com.cnepay.dragger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.cnepay.dragger2.bean.Student;
import com.cnepay.dragger2.di.components.DaggerLazyAndProviderComponent;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.Lazy;

/**
 * 通过Lazy 获取到的对象是单例的，懒加载，把类的初始化放大 lazy的 get中
 * provider 则是调用一次get 同样是把类的初始化延迟到get中
 */
public class LazyAndProviderActivity extends AppCompatActivity {

    private static final String TAG = "LazyAndProviderActivity";

    @Inject
    Lazy<Student> lazyStudent;

    @Inject
    Provider<Student> providerStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lazy_and_provider);
        DaggerLazyAndProviderComponent.create().injectLazyActivity(this);

        Student student1 = providerStudent.get();
        student1.setName("我是");
        Student student2 = providerStudent.get();
        student2.setName("ha");
        Log.e(TAG, "onCreate: " + student1.toString() + "   " + student2.toString() + "    " + (student1 == student2));


        Student student3 = lazyStudent.get();
        student3.setName("student3");
        Student student4 = lazyStudent.get();
        student4.setName("student4");
        Log.e(TAG, "onCreate: " + student3.toString() + "        " + student4.toString() + "   " + (student3 == student4));


    }
}
