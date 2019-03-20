package com.limiao.daggerdemo;

import dagger.Component;

/**
 * Created by miao on 2019/3/13.
 */
@Component (modules = {CActivityModule.class})
public interface CComponent {

    void inject(CActivity cActivity);

}
