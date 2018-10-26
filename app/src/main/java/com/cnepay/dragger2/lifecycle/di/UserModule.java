package com.cnepay.dragger2.lifecycle.di;

import com.cnepay.dragger2.di.scopes.ActivityScope;
import com.cnepay.dragger2.lifecycle.UserModel;
import com.cnepay.dragger2.mvp.IModel;
import com.cnepay.dragger2.mvp.IView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by master on 2018/9/26.
 */

@Module
public class UserModule {

    private IView view;

    /**
     * 构建 UserModel 时,将 View 的实现类传进来,这样就可以提供 View 的实现类给 Presenter
     *
     * @param view
     */
    public UserModule(IView view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    IView provideUserView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    IModel provideUserModel(UserModel model) {
        return model;
    }

}
