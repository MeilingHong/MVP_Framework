package com.meiling.mvp.application;

import android.content.Context;
import android.content.SharedPreferences;

import com.meiling.mvp.application.constants.CommonSharePreferenceKey;

/**
 * TODO to store little data with key
 * TODO 存储少量数据的键值对工具
 * Created by Administrator on 2017/4/21 0021.
 */

public class BaseSharePreference {
    private static BaseSharePreference instances;
    private BaseSharePreference(){

    }

    public BaseSharePreference getInstances(){
        if(instances==null){
            instances = new BaseSharePreference();
        }
        return  instances;
    }

    public void setUserId(int userId) {
        SharedPreferences.Editor editor = BaseApplication.getInstances().getSharedPreferences(CommonSharePreferenceKey.SP_FILE_NAME, Context.MODE_PRIVATE).edit();
        editor.putInt(CommonSharePreferenceKey.KEY_USERID, userId);
        editor.commit();
    }

    public void setInt(int common_int) {
        SharedPreferences.Editor editor = BaseApplication.getInstances().getSharedPreferences(CommonSharePreferenceKey.SP_FILE_NAME, Context.MODE_PRIVATE).edit();
        editor.putInt(CommonSharePreferenceKey.KEY_COMMON_INT, common_int);
        editor.commit();
    }

    public void setString(String common_String) {
        SharedPreferences.Editor editor = BaseApplication.getInstances().getSharedPreferences(CommonSharePreferenceKey.SP_FILE_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(CommonSharePreferenceKey.KEY_COMMON_STRING, common_String);
        editor.commit();
    }

    //***********************************

    public void setIntValue(String key,int value) {
        SharedPreferences.Editor editor = BaseApplication.getInstances().getSharedPreferences(CommonSharePreferenceKey.SP_FILE_NAME, Context.MODE_PRIVATE).edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public void setStringValue(String key,String value) {
        SharedPreferences.Editor editor = BaseApplication.getInstances().getSharedPreferences(CommonSharePreferenceKey.SP_FILE_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public int getIntValue(String key){
        return BaseApplication.getInstances().getSharedPreferences(CommonSharePreferenceKey.SP_FILE_NAME,Context.MODE_PRIVATE).getInt(key,-1);
    }

    public String getStringValue(String key){
        return BaseApplication.getInstances().getSharedPreferences(CommonSharePreferenceKey.SP_FILE_NAME,Context.MODE_PRIVATE).getString(key,"");
    }

    //***********************************

    public void setIntValue(String filename,String key,int value) {
        SharedPreferences.Editor editor = BaseApplication.getInstances().getSharedPreferences(filename, Context.MODE_PRIVATE).edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public void setStringValue(String filename,String key,String value) {
        SharedPreferences.Editor editor = BaseApplication.getInstances().getSharedPreferences(filename, Context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public int getIntValue(String filename,String key){
        return BaseApplication.getInstances().getSharedPreferences(filename,Context.MODE_PRIVATE).getInt(key,-1);
    }

    public String getStringValue(String filename,String key){
        return BaseApplication.getInstances().getSharedPreferences(filename,Context.MODE_PRIVATE).getString(key,"");
    }


}
