package com.cnepay.dragger2.di.modules;

import com.cnepay.dragger2.bean.Student;
import com.cnepay.dragger2.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class DepModule1 {

    @Provides
    @ActivityScope
    Student providerStudent() {
        return new Student();
    }
}
