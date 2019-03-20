package com.example.webveiwbipmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private ImageView iv;

        private String url = "file:///android_asset/localResult.html";
//    private String url = "http://www.runoob.com/java/number-equals.html";

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.enableSlowWholeDocumentDraw();
        }
        // 状态栏的高度
        int statusBarHeight1 = -1;
        //获取status_bar_height资源的ID
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight1 = getResources().getDimensionPixelSize(resourceId);
        }

        Log.e("MainActivity", "statusBarHeight1:" + statusBarHeight1);

        Window window = getWindow();
        window.setStatusBarColor(Color.RED);

        setContentView(R.layout.activity_main);
        initView();
        initSetting();


        mWebView.addJavascriptInterface(new JavaScriptInterface(), "HTMLOUT");

        mWebView.loadUrl(url);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(final WebView view, String url) {
                super.onPageFinished(view, url);

                mWebView.loadUrl("javascript:window.HTMLOUT.getContentWidth(document.getElementsByTagName('html')[0].scrollWidth);");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        snapshotView(view);
                    }
                }, 2000);
            }
        });

        String classify = "";
        String value = "收派服务费";
        String string = "";
        if (value.contains("*")) {
            string = value.substring(value.indexOf("*") + 1, value.lastIndexOf("*"));
        }
        if (string.contains("餐饮")) {
            classify = "food";
        } else if (string.contains("住宿")) {
            classify = "live";
        } else if (string.contains("交通")) {
            classify = "traffic";
        } else {
            classify = "other";
        }


        Log.e("MainActivity", "classify:" + classify);

    }

    private void initView() {
        mWebView = (WebView) findViewById(R.id.webview);
        iv = (ImageView) findViewById(R.id.iv);
    }


    /**
     * webview 截屏
     *
     * @param view
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public Bitmap snapshotView(WebView view) {

        //屏幕
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Log.e("MainActivity", "屏幕高:" + dm.heightPixels);

        //应用区域
        Rect outRect1 = new Rect();
        // outRect1 被处理成应用的显示区域（除状态栏之外的所有可视区域）
        getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect1);
        Log.e("MainActivity", "应用区顶部" + outRect1.top);
        Log.e("MainActivity", "应用区高" + outRect1.height());

        int top = outRect1.top;



        //View绘制区域
        Rect outRect2 = new Rect();

        //不能像上边一样由outRect2.top获取，这种方式获得的top是0,获取到的值跟滑动的值有关
        getWindow().findViewById(Window.ID_ANDROID_CONTENT).getDrawingRect(outRect2);


        Log.e("MainActivity---", "outRect2.left:" + outRect2.left);
        Log.e("MainActivity---", "outRect2.top:" + outRect2.top);
        Log.e("MainActivity---", "outRect2.right:" + outRect2.right);
        Log.e("MainActivity---", "outRect2.bottom:" + outRect2.bottom);


        Log.e("MainActivity", "View绘制区域顶部-错误方法：" + outRect2.top);
        // 标题栏的高度
        int viewTop = getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();   //要用这种方法
        Log.e("MainActivity", "View绘制区域顶部-正确方法：" + viewTop);
        Log.e("MainActivity", "View绘制区域高度：" + outRect2.height());


//        if (window != null) {
        //找到当前页面的根布局
//            View view = window.getDecorView().getRootView();
        //获取当前屏幕的大小
        int width = view.getWidth();
        int height = view.getHeight();
//


        Log.e("MainActivity", "view.getContentHeight():" + view.getContentHeight());
        Log.e("MainActivity", "viewTop:" + viewTop);
//        Log.e("MainActivity", "view.getDrawingCache().getHeight():" + view.getDrawingCache().getHeight());
        Log.e("MainActivity", "width:" + width);
        //////缓存的图片/////////////////////////////////////////////////////////////////////


        //设置缓存
        view.setDrawingCacheEnabled(true);
        // 如果手动调用了 buildDrawingCache()，而没有调用 setDrawingCacheEnabled(true),之后应该调用 destroyDrawingCache() 清除缓存
        // 有关在兼容模式下自动缩放的注意事项:当不能自动缩放时，该方法会创建一个与 view 大小相同的 bitmap，因为这个 bitmap 会按照父容器的比例去绘制，屏幕上可能会显示缩放控件
        // 为了避免这个缩放，应该通过设置为可以自动缩放，这样的话会生成一个与 view 不一样的尺寸的 bitmap，这也意味着你的应用必须能处理这个尺寸
        // 当硬件加速开启的时候应该避免调用这个方法，如果不需要绘制缓存 bitmap 的话，开启会增加内存的消耗，并且会导致 view 在软件中呈现一次，因此会影响性能
        view.buildDrawingCache();
            /*1、从缓存中获取当前屏幕的图片,创建一个DrawingCache的拷贝，因为DrawingCache得到的位图在禁用后会被回收
             如果直接是控件调用buildDrawingCache
             *是该控件当前显示在屏幕上的部分就不用减去状态栏的高度了
             */
            //
        view.getDrawingCache().setHeight(view.getHeight());
