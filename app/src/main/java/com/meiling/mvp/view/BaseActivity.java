package com.meiling.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by john on 2017-04-21.
 */

public abstract class BaseActivity extends AppCompatActivity implements IActivity{

    //******************** 上面用于声明组件、域

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //******************** 下面用于实现

//    public View getView(int resourceID){
//        return null;
//    }
//
//    public void setView(int resourceID,ViewTYPE viewTYPE,Object data){
//
//    }
//
//    public void setViewTag(int resourceID,ViewTYPE viewTYPE,Object data){
//
//    }
//
//    public Object getParamter(int type){
//        return null;
//    }
//
//    public void showMyDialog(int type){
//
//    }
//
//    public void dismissMyDialog(int type){
//
//    }
//
//    public void onSuccess(int type,int httpResponseCode,Object result){
//
//    }
//
//    public void onError(int type,int httpResponseCode,Object errorMsg){
//
//    }
}
