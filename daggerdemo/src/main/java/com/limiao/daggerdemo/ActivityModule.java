package com.limiao.daggerdemo;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by miao on 2019/3/11.
 */
@Module
public class ActivityModule {

    Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    Student providerStudent(){
        return new Student();
    }
}
