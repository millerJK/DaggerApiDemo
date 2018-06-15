package com.cnepay.dragger2.di.components;

import com.cnepay.dragger2.SubActivity;
import com.cnepay.dragger2.di.modules.SomeHModule;

import javax.inject.Singleton;

import dagger.Subcomponent;

/**
 * Created by master on 2018/5/23.
 */


@Subcomponent(modules = SomeHModule.class)
public interface MainComponent {

    void injectMainActivity(SubActivity activity);

    @Subcomponent.Builder
    interface Builder {
        MainComponent build();
    }

}
