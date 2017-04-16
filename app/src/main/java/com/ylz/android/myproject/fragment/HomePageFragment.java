package com.ylz.android.myproject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ylz.android.myproject.MainActivity;
import com.ylz.android.myproject.R;
import com.ylz.android.myproject.utils.LogUtil;

/**
 * Created by Android on 2017/2/15.
 */
public class HomePageFragment extends Fragment implements View.OnClickListener {


    private MainActivity context;
    private Fragment[] listpage;
    private LinearLayout ll_homepage_selcontent;
    private View divider_homepage_titlebar;
    private RelativeLayout btn_homepage_leftmenu;
    private TextView tv_homepage_title;
    private Button[] btns;
    private RelativeLayout rl_homepae_titlebar;
    private int currfragmentindex;
    private int lastfragmentindex;
    private Page1Fragment page1;
    private Page2Fragment page2;
    private Page3Fragment page3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_home_page_fragment, container, false);
        context = (MainActivity) this.getActivity();
        listpage = new Fragment[4];
        initview(v);
        return v;
    }

    private void initview(View v) {

        // 头部栏
        rl_homepae_titlebar = (RelativeLayout) v.findViewById(R.id.rl_homepae_titlebar);
        // 底部栏
        ll_homepage_selcontent = (LinearLayout) v.findViewById(R.id.ll_homepage_selcontent);
        //白底边
        divider_homepage_titlebar = (View) v.findViewById(R.id.divider_homepage_titlebar);
        // 左侧菜单
        btn_homepage_leftmenu = (RelativeLayout) v.findViewById(R.id.btn_homepage_leftmenu);
        // 右侧菜单
//        btn_homepage_rightmenu = (ImageButton) v.findViewById(R.id.btn_homepage_rightmenu);
        // 标题
        tv_homepage_title = (TextView) v.findViewById(R.id.tv_homepage_title);

        btns = new Button[4]; // 存储5个菜单键

        Button btn_homepage_1 = (Button) v.findViewById(R.id.btn_homepage_1);
        btns[0] = btn_homepage_1;

        Button btn_homepage_2 = (Button) v.findViewById(R.id.btn_homepage_2);
        btns[1] = btn_homepage_2;

        Button btn_homepage_3 = (Button) v.findViewById(R.id.btn_homepage_3);
        btns[2] = btn_homepage_3;

        // 5个菜单键的单击事件的监听
        btn_homepage_1.setOnClickListener(this);
        btn_homepage_1.setSelected(true);
        btn_homepage_2.setOnClickListener(this);
        btn_homepage_3.setOnClickListener(this);

        currfragmentindex = 0;//当前fragment index
        lastfragmentindex = 0;//上一次fragment index

        initFragement();
    }

    public void initFragement() {
        page1 = (Page1Fragment) context.getSupportFragmentManager().findFragmentByTag("page1");
        if (page1 == null) {
            page1 = new Page1Fragment();
            listpage[0] = page1; // 将page1加入 数组
            FragmentTransaction t = context
                    .getSupportFragmentManager().beginTransaction();

            t.add(R.id.fl_homepage_content, page1, "page1");
            //t.addToBackStack("page1");
            t.commit();
        } else {
            page1.refreshData(); // 默认选择全部
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_homepage_1:
                setVsibility(true);
                //打开单词页
                OpenPage1(v);
                break;
            case R.id.btn_homepage_2:
                setVsibility(false);
                //打开短文页
                OpenPage2(v);
                break;
            case R.id.btn_homepage_3:
                setVsibility(false);
                //打开组织架构
                OpenPage3(v);
                break;
            case R.id.btn_homepage_leftmenu:
                break;
        }
    }

    private void OpenPage3(View v) {
        System.out.println("打开page3");
        // 设置标题
        tv_homepage_title.setText("群组");

        if (page3 == null) {
            page3 = new Page3Fragment();
            listpage[2] = page3;

            FragmentTransaction t = context
                    .getSupportFragmentManager().beginTransaction();
            t.add(R.id.fl_homepage_content, page3, "page3");
            currfragmentindex = 2;

            changeButtonState();

            t.hide(listpage[lastfragmentindex]);
            lastfragmentindex = currfragmentindex;
            t.commit();
        } else {

            if (!page3.isHidden()) {
                return;
            }

            FragmentTransaction t = context
                    .getSupportFragmentManager().beginTransaction();
            currfragmentindex = 2;

            changeButtonState();

            System.out.println("lastfragmentindex,currfragmentindex"
                    + lastfragmentindex + "," + currfragmentindex);

            t.hide(listpage[lastfragmentindex]);
            t.show(listpage[currfragmentindex]);
            lastfragmentindex = currfragmentindex;
            t.commit();
        }
    }

    private void OpenPage2(View v) {
        System.out.println("打开page2");
        // 设置标题
        tv_homepage_title.setText("短文");

        page2=(Page2Fragment)context.getSupportFragmentManager().findFragmentByTag("page2");

        if (page2 == null) {
            LogUtil.e("HomepageFragment.page2=null",
                    "HomepageFragment.page2=null");
            page2 = new Page2Fragment();

            listpage[1] = page2;

            FragmentTransaction  t = context
                    .getSupportFragmentManager().beginTransaction();
            t.add(R.id.fl_homepage_content, page2, "page2");



            currfragmentindex = 1;

            changeButtonState();

            t.hide(listpage[lastfragmentindex]);
            lastfragmentindex = currfragmentindex;
            //t.addToBackStack("page2");
            t.commit();
        } else {





            LogUtil.e("HomepageFragment.page2",
                    page2.isVisible() + "," + page2.isAdded() + "," + page2.isDetached() + "," + page2.isHidden());

          /*  if (!page2.isHidden()) {
                return;
            }
*/
            FragmentTransaction  t = context
                    .getSupportFragmentManager().beginTransaction();
            currfragmentindex = 1;

            changeButtonState();

            t.hide(listpage[lastfragmentindex]);
            t.show(listpage[currfragmentindex]);
            lastfragmentindex = currfragmentindex;
            t.commit();
        }
    }

    private void OpenPage1(View v) {
        System.out.println("打开page1");
        // 设置标题
        tv_homepage_title.setText("背单词");

        if (!page1.isHidden()) {
            return;
        }

        FragmentTransaction t = context.getSupportFragmentManager().beginTransaction();
        currfragmentindex = 0;

        changeButtonState();

        System.out.println("lastfragmentindex,currfragmentindex"
                + lastfragmentindex + "," + currfragmentindex);

        t.hide(listpage[lastfragmentindex]);
        t.show(listpage[currfragmentindex]);
        lastfragmentindex = currfragmentindex;
        t.commit();
    }

    private void changeButtonState() {
        /**
         * 改变按钮的颜色
         */
        btns[lastfragmentindex].setSelected(false);
        btns[currfragmentindex].setSelected(true);

    }

    public void setVsibility(boolean isShow) {
        if (isShow) {
            btn_homepage_leftmenu.setVisibility(View.VISIBLE);
            ((MainActivity) getActivity()).setDrawLayoutLocked(false);
        } else {
            btn_homepage_leftmenu.setVisibility(View.GONE);
            ((MainActivity) getActivity()).setDrawLayoutLocked(true);
        }

    }
}
