package com.cnepay.dragger2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cnepay.dragger2.daggerAndroid.DaggerAndroid2Activity;
import com.cnepay.dragger2.daggerAndroid.DaggerAndroidActivity;
import com.cnepay.dragger2.lifecycle.UserActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 本demo主要是了解Dagger2
 * 使用依赖注入的目的： 减少类间依赖，主要体现在变量的初始化，类间解耦
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
public class SplashActivity extends AppCompatActivity {
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mUnbinder = ButterKnife.bind(this);
    }


    @OnClick({R.id.btn1, R.id.btn2, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Intent intent9 = new Intent(this, SubActivity.class);
                startActivity(intent9);
                break;
            case R.id.btn2:
                Intent intent10 = new Intent(this, InjectActivity.class);
                startActivity(intent10);
                break;
            case R.id.btn4:
                Intent intent = new Intent(this, DepActivity.class);
                startActivity(intent);
                break;
            case R.id.btn5:
                Intent intent1 = new Intent(this, LazyAndProviderActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn6:
                Intent intent2 = new Intent(this, DaggerAndroidActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn7:
                Intent intent3 = new Intent(this, DaggerAndroid2Activity.class);
                startActivity(intent3);
                break;
            case R.id.btn8:
                Intent intent8 = new Intent(this, UserActivity.class);
                startActivity(intent8);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
