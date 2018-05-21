package com.meiling.mvp.module.datautil.log;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;

import com.meiling.framework.permission.interfaces.ICommonPermission;

/**
 * Created by john on 2018-05-11.
 */

public class LogPermissionCheck {
    private static final String[] REQUEST_PERMISSIONS_STORAGE = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};

    /**
     *
     * @param activity
     * @return result[0]   权限是否开放了 ;  result[1]   是否允许动态申请权限
     */
    public static boolean[] checkPermission(Activity activity) {
        /**
         * result[0]   权限是否开放了
         *
         * result[1]   是否允许动态申请权限
         */
        boolean[] result = new boolean[]{false,false};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            result[1] = true;
            for (int i = 0; i < REQUEST_PERMISSIONS_STORAGE.length; i++) {
                result[0] = activity.checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_STORAGE[i]) == PackageManager.PERMISSION_GRANTED ? true : false;
                if (result[0]) {
                    continue;
                } else {
                    break;
                }
            }
        }else{
            result[1] = false;
        }
        return result;
    }

    public static boolean[] checkPermission(AppCompatActivity activity) {
        /**
         * result[0]   权限是否开放了
         *
         * result[1]   是否允许动态申请权限
         */
        boolean[] result = new boolean[]{false,false};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            result[1] = true;
            for (int i = 0; i < REQUEST_PERMISSIONS_STORAGE.length; i++) {
                result[0] = activity.checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_STORAGE[i]) == PackageManager.PERMISSION_GRANTED ? true : false;
                if (result[0]) {
                    continue;
                } else {
                    break;
                }
            }
        }else{
            result[1] = false;
        }
        return result;
    }

    public static boolean[] checkPermission(android.app.Fragment activity) {
        /**
         * result[0]   权限是否开放了
         *
         * result[1]   是否允许动态申请权限
         */
        boolean[] result = new boolean[]{false,false};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            result[1] = true;
            for (int i = 0; i < REQUEST_PERMISSIONS_STORAGE.length; i++) {
                result[0] = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_STORAGE[i]) == PackageManager.PERMISSION_GRANTED ? true : false;
                if (result[0]) {
                    continue;
                } else {
                    break;
                }
            }
        }else{
            result[1] = false;
        }
        return result;
    }

    public static boolean[] checkPermission(android.support.v4.app.Fragment activity) {
        /**
         * result[0]   权限是否开放了
         *
         * result[1]   是否允许动态申请权限
         */
        boolean[] result = new boolean[]{false,false};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            result[1] = true;
            for (int i = 0; i < REQUEST_PERMISSIONS_STORAGE.length; i++) {
                result[0] = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_STORAGE[i]) == PackageManager.PERMISSION_GRANTED ? true : false;
                if (result[0]) {
                    continue;
                } else {
                    break;
                }
            }
        }else{
            result[1] = false;
        }
        return result;
    }
}
