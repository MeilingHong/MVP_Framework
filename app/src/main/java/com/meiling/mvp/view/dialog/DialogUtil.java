package com.meiling.mvp.view.dialog;

import android.app.Dialog;

/**
 * Dialog的统一管理类
 * Created by john on 2017-04-21.
 */

public class DialogUtil {
    private static DialogUtil instance;

    //TODO 共同的Dialog实例
    private Dialog commonDialog;

    private DialogUtil(){

    }

    public static void init(){
        if(instance==null){
            instance = new DialogUtil();
        }
    }
}
