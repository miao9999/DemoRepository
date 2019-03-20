package com.limiao.daggerdemo;

import javax.inject.Inject;

import dagger.Component;

/**
 * Created by miao on 2019/3/13.
 */
@Component(modules = AActivityModule.class)
public interface BActivityComponent {

    void inject(BActivity bActivity);
}
