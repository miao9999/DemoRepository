package com.example.uridata;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

import static android.app.RemoteInput.EXTRA_RESULTS_DATA;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE_CAMERA = 00001;
    public static final int REQUEST_CODE_EXTERNAL_STORAGE = 00002;
    public static final int REQUEST_CODE_TACK_PHOTO = 00003;
    public static final int REQUEST_CODE_TACK_ALBUM = 00004;
    private Button mPz;
    private Button mXc;
    private ImageView mIv;
    private Uri mUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

//        obtainPermission();
    }


    // 1. 先获取权限
    public void obtainPermission() {
        // 相机
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_CAMERA);
        } else {
            Log.e("MainActivity", "camera permission");

            tackPhoto();
        }

    }

    public void obtainSDPermission(){
        // sd 卡
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_EXTERNAL_STORAGE);
        } else {
            selectPic();
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_CODE_CAMERA:
                tackPhoto();
                break;
            case REQUEST_CODE_EXTERNAL_STORAGE:
                selectPic();
                break;
        }

    }

    public void tackPhoto(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File imgFile = new File(Environment.getExternalStorageDirectory(),System.currentTimeMillis() + ".png");
        mUri = Uri.fromFile(imgFile);
        // 不使用 intent 传递图片信息，而是直接保存在指定的 uri（mUri）中
        intent.putExtra(MediaStore.EXTRA_OUTPUT,mUri);

        startActivityForResult(intent,REQUEST_CODE_TACK_PHOTO);

    }

    public void selectPic(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent,REQUEST_CODE_TACK_ALBUM);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode){
                case REQUEST_CODE_TACK_PHOTO:
                    Log.e("MainActivity", "tack");
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), mUri);
                        mIv.setImageBitmap(bitmap);

                        File file = new File(mUri.toString());
                        Log.e("MainActivity", "file:" + file);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case REQUEST_CODE_TACK_ALBUM:
                    try {
                        Log.e("MainActivity", "data.getData():" + data.getData());
                        File file = new File(data.getData().toString());
                        Log.e("MainActivity", "file:" + file);
                        // uri 解析成 bitmap
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),data.getData());
                        mIv.setImageBitmap(bitmap);
//                        Utils.getPath(this,data.getData());

                        Uri uri  = Uri.parse(Utils.getPath(this,data.getData()));

                        Log.d("MainActivity", uri.toString());


                        File file1 = new File(Utils.getRealFilePath(this,data.getData()));
                        Log.d("MainActivity", file1.toString());
                         Uri uri1 = Uri.fromFile(file1);
                        Log.e("MainActivity", uri1.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    private void initView() {
        mPz = (Button) findViewById(R.id.pz);
        mXc = (Button) findViewById(R.id.xc);
        mIv = (ImageView) findViewById(R.id.iv);

        mPz.setOnClickListener(this);
        mXc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pz:
                obtainPermission();
                break;
            case R.id.xc:
                obtainSDPermission();
                break;
        }
    }
}
