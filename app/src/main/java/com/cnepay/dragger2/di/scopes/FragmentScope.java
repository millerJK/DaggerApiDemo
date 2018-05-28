package com.cnepay.dragger2.di.scopes;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by master on 2018/5/24.
 */

@Scope
@Documented
@Retention(RUNTIME)
public @interface FragmentScope {
}
