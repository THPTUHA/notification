package com.badao.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);
        Log.e("Notification received", "OK");
        RemoteMessage.Notification  notification = message.getNotification();
        if(notification == null){
            return;
        }

        String title = notification.getTitle();
        String mess = notification.getBody();
        NotificationDB.getInstance(this).create(new NotificationModel(title, mess));
        sendNotification(title, mess);
    }

    private void sendNotification(String title, String mess) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this, MyApplication.CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(mess)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentIntent(pendingIntent );

        Notification notification = nBuilder.build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if(notificationManager != null){
            notificationManager.notify(1, notification);
        }
    }
}
