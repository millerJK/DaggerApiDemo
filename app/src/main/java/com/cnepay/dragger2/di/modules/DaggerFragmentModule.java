package com.cnepay.dragger2.di.modules;

import com.cnepay.dragger2.bean.ModuleDaggerFragmentBean;

import dagger.Module;
import dagger.Provides;

/**
 * Created by master on 2018/9/19.
 */

@Module
public class DaggerFragmentModule {

    @Provides
    ModuleDaggerFragmentBean providerDaggerAndroidFragment() {
        return new ModuleDaggerFragmentBean();
    }


}
