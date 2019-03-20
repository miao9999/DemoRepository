package com.limiao.annotationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private UserRequst mUserRequst;
    private RequestParam mRequestParam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserRequst = new UserRequst();
        mUserRequst.username = "username";
        mUserRequst.password = "password";

        try {
            RequestParam.requestParam(UserRequst.class,mUserRequst);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
