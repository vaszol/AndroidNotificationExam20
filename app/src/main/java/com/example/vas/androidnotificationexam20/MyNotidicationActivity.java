package com.example.vas.androidnotificationexam20;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

/**
 * Created by vas on 21.12.14.
 */
public class MyNotidicationActivity extends Activity {

    private NotificationManager nm;
    private final int NOTIFICATION_ID = 127;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        nm = (NotificationManager)getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void showNotification(View view){
        Notification.Builder builder = new Notification.Builder(getApplicationContext());

        Intent intent = new Intent(getApplicationContext(), FinishActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.ic_launcher))
                .setTicker("НОвое уведомление")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("Уведомление")
                .setContentText("Нажмите чтобы узнать секрет");
        Notification notification = builder.build();
        nm.notify(NOTIFICATION_ID, notification);

    }
}
