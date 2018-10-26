package com.cnepay.dragger2.daggerAndroid;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cnepay.dragger2.R;
import com.cnepay.dragger2.bean.ModuleDaggerFragmentBean;

import javax.inject.Inject;

import dagger.android.AndroidInjection;


/**
 * fragment 是依赖于activity的
 */
public class DaggerAndroidFragment extends Fragment {

    public static final String TAG = "DaggerAndroidFragment";
    @Inject
    ModuleDaggerFragmentBean bean;

    public DaggerAndroidFragment() {
        // Required empty public constructor
    }

    public static DaggerAndroidFragment newInstance() {
        return new DaggerAndroidFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dagger_android, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        AndroidInjection.inject(this);
        super.onAttach(activity);
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(), bean.getName(), Toast.LENGTH_SHORT).show();
    }
}
