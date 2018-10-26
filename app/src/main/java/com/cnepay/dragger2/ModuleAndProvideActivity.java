package com.cnepay.dragger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cnepay.dragger2.bean.SomeHC1;
import com.cnepay.dragger2.di.components.DaggerModuleAndProvideComponent;

import javax.inject.Inject;

/**
 * 我们知道使用inject并不是万能，一下几种情况inject是解决不了的
 * <p>
 * 1.接口没有构造函数
 * <p>
 * 2.第三方库的类不能被标注
 * <p>
 * 3.构造函数中的参数必须配置
 */
public class ModuleAndProvideActivity extends AppCompatActivity {

    @Inject
    SomeHC1 someHC1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_and_provide);

        DaggerModuleAndProvideComponent.create();
    }
}
