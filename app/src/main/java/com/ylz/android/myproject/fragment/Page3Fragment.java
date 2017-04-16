package com.ylz.android.myproject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylz.android.myproject.MainActivity;
import com.ylz.android.myproject.R;

/**
 * Created by Android on 2017/2/9.
 */
public class Page3Fragment extends Fragment {

    private MainActivity context;

    private int currindex;

    public int getCurrindex() {
        return currindex;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.page3_fragment, container, false);
        context = (MainActivity) this.getActivity();
        return v;
    }
}
