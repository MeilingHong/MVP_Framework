package com.meiling.mvp.presenter.net.rx.rx_service;

import com.meiling.mvp.presenter.net.rx.net_result.GetResult;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/5/23 0023.
 */

public interface RxGetRequest3 {
    @GET("/device/service")
    rx.Observable<GetResult> getReqesut(@Query("code") String code,
                                        @Query("type") String type,
                                        @Query("userid") String userid);
}
