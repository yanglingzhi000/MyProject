package com.ylz.android.myproject.fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.gson.Gson;
import com.ylz.android.myproject.R;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProgressFragment extends Fragment {


    private WebView webview_charts;

    public ProgressFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_progress, container, false);
//        loadUrl("javascript:refresh('" + getJsData() + "')");
        webview_charts = (WebView) v.findViewById(R.id.charts);
        // 启用支持javascript
        WebSettings settings = webview_charts.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheMaxSize(8 * 1024 * 1024);
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            webview_charts.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            settings.setLoadsImagesAutomatically(true);
        } else {
            settings.setLoadsImagesAutomatically(false);
        }

        // 加载网页文件
        webview_charts.loadUrl("file:///android_asset/index.html");
        get_view();
        return v;
    }

    private void get_view() {
        webview_charts.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if (!webview_charts.getSettings().getLoadsImagesAutomatically()) {
                    webview_charts.getSettings().setLoadsImagesAutomatically(true);
                }
            }
        });
    }



//    void loadUrl(final String url) {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                webview_charts.loadUrl(url);
//            }
//        });
//    }


    String getJsData() {
        JsData data = new JsData();
        data.categories = new String[]{"春", "夏", "秋", "冬"};
        data.series = new YData[2];
        Random random = new Random();
        for (int i = 0; i < data.series.length; i++) {
            data.series[i] = new YData();
            data.series[i].name = "Name" + (i + 1);
            int j = i;
            data.series[i].data = new int[]{100 * j + random.nextInt(100), 100 * j + random.nextInt(100), 100 * j + random.nextInt(100), 100 * j + random.nextInt(100)};
        }
        String json = new Gson().toJson(data);
        System.out.println("json = " + json);
        return json;
    }

    class JsData {
        String[] categories;
        YData[] series;
    }

    class YData {

        String name;

        int[] data;
    }
}
