package com.limiao.daggerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import javax.inject.Inject;

/**
 * Created by miao on 2019/3/13.
 */
public class BActivity extends AppCompatActivity {

    @Inject
    Person mPerson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DaggerBActivityComponent.builder().build().inject(this);

//        Log.e("BActivity", mPerson.toString());

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this,CActivity.class));
            }
        });
    }
}
