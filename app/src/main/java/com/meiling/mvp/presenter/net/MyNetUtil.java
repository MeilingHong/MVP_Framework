package com.meiling.mvp.presenter.net;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * 完全由自己实现的网络访问工具
 * Created by john on 2017-04-21.
 */

public class MyNetUtil {
    public static final String UTF_8 = "UTF-8";
    public static final String GBK = "GBK";
    public static final String GB2312 = "GB2312";
    public static final String ISO8859_1 = "ISO8859-1";
    public static final String ASCII = "ASCII";

    //TODO 需要针对Get请求增加重定向的处理---其他类型请求也可以增加这个功能，但无法保证不会出现问题（一般情况下，重定向针对的是Get请求）

    public static void postRequest(String urlPaht, Map<String, String> params, String requestEntity) {
        try {
            URL url = new URL(urlPaht);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            /**
             * 增加请求参数
             */
            if (params != null && params.keySet().size() > 0) {
                for (String key : params.keySet()) {
                    httpURLConnection.addRequestProperty(key, params.get(key));
                }
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            /**
             * 向请求体中写入数据
             */
            OutputStream os = httpURLConnection.getOutputStream();
            os.write(requestEntity.getBytes(UTF_8));
            os.flush();
            os.close();

            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                /**
                 * 请求成功
                 */
//                InputStream reader = httpURLConnection.getInputStream();
//                StringBuilder stringBuilder = new StringBuilder();
//                byte[] cache = new byte[4096];
//                int len = -1;
//                while ((len = reader.read(cache)) != -1) {
//                    stringBuilder.append(new String(cache, 0, len, UTF_8));
//                }
                Log.e("LOGLOGLOG", "postRequest----" + getResponseString(httpURLConnection.getInputStream()));
            }
            //TODO 对于重定向的请求需要额外进行处理

            else {
                /**
                 * 请求出错
                 */
                Log.e("LOGLOGLOG", "getRequest----responseCode" + responseCode);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getRequest(String urlPaht, Map<String, String> params) {
        try {
            URL url = new URL(urlPaht);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            /**
             * 增加请求参数
             */
            if (params != null && params.keySet().size() > 0) {
                for (String key : params.keySet()) {
                    httpURLConnection.addRequestProperty(key, params.get(key));
                }
            }
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDefaultUseCaches(false);

//            httpURLConnection.setDoInput(true);
// TODO Get请求是不需要向请求体中写入数据的，根据某些请求，可能还会在检查请求的格式，当Get请求在请求体中写入数据，可能导致请求失败

//            httpURLConnection.setDoOutput(true);
//            /**
//             * 向请求体中写入数据
//             */
//            OutputStream os = httpURLConnection.getOutputStream();
//            os.write(requestEntity.getBytes(UTF_8));
//            os.flush();
//            os.close();

            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                /**
                 * 请求成功
                 */
//                InputStream reader = httpURLConnection.getInputStream();
//                StringBuilder stringBuilder = new StringBuilder();
//                byte[] cache = new byte[4096];
//                int len = -1;
//                while ((len = reader.read(cache)) != -1) {
//                    stringBuilder.append(new String(cache, 0, len, UTF_8));
//                }
                Log.e("LOGLOGLOG", "getRequest----" + getResponseString(httpURLConnection.getInputStream()));
            } else {
                /**
                 * 请求出错
                 */
                Log.e("LOGLOGLOG", "getRequest----responseCode" + responseCode);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void putRequest(String urlPaht, Map<String, String> params, String requestEntity) {
        try {
            URL url = new URL(urlPaht);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            /**
             * 增加请求参数
             */
            if (params != null && params.keySet().size() > 0) {
                for (String key : params.keySet()) {
                    httpURLConnection.addRequestProperty(key, params.get(key));
                }
            }
            httpURLConnection.setRequestMethod("PUT");
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            /**
             * 向请求体中写入数据
             */
            OutputStream os = httpURLConnection.getOutputStream();
            os.write(requestEntity.getBytes(UTF_8));
            os.flush();
            os.close();

            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                /**
                 * 请求成功
                 */
//                InputStream reader = httpURLConnection.getInputStream();
//                StringBuilder stringBuilder = new StringBuilder();
//                byte[] cache = new byte[4096];
//                int len = -1;
//                while ((len = reader.read(cache)) != -1) {
//                    stringBuilder.append(new String(cache, 0, len, UTF_8));
//                }
                Log.e("LOGLOGLOG", "putRequest----" + getResponseString(httpURLConnection.getInputStream()));
            } else {
                /**
                 * 请求出错
                 */
                Log.e("LOGLOGLOG", "putRequest----responseCode" + responseCode);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteRequest(String urlPaht, Map<String, String> params, String requestEntity) {
        try {
            URL url = new URL(urlPaht);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            /**
             * 增加请求参数
             */
            if (params != null && params.keySet().size() > 0) {
                for (String key : params.keySet()) {
                    httpURLConnection.addRequestProperty(key, params.get(key));
                }
            }
            httpURLConnection.setRequestMethod("DELETE");
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            /**
             * 向请求体中写入数据
             */
            OutputStream os = httpURLConnection.getOutputStream();
            os.write(requestEntity.getBytes(UTF_8));
            os.flush();
            os.close();

            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                /**
                 * 请求成功
                 */
//                InputStream reader = httpURLConnection.getInputStream();
//                StringBuilder stringBuilder = new StringBuilder();
//                byte[] cache = new byte[4096];
//                int len = -1;
//                while ((len = reader.read(cache)) != -1) {
//                    stringBuilder.append(new String(cache, 0, len, UTF_8));
//                }
                Log.e("LOGLOGLOG", "deleteRequest----" + getResponseString(httpURLConnection.getInputStream()));
            } else {
                /**
                 * 请求出错
                 */
                Log.e("LOGLOGLOG", "deleteRequest----responseCode" + responseCode);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getResponseString(InputStream reader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        byte[] cache = new byte[4096];
        int len = -1;
        while ((len = reader.read(cache)) != -1) {
            stringBuilder.append(new String(cache, 0, len, UTF_8));
        }
        cache = null;
        reader.close();
        return stringBuilder.toString();
    }
}

