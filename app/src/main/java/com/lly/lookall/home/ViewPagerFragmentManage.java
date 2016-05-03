package com.lly.lookall.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lly.lookall.R;
import com.lly.lookall.entity.TabBean;
import com.lly.lookall.params.BundleKey;

import java.util.List;

/**
 * ViewPagerFragmentManage[v 1.0.0]
 * classes:com.lly.lookall.home.ViewPagerFragmentManage
 *
 * @author lileiyi
 * @date 2016/4/27
 * @time 13:24
 * @description
 */
public class ViewPagerFragmentManage extends BaseFragment {

    //Tab
    private TabLayout mTablayout;
    private ViewPager mViewpager;
    private List<TabBean> mTabBeen;

    public ViewPagerFragmentManage() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mTabBeen = getArguments().getParcelableArrayList(BundleKey.KEY_TAB);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmentmanage_layout, container, false);
        mTablayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mViewpager = (ViewPager) view.findViewById(R.id.vp_viewpage_fragment);
        mViewpager.setOffscreenPageLimit(2);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getChildFragmentManager(), mTabBeen);
        mViewpager.setAdapter(viewpagerAdapter);
        mTablayout.setupWithViewPager(mViewpager);
    }
}
