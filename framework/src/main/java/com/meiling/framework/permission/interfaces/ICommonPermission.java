package com.meiling.framework.permission.interfaces;

import android.Manifest;

/**
 * Created by Administrator on 14:36.
 *
 * @package com.meiling.permission
 * @auther By MeilingHong
 * @emall marisareimu123@gmail.com
 * @date 2018-02-06   14:36
 */

public interface ICommonPermission {

    int CODE_REQUEST_PERMISSIONS_CONTACTS = 10001;
    int CODE_REQUEST_PERMISSIONS_PHONE_ALL = 10002;
    int CODE_REQUEST_PERMISSIONS_CALENDAR = 10003;
    int CODE_REQUEST_PERMISSIONS_CAMERA = 10004;
    //****************************
    int CODE_REQUEST_PERMISSIONS_SENSORS = 10005;
    int CODE_REQUEST_PERMISSIONS_LOCATION = 10006;
    int CODE_REQUEST_PERMISSIONS_STORAGE = 10007;
    int CODE_REQUEST_PERMISSIONS_VOICE_RECORD = 10008;
    //****************************
    int CODE_REQUEST_PERMISSIONS_SMS_ALL = 10009;
    int CODE_REQUEST_PERMISSIONS_PHONE_CALL = 10010;
    /**
     * *******************************************************************************************************************
     */
    String[] REQUEST_PERMISSIONS_CONTACTS = new String[]{
            Manifest.permission.GET_ACCOUNTS, Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS};

    String[] REQUEST_PERMISSIONS_PHONE_ALL = new String[]{
            Manifest.permission.READ_CALL_LOG, Manifest.permission.READ_PHONE_STATE, Manifest.permission.CALL_PHONE,
            Manifest.permission.WRITE_CALL_LOG, Manifest.permission.USE_SIP, Manifest.permission.PROCESS_OUTGOING_CALLS,
            Manifest.permission.ADD_VOICEMAIL};

    String[] REQUEST_PERMISSIONS_CALENDAR = new String[]{Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR};
    String[] REQUEST_PERMISSIONS_CAMERA = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    //****************************
    String[] REQUEST_PERMISSIONS_SENSORS = new String[]{Manifest.permission.BODY_SENSORS};
    String[] REQUEST_PERMISSIONS_LOCATION = new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
    String[] REQUEST_PERMISSIONS_STORAGE = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    String[] REQUEST_PERMISSIONS_VOICE_RECORD = new String[]{Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    //****************************
    String[] REQUEST_PERMISSIONS_SMS_ALL = new String[]{
            Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_WAP_PUSH, Manifest.permission.RECEIVE_MMS,
            Manifest.permission.RECEIVE_SMS, Manifest.permission.SEND_SMS};

    String[] REQUEST_PERMISSIONS_PHONE_CALL = new String[]{
            Manifest.permission.CALL_PHONE};







}
