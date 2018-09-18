package com.cnepay.dragger2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cnepay.dragger2.di.components.DaggerDepComponent;
import com.cnepay.dragger2.di.components.DaggerDepComponent1;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Inject;

/**
 * 依赖关系Dagger dependencies
 */
public class DepActivity extends BaseActivity {

    @Inject
    MyApplication application;

    @Inject
    OkHttpClient client;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependence);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DaggerDepComponent.builder().appComponent(getAppComponent()).depComponent1(DaggerDepComponent1.create()).build();
    }

}
