package com.cnepay.dragger2.di.modules;

import com.cnepay.dragger2.bean.ModuleDaggerAndroid;

import dagger.Module;
import dagger.Provides;

/**
 * Created by master on 2018/9/19.
 */

@Module
public class DaggerAndroidModule {

    @Provides
    ModuleDaggerAndroid providerDaggerAndroid() {
        return new ModuleDaggerAndroid();
    }


}
