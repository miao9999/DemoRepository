package com.limiao.daggerdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import javax.inject.Inject;

/**
 * Created by miao on 2019/3/11.
 */
public class AActivity extends AppCompatActivity {


    @Inject
    Student mStudent;
    @Inject
    SharedPreferences mSharedPreferences;

    @Inject
    Person mPerson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerAActivityComponent.builder().applicationComponent(MyApplication.ComponentHolder.getApplicationComponent())
                .aActivityModule(new AActivityModule(this))
                .build()
                .inject(this);
//


        Log.e("AActivity", mSharedPreferences.toString());
        Log.e("AActivity", mStudent.toString());

        Log.e("AActivity", mPerson.toString());

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AActivity.this,BActivity.class));
            }
        });
    }
}
