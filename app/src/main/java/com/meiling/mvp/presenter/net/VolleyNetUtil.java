package com.meiling.mvp.presenter.net;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

/**
 * TODO Volley似乎无法处理存在重定向的链接
 *
 * Created by Administrator on 2016/12/12 0012.
 */

public class VolleyNetUtil {
    private RequestQueue mQueue;

    //初始化请求队列，需要在Application中调用
    public void init(Context context) {
        if (mQueue == null) {
            mQueue = Volley.newRequestQueue(context);
        }
    }

    private VolleyNetUtil() {

    }

    public static VolleyNetUtil getInstances() {
        return NetAccessHolder.instances;//使用静态内部类控制单例，避免一般的检查的失效问题
    }

    public RequestQueue getmQueue() {
        return mQueue;
    }

    private static class NetAccessHolder {
        private static final VolleyNetUtil instances = new VolleyNetUtil();
    }

    public void startStringRequest(final String urlPath, final INetSuccessListener successListener, final INetErrorListener errorListener) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET,urlPath,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Log.d("TAG", response);
                        if(successListener!=null){
                            successListener.onSuccess(response);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        Log.e("TAG", error.getMessage(), error);
                        if(errorListener!=null){
                            errorListener.onError(error.getMessage());
                        }
                    }
                }
        );
        mQueue.add(stringRequest);
    }

    public void startStringRequest(final String urlPath, final INetSuccessListener successListener, final INetErrorListener errorListener, final Map<String,String> map) {
        StringRequest stringRequest = new StringRequest(urlPath,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Log.d("TAG", response);
                        if(successListener!=null){
                            successListener.onSuccess(response);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        Log.e("TAG", error.getMessage(), error);
                        if(errorListener!=null){
                            errorListener.onError(error.getMessage());
                        }
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> mapParams = map;
//                map.put("params1", "value1");
//                map.put("params2", "value2");
                return mapParams;
            }
        };
        mQueue.add(stringRequest);
    }

    /**
     * *****************************************************************************
     * String 格式返回的数据
     */
    public void startGetStringRequest(final String urlPath, final INetSuccessListener successListener, final INetErrorListener errorListener, final Map<String,String> map) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET,urlPath,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.w("TAG", response);
                        if(successListener!=null){
                            successListener.onSuccess(response);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", error.getMessage(), error);
                        if(errorListener!=null){
                            errorListener.onError(error.getMessage());
                        }
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> mapParams = map;
//                map.put("params1", "value1");
//                map.put("params2", "value2");
                return mapParams;
            }
        };
        mQueue.add(stringRequest);
    }

    public void startPostStringRequest(final String urlPath, final INetSuccessListener successListener, final INetErrorListener errorListener, final Map<String,String> map) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,urlPath,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        LogUtil.e("Volley response success:" + response.toString());
                        if(successListener!=null){
                            successListener.onSuccess(response);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        LogUtil.e("Volley response error:" + error.getMessage());
                        if(errorListener!=null){
                            errorListener.onError(error.getMessage());
                        }
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> mapParams = map;
//                map.put("params1", "value1");
//                map.put("params2", "value2");
                return mapParams;
            }
        };
        mQueue.add(stringRequest);
    }
    /**
     * *****************************************************************************
     * JSON 格式返回的数据
     *
     */

//    public void startGetJSONRequest(final String urlPath, final NetSuccessListener successListener, final NetErrorListener errorListener, final Map<String,String> map) {
//        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, urlPath,
//                null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
////                        Log.d("TAG", response.toString());
//                        if(successListener!=null){
//                            successListener.onSuccess(response);
//                        }
//                    }
//                }
//                ,
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
////                        Log.e("TAG", error.getMessage(), error);
//                        if(errorListener!=null){
//                            errorListener.onError(error.getMessage());
//                        }
//                    }
//                }
//        ){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> mapParams = map;
////                map.put("params1", "value1");
////                map.put("params2", "value2");
//                return mapParams;
//            }
//        };
//        mQueue.add(stringRequest);
//    }
//
//    public void startPostJSONRequest(final String urlPath, final NetSuccessListener successListener, final NetErrorListener errorListener, final Map<String,String> map) {
//        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, urlPath,
//                null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
////                        Log.d("TAG", response.toString());
//                        if(successListener!=null){
//                            successListener.onSuccess(response);
//                        }
//                    }
//                }
//                ,
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("TAG", error.getMessage(), error);
//                        if(errorListener!=null){
//                            errorListener.onError(error.getMessage());
//                        }
//                    }
//                }
//        )/*{
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> mapParams = map;
////                map.put("params1", "value1");
////                map.put("params2", "value2");
//                return mapParams;
//            }
//        }*/;
//        mQueue.add(stringRequest);
//    }

}
