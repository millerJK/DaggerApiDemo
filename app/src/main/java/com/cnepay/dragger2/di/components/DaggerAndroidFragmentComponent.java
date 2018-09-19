package com.cnepay.dragger2.di.components;

import com.cnepay.dragger2.DaggerAndroidFragment;
import com.cnepay.dragger2.di.modules.DaggerFragmentModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by master on 2018/9/19.
 */

@Subcomponent(modules = {DaggerFragmentModule.class})
public interface DaggerAndroidFragmentComponent extends AndroidInjector<DaggerAndroidFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DaggerAndroidFragment> {
    }

}
