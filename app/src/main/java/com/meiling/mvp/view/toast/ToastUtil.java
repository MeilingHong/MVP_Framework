package com.meiling.mvp.view.toast;

import android.content.Context;
import android.widget.Toast;

/**
 * 其实本身这种Toast的提示存在一定的局限性（当权限设置了，可能导致无法显示）
 *
 * @auther MeilingHong
 * @date ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}
 * @email marisareimu123@gmail.com
 * @version 
 * @description 添加描述
 */

public class ToastUtil {
    public static void toastShort(final Context context,String msg){
        Toast.makeText(context, ""+msg, Toast.LENGTH_SHORT).show();
    }

    public static void toastLong(final Context context,String msg){
        Toast.makeText(context, ""+msg, Toast.LENGTH_LONG).show();
    }
}
