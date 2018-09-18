package com.cnepay.dragger2.di.modules;

import com.cnepay.dragger2.bean.Student;
import com.cnepay.dragger2.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by master on 2018/6/1.
 * Bind修饰符只能修饰抽象方法
 * Error:(19, 17) 错误: A @Module may not contain both non-static @Provides methods and abstract @Binds or @Multibinds declarations
 */


@Module
public class DepModule1 {

    @Provides
    @ActivityScope
    Student providerStudent() {
        return new Student();
    }
}
