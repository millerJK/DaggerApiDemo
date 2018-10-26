package com.cnepay.dragger2.lifecycle.di;

import com.cnepay.dragger2.di.components.AppComponent;
import com.cnepay.dragger2.di.scopes.ActivityScope;
import com.cnepay.dragger2.lifecycle.UserActivity;

import dagger.Component;

/**
 * Created by master on 2018/9/26.
 */

@ActivityScope
@Component(modules = {UserModule.class}, dependencies = {AppComponent.class})
public interface UserComponent {
    void inject(UserActivity activity);
}
