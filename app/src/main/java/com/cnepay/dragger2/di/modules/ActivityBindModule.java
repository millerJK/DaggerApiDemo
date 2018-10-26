package com.cnepay.dragger2.di.modules;

import com.cnepay.dragger2.daggerAndroid.DaggerAndroid2Activity;
import com.cnepay.dragger2.daggerAndroid.DaggerAndroidActivity;
import com.cnepay.dragger2.di.components.BaseActivityComponent;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by master on 2018/9/19.
 */
@Module(subcomponents = BaseActivityComponent.class)
public abstract class ActivityBindModule {

    @ContributesAndroidInjector(modules = {FragmentBindModule.class, DaggerAndroidModule.class})
    abstract DaggerAndroidActivity bindDaggerAndroidActivityInjectorFactory();

    @ContributesAndroidInjector(modules = DaggerAndroidModule.class)
    abstract DaggerAndroid2Activity bindDaggerAndroid2ActivityInjectorFactory();
}
