package com.cnepay.dragger2;

import android.app.Application;
import android.os.Bundle;
import android.widget.Toast;

import com.cnepay.dragger2.bean.SomeClassA1;
import com.cnepay.dragger2.bean.SomeClassB1;
import com.cnepay.dragger2.bean.SomeHC1;
import com.cnepay.dragger2.di.components.DaggerSubParentComponent;
import com.cnepay.dragger2.di.components.SubParentComponent;

import javax.inject.Inject;

/**
 *
 */
public class SubActivity extends BaseActivity {

    private static final String TAG = "SubActivity";

    @Inject
    SomeClassA1 mSomeClassA1;

    @Inject
    SomeClassB1 mSomeClassB1;

    @Inject
    SomeHC1 mSomeHC1;

    @Inject
    Application mApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SubComponent
        SubParentComponent subParentComponent = DaggerSubParentComponent.builder().appComponent(getAppComponent()).build();
        subParentComponent.sonComponent().build().injectMainActivity(this);

        Toast.makeText(mApplication, "yes", Toast.LENGTH_SHORT).show();
    }


}
