package com.lly.lookall.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lly.lookall.entity.TabBean;
import com.lly.lookall.module.choiceness.ChoicenessFragment;
import com.lly.lookall.module.Fragment3;
import com.lly.lookall.module.JokeFragment;

import java.util.List;

/**
 * ViewpagerAdapter[v 1.0.0]
 * classes:com.lly.lookall.home.ViewpagerAdapter
 *
 * @author lileiyi
 * @date 2016/4/27
 * @time 13:35
 * @description
 */
public class ViewpagerAdapter extends FragmentPagerAdapter {

    private List<TabBean> mTabList;

    public ViewpagerAdapter(FragmentManager fm, List<TabBean> list) {
        super(fm);
        this.mTabList = list;
    }

    @Override
    public Fragment getItem(int position) {
        TabBean bean = mTabList.get(position);
        BaseFragment baseFragment = null;
        switch (bean.getType()) {
            case 1:
                ChoicenessFragment choicenessFragment = new ChoicenessFragment();
                baseFragment = choicenessFragment;
                break;
            case 2:
                JokeFragment jokeFragment = new JokeFragment();
                baseFragment = jokeFragment;
                break;
            case 3:
                Fragment3 fragment3 = new Fragment3();
                baseFragment = fragment3;
                break;
        }
        return baseFragment;
    }

    @Override
    public int getCount() {
        return mTabList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabList.get(position).getName();
    }
}
