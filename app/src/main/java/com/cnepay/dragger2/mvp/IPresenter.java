package com.cnepay.dragger2.mvp;

import android.app.Activity;
import android.arch.lifecycle.LifecycleObserver;

/**
 * Created by master on 2018/9/26.
 */

public interface IPresenter extends LifecycleObserver {

    /**
     * 做一些初始化操作
     */
    void onStart();

    /**
     * 在框架中 {@link Activity#onDestroy()} 时会默认调用 {@link IPresenter#onDestroy()}
     */
    void onDestroy();

}
