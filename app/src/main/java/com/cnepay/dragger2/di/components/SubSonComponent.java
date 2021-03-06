package com.cnepay.dragger2.di.components;

import com.cnepay.dragger2.SubActivity;
import com.cnepay.dragger2.di.modules.SomeHModule;

import javax.inject.Singleton;

import dagger.Subcomponent;

/**
 * Created by master on 2018/5/23.
 */

@Singleton
@Subcomponent(modules = SomeHModule.class)
public interface SubSonComponent {

    void injectMainActivity(SubActivity activity);

    @Subcomponent.Builder
    interface Builder {
        SubSonComponent build();
    }

}
