package com.cnepay.dragger2.mvp;

import android.support.annotation.NonNull;

/**
 * Created by master on 2018/9/26.
 */

public interface IView {

    /**
     * 显示加载
     */
    default void showLoading() {

    }

    /**
     * 隐藏加载
     */
    default void hideLoading() {

    }

    /**
     * 显示信息
     *
     * @param message 消息内容, 不能为 {@code null}
     */
    void showMessage(@NonNull String message);

}
