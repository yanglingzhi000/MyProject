package com.ylz.android.myproject.utils;





import com.ylz.android.myproject.application.MyApplication;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/4/28.
 */
public class PrintParams {

    public static void  printParam(HashMap<String, String> hm ){


        try {
            if(hm!=null && !MyApplication.isRelease) {
                Set s = hm.entrySet();
                Iterator i = s.iterator();
                while (i.hasNext()) {
                    Map.Entry o = (Map.Entry) i.next();
                    LogUtil.e("params",o.getKey() + " -- " + o.getValue());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
