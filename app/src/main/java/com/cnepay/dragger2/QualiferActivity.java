package com.cnepay.dragger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cnepay.dragger2.bean.Student;
import com.cnepay.dragger2.di.components.DaggerQualiferComponent;
import com.cnepay.dragger2.di.components.QualiferComponent;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * 阐述Qualifier注解使用，Named是自带的，如需要自定义Qualifer参照Named定义即可
 */
public class QualiferActivity extends AppCompatActivity {

    @Inject
    @Named("student1")
    Student student1;

    @Inject
    @Named("student2")
    Student student2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualifer);
        QualiferComponent component = DaggerQualiferComponent.create();
        component.injectQualiferActivity(this);

    }
}
