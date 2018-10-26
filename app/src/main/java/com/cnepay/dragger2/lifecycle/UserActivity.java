package com.cnepay.dragger2.lifecycle;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cnepay.dragger2.BaseMvpActivity;
import com.cnepay.dragger2.R;
import com.cnepay.dragger2.lifecycle.di.DaggerUserComponent;
import com.cnepay.dragger2.lifecycle.di.UserModule;
import com.cnepay.dragger2.mvp.IView;

public class UserActivity extends BaseMvpActivity<LifePresenter> implements IView {

    protected static String TAG = UserActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        DaggerUserComponent.builder()
                .appComponent(getAppComponent())
                .userModule(new UserModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void showMessage(@NonNull String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view) {
        Log.e(TAG, "onClick: "+presenter );
//        presenter.onStart();
    }
}
