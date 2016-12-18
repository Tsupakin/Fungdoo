package com.fungdoo.project.fungdoo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;

import java.util.Random;

/**
 * Created by kundan on 10/22/2015.
 */
public class PushNotificationService extends GcmListenerService {

    @Override
    public void onMessageReceived(String from, Bundle data) {

        String title = data.getString("title");
        Log.d("title",title);
        String message = data.getString("message");
        Log.d("message",message);
        String subtitle = ""+data.getString("subtitle");
        Log.d("subtitle",subtitle);
        String id_ = data.getString("tickerText");
        Log.d("id_",id_);
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, Login.class), 0);
        Resources r = getResources();
        Notification notification = new NotificationCompat.Builder(this)
                .setTicker(title)
                //.setSmallIcon( R.drawable.ic_stat_name)
                .setContentTitle(message)
                .setContentText(title)
                .setContentText(subtitle)
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.defaults|= Notification.DEFAULT_SOUND;
        notification.defaults|= Notification.DEFAULT_LIGHTS;
        notification.defaults|= Notification.DEFAULT_VIBRATE;

        Random random = new Random();
        int m = random.nextInt(9999 - 1000) + 1000;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(m, notification);


    }

}
