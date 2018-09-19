package com.cnepay.dragger2.di.components;

import com.cnepay.dragger2.DaggerAndroidActivity;
import com.cnepay.dragger2.di.modules.DaggerAndroidModule;
import com.cnepay.dragger2.di.modules.FragmentBindModule;

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


@Subcomponent(modules = {FragmentBindModule.class, DaggerAndroidModule.class})
public interface DaggerAndroidSonComponent extends AndroidInjector<DaggerAndroidActivity> {

//    void injectDaggerAndroidActivity(DaggerAndroidActivity activity);

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DaggerAndroidActivity> {
    }


//    interface Builder {
//
//        @BindsInstance
//        Builder activity(Activity activity);
//
//        DaggerAndroidSonComponent build();
//    }
}
