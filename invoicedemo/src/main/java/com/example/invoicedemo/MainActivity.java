package com.example.invoicedemo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webview;
    private String url = "http://zwcx.tax861.gov.cn/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        webview.loadUrl(url);
        webview.addJavascriptInterface(new InJavaScriptLocalObj(), "local_obj");


        String value = "工商北京云岗支行 0200006409200013841";

        int index = 0;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) >= 48 && value.charAt(i) <= 57) {
                index = i;
                break;
            }
        }

        Log.e("MainActivity","pre:" + value.substring(0, index));

        Log.e("MainActivity","after:" + value.substring(index, value.length()));

        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);


                /***************北京市地方税务局******************/
                // 发票代码
                view.loadUrl("javascript:(function(){" +
                        "document.getElementById('fpdmnumber').value='" +
                        "011001800104" +
                        "';" + "})()");

                // 发票号码
                view.loadUrl("javascript:(function(){" +
                        "document.getElementById('fphmnumber').value='" +
                        "10914881" +
                        "';" + "})()");

                //  发票密码
                view.loadUrl("javascript:(function(){" +
                        "document.getElementById('fppassword').value='" +
                        "20180814" +
                        "';" + "})()");

                // 验证码
                view.loadUrl("javascript:(function(){" +
                        "document.getElementById('rand').value='" +
                        "20180814" +
                        "';" + "})()");


                // 验证码 图片   document.getElementById('filldb1').childNodes[16]
                view.loadUrl("javascript:window.local_obj.getImgValue(document.getElementById('filldb1').childNodes[16].src);");


                // 查验
                view.loadUrl("javascript:(function(){" +
                        "document.getElementById('submit1').onclick();" + "})()");


                // 重置
                view.loadUrl("javascript:(function(){" +
                        "document.getElementById('back').click();" + "})()");


                // 查询结果

                // 1. 此发票与北京市地方税务局后台数据信息不符!

                //发票代码： 111001681012
                view.loadUrl("javascript:window.local_obj.getImgValue(document.getElementById('filldb1').childNodes[2]);");

                //发票号码： 111001681012
                view.loadUrl("javascript:window.local_obj.getImgValue(document.getElementById('filldb1').childNodes[4]);");

                //密码： 111001681012
                view.loadUrl("javascript:window.local_obj.getImgValue(document.getElementById('filldb1').childNodes[6]);");


                //此发票与北京市地方税务局后台数据信息不符!
                view.loadUrl("javascript:window.local_obj.getImgValue(document.getElementById('filldb1').childNodes[9]);");

                //此发票不得作为财务报销凭证，任何单位和个人有权拒收并举报！
                view.loadUrl("javascript:window.local_obj.getImgValue(document.getElementById('filldb1').childNodes[11]);");




                /*******************国家税务总局北京市税务局***************************************************/

                // 发票代码
                view.loadUrl("javascript:(function(){" +
                        "document.getElementById('fpdm').value='" +
                        "011001800104" +
                        "';" + "})()");

                // 发票号码
                view.loadUrl("javascript:(function(){" +
                        "document.getElementById('fphm').value='" +
                        "10914881" +
                        "';" + "})()");

                //  发票密码
                view.loadUrl("javascript:(function(){" +
                        "document.getElementById('fpmm').value='" +
                        "20180814" +
                        "';" + "})()");

                // 验证码
                view.loadUrl("javascript:(function(){" +
                        "document.getElementById('yzm').value='" +
                        "20180814" +
                        "';" + "})()");


                // 验证码 图片   document.getElementById('filldb1').childNodes[16]
                view.loadUrl("javascript:window.local_obj.getImgValue(document.getElementById('yzmIMG').src);");


                // 查验
                view.loadUrl("javascript:(function(){" +
                        "document.getElementById('cxan').onclick();" + "})()");


                // 重置
                view.loadUrl("javascript:(function(){" +
                        "document.getElementById('cz').onclick();" + "})()");


                // 结果页
                view.loadUrl("javascript:window.local_obj.getImgValue(document.getElementsByTagName('tbody')[0]);");



                /***********行程单*************************/

                // 电子客票/行程单号
                view.loadUrl("javascript:(function(){" +
                        "document.getElementById('eticketNoORIn').value='" +
                        "20180814" +
                        "';" + "})()");

                //旅客姓名
                view.loadUrl("javascript:(function(){" +
                        "document.getElementById('passengerName_src').value='" +
                        "20180814" +
                        "';" + "})()");

                // 验证码
                view.loadUrl("javascript:(function(){" +
                        "document.getElementById('randCode').value='" +
                        "20180814" +
                        "';" + "})()");



                // 验证码 图片   document.getElementById('filldb1').childNodes[16]
                view.loadUrl("javascript:window.local_obj.getImgValue(document.getElementById('img_randCode_t').src);");



                // 查验
                view.loadUrl("javascript:(function(){" +
                        "document.getElementsByClassName('verification-btn')[0].onclick();" + "})()");





                // 验证码错误  提示不对应
                view.loadUrl("javascript:window.local_obj.getImgValue(document.getElementsByClassName('error-txt')[0].innerHTML);");


                // 结果页 简单
                view.loadUrl("javascript:window.local_obj.getImgValue(document.getElementsByClassName('result-box')[0]);");


                // 结果页 详细
                view.loadUrl("javascript:window.local_obj.getImgValue(document.getElementsByClassName('view-info-box')[0]);");



                // 错误信息  抱歉，由于访问量增多，会有查询不到信息或信息不完整的情况，请多试几次或稍后再试!
                // 正确时不等于
                view.loadUrl("javascript:window.local_obj.getImgValue(document.getElementsByTagName('body')[0].firstElementChild.innerHTML);");

            }
        });


    }


    /**
     * 初始化 WebView 各项设置
     */
    private void initSetting() {
        WebSettings webSettings = webview.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        webSettings.setSupportZoom(false);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setDisplayZoomControls(false);

        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setGeolocationEnabled(true);
        webSettings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webview.setWebContentsDebuggingEnabled(true);
        }
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

    }

    final class InJavaScriptLocalObj {


        @android.webkit.JavascriptInterface
        public void showSource(final String html) {
            Log.e("HTML", html);
            Log.e("WebViewActivity", "InJavaScriptLocalObj-----" + html);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    mTextView.setText(html);
                }
            });
        }

        // 验证码图片
        @android.webkit.JavascriptInterface
        public void getImgValue(final String value) {
            Log.e("WebViewActivity", "img value:" + value);
//            value = "data:image/png;base64,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";
//           final String v = "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";

//            final String v = value.replace("data:image/png;base64,", "");

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    mImageView.setImageBitmap(stringtoBitmap(v));
                }
            });

        }

        @android.webkit.JavascriptInterface
        public void getCodeTip(final String value) {
            Log.e("InJavaScriptLocalObj", "code tip:" + value);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    codeTv.setText(value);
                }
            });
        }

        @JavascriptInterface
        public void getCheckCodeInfo(final String codeInfo) {
            Log.e("WebViewActivity", codeInfo);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (codeInfo.equals("校验码：")) {
                        webview.loadUrl("javascript:(function(){" +
                                "document.getElementById('kjje').value='" +
                                "560566" +
                                "';" + "})()");
                    }
                }
            });

        }

        @JavascriptInterface
        public void getContent(final String content) {
            Log.e("WebViewActivity", "content:" + content);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    Intent intent = new Intent(MainActivity.this,ResultActivity.class);
//                    intent.putExtra("content",content);
//                    startActivity(intent);
                }
            });
        }

    }


    private void initView() {
        webview = (WebView) findViewById(R.id.web);
    }
}
