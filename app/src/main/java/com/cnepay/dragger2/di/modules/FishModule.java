package com.cnepay.dragger2.di.modules;

import android.content.Context;

import com.cnepay.dragger2.bean.BlackFish;
import com.cnepay.dragger2.bean.Fish;
import com.cnepay.dragger2.bean.WhiteFish;

import dagger.Module;
import dagger.Provides;

/**
 * Created by master on 2018/5/24.
 */

@Module
public class FishModule {

    private Context context;

    public FishModule(Context context) {
        this.context = context;
    }

    @Provides
    @com.cnepay.dragger2.di.modules.WhiteFish
    Fish getWhiteFish() {
        return new WhiteFish();
    }


    @Provides
    @com.cnepay.dragger2.di.modules.BlackFish
    Fish getBlackFish(){
        return new BlackFish();
    }

}
