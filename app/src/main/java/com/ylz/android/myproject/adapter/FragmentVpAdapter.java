package com.ylz.android.myproject.adapter;

/**
 * Created by Administrator on 2016/9/25.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * author: lvqueen
 * mailbox: lvyequeen@163.com
 * time: 15/12/22 23:17
 */
public class FragmentVpAdapter extends FragmentPagerAdapter {
    //    这个是viewpager的填充视图
    private List<Fragment> fragmentList;
    //    这个是table导航条里面的内容填充
    private List<String> tabstrs;

    public FragmentVpAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> tabstrs) {
        super(fm);
        this.fragmentList = fragmentList;
        this.tabstrs = tabstrs;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }


    //    这个是和tablelayout相关的
    @Override
    public CharSequence getPageTitle(int position) {
        return tabstrs.get(position);
    }
}