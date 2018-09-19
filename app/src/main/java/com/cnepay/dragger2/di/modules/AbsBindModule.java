package com.cnepay.dragger2.di.modules;

import com.cnepay.dragger2.bean.fish.*;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

/**
 * Created by master on 2018/6/1.
 * 如果module修饰的类是抽象类的话，抽象方法需要使用bind 进行修饰
 * Bind修饰符只能修饰抽象方法
 *
 */


@Module
public abstract class AbsBindModule {

    @Binds
    @Named("blackFish")
    abstract Fish bindBlackFish(BlackFish fish);

    @Binds
    @Named("whiteFish")
    abstract Fish bindWhiteFish(WhiteFish fish);
}
