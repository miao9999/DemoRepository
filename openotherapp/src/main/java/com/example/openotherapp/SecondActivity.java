package com.example.openotherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by limiao on 2018/10/15.
 */
public class SecondActivity extends AppCompatActivity {

    private TextView action_tv;
    private TextView category_tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        Intent intent = getIntent();
        if (intent != null) {
            action_tv.setText(intent.getAction() + "");

            category_tv.setText(intent.getCategories() + "");
        }
    }

    private void initView() {
        action_tv = (TextView) findViewById(R.id.action_tv);
        category_tv = (TextView) findViewById(R.id.category_tv);
    }
}
