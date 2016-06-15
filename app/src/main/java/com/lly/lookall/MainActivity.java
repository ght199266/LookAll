package com.lly.lookall;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.lly.lookall.entity.TabBean;
import com.lly.lookall.home.ViewPagerFragmentManage;
import com.lly.lookall.params.BundleKey;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private ArrayList<TabBean> mTabBeen = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initFragment();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mTabBeen.add(new TabBean("精选", 1));
        mTabBeen.add(new TabBean("笑话", 2));
        mTabBeen.add(new TabBean("图片", 3));
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        ViewPagerFragmentManage viewPagerFragmentManag = new ViewPagerFragmentManage();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(BundleKey.KEY_TAB, mTabBeen);
        viewPagerFragmentManag.setArguments(bundle);
        fragmentTransaction.add(R.id.layout_main_container, viewPagerFragmentManag);
        fragmentTransaction.commit();
    }
}
