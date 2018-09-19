package com.cnepay.dragger2.di.components;

import com.cnepay.dragger2.DaggerAndroid2Activity;
import com.cnepay.dragger2.di.modules.DaggerAndroidModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by master on 2018/9/19.
 */
//未使用Dagger.Android之前子Component书写的代码
//@Subcomponent(modules = DaggerAndroidModule.class)
//public interface DaggerAndroidSonComponent {
//
//    void injectDaggerAndroidActivity(DaggerAndroidActivity activity);
//
//    @Subcomponent.Builder
//    interface Builder {
//
//        @BindsInstance
//        Builder activity(Activity activity);
//
//        DaggerAndroidSonComponent build();
//    }
//}


@Subcomponent(modules = {DaggerAndroidModule.class})
public interface DaggerAndroidSon2Component extends AndroidInjector<DaggerAndroid2Activity> {

//    void injectDaggerAndroidActivity(DaggerAndroidActivity activity);

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DaggerAndroid2Activity> {
    }


//    interface Builder {
//
//        @BindsInstance
//        Builder activity(Activity activity);
//
//        DaggerAndroidSonComponent build();
//    }
}
