package com.lly.lookall.module;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lly.lookall.R;
import com.lly.lookall.home.BaseFragment;

/**
 * Fragment3[v 1.0.0]
 * classes:com.lly.lookall.module.Fragment3
 *
 * @author lileiyi
 * @date 2016/4/28
 * @time 9:52
 * @description
 */
public class Fragment3 extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment3_layout, container, false);
    }
}
