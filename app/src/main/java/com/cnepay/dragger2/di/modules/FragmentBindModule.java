package com.cnepay.dragger2.di.modules;

import android.app.Fragment;

import com.cnepay.dragger2.daggerAndroid.DaggerAndroidFragment;
import com.cnepay.dragger2.di.components.DaggerAndroidFragmentComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by master on 2018/9/19.
 */
@Module(subcomponents = {DaggerAndroidFragmentComponent.class})
public abstract class FragmentBindModule {

    @Binds
    @IntoMap
    @FragmentKey(DaggerAndroidFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindYourActivityInjectorFactory(DaggerAndroidFragmentComponent.Builder builder);

}
