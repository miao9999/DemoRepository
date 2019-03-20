package com.example.popshowup;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = View.inflate(MainActivity.this, R.layout.item_pop, null);
                //获取PopupWindow中View的宽高
                view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                PopupWindow popupWindow = new PopupWindow(view, getResources().getDisplayMetrics().widthPixels
                        , getResources().getDisplayMetrics().heightPixels);
//                popupWindow.setFocusable(true);//popupwindow设置焦点

//                popupWindow.setBackgroundDrawable(new ColorDrawable(0xaa000000));//设置背景
//                popupWindow.setOutsideTouchable(true);//点击外面窗口消失
                // popupWindow.showAsDropDown(v,0,0);
                //获取点击View的坐标
                int[] location = new int[2];
                v.getLocationOnScreen(location);
//                popupWindow.showAsDropDown(v);//在v的下面
                //显示在上方
                popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, location[0] + v.getWidth() / 2, location[1] - measuredHeight);
                //显示在正上方
//                popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, (location[0] + v.getWidth() / 2) - measuredWidth / 2, location[1] - measuredHeight);
                //显示在左方
//                popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, location[0] - popupWindow.getWidth(), location[1]);
                //显示在下方
//                popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, location[0] + v.getWidth(), location[1]);
//                popupWindow.setAnimationStyle(android.R.style.Animation_Translucent);//设置动画

            }
        });

    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
    }
}

