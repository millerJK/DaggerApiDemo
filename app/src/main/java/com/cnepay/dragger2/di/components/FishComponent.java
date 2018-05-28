package com.cnepay.dragger2.di.components;

import com.cnepay.dragger2.bean.Fish;
import com.cnepay.dragger2.di.modules.BlackFish;
import com.cnepay.dragger2.di.modules.FishModule;
import com.cnepay.dragger2.di.modules.WhiteFish;

import dagger.Component;

/**
 * Created by master on 2018/5/24.
 */

@Component(modules = FishModule.class)
public interface FishComponent {

    @BlackFish
    Fish getBlackFish();

    @WhiteFish
    Fish getWhiteFish();

}
