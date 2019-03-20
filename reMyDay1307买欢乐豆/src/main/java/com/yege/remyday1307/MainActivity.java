package com.yege.remyday1307;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yege.remyday1306.XiaomiAIDL;

public class MainActivity extends AppCompatActivity {

    String action = "1306hahaha";

    MyConn conn = new MyConn();

    XiaomiAIDL xiaoa;

    private EditText et;


    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();

        intent.setAction(action);
        intent.setPackage("com.yege.remyday1306");

        bindService(intent, conn, BIND_AUTO_CREATE);

        et = (EditText) findViewById(R.id.et);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(view);
            }
        });


    }


    public void click(View v) {

        String s = et.getText().toString().trim();

        int money = 0;

        if (!TextUtils.isEmpty(s)) {
            money = Integer.parseInt(s);
        } else {
            Toast.makeText(this, "输入数", Toast.LENGTH_SHORT).show();
        }


        try {
            String result = xiaoa.xiaomizhifu(money);

            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }


    class MyConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            xiaoa = XiaomiAIDL.Stub.asInterface(service);

            Log.e("yy", "1306连接conn");


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("yy", "1306断开conn");
        }
    }


}
