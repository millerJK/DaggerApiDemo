package com.cnepay.dragger2.di.components;

import com.cnepay.dragger2.LazyAndProviderActivity;

import dagger.Component;


@Component
public interface LazyAndProviderComponent {
    void injectLazyActivity(LazyAndProviderActivity activity);
}
