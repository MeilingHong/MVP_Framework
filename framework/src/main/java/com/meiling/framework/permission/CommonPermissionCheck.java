package com.meiling.framework.permission;

import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;

import com.meiling.framework.common.BaseActivity;
import com.meiling.framework.common.BaseFragment;
import com.meiling.framework.common.BaseFragmentV4;
import com.meiling.framework.permission.interfaces.ICommonPermission;
import com.meiling.framework.permission.interfaces.ICommonPermissionCallback;

/**
 * Created by Administrator on 15:48.
 *
 * @package com.meiling.permission
 * @auther By MeilingHong
 * @emall marisareimu123@gmail.com
 * @date 2018-02-06   15:48
 */

public class CommonPermissionCheck {
    public static boolean checkPermission(final BaseActivity activity, final PermissionType permissionType,@NonNull final ICommonPermissionCallback permissionCallback) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            switch (permissionType) {
                case CALENDAR: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case CAMERA: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case CONTACTS: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case VOICE_RECORD: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }

                case PHONE: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case LOCATION: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case SENSORS: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case STORAGE: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }

                case SMS: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case PHONE_CALL:{
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
            }
        }
        return true;
    }

    public static boolean checkPermission(final BaseFragment activity, final PermissionType permissionType,final ICommonPermissionCallback permissionCallback) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            switch (permissionType) {
                case CALENDAR: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case CAMERA: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case CONTACTS: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case VOICE_RECORD: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }

                case PHONE: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case LOCATION: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case SENSORS: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case STORAGE: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }

                case SMS: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case PHONE_CALL:{
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
            }
        }
        return true;
    }

    public static boolean checkPermission(final BaseFragmentV4 activity, final PermissionType permissionType,final ICommonPermissionCallback permissionCallback) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            switch (permissionType) {
                case CALENDAR: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case CAMERA: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case CONTACTS: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case VOICE_RECORD: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }

                case PHONE: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case LOCATION: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case SENSORS: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case STORAGE: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }

                case SMS: {
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
                case PHONE_CALL:{
                    if(!checkGrantedResult(activity, permissionType)){
                        requestPermissions(activity, permissionType,permissionCallback);
                        return false;
                    }
                    return true;
                }
            }
        }
        return true;
    }

    private static boolean checkGrantedResult(final BaseActivity activity, final PermissionType permissionType) {
        boolean result = false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            switch (permissionType) {
                case CALENDAR: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_CALENDAR.length; i++) {
                        result = activity.checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_CALENDAR[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
                case CAMERA: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_CAMERA.length; i++) {
                        result = activity.checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_CAMERA[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
                case CONTACTS: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_CONTACTS.length; i++) {
                        result = activity.checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_CONTACTS[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
                case VOICE_RECORD: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_VOICE_RECORD.length; i++) {
                        result = activity.checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_VOICE_RECORD[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }

                case PHONE: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_PHONE_ALL.length; i++) {
                        result = activity.checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_PHONE_ALL[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
                case LOCATION: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_LOCATION.length; i++) {
                        result = activity.checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_LOCATION[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
                case SENSORS: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_SENSORS.length; i++) {
                        result = activity.checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_SENSORS[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
                case STORAGE: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_STORAGE.length; i++) {
                        result = activity.checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_STORAGE[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }

                case SMS: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_SMS_ALL.length; i++) {
                        result = activity.checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_SMS_ALL[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }

                case PHONE_CALL: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_PHONE_CALL.length; i++) {
                        result = activity.checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_PHONE_CALL[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
            }
        }
        return result;
    }

    private static boolean checkGrantedResult(final BaseFragment activity, final PermissionType permissionType) {
        boolean result = false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            switch (permissionType) {
                case CALENDAR: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_CALENDAR.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_CALENDAR[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
                case CAMERA: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_CAMERA.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_CAMERA[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
                case CONTACTS: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_CONTACTS.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_CONTACTS[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
                case VOICE_RECORD: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_VOICE_RECORD.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_VOICE_RECORD[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }

                case PHONE: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_PHONE_ALL.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_PHONE_ALL[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
                case LOCATION: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_LOCATION.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_LOCATION[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
                case SENSORS: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_SENSORS.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_SENSORS[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
                case STORAGE: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_STORAGE.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_STORAGE[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }

                case SMS: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_SMS_ALL.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_SMS_ALL[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }

                case PHONE_CALL: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_PHONE_CALL.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_PHONE_CALL[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
            }
        }
        return result;
    }

    private static boolean checkGrantedResult(final BaseFragmentV4 activity, final PermissionType permissionType) {
        boolean result = false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            switch (permissionType) {
                case CALENDAR: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_CALENDAR.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_CALENDAR[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
                case CAMERA: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_CAMERA.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_CAMERA[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
                case CONTACTS: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_CONTACTS.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_CONTACTS[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
                case VOICE_RECORD: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_VOICE_RECORD.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_VOICE_RECORD[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }

                case PHONE: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_PHONE_ALL.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_PHONE_ALL[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
                case LOCATION: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_LOCATION.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_LOCATION[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
                case SENSORS: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_SENSORS.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_SENSORS[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
                case STORAGE: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_STORAGE.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_STORAGE[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }

                case SMS: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_SMS_ALL.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_SMS_ALL[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }

                case PHONE_CALL: {
                    for (int i = 0; i < ICommonPermission.REQUEST_PERMISSIONS_PHONE_CALL.length; i++) {
                        result = activity.getActivity().checkSelfPermission(ICommonPermission.REQUEST_PERMISSIONS_PHONE_CALL[i]) == PackageManager.PERMISSION_GRANTED ? true:false;
                        if(result){
                            continue;
                        }else{
                            break;
                        }
                    }
                    return result;
                }
            }
        }
        return result;
    }

    private static void requestPermissions(final BaseActivity activity, final PermissionType permissionType,@NonNull final ICommonPermissionCallback permissionCallback) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(activity!=null && permissionCallback!=null){
                activity.setThisCallback(permissionCallback);
            }
            switch (permissionType) {
                case CALENDAR: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_CALENDAR, ICommonPermission.CODE_REQUEST_PERMISSIONS_CALENDAR);
                    break;
                }
                case CAMERA: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_CAMERA, ICommonPermission.CODE_REQUEST_PERMISSIONS_CAMERA);
                    break;
                }
                case CONTACTS: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_CONTACTS, ICommonPermission.CODE_REQUEST_PERMISSIONS_CONTACTS);
                    break;
                }
                case VOICE_RECORD: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_VOICE_RECORD, ICommonPermission.CODE_REQUEST_PERMISSIONS_VOICE_RECORD);
                    break;
                }

                case PHONE: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_PHONE_ALL, ICommonPermission.CODE_REQUEST_PERMISSIONS_PHONE_ALL);
                    break;
                }
                case LOCATION: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_LOCATION, ICommonPermission.CODE_REQUEST_PERMISSIONS_LOCATION);
                    break;
                }
                case SENSORS: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_SENSORS, ICommonPermission.CODE_REQUEST_PERMISSIONS_SENSORS);
                    break;
                }
                case STORAGE: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_STORAGE, ICommonPermission.CODE_REQUEST_PERMISSIONS_STORAGE);
                    break;
                }

                case SMS: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_SMS_ALL, ICommonPermission.CODE_REQUEST_PERMISSIONS_SMS_ALL);
                    break;
                }

                case PHONE_CALL: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_PHONE_CALL, ICommonPermission.CODE_REQUEST_PERMISSIONS_PHONE_CALL);
                    break;
                }
            }
        }
    }

    private static void requestPermissions(final BaseFragment activity, final PermissionType permissionType,@NonNull final ICommonPermissionCallback permissionCallback) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(activity!=null && permissionCallback!=null){
                activity.setThisCallback(permissionCallback);
            }
            switch (permissionType) {
                case CALENDAR: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_CALENDAR, ICommonPermission.CODE_REQUEST_PERMISSIONS_CALENDAR);
                    break;
                }
                case CAMERA: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_CAMERA, ICommonPermission.CODE_REQUEST_PERMISSIONS_CAMERA);
                    break;
                }
                case CONTACTS: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_CONTACTS, ICommonPermission.CODE_REQUEST_PERMISSIONS_CONTACTS);
                    break;
                }
                case VOICE_RECORD: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_VOICE_RECORD, ICommonPermission.CODE_REQUEST_PERMISSIONS_VOICE_RECORD);
                    break;
                }

                case PHONE: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_PHONE_ALL, ICommonPermission.CODE_REQUEST_PERMISSIONS_PHONE_ALL);
                    break;
                }
                case LOCATION: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_LOCATION, ICommonPermission.CODE_REQUEST_PERMISSIONS_LOCATION);
                    break;
                }
                case SENSORS: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_SENSORS, ICommonPermission.CODE_REQUEST_PERMISSIONS_SENSORS);
                    break;
                }
                case STORAGE: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_STORAGE, ICommonPermission.CODE_REQUEST_PERMISSIONS_STORAGE);
                    break;
                }

                case SMS: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_SMS_ALL, ICommonPermission.CODE_REQUEST_PERMISSIONS_SMS_ALL);
                    break;
                }

                case PHONE_CALL: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_PHONE_CALL, ICommonPermission.CODE_REQUEST_PERMISSIONS_PHONE_CALL);
                    break;
                }
            }
        }
    }

    private static void requestPermissions(final BaseFragmentV4 activity, final PermissionType permissionType,@NonNull final ICommonPermissionCallback permissionCallback) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(activity!=null && permissionCallback!=null){
                activity.setThisCallback(permissionCallback);
            }
            switch (permissionType) {
                case CALENDAR: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_CALENDAR, ICommonPermission.CODE_REQUEST_PERMISSIONS_CALENDAR);
                    break;
                }
                case CAMERA: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_CAMERA, ICommonPermission.CODE_REQUEST_PERMISSIONS_CAMERA);
                    break;
                }
                case CONTACTS: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_CONTACTS, ICommonPermission.CODE_REQUEST_PERMISSIONS_CONTACTS);
                    break;
                }
                case VOICE_RECORD: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_VOICE_RECORD, ICommonPermission.CODE_REQUEST_PERMISSIONS_VOICE_RECORD);
                    break;
                }

                case PHONE: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_PHONE_ALL, ICommonPermission.CODE_REQUEST_PERMISSIONS_PHONE_ALL);
                    break;
                }
                case LOCATION: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_LOCATION, ICommonPermission.CODE_REQUEST_PERMISSIONS_LOCATION);
                    break;
                }
                case SENSORS: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_SENSORS, ICommonPermission.CODE_REQUEST_PERMISSIONS_SENSORS);
                    break;
                }
                case STORAGE: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_STORAGE, ICommonPermission.CODE_REQUEST_PERMISSIONS_STORAGE);
                    break;
                }

                case SMS: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_SMS_ALL, ICommonPermission.CODE_REQUEST_PERMISSIONS_SMS_ALL);
                    break;
                }

                case PHONE_CALL: {
                    activity.requestPermissions(ICommonPermission.REQUEST_PERMISSIONS_PHONE_CALL, ICommonPermission.CODE_REQUEST_PERMISSIONS_PHONE_CALL);
                    break;
                }
            }
        }
    }
}
