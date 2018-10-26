package com.cnepay.dragger2.lifecycle;


import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

import com.cnepay.dragger2.mvp.BasePresenter;
import com.cnepay.dragger2.mvp.IModel;
import com.cnepay.dragger2.mvp.IView;

import javax.inject.Inject;

/**
 * Created by master on 2018/9/26.
 */

public class LifePresenter extends BasePresenter {
    public static String TAG = LifePresenter.class.getSimpleName();

    @Inject
    public LifePresenter(IModel model, IView rootView) {
        super(model, rootView);
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause() {
        Log.e(TAG, "onPause: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        mRootView.showMessage("are you ok");
    }
}
