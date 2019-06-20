package com.maxwell.kaavidesam;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class SukkiraOraiReceiver extends BroadcastReceiver {
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
                .setContentText("சுக்கிர ஓரை - திருமண விஷயமாகச் செல்லுதல், நகை வாங்குதல், கலை துறை சம்பந்தமான காரியம் செய்தல், கறவைமாடு வாங்குதல், நிலத்தில் போர் போடுதல், கடன் வசூல் செய்தல், கலைத் துறை சம்பந்தப்பட்ட கடை வைத்தல், சொகுசு வண்டி வாங்குதல் உத்தமம் நன்மை.").setSound(alarmSound)
                .setAutoCancel(true).setWhen(when)
                .setContentIntent(pendingIntent)
                .setVibrate(new long[]{1000, 1000});
        notificationManager.notify(MID, mNotifyBuilder.build());
        MID++;

    }

}
