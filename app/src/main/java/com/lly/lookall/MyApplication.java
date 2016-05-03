package com.lly.lookall;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * com.lly.lookall.MyApplication[v 1.0.0]
 * classes:PACKAGE_NAME.com.lly.lookall.MyApplication
 *
 * @author lileiyi
 * @date 2016/5/3
 * @time 11:26
 * @description
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());
    }
}
