package com.cnepay.dragger2.di.components;

import com.cnepay.dragger2.ModuleAndProvideActivity;
import com.cnepay.dragger2.di.modules.SomeHModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by master on 2018/10/26.
 */

@Singleton
@Component(modules = {SomeHModule.class})
public interface ModuleAndProvideComponent {

    void injectActivity(ModuleAndProvideActivity activity);
}
