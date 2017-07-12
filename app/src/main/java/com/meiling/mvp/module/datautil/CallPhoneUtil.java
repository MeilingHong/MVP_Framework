package com.meiling.mvp.module.datautil;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;

import com.meiling.mvp.R;
import com.meiling.mvp.view.toast.ToastUtil;

/**
 * Created by Administrator on 2017/6/9 0009.
 */

public class CallPhoneUtil {
    public static void callPhone(Activity activity, String phoneNumber) {
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ToastUtil.toastLong(activity,activity.getString(R.string.permission_call));
            return;
        }
        //TODO 含有国际地区编码的电话应该如何进行判断，暂时未发现合适的
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
        activity.startActivity(intent);
    }
}
