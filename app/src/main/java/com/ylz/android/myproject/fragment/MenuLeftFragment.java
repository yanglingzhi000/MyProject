package com.ylz.android.myproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


import com.ylz.android.myproject.MainActivity;
import com.ylz.android.myproject.R;
import com.ylz.android.myproject.customview.RoundImageView;
import com.ylz.android.myproject.utils.LogUtil;
import com.ylz.android.myproject.utils.SharePrefrenceUtil;

public class MenuLeftFragment extends Fragment implements View.OnClickListener {
    private MainActivity context;
    private RoundImageView riv_avatar;
    private TextView tv_avatar_title;
    private TextView tv_avatar_name;
    private ListView elv_menu;
    private SimpleAdapter adapter;

    private TextView tv_adress;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_left_menu, container, false);
        context=(MainActivity)getActivity();
        initview(v);
        setlistener();
        LogUtil.e("MenuLeftFragment", "初始化结束");
//        initData();
        return v;
    }

    /*
                           * * 获取数据
                           * */
//    private void initData() {
//        AdressBiz adressBiz = new AdressBiz();
//        adressBiz.getdata(MyApplication.mApplication.getApplicationContext(), new NetCallBack<Data<Shi>>() {
//            @Override
//            public void getNetSuccess(int statu, String url, final Data<Shi> shiData) {
//                if(shiData!=null){
//                    final String shiName = shiData.getData().getShiName();
//                     List<Xian> xian_list = shiData.getData().getList();
//                      if(xian_list!=null){
//                          groupdata.clear();
//                          groupdata.addAll(xian_list);
//                      }
//                    Executors.newSingleThreadExecutor().execute(new Runnable() {
//                        @Override
//                        public void run() {
//
//                            List<List<Xiang>> lists = new ArrayList<List<Xiang>>();
//                            for(int i=0;i<groupdata.size();i++){
//                                lists.add(groupdata.get(i).getList());
//                            }
//
//                            if(lists!=null){
//                                childdata.clear();
//                                childdata.addAll(lists);
//                            }
//
//                            getActivity().runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    tv_adress.setText(shiName);
//                                    adapter.notifyDataSetChanged();
//
//                                }
//                            });
//
//                        }
//                    });
//                }
//            }
//
//            @Override
//            public void getNetFauiled(int statu, String url) {
//
//            }
//
//            @Override
//            public void getNetCanceled(int statu, String url) {
//
//            }
//
//            @Override
//            public void getNetError(int statu, String url) {
//
//            }
//
//            @Override
//            public void getNetFinished(int statu, String url) {
//
//            }
//        });
//    }

    private void setlistener() {
        riv_avatar.setOnClickListener(this);
    }

    private void initview(View v) {

        riv_avatar = (RoundImageView) v.findViewById(R.id.riv_avatar);
        tv_avatar_title = (TextView) v.findViewById(R.id.tv_avatar_title);
        tv_avatar_name = (TextView) v.findViewById(R.id.tv_avatar_name);
        tv_adress = (TextView) v.findViewById(R.id.tv_adress);
        elv_menu = (ListView)v.findViewById(R.id.lv_menu);



        tv_avatar_name.setText(String.valueOf(SharePrefrenceUtil.getParam(context, "username", "")));


//        adapter = new ExpandableListViewAdapter(groupdata,childdata,context);
        elv_menu.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.riv_avatar:
//                startActivityForResult(new Intent(context, ManagerCenterActivity.class), 0);
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==1){
            getActivity().finish();
        }
    }
}
