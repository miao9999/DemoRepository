package com.limiao.daggerdemo;

import android.content.SharedPreferences;

import dagger.Component;

/**
 * Created by miao on 2019/3/11.
 */
@Component(modules = AppModule.class)
public interface ApplicationComponent {

    SharedPreferences shardPreferences();

    MyApplication myApplicaton();
}
