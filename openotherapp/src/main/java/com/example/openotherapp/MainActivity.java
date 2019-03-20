package com.example.openotherapp;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                openApp(getPackageName());

//                startApp();

            }
        });




    }


    //打开一个数据视图，但是没有要求，系统会默认让你从多个中选择其中一个打开
    public void action(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        startActivity(intent);
    }

    //打开一个数据视图，有数据要求，系统帮你打开一个浏览器，并连接到相关的页面
    public void actionUri(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }

    //使用显示跳转的方法跳转到第二个页面
    public void ToSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    //这里只用自己定义的Action字符串来找到对应的页面
    public void MyAction(View v) {
        Intent intent = new Intent("HelloWorld");//Action字符串可以直接放在Intent的构造函数里面，也可以单独写
        // intent.setAction("HelloWorld");
        intent.addCategory("android.intent.category.DEFAULT");//可以没有
        //但是自定义的Action的xml文件里面必须要有category元素，否则会报错
        startActivity(intent);
    }

    //打开程序入口，特征是桌面
    public void actionMain(View v) {
        try {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "找不到目标页面", Toast.LENGTH_SHORT).show();
        }

    }



    public void startApp(){

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }


        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse(Environment.getExternalStorageDirectory()+"/1.txt"), "text/plain");
        startActivity(intent);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    private void openApp(String packageName) {
        Log.e("MainActivity", "package name:" + packageName);


        PackageManager pm = getPackageManager();
        PackageInfo pi = null;
        try {
            pi = getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
        resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        resolveIntent.setPackage(pi.packageName);

        List<ResolveInfo> apps = pm.queryIntentActivities(resolveIntent, 0);

        List<ApplicationInfo> applicationInfoList = pm.getInstalledApplications(0);
        for (int i = 0; i < applicationInfoList.size(); i++) {
            Log.e("MainActivity", "class name:" + applicationInfoList.get(i).className);
            Log.e("MainActivity", "packageName2:" + applicationInfoList.get(i).packageName);



        }


//        for (int i = 0; i < apps.size(); i++) {


//        ResolveInfo ri = apps.iterator().next();
//        while (ri != null) {
//            String packageName1 = ri.activityInfo.packageName;
//
//            Log.e("MainActivity", "package Name1:" + packageName1);
//            if (packageName1.equals("com.sanyuan.assistant")) {
//                String className = ri.activityInfo.name;
//
//                Intent intent = new Intent(Intent.ACTION_MAIN);
//                intent.addCategory(Intent.CATEGORY_LAUNCHER);
//
//                ComponentName cn = new ComponentName(packageName1, className);
//
//                intent.setComponent(cn);
////                startActivity(intent);
//            }
//        }

        PackageManager packageManager = getPackageManager();
        Intent intent = new Intent();
        intent = packageManager.getLaunchIntentForPackage("com.sanyuan.assistant");
        if (intent == null) {
            Toast.makeText(MainActivity.this, "未安装", Toast.LENGTH_LONG).show();
        } else {
            startActivity(intent);
        }

    }

//    }


}
