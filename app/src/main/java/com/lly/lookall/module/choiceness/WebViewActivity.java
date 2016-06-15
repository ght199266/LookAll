package com.lly.lookall.module.choiceness;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lly.lookall.BaseActivity;
import com.lly.lookall.R;
import com.lly.lookall.params.BundleKey;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * WebViewActivity[v 1.0.0]
 * classes:com.lly.lookall.module.choiceness.WebViewActivity
 *
 * @author lileiyi
 * @date 2016/5/3
 * @time 13:21
 * @description
 */
public class WebViewActivity extends BaseActivity {

    private WebView mWebView;
    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_layout);
        Intent intent = getIntent();
        if (intent.hasExtra(BundleKey.URL)) {
//            url = intent.getStringExtra(BundleKey.URL);
        }
        initView();
//        setWebView();

//        HashMap<String, String> hashMap = new HashMap<String, String>();
//        hashMap.put("orderid", "");
//        hashMap.put("amount", "50");
//        hashMap.put("productname", "彩象-充值");
//        hashMap.put("identitytype", "2");
//        hashMap.put("identityid", "603250000018300");
//        hashMap.put("terminaltype", "2");
//        hashMap.put("terminalid", "A0000049CACEDB");
//        hashMap.put("userip", "10.0.3.15");
//        hashMap.put("currency", "156");
//        hashMap.put("productcatalog", "8");
//        hashMap.put("orderexpdate", "60");
//        hashMap.put("transtime", "1464075989");
        OkHttpUtils
                .post()
                .url("http://121.41.114.221:8080/jsp/pay/yeepay/payment_yeepay_wap_request.jsp")
                .addParams("orderid", "17824")
                .addParams("amount", "50")
                .addParams("productname", "彩象-充值")
                .addParams("identitytype", "2")
                .addParams("identityid", "603250000018300")
                .addParams("terminaltype", "2")
                .addParams("terminalid", "A0000049CACEDB")
                .addParams("userip", "10.0.3.15")
                .addParams("currency", "156")
                .addParams("productcatalog", "8")
                .addParams("orderexpdate", "60")
                .addParams("transtime", "1464075989")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        Log.v("leizi", "respons0.0e" + e.toString());
                    }

                    @Override
                    public void onResponse(String response) {
                        Log.v("leizi", "response0.0" + response);
                    }
                });

        OkHttpUtils
                .post()
                .url("http://121.41.114.221:8080/jsp/pay/yeepay/payment_yeepay_wap_request.jsp")
                .addParams("orderid", "17824")
                .addParams("amount", "50")
                .addParams("productname", "彩象-充值")
                .addParams("identitytype", "2")
                .addParams("identityid", "603250000018300")
                .addParams("terminaltype", "2")
                .addParams("terminalid", "A0000049CACEDB")
                .addParams("userip", "10.0.3.15")
                .addParams("currency", "156")
                .addParams("productcatalog", "8")
                .addParams("orderexpdate", "60")
                .addParams("transtime", "1464075989")
                .build()
                .execute(new Callback() {

                    @Override
                    public Object parseNetworkResponse(Response response) throws Exception {
                        Log.v("leizi", "response11" + response.toString());
                        return null;
                    }

                    @Override
                    public void onError(Call call, Exception e) {
                        Log.v("leizi", "Exception" + e.toString());
                    }

                    @Override
                    public void onResponse(Object response) {
                        Log.v("leizi", "response22" + response.toString());
                    }
                });

    }

    /**
     * 设置webView相关属性
     */

    private void setWebView() {
        //设置WebView属性，能够执行Javascript脚本
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(url);
        Log.v("leizi", "Url:=" + url);
//        mWebView.loadUrl("www.baidu.com");
        mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) { //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);
                return true;
            }
        });
    }

    /**
     * 初始化View
     */
    private void initView() {
        mWebView = (WebView) findViewById(R.id.webview);
    }
}
