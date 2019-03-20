package com.example.roundimg;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private RoundRaceView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
////            iv.setOutlineProvider(new RoundRaceView(30f));
//
//            iv.setClipToOutline(true);
//        }
    }

    private void initView() {
        iv = (RoundRaceView) findViewById(R.id.iv);
    }
}
