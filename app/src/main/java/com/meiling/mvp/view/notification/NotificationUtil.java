package com.meiling.mvp.view.notification;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;

import com.meiling.mvp.R;
import com.meiling.mvp.view.toast.ToastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/7/12.
 */

public class NotificationUtil {
    //TODO 防止存在没有清除的Notification存在
    private static List<Integer> notificationIDs = new ArrayList<>();

    public static void commonNotification(final Context mContext, final String title, final String content, boolean isVibrate, boolean isRing) {

        Uri sound = Uri.parse("android.resource://" + mContext.getPackageName() + "/" + R.raw.beep);//TODO 使用自己的提醒声音
        NotificationManager manager = (NotificationManager) mContext
                .getSystemService(Context.NOTIFICATION_SERVICE);
        //TODO 根据API使用不同的Notification构造
        Notification notification;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext);
        builder.setAutoCancel(true)
        .setSmallIcon(R.mipmap.ic_launcher)
        .setContentTitle(""+title)
        .setContentText(""+content)
        ;
        //TODO
        if(isVibrate && isRing){
            if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.VIBRATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                ToastUtil.toastLong(mContext,mContext.getString(R.string.permission_vibrate));
                builder.setDefaults(Notification.DEFAULT_SOUND).setSound(sound);
            }else{
                builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE).setSound(sound);
            }
            builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE).setSound(sound);
        }else if(!isVibrate && isRing){
            builder.setDefaults(Notification.DEFAULT_SOUND).setSound(sound);
        }else if(isVibrate && !isRing){
            if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.VIBRATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                ToastUtil.toastLong(mContext,mContext.getString(R.string.permission_vibrate));
            }else{
                builder.setDefaults(Notification.DEFAULT_VIBRATE);
            }
        }

        notification = builder.build();
        int id = new Random().nextInt();
        notificationIDs.add(id);
        manager.notify(id,notification);

    }

    public static void removeNotification(final Context mContext, int notificationID) {
        if (notificationIDs.contains(notificationID)) {
            NotificationManager manager = (NotificationManager) mContext
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            manager.cancel(notificationID);
            //TODO 这里不能使用默认，不然可能导致越界异常
            Integer id = new Integer(notificationID);
            notificationIDs.remove(id);
        }
    }

    public static void removeAllNotification(final Context mContext) {
        NotificationManager manager = (NotificationManager) mContext
                .getSystemService(Context.NOTIFICATION_SERVICE);
        while (!notificationIDs.isEmpty()){
            Integer id = notificationIDs.get(0);
            manager.cancel(id.intValue());
            //TODO 这里不能使用默认，不然可能导致越界异常
            notificationIDs.remove(id);
        }
    }
}
