package com.meiling.mvp.presenter.net.rx.rx_service;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/5/23 0023.
 */

public interface RxGetRequest2 {
    @GET("/device/service")
    rx.Observable<String> getReqesut(@Query("code") String code,
                                     @Query("type") String type,
                                     @Query("userid") String userid);
}
