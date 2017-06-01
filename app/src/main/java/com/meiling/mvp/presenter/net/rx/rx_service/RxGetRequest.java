package com.meiling.mvp.presenter.net.rx.rx_service;

import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/5/23 0023.
 */

public interface RxGetRequest {
    @GET("/")
    rx.Observable<String> getReqesut();
}
