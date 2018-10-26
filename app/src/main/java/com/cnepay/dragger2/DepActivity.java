package com.cnepay.dragger2;

import android.app.Application;
import android.os.Bundle;

import com.cnepay.dragger2.bean.Student;
import com.cnepay.dragger2.di.components.DaggerDepComponent;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Inject;

/**
 * 依赖关系Dagger dependencies
 * <p>
 * <p>
 * 1.被依赖的 Component 需要把暴露的依赖实例用显式的接口声明，我们只能使用朋友愿意分享的东西。
 * <p>
 * 2.依赖关系中的 Component 的 Scope 不能相同，因为它们的生命周期不同。
 */
public class DepActivity extends BaseActivity {

    @Inject
    Application application;

    @Inject
    OkHttpClient client;

    @Inject
    Student student;

    @Inject
    Student st;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependence);

        DaggerDepComponent.builder()
                .appComponent(getAppComponent())
                .build();
    }

}
