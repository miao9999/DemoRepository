package com.limiao.tablayoutwidth;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private TabLayout signTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = findViewById(R.id.tab);

        signTab = findViewById(R.id.signtab);

        mTabLayout.addTab(mTabLayout.newTab().setText("全部"));
        mTabLayout.addTab(mTabLayout.newTab().setText("全部sfj"));
        mTabLayout.addTab(mTabLayout.newTab().setText("全部sdfjh"));
        mTabLayout.addTab(mTabLayout.newTab().setText("全部ad"));
        mTabLayout.addTab(mTabLayout.newTab().setText("全部adf"));
        mTabLayout.addTab(mTabLayout.newTab().setText("全部adf"));
        mTabLayout.addTab(mTabLayout.newTab().setText("全部adf"));
        mTabLayout.addTab(mTabLayout.newTab().setText("全部adfa"));
        mTabLayout.addTab(mTabLayout.newTab().setText("全部adfa"));

        signTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        for (int i = 0; i < 15; i++) {
            signTab.addTab(signTab.newTab().setCustomView(getSignTabView(i, 0)));
        }



        mTabLayout.post(new Runnable() {
            @Override
            public void run() {
                try {
                    //拿到tabLayout的mTabStrip属性
                    Field mTabStripField = mTabLayout.getClass().getDeclaredField("mTabStrip");
                    mTabStripField.setAccessible(true);

                    LinearLayout mTabStrip = (LinearLayout) mTabStripField.get(mTabLayout);

                    int dp10 = 10;

                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                        View tabView = mTabStrip.getChildAt(i);

                        //拿到tabView的mTextView属性
                        Field mTextViewField = tabView.getClass().getDeclaredField("mTextView");
                        mTextViewField.setAccessible(true);

                        TextView mTextView = (TextView) mTextViewField.get(tabView);

                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mTextView.getLayoutParams();
                        layoutParams.leftMargin = 25;
                        layoutParams.rightMargin = 25;
                        mTextView.setLayoutParams(layoutParams);
                        tabView.setPadding(0, 0, 0, 0);

                        // 根据字的宽度设置 tab 的宽度
                        int width = 0;
                        width = mTextView.getWidth();
                        if (width == 0) {
                            mTextView.measure(0, 0);
                            width = mTextView.getMeasuredWidth();
                        }

                        //设置tab左右间距为10dp  注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                        params.width = width + 50;
                        params.leftMargin = dp10;
                        params.rightMargin = dp10;
                        tabView.setLayoutParams(params);

                        tabView.invalidate();
                    }

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });


        signTab.post(new Runnable() {
            @Override
            public void run() {
                try {
                    //拿到tabLayout的mTabStrip属性
                    Field mTabStripField = signTab.getClass().getDeclaredField("mTabStrip");
                    mTabStripField.setAccessible(true);

                    LinearLayout mTabStrip = (LinearLayout) mTabStripField.get(signTab);

                    int dp10 = 10;

                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                        View tabView = mTabStrip.getChildAt(i);

                        //拿到tabView的mTextView属性
//                        Field mTextViewField = tabView.getClass().getDeclaredField("mTextView");
//                        mTextViewField.setAccessible(true);
//
//                        TextView mTextView = (TextView) mTextViewField.get(tabView);

                        tabView.setPadding(0, 0, 0, 0);

                        //因为我想要的效果是   字多宽线就多宽，所以测量mTextView的宽度
                        int width = 100;
//                        width = mTextView.getWidth();
//                        if (width == 0) {
//                            mTextView.measure(0, 0);
//                            width = mTextView.getMeasuredWidth();
//                        }

                        //设置tab左右间距为10dp  注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                        params.width = width ;
                        params.leftMargin = dp10;
                        params.rightMargin = dp10;
                        tabView.setLayoutParams(params);

                        tabView.invalidate();
                    }

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

    }



    private View getSignTabView(int position, int flag) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_quan_sign, null);
        ImageView imageView = view.findViewById(R.id.sign_iv);
        TextView textView = view.findViewById(R.id.sign_tv);
        // 0 未签到 ，1 签到
        if (flag == 0) {
            imageView.setImageResource(R.mipmap.quan_star_normal);
        } else if (flag == 1) {
            imageView.setImageResource(R.mipmap.quan_star);
        }
        textView.setText("第" + position + "天");
        return view;

    }
}
