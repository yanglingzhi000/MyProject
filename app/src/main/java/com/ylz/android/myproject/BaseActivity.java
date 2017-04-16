package com.ylz.android.myproject;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.ylz.android.myproject.application.MyApplication;


/**
 * Created by NewWater on 2016/2/25.
 */
public class BaseActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        MyApplication.listactivity.add(this);
    }

    public void back(View v) {
        finish();
    }

}
