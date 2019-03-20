package com.kotlin.limiao.activitylaunchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by miao on 2018/12/13.
 */
public class A extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        tv.setText("A");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
//                intent.addCategory("com.limiao.test.category.one");
                startActivity(intent);
            }
        });

    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
    }
}
