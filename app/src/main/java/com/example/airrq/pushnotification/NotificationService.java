package com.example.airrq.pushnotification;

import android.app.Notification;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.airrq.GlobalApplication;
import com.example.airrq.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class NotificationService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Notification notification = new NotificationCompat.Builder(GlobalApplication.getAppContext())
                .setContentTitle(remoteMessage.getNotification().getTitle())
                .setContentText(remoteMessage.getNotification().getBody())
                .setSmallIcon(R.drawable.icon)
                .build();
        NotificationManagerCompat manager = NotificationManagerCompat.from(GlobalApplication.getAppContext());
        manager.notify(123, notification);
    }
}
