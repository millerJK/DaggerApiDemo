package com.cnepay.dragger2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cnepay.dragger2.bean.fish.Fish;
import com.cnepay.dragger2.bean.Human;
import com.cnepay.dragger2.bean.SomeClassA1;
import com.cnepay.dragger2.bean.SomeClassB1;
import com.cnepay.dragger2.bean.SomeHC1;
import com.cnepay.dragger2.bean.Student;
import com.cnepay.dragger2.di.components.DaggerSomeClassComponent;
import com.cnepay.dragger2.di.components.MainComponent;
import com.cnepay.dragger2.di.components.SomeClassComponent;
import com.cnepay.dragger2.di.qualifier.BlackFish;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 本demo主要是了解Dagger2
 * 使用依赖注入的目的： 减少类间依赖，主要体现在变量的初始化
 * <p>
 * 1.增加开发效率、省去重复的简单体力劳动
 * 2.首先new一个实例的过程是一个重复的简单体力劳动，dagger2完全可以把new一个实例的工作做了，因此我们把主要精力集中在关键业务上、同时也能增加开发效率上。
 * 3.省去写单例的方法，并且也不需要担心自己写的单例方法是否线程安全，自己写的单例是懒汉模式还是饿汉模式。因为dagger2都可以把这些工作做了。
 * 4.没有必要知道依赖类的实现方式符合设计规则
 * </p>
 * <p>
 * 更好的管理类实例
 * 每个app中的ApplicationComponent管理整个app的全局类实例，所有的全局类实例都统一交给ApplicationComponent管理，并且它们的生命周期与app的生命周期一样。
 * 每个页面对应自己的Component，页面Component管理着自己页面所依赖的所有类实例。
 * 因为Component，Module，整个app的类实例结构变的很清晰。</p>
 * <p>
 * 解耦
 * 假如不用dagger2的话，一个类的new代码是非常可能充斥在app的多个类中的，假如该类的构造函数发生变化，那这些涉及到的类都得进行修改。设计模式中提倡把容易变化的部分封装起来。
 * <p>
 * <p>
 * Android 中应该怎么使用Dagger
 * <p>
 * 一般会有个 AppComponent，管理 app 中的单例依赖，同时提供 ApplicationContext 依赖。
 * <p>
 * 一般一个页面对应一个 Component，例如 Activity、Fragment 对应各自的 Component，但是两个页面的依赖相同时，可以用同一个 Component。
 * <p>
 * Android 中推荐使用 Component 的继承关系。
 * <p>
 * 尽量多使用 Scope 作用域，增加可读性还能方便控制依赖实例的生命周期。
 */
public class SubActivity extends BaseActivity {

    private static final String TAG = "SubActivity";

    private Unbinder mUnbinder;

    private MainComponent mainComponent;

    Student student;

    OkHttpClient client;

    @Inject
    Human human1;

    @Inject
    Human human2;

    @Inject
    SomeClassA1 mSomeClassA1;

    @Inject
    SomeClassB1 mSomeClassB1;

    @Inject
    SomeHC1 mSomeHC1;

    @Inject
    @BlackFish
    Fish blackFish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);

        //SubComponent
        SomeClassComponent someClassComponent = DaggerSomeClassComponent.create();
        someClassComponent.sonComponent().build().injectMainActivity(this);

    }


    @Inject
    public void setStudent(Student student) {
        this.student = student;
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                //无参
                student.setName("王小明");
                Toast.makeText(this, student.getName(), Toast.LENGTH_LONG).show();
                break;
            case R.id.btn2:
                final Request request = new Request.Builder().url("https://github.com/hongyangAndroid").get().build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                    }

                    @Override
                    public void onResponse(final Response response) throws IOException {
                        final String msg = response.body().string().toString();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(SubActivity.this, msg, Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
                break;

            case R.id.btn3:
                Toast.makeText(this, human1 == human2 ? "=" : "!=", Toast.LENGTH_LONG).show();
                break;

            case R.id.btn4:
                Intent intent = new Intent(this, DepActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
