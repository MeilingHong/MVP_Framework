package com.meiling.mvp.module.datautil;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by Administrator on 2017/4/24 0024.
 */

public class CharUtil {

    public static String getIMEI(Context context) {

        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        return imei;
    }

    public static String getIMSI(Context context){
        TelephonyManager mTelephonyMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String imsi = mTelephonyMgr.getSubscriberId();
        return imsi ;
    }
}
