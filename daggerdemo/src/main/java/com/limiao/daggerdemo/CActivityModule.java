package com.limiao.daggerdemo;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by miao on 2019/3/13.
 */
@Module
public class CActivityModule {


    @Provides
    @Named("student")
    Person providerStudent(){
        return new Student();
    }


    @Provides
    @Named("man")
    Person providerMan(){
        return new Man();
    }

    @Provides
    Pot providerPerson(@Named("student") Person person){
        return new Pot(person);
    }




}
