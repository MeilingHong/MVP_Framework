package com.meiling.mvp.module.db;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;

import com.meiling.mvp.module.datautil.LogUtil;
import com.meiling.mvp.module.dbentity.RecordEntity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/9 0009.
 */

public class PhoneDBUtil {
    /**
     * TODO 用于获取Android手机公共数据库中的数据，例如：通话记录、短信记录、联系人
     */

    public static void getCallLogRecord(Context mActivity) {
        ContentResolver contentResolver = mActivity.getContentResolver();
        Cursor cursor = null;
        try {
            if (ActivityCompat.checkSelfPermission(mActivity, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                LogUtil.getInstances().e("Permission Denial  ---- getCallLogRecord");
                return;
            }
            cursor = contentResolver.query(
                    // CallLog.Calls.CONTENT_URI, Columns, null,
                    // null,CallLog.Calls.DATE+" desc");
                    CallLog.Calls.CONTENT_URI, null, null, null,
                    CallLog.Calls.DATE + " desc");
            if (cursor == null)
                return;
//            List<RecordEntity> mRecordList = new ArrayList<RecordEntity>();
            while (cursor.moveToNext()) {
                RecordEntity record = new RecordEntity();
                record.setName(cursor.getString(cursor
                        .getColumnIndex(CallLog.Calls.CACHED_NAME)));
                record.setNumber(cursor.getString(cursor
                        .getColumnIndex(CallLog.Calls.NUMBER)));
                record.setType(cursor.getInt(cursor
                        .getColumnIndex(CallLog.Calls.TYPE)));;
                record.setlDate(cursor.getLong(cursor
                        .getColumnIndex(CallLog.Calls.DATE)));;
                record.setDuration(cursor.getLong(cursor
                        .getColumnIndex(CallLog.Calls.DURATION)));;
                record.set_new(cursor.getInt(cursor
                        .getColumnIndex(CallLog.Calls.NEW)));;
                LogUtil.getInstances().e( record.toString());
                //                      int photoIdIndex = cursor.getColumnIndex(CACHED_PHOTO_ID);
                //                      if (photoIdIndex >= 0) {
                //                          record.cachePhotoId = cursor.getLong(photoIdIndex);
                //                      }

//                mRecordList.add(record);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }

        }
    }

    /**得到手机通讯录联系人信息**/
    public static void getPhoneContacts(Context mContext) {
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED  ||
                ActivityCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_CONTACTS) != PackageManager.PERMISSION_GRANTED ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            LogUtil.getInstances().e("Permission Denial  ---- getPhoneContacts");
            return;
        }
        ContentResolver resolver = mContext.getContentResolver();
        // 获取手机【不是Sim卡中的】联系人
        Cursor phoneCursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,new String[] {
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Photo.PHOTO_ID, ContactsContract.CommonDataKinds.Phone.CONTACT_ID }, null, null, null);


