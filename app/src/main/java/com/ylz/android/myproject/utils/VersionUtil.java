package com.ylz.android.myproject.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class VersionUtil {
	/**
	 * 获取app版本号
	 */
	 public static String getVersion(Context context) {
		 String version=null;
		 PackageManager pm = context.getPackageManager();
		 try {
			 PackageInfo packinfo = pm.getPackageInfo(context.getPackageName(), 0);
			 version = packinfo.versionName;
			 return version;
		 } catch (NameNotFoundException e) {
			 e.printStackTrace();
			 return version;
		 }
	 }

}
