package com.meiling.mvp.presenter.net;

import org.json.JSONObject;

/**
 * Created by Administrator on 2016/12/12 0012.
 */

public interface INetSuccessListener {
    String onSuccess(String responseMessage);
    JSONObject onSuccess(JSONObject responseMessage);
}
