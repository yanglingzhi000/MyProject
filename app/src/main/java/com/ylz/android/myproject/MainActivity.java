package com.ylz.android.myproject;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;
import com.ylz.android.myproject.fragment.HomePageFragment;

public class MainActivity extends BaseActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvents();
        initDefaultFragment();
    }


    private void initView() {
        // 抽屉控件
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
    }

    /**
     *  关闭左侧菜单
     * @param view
     */
    public void closeLeftMenu(View view){
        mDrawerLayout.closeDrawer(Gravity.LEFT);
    }

    /**
     *  打开左侧菜单
     * @param view
     */
    public void OpenLeftMenu(View view)
    {
        mDrawerLayout.openDrawer(Gravity.LEFT);
		/*mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,
				Gravity.LEFT);*/
    }

    /**
     * 单击事件
     */
    public void onClick(View v){

        switch (v.getId()) {
//            case R.id.btn_homepage_rightmenu:
//                // 打开右侧菜单
//                OpenRightMenu(v);
//                break;
            case R.id.btn_homepage_leftmenu:
                // 打开左侧菜单
                OpenLeftMenu(v);
                break;



            default:
                break;
        }

    }


    /**
     * 初始化事件
     */
    private void initEvents() {
        /**
         * ΪDrawerLayout  抽屉
         */
        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerStateChanged(int newState) {
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                View mContent = mDrawerLayout.getChildAt(0);
                View mMenu = drawerView;
                float scale = 1 - slideOffset;
                float rightScale = 0.8f + scale * 0.2f;

                if (drawerView.getTag().equals("LEFT")) {

                    float leftScale = 1 - 0.3f * scale;

                    ViewHelper.setScaleX(mMenu, leftScale);
                    ViewHelper.setScaleY(mMenu, leftScale);
                    ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));
                    ViewHelper.setTranslationX(mContent,
                            mMenu.getMeasuredWidth() * (1 - scale));
                    ViewHelper.setPivotX(mContent, 0);
                    ViewHelper.setPivotY(mContent,
                            mContent.getMeasuredHeight() / 2);
                    mContent.invalidate();
                    ViewHelper.setScaleX(mContent, rightScale);
                    ViewHelper.setScaleY(mContent, rightScale);
                } else {
                    ViewHelper.setTranslationX(mContent,
                            -mMenu.getMeasuredWidth() * slideOffset);
                    ViewHelper.setPivotX(mContent, mContent.getMeasuredWidth());
                    ViewHelper.setPivotY(mContent,
                            mContent.getMeasuredHeight() / 2);
                    mContent.invalidate();
                    ViewHelper.setScaleX(mContent, rightScale);
                    ViewHelper.setScaleY(mContent, rightScale);
                }

            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }

            @Override
            public void onDrawerClosed(View drawerView) {
				/*mDrawerLayout.setDrawerLockMode(
						DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.LEFT);*/
            }
        });
    }


    /**
     * 将左侧菜单锁定，不可触摸移动打开
     * @param lock
     */
    public void setDrawLayoutLocked(boolean lock){
        if(lock){
            mDrawerLayout.setDrawerLockMode(
                    DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.LEFT);
        }else{
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,
                    Gravity.LEFT);
        }
    }

     /*
    * 初始化fragment
    * */

    private void initDefaultFragment() {
        HomePageFragment homefragment=(HomePageFragment)getSupportFragmentManager().findFragmentByTag("homepagefragment");
        if(homefragment==null){
            homefragment=new HomePageFragment();

            FragmentTransaction t = this
                    .getSupportFragmentManager().beginTransaction();//

            t.add(R.id.rl_main_content, homefragment,"homepagefragment");
            //t.addToBackStack("homepagefragment");
            t.commit();
        }else{

            homefragment.initFragement();

        }
    }
}
