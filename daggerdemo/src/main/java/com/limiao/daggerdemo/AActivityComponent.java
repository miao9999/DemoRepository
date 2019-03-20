package com.limiao.daggerdemo;

import dagger.Component;

/**
 * Created by miao on 2019/3/11.
 */
@Component (modules = AActivityModule.class,dependencies = ApplicationComponent.class)
public interface AActivityComponent {

    void inject(AActivity aActivity);
}
