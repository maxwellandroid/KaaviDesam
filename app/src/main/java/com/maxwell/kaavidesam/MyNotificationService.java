package com.maxwell.kaavidesam;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

public class MyNotificationService extends Service {

    private NotificationManager mManager;
    private static final int NOTIFICATION_ID = 1;
    private PendingIntent pendingIntent;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        Context context = this.getApplicationContext();
        mManager = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
        Intent mIntent = new Intent(this, HomePageActivity.class);
        pendingIntent = PendingIntent.getActivity(context, 0, mIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Nalla Neram");
        builder.setContentText("Nalla neram will be starting on 11:45 AM.");
        builder.setSmallIcon(R.drawable.shortcut_logo);
        builder.setContentIntent(pendingIntent);

        mManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        mManager.notify(NOTIFICATION_ID, builder.build());

          /* mManager = (NotificationManager) this.getApplicationContext().getSystemService(this.getApplicationContext().NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(this.getApplicationContext(),HomePageActivity.class);
        Notification notification = new Notification(R.drawable.shortcut_logo,"This is a test message!", System.currentTimeMillis());
        intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP| Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingNotificationIntent = PendingIntent.getActivity( this.getApplicationContext(),0, intent1,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.setLatestEventInfo(this.getApplicationContext(), "Daily Notification Demo", "This is a test message!", pendingNotificationIntent);
        mManager.notify(0, notification);*/
    }
}
