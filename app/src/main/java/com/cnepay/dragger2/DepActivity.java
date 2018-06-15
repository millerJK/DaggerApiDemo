package com.cnepay.dragger2;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cnepay.dragger2.bean.fish.Fish;
import com.cnepay.dragger2.di.components.DaggerDepComponent;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Inject;
import javax.inject.Named;


public class DepActivity extends BaseActivity {

    @Inject
    Context application;

    @Inject
    OkHttpClient client;

    @Named("blackFish")
    @Inject
    Fish fish;

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

        DaggerDepComponent.builder().appComponent(getAppComponent()).build();
    }

}
