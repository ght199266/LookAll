package com.lly.lookall.module.choiceness;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lly.lookall.BaseActivity;
import com.lly.lookall.R;
import com.lly.lookall.params.BundleKey;

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
            url = intent.getStringExtra(BundleKey.URL);
        } else {
            showToast("URL is null");
        }
        initView();
        //设置WebView属性，能够执行Javascript脚本
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(url);
    }

    private void initView() {
        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) { //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);
                return true;
            }
        });
    }
}
