package com.cnepay.dragger2.di.components;

import com.cnepay.dragger2.BaseActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by master on 2018/9/19.
 */

@Subcomponent
public interface BaseActivityComponent extends AndroidInjector<BaseActivity> {

    //每一个继承BaseActivity的Activity，都共享同一个SubComponent
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BaseActivity> {
    }

}
