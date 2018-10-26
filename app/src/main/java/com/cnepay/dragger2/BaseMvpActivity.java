package com.cnepay.dragger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cnepay.dragger2.di.components.AppComponent;
import com.cnepay.dragger2.mvp.BasePresenter;

import javax.inject.Inject;

public class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity {

    @Inject
   public P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_mvp);
    }


    public AppComponent getAppComponent() {
        return ((MyApplication) getApplication()).getAppComponent();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter != null)
            presenter.onDestroy();
    }
}
