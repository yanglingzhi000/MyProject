package com.ylz.android.myproject.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylz.android.myproject.MainActivity;
import com.ylz.android.myproject.R;
import com.ylz.android.myproject.adapter.FragmentVpAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 2017/2/9.
 */
public class Page1Fragment extends Fragment implements ViewPager.OnPageChangeListener {

    private MainActivity context;

    private TabLayout tab1;
    private ViewPager vp1;

    private List<String> tablist1 = new ArrayList<>();
    private List<Fragment> views1 = new ArrayList<>();

    private FragmentVpAdapter fragmentVpAdapter;
    private int currindex;

    public int getCurrindex() {
        return currindex;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initViews();
        initTabStr();
        View v = inflater.inflate(R.layout.page1_fragment, container, false);
        context = (MainActivity) this.getActivity();

        tab1 = ((TabLayout) v.findViewById(R.id.tab_page1));
        vp1 = ((ViewPager) v.findViewById(R.id.vp_page1));

        tab1.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < 4; i++) {
            tab1.addTab(tab1.newTab().setText(tablist1.get(i)));
        }

        fragmentVpAdapter = new FragmentVpAdapter(getActivity().getSupportFragmentManager(),views1, tablist1);
        vp1.setAdapter(fragmentVpAdapter);
        vp1.addOnPageChangeListener(this);
        //        将tablelayout和ViewPager关联起来
        tab1.setupWithViewPager(vp1);
        tab1.setTabsFromPagerAdapter(fragmentVpAdapter);

        return v;
    }

    /**
     * 初始化Viewpager的每个页面内容，这里为了简单，就直接new的视图
     * 如果想要不同布局的内容，就按ViewPager的使用方式就行了。
     */
    private void initViews() {
        views1.clear();
        WordsFragment wordsFragment =new WordsFragment();
        ProgressFragment progressFragment = new ProgressFragment();
        ThesaurusFragment thesaurusFragment = new ThesaurusFragment();
        RecommendFragment recommendFragment = new RecommendFragment();
        views1.add(wordsFragment);
        views1.add(progressFragment);
        views1.add(thesaurusFragment);
        views1.add(recommendFragment);

    }

    private void initTabStr() {
        tablist1.clear();
        tablist1.add("背单词");
        tablist1.add("进度");
        tablist1.add("词库");
        tablist1.add("推荐");
    }

    public void refreshData() {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currindex=position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
