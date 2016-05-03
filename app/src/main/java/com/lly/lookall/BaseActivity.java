package com.lly.lookall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * BaseActivity[v 1.0.0]
 * classes:com.lly.lookall.BaseActivity
 *
 * @author lileiyi
 * @date 2016/4/27
 * @time 11:55
 * @description
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

    }
}
