package com.maxwell.kaavidesam;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class SaniOraiReceiver extends BroadcastReceiver {
    public static  int MID =0 ;
    int requestCode;

    @Override
    public void onReceive(Context context, Intent intent) {
        long when = System.currentTimeMillis();
        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        Intent notificationIntent = new Intent(context, HomePageActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        requestCode=intent.getIntExtra("requestCode",0);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, requestCode,
                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(
                context).setSmallIcon(R.drawable.shortcut_logo)
                .setContentTitle("காவி தேசம்")
                .setContentText("சனி ஓரை - விவசாயம் சம்பந்தப்பட்ட வாகனம் வாங்குதல், நிலை சம்பந்தப்பட்டவகைகள் தீர்வு காணுதல், தோப்புகளை உற்பத்தி செய்தல் இரும்பு சம்பந்தப்பட்ட கடைகள், பட்டறை வைத்தல் உத்தமம் நன்மை.").setSound(alarmSound)
                .setAutoCancel(true).setWhen(when)
                .setContentIntent(pendingIntent)
                .setVibrate(new long[]{1000, 1000});
        notificationManager.notify(MID, mNotifyBuilder.build());
        MID++;

    }

}
