package com.cnepay.dragger2.di.components;

import com.cnepay.dragger2.MainActivity;
import com.cnepay.dragger2.di.modules.SomeHModule;

import javax.inject.Singleton;

import dagger.Subcomponent;

/**
 * Created by master on 2018/5/23.
 */

@Singleton
@Subcomponent(modules = SomeHModule.class)
public interface MainComponent {

    void injectMainActivity(MainActivity mainActivity);

    @Subcomponent.Builder
    interface Builder { // SubComponent 必须显式地声明 Subcomponent.Builder，parent Component 需要用 Builder 来创建 SubComponent
        MainComponent build();
    }

}
