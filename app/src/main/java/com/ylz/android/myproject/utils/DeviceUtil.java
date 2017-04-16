package com.ylz.android.myproject.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

public class DeviceUtil {

	public static String getDeviceid(Context context){
		TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
		String DEVICE_ID = tm.getDeviceId();
		return DEVICE_ID;
	}

}
