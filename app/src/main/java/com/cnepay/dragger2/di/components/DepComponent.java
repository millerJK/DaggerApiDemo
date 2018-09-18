package com.cnepay.dragger2.di.components;

import com.cnepay.dragger2.DepActivity;
import com.cnepay.dragger2.di.modules.DepModule;
import com.cnepay.dragger2.di.scopes.ActivityScope;

import dagger.Component;

/**
 * Created by master on 2018/6/1.
 */
@ActivityScope
@Component(dependencies = {AppComponent.class,DepComponent1.class},modules = DepModule.class)
public interface DepComponent {

    void injectDepActivity(DepActivity activity);

}
