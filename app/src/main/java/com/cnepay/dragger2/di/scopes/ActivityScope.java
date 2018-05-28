package com.cnepay.dragger2.di.scopes;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;


/**
 * scope 机制可以使得在scope 存在时保持类的单例
 * Dagger 只是提供了scope的一个注解：singleton ,其他的只能自定义
 * <p>
 * scope 特性
 * 1.范围性
 * 2.单例性
 * <p>
 * 原理：
 * 1.在Module中定义创建全局类实例的方法
 * 2.ApplicationComponent管理Module
 * 3.保证ApplicationComponent只有一个实例（在app的Application中实例化ApplicationComponent）
 */

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
