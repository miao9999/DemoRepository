package com.limiao.daggerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

/**
 * Created by miao on 2019/3/13.
 */
public class CActivity extends AppCompatActivity {


//    @Inject
//    Man mMan;

    @Inject
    Pot mPot;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        DaggerCComponent.builder().cActivityModule(new CActivityModule()).build().inject(this);

        Log.e("CActivity", mPot.toString());
    }
}
