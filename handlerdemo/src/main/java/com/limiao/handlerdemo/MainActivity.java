package com.limiao.handlerdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ThreadLocal<Boolean> mBooleanThreadLocal = new ThreadLocal<>();
    private Button btn1;
    private Button btn2;


    private Handler.Callback mCallback = new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            int result = msg.what;
            Toast.makeText(MainActivity.this, "result:" + result, Toast.LENGTH_SHORT).show();
            return false;
        }
    };
    private Handler mHandler = new Handler(mCallback) ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        // 为 mBooleanThreadLocal 设置值为 true
        mBooleanThreadLocal.set(true);


        Log.e("MainActivity", "[Thread#main]mBooleanThreadLocal=" + mBooleanThreadLocal.get());








    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                new Thread("Thread#1") {
                    @Override
                    public void run() {
                        super.run();
                        mBooleanThreadLocal.set(false);
                        Log.e("MainActivity", "[Thread#1]mBooleanThreadLocal=" + mBooleanThreadLocal.get());
                        Message message = Message.obtain();
                        message.what = 1;
                        mHandler.sendMessage(message);
                    }
                }.start();
                break;
            case R.id.btn_2:
                new Thread("Thread#2") {
                    @Override
                    public void run() {
                        super.run();
//                mBooleanThreadLocal.set(false);
//                        Log.e("MainActivity", "[Thread#2]mBooleanThreadLocal=" + mBooleanThreadLocal.get());

                        Looper.prepare();
                        Looper.loop();
                        final Handler handler = new Handler(){
                            @Override
                            public void handleMessage(Message msg) {
                                super.handleMessage(msg);
                                int result = msg.what;
                                Log.e("MainActivity", "result:" + result);
                            }
                        };

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                Message msg = Message.obtain();
                                msg.what = 2;
                                handler.sendMessage(msg);
                            }
                        }).start();


                    }
                }.start();
                break;
        }

    }



}
