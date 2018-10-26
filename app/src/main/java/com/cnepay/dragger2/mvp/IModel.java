package com.cnepay.dragger2.mvp;

import android.arch.lifecycle.LifecycleObserver;

/**
 * Created by master on 2018/9/26.
 */

public interface IModel extends LifecycleObserver {


    void onDestroy();
}
