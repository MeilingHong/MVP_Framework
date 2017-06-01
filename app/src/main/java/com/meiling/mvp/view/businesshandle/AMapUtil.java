package com.meiling.mvp.view.businesshandle;

//import com.amap.api.location.AMapLocationClient;
//import com.amap.api.maps2d.AMap;
//import com.amap.api.maps2d.CameraUpdateFactory;
//import com.amap.api.maps2d.LocationSource;
//import com.amap.api.maps2d.model.LatLng;

/**
 * 高德地图工具类，实际发现针对View的操作还是的放在Activity中进行，
 * Created by Administrator on 2017/4/24 0024.
 */

public class AMapUtil {
    public static final int LOCATION_GET_LATLNG = 1;//仅仅获取定位点
    public static final int LOCATION_SHOW_LATLNG = 2;//获取定位点，并且展示到地图上
    public static final int LOCATION_GET_SHOW_MOVE_LATLNG = 3;//获取定位点，展示到地图上，同时将焦点移动到定位点处

    //
    private int SOLID_ZOOM =16;

    //自己的定位信息
    private double selfLatitude = -1000;
    private double selfLongitude = -1000;
    private String selfAdress = "";

    private static AMapUtil instance;

    private AMapUtil(){

    }

    public static AMapUtil getInstances(){
        if(instance==null){
            instance = new AMapUtil();
        }
        return instance;
    }

    //TODO 释放对象
    public static void close(){
        if(instance!=null){
            try {
                instance.finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }finally {
                instance=null;
            }
        }
    }

//    public void stopLocationSelf(AMapLocationClient mlocationClient){
//        if (mlocationClient != null) {
//            mlocationClient.stopLocation();
//            mlocationClient.onDestroy();
//        }
//        mlocationClient = null;
//    }
//
//    public void startLocationSelf(final Context context,
//                                         final AMap aMap,
//                                         final  AMapLocationClient mlocationClient,
//                                         final LocationSource.OnLocationChangedListener mListener,
//                                         final int locationType,
//                                         final int locationPointImgResourceID){
//        stopLocationSelf(mlocationClient);
//        MyLocationStyle myLocationStyle = new MyLocationStyle();
//        myLocationStyle.myLocationIcon(BitmapDescriptorFactory
//                .fromResource(locationPointImgResourceID));// 设置小蓝点的图标
//        myLocationStyle.strokeColor(Color.TRANSPARENT);// 设置圆形的边框颜色
//        myLocationStyle.radiusFillColor(Color.argb(0, 0, 0, 0));// 设置圆形的填充颜色
//        // myLocationStyle.anchor(int,int)//设置小蓝点的锚点
//        myLocationStyle.strokeWidth(1.0f);// 设置圆形的边框粗细
//
//        aMap.setMyLocationStyle(myLocationStyle);
//        aMap.moveCamera(CameraUpdateFactory.zoomTo(16));
//        aMap.setLocationSource(new LocationSource() {
//            @Override
//            public void activate(OnLocationChangedListener onLocationChangedListener) {
////                mListener = onLocationChangedListener;
////                if (mlocationClient == null) {
////                    mlocationClient = new AMapLocationClient(context);
////                    mLocationOption = new AMapLocationClientOption();
////                    //设置定位监听
////                    mlocationClient.setLocationListener(new AMapLocationListener() {
////                        @Override
////                        public void onLocationChanged(AMapLocation aMapLocation) {
////                            if (mListener != null && aMapLocation != null) {
////                                if (aMapLocation != null
////                                        && aMapLocation.getErrorCode() == 0) {
////                                    if(locationType!=LOCATION_GET_LATLNG){
////                                        mListener.onLocationChanged(aMapLocation);//TODO 不调用这句，仍能获取到个人的定位信息，不过style选项不会生效[即定位图标不会显示]
////                                    }
////                                    selfLatitude = aMapLocation.getLatitude();
////                                    selfLongitude = aMapLocation.getLongitude();
////                                    selfAdress = aMapLocation.getAddress();
//////                                    Log.e("自己的位置\nselfLatitude:" + selfLatitude +
//////                                            "\nselfLongitude:" + selfLongitude +
//////                                            "\nselfAdress:" + selfAdress+
//////                                            "\n TYPE:"+locateType+
//////                                            "\n("+"LOCATION_TYPE_GET_POSITION=="+LOCATION_TYPE_GET_POSITION+"  ;  "
//////                                            +"LOCATION_TYPE_SHOW_POSITION=="+LOCATION_TYPE_SHOW_POSITION+"   ;  "
//////                                            +"LOCATION_TYPE_SHOW_AND_MOVE_POSITION=="+LOCATION_TYPE_SHOW_AND_MOVE_POSITION+"  "+")"
//////                                    );
////
////                                    stopLocationSelf(mlocationClient);
////                                    if(locationType==LOCATION_GET_SHOW_MOVE_LATLNG){
////                                        moveCamera(new LatLng(selfLatitude, selfLongitude));
////                                    }
////                                }else{
////                                }
////                            }else{
////                            }
////                        }
////                    });
////                    mLocationOption.setInterval(30000);
////                    //设置为高精度定位模式
////                    mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
////                    //设置定位参数
////                    mlocationClient.setLocationOption(mLocationOption);
////                    mlocationClient.startLocation();
//                }
//            }
//
//            @Override
//            public void deactivate() {
////                mListener = null;
////                if (mlocationClient != null) {
////                    mlocationClient.stopLocation();
////                    mlocationClient.onDestroy();
////                }
////                mlocationClient = null;
//            }
//        });// 设置定位监听
//        aMap.getUiSettings().setZoomControlsEnabled(false);
//        aMap.getUiSettings().setCompassEnabled(false);
//        aMap.getUiSettings().setMyLocationButtonEnabled(false);// 设置默认定位按钮是否显示
//        aMap.setMyLocationEnabled(true);
//    }

//    public void moveCamera(final AMap aMap,LatLng point) {
//        if (point == null || aMap==null) {
//            return;
//        }
//        aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, SOLID_ZOOM));
//    }
}
