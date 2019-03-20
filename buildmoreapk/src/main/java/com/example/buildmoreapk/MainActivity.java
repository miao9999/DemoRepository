package com.example.buildmoreapk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        tv.setText(BuildConfig.VERSION_NAME);
        Log.e("MainActivity", "version name:" + BuildConfig.VERSION_NAME);
    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
    }
}
