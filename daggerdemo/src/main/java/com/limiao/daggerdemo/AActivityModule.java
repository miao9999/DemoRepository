package com.limiao.daggerdemo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by miao on 2019/3/11.
 */
@Module
public class AActivityModule  {
    AActivity mAActivity ;

    public AActivityModule(AActivity AActivity) {
        mAActivity = AActivity;
    }

    @Provides
    Student providerStudent(){
        return new Student();
    }

    @Provides
    Person providerPerson(){
        return new Person();
    }
}
