package com.limiao.daggerdemo;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;

/**
 * Created by miao on 2019/3/11.
 */
@Module
public class AppModule {
    MyApplication mMyApplication;

    public AppModule(MyApplication myApplication) {
        mMyApplication = myApplication;
    }

    @Provides
    SharedPreferences providerSharedPreferences(){
        return mMyApplication.getSharedPreferences("my_sp", Context.MODE_PRIVATE);
    }


    @Provides
    MyApplication providerMyApplicaton(){
        return mMyApplication;
    }



}
