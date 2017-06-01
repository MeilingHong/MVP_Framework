package com.meiling.mvp.module.datautil;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * 序列化工具类
 * Created by Administrator on 2017/4/21 0021.
 */

public class SerialUtil {
    //TODO 专做序列化相关工作
    private static Gson gson = new Gson();

    /**
     *
     * @param jsonData
     * @param classes new TypeToken<T>(){}.getType();
     * @return T需要进行强制转换
     */
    public static Object jsonToObject(String jsonData, Type classes){
        return gson.fromJson(jsonData,classes);
    }

    public static void close(){
        if(gson!=null){
            gson = null;
        }
    }
}
