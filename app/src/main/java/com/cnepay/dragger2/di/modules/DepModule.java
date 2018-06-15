package com.cnepay.dragger2.di.modules;

import com.cnepay.dragger2.bean.fish.*;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

/**
 * Created by master on 2018/6/1.
 * Bind修饰符只能修饰抽象方法
 * Error:(19, 17) 错误: A @Module may not contain both non-static @Provides methods and abstract @Binds or @Multibinds declarations
 */


@Module
public abstract class DepModule {

    @Binds
    @Named("blackFish")
    abstract Fish bindBlackFish(com.cnepay.dragger2.bean.fish.BlackFish fish);
}
