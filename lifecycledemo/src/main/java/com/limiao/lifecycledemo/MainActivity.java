package com.limiao.lifecycledemo;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {


    private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFrameLayout = findViewById(R.id.frame_layout);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.frame_layout,new MainFragment()).commit();

        Log.e("MainActivity", "on create");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MainActivity", "on start");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("MainActivity", "on restart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MainActivity", "on resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MainActivity", "on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MainActivity", "on stop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MainActivity", "on destroy");
    }
}

