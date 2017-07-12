package com.meiling.mvp.view.toast;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/7/12.
 */

public class ToastUtil {
    public static void toastShort(final Context context,String msg){
        Toast.makeText(context, ""+msg, Toast.LENGTH_SHORT).show();
    }

    public static void toastLong(final Context context,String msg){
        Toast.makeText(context, ""+msg, Toast.LENGTH_LONG).show();
    }
}
