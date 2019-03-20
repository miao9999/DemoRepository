package com.limiao.daggerdemo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by miao on 2019/3/13.
 */
public class Pot {

    private Person mPerson;



    public Pot( Person person) {
        this.mPerson = person;
    }
}
