package com.maxwell.kaavidesam;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class ChandiraOraiReceiver extends BroadcastReceiver {
    public static  int MID =0 ;
    int requsetcode;

    @Override
    public void onReceive(Context context, Intent intent) {
        long when = System.currentTimeMillis();
        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        Intent notificationIntent = new Intent(context, HomePageActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        requsetcode=intent.getIntExtra("requstCode",0);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, requsetcode,
                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(
                context).setSmallIcon(R.drawable.shortcut_logo)
                .setContentTitle("காவி தேசம்")
                .setContentText("சந்திர ஓரை - பயணம் தொடங்குதல், பாஸ்போர்ட் விசா டிக்கெட் சம்பந்தப்பட்ட வேலைகள், திருமனதிக்குப் பெண் பார்த்தல், கலைத் துறையில் புதிய உத்திக்க கையாளுதல், ஆடை ஆபரணம் வாங்குதல், சரக்குகளை வெளியே எடுத்து செல்லுதல், நிலத்தில் போர் போடுதல் ஆகியவற்றை வளர்பிறை சந்திர ஓரையில் செய்வது உத்தமம் நன்மை.").setSound(alarmSound)
                .setAutoCancel(true).setWhen(when)
                .setContentIntent(pendingIntent)
                .setVibrate(new long[]{1000, 1000});
        notificationManager.notify(MID, mNotifyBuilder.build());
        MID++;
    }
}
