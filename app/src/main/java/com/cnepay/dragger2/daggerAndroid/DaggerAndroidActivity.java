package com.cnepay.dragger2.daggerAndroid;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.cnepay.dragger2.R;
import com.cnepay.dragger2.bean.ModuleDaggerAndroid;
import com.cnepay.dragger2.bean.SomeClassD1;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

/**
 * 主要是验证daggerAndroid的使用
 */
public class DaggerAndroidActivity extends BaseDaggerAndroidActivity implements HasFragmentInjector {

    public static final String TAG = "DaggerAndroidActivity";

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Inject
    ModuleDaggerAndroid mDaggerAndroid;

    @Inject
    OkHttpClient client;

    @Inject
    OkHttpClient client1;

    @Inject
    @Named("someClassD1")
    SomeClassD1 mSomeClassD1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_android);


        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, DaggerAndroidFragment.newInstance(), DaggerAndroidFragment.TAG)
                .commit();


        Toast.makeText(this, mSomeClassD1.getName(), Toast.LENGTH_SHORT).show();
//        ((MyApplication) getApplication())
//                .getAppComponent()
//                .daggerAndroidComponent()
//                .activity(this)
//                .build()
//                .injectDaggerAndroidActivity(this);


        final Request request = new Request.Builder().url("https://github.com/hongyangAndroid").get().build();

        Log.e(TAG, "onCreate: " + (client == client1));
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
            }

            @Override
            public void onResponse(final Response response) throws IOException {
                final String msg = response.body().string().toString();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(DaggerAndroidActivity.this, msg, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }
}
