package com.cnepay.dragger2.di.modules;

import android.app.Activity;

import com.cnepay.dragger2.DaggerAndroidActivity;
import com.cnepay.dragger2.di.components.DaggerAndroidSonComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by master on 2018/9/19.
 */
@Module(subcomponents = {DaggerAndroidSonComponent.class})
public abstract class ActivityBindModule {

    @Binds
    @IntoMap
    @ActivityKey(DaggerAndroidActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindYourActivityInjectorFactory(DaggerAndroidSonComponent.Builder builder);

}
