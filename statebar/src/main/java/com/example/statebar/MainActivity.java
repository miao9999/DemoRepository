package com.example.statebar;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// 设置状态栏全透明,
        // 设置全透明之后，整个布局会扩充到状态栏的地方，会被状态栏遮挡一部分
        // 状态栏的文字还是白色的，会看不清
        Window window = getWindow();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.getDecorView().setSystemUiVisibility(
////                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | // 占满整个屏幕
//                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);// 状态栏文字显深色
////                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
////                window.setNavigationBarColor(Color.TRANSPARENT);
//        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }


        // 沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.0以上使用原生方法
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
//            );

            // 当 setStatusBarColor 设置为 TRANSPARENT（透明）时，
            // window.getDecorView().setSystemUiVisibility()
            // 设置 View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN （全屏）时，statusBar 会遮挡布局
            // 如果setStatusBarColor 设置为其他颜色时，设置全屏属性时也不会遮挡布局
//            window.setStatusBarColor(Color.TRANSPARENT);
//            window.setStatusBarColor(Color.GRAY);// 顶部状态栏的颜色

//            window.setNavigationBarColor(Color.BLUE);
//            window.setNavigationBarColor(Color.BLUE); // 底部状态栏的颜色，部分手机会有
            window.addFlags(
//                    WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
//                            WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION // 底部导航栏透明，设置该属性之后底部导航栏设置什么颜色都不起做用
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS // 顶端状态栏透明，设置该属性后，导航栏设置其他的颜色都不起作用
//                    WindowManager.LayoutParams.FLAG_FULLSCREEN // 全屏，不显示顶部状态栏，显示下面导航栏
                    WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN

            );



            window.getDecorView().setSystemUiVisibility(
                    // 导航栏上的图标会变暗，有的不可见
//                    View.SYSTEM_UI_FLAG_LOW_PROFILE |
                    // 全屏 上面导航栏不显示
//                    View.SYSTEM_UI_FLAG_FULLSCREEN
                    // 上面会遮挡，下面不遮挡
//                  View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

                    // 与 View.SYSTEM_UI_FLAG_HIDE_NAVIGATION 一起使用,文档中说如果不设置该值，
                    // 系统使用其他值时会清除掉View.SYSTEM_UI_FLAG_HIDE_NAVIGATION这个值，但没看到效果
//                   View.SYSTEM_UI_FLAG_IMMERSIVE

                    // 与 View.SYSTEM_UI_FLAG_FULLSCREEN 一起使用时，上面的状态栏不显示，从屏幕顶部向下滑动时
                    // 状态栏会出现，一段时间后消息
                    // 与 SYSTEM_UI_FLAG_HIDE_NAVIGATION 一起使用时类似
                    // 在真机上部分会出现状态栏白色的情况
//                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

                    // 布局会扩展到全屏，上下导航栏会遮挡布局
//                       View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    //自动隐藏下边导航栏，手动调出时，不会遮挡布
                    // View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

                    // 不全屏，布局在状态栏下面
                     View.SYSTEM_UI_FLAG_LAYOUT_STABLE

                    // 状态栏文字显示深色
//                     View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

            );

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //4.4-5.0使用三方工具类，有些4.4的手机有问题，这里为演示方便，不使用沉浸式
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            SystemBarTintManager tintManager = new SystemBarTintManager(this);
//            tintManager.setStatusBarTintEnabled(true);
//            tintManager.setStatusBarTintColor(Color.TRANSPARENT);
        }


//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//                | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            window.setStatusBarColor(Color.TRANSPARENT);
//            window.setNavigationBarColor(Color.TRANSPARENT);
//        }


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
//            // 状态栏透明时文字显示深色
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        }


        setContentView(R.layout.activity_main);

    }
}
