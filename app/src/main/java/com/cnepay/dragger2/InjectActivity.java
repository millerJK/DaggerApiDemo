package com.cnepay.dragger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.cnepay.dragger2.bean.Student;
import com.cnepay.dragger2.di.components.DaggerInjectComponent;

import javax.inject.Inject;

/**
 * 主要阐述Inject的使用方法
 * inject 可以标注到成员变量上，也可以标注到方法上
 */
public class InjectActivity extends AppCompatActivity {

    @Inject
    Student student1;

    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inject);

        DaggerInjectComponent.create().injectInjectActivity(this);

        student.setName("王小明");
        Toast.makeText(this, student.getName(), Toast.LENGTH_LONG).show();
    }

    @Inject
    public void setStudent(Student student) {
        this.student = student;
    }
}
