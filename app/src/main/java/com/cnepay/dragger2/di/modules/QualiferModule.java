package com.cnepay.dragger2.di.modules;

import com.cnepay.dragger2.bean.Student;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by master on 2018/9/18.
 * 检验Qualifer
 */

@Module
public class QualiferModule {

    public QualiferModule() {
    }

    @Provides
    @Named("student1")
    Student getStudent1() {
        return new Student("student1");
    }

    @Provides
    @Named("student2")
    Student getStudent2() {
        return new Student("student2");
    }
}