        if (phoneCursor != null && phoneCursor.getCount()>0) {
            while (phoneCursor.moveToNext()) {

                //得到手机号码
                String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                //当手机号码为空的或者为空字段 跳过当前循环
                if (TextUtils.isEmpty(phoneNumber))
                    continue;

                //得到联系人名称
                String contactName = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

                //得到联系人ID
                Long contactid = phoneCursor.getLong(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));

                //得到联系人头像ID
                Long photoid = phoneCursor.getLong(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_ID));
                LogUtil.getInstances().e("phoneNumber="+phoneNumber+"  ** contactName="+contactName+"  ** contactid="+contactid+"  ** photoid="+photoid);
//                //得到联系人头像Bitamp
//                Bitmap contactPhoto = null;
//
//                //photoid 大于0 表示联系人有头像 如果没有给此人设置头像则给他一个默认的
//                if(photoid > 0 ) {
//                    Uri uri =ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI,contactid);
//                    InputStream input = ContactsContract.Contacts.openContactPhotoInputStream(resolver, uri);
//                    contactPhoto = BitmapFactory.decodeStream(input);
//                }else {
//                    contactPhoto = BitmapFactory.decodeResource(getResources(), R.drawable.contact_photo);
//                }
//
//                mContactsName.add(contactName);
//                mContactsNumber.add(phoneNumber);
//                mContactsPhonto.add(contactPhoto);
            }

            phoneCursor.close();
        }
    }


    /**得到手机SIM卡联系人人信息**/
    public static void getSIMContacts(Context mContext) {
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED  ||
                ActivityCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_CONTACTS) != PackageManager.PERMISSION_GRANTED ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            LogUtil.getInstances().e("Permission Denial  ---- getSIMContacts");
            return;
        }
        ContentResolver resolver = mContext.getContentResolver();
        // 获取Sims卡联系人
        Uri uri = Uri.parse("content://sim/adn");// TODO content://sim/adn   content://icc/adn
        Cursor phoneCursor = resolver.query(uri, new String[] {
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID }, null, null,
                null);

        if (phoneCursor != null && phoneCursor.getCount()>0) {
            while (phoneCursor.moveToNext()) {

                // 得到手机号码
                String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                // 当手机号码为空的或者为空字段 跳过当前循环
                if (TextUtils.isEmpty(phoneNumber))
                    continue;
                // 得到联系人名称
                String contactName = phoneCursor
                        .getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                LogUtil.getInstances().e("SIM Card : phoneNumber="+phoneNumber+"  ** contactName="+contactName);
                //Sim卡中没有联系人头像
            }

            phoneCursor.close();
        }
    }

    public static String getSmsInPhone(Context mContext) {

        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED
                ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            LogUtil.getInstances().e("Permission Denial  ---- getSmsInPhone");
            return null;
        }
        final String SMS_URI_ALL = "content://sms/";
        final String SMS_URI_INBOX = "content://sms/inbox";
        final String SMS_URI_SEND = "content://sms/sent";
        final String SMS_URI_DRAFT = "content://sms/draft";
        final String SMS_URI_OUTBOX = "content://sms/outbox";
        final String SMS_URI_FAILED = "content://sms/failed";
        final String SMS_URI_QUEUED = "content://sms/queued";

        StringBuilder smsBuilder = new StringBuilder();

        try {
            Uri uri = Uri.parse(SMS_URI_ALL);
            String[] projection = new String[] { "_id", "address", "person", "body", "date", "type" };
            Cursor cur = mContext.getContentResolver().query(uri, projection, null, null, "date desc");      // 获取手机内部短信

            if (cur.moveToFirst()) {
                int index_Address = cur.getColumnIndex("address");
                int index_Person = cur.getColumnIndex("person");
                int index_Body = cur.getColumnIndex("body");
                int index_Date = cur.getColumnIndex("date");
                int index_Type = cur.getColumnIndex("type");

                do {
                    String strAddress = cur.getString(index_Address);
                    int intPerson = cur.getInt(index_Person);
                    String strbody = cur.getString(index_Body);
                    long longDate = cur.getLong(index_Date);
                    int intType = cur.getInt(index_Type);

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    Date d = new Date(longDate);
                    String strDate = dateFormat.format(d);

                    String strType = "";
                    if (intType == 1) {
                        strType = "接收";
                    } else if (intType == 2) {
                        strType = "发送";
                    } else {
                        strType = "null";
                    }

                    smsBuilder.append("[ ");
                    smsBuilder.append(strAddress + ", ");
                    smsBuilder.append(intPerson + ", ");
                    smsBuilder.append(strbody + ", ");
                    smsBuilder.append(strDate + ", ");
                    smsBuilder.append(strType);
                    smsBuilder.append(" ]\n\n");
                } while (cur.moveToNext());

                if (!cur.isClosed()) {
                    cur.close();
                    cur = null;
                }
            } else {
                smsBuilder.append("no result!");
            } // end if
            LogUtil.getInstances().e(smsBuilder.toString());
        } catch (SQLiteException ex) {
            LogUtil.getInstances().e(ex.getMessage());
        }
        return smsBuilder.toString();
    }

}
