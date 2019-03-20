package com.example.bottomnavitiontip;

import android.graphics.Color;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;

import com.example.bottomnavitiontip.bottom.BadgeFactory;
import com.example.bottomnavitiontip.bottom.BadgeView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom);
        BadgeFactory.create(this)
                .setTextColor(Color.RED)
                .setWidthAndHeight(25,25)
                .setBadgeBackground(Color.RED)
                .setTextSize(10)
                .setBadgeGravity(Gravity.RIGHT|Gravity.TOP)
                .setBadgeCount(0)
                .setShape(BadgeView.SHAPE_CIRCLE)
                .setSpace(10,10)
                .bind(bottomNavigationView);

    }
}
