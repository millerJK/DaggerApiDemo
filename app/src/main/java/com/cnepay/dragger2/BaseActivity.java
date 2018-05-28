package com.cnepay.dragger2;

import android.support.v7.app.AppCompatActivity;

import com.cnepay.dragger2.di.components.AppComponent;

/**
 * Created by master on 2018/5/24.
 */

public class BaseActivity extends AppCompatActivity {

    public AppComponent getAppComponent() {
        return ((MyApplication) getApplication()).getAppComponent();
    }
}