//        Bitmap temBitmap = Bitmap.createBitmap(view.getDrawingCache(), 0, 0, width, view.getHeight());


        //禁用DrawingCahce否则会影响性能 ,而且不禁止会导致每次截图到保存的是缓存的位图
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);


        Log.e("MainActivity", "view.getWidth():" + view.getWidth());
        Log.e("MainActivity", "view.getHeight():" + view.getHeight());

        Log.e("MainActivity", "view.getContentHeight():" + view.getContentHeight());
//        Log.e("MainActivity", "(view.getContentHeight() * density):" + (int) (view.getContentHeight() * density));

        ////view 的全部内容///////////////////////////////////////////////////


         float density = getResources().getDisplayMetrics().density;
         Bitmap temBitmap = Bitmap.createBitmap(width, (int) (view.getContentHeight() * density), Bitmap.Config.ARGB_4444);
         Canvas canvas = new Canvas(temBitmap);
         view.draw(canvas);



        iv.setImageBitmap(temBitmap);
        return temBitmap;
//        return view.getDrawingCache();

//        }
//        return null;
    }


//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    public Bitmap snapshotView(WebView view){
//        //设置缓存
//        view.setDrawingCacheEnabled(true);
//        // 如果手动调用了 buildDrawingCache()，而没有调用 setDrawingCacheEnabled(true),之后应该调用 destroyDrawingCache() 清除缓存
//        // 有关在兼容模式下自动缩放的注意事项:当不能自动缩放时，该方法会创建一个与 view 大小相同的 bitmap，因为这个 bitmap 会按照父容器的比例去绘制，屏幕上可能会显示缩放控件
//        // 为了避免这个缩放，应该通过设置为可以自动缩放，这样的话会生成一个与 view 不一样的尺寸的 bitmap，这也意味着你的应用必须能处理这个尺寸
//        // 当硬件加速开启的时候应该避免调用这个方法，如果不需要绘制缓存 bitmap 的话，开启会增加内存的消耗，并且会导致 view 在软件中呈现一次，因此会影响性能
//        view.buildDrawingCache();
//            /*1、从缓存中获取当前屏幕的图片,创建一个DrawingCache的拷贝，因为DrawingCache得到的位图在禁用后会被回收
//             如果直接是控件调用buildDrawingCache
//             *是该控件当前显示在屏幕上的部分就不用减去状态栏的高度了
//             */
//        //
//        view.getDrawingCache().setHeight(view.getHeight());
//        Bitmap temBitmap = Bitmap.createBitmap(view.getDrawingCache(), 0, 0, view.getWidth(), view.getHeight());
//
//        //禁用DrawingCahce否则会影响性能 ,而且不禁止会导致每次截图到保存的是缓存的位图
//        view.destroyDrawingCache();
//        view.setDrawingCacheEnabled(false);
//        return temBitmap;
//
//    }


    /**
     * 初始化 WebView 各项设置
     */
    private void initSetting() {
        WebSettings webSettings = mWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);

        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setGeolocationEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mWebView.setWebContentsDebuggingEnabled(true);
        }
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);


    }

    class JavaScriptInterface {
        int webviewContentWidth;

        @JavascriptInterface
        public void getContentWidth(String value) {
            if (value != null) {
                webviewContentWidth = Integer.parseInt(value);
                Log.e("MainActivity", "Result from javascript: " + webviewContentWidth);
            }
        }
    }
}
