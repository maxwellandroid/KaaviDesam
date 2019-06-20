package com.maxwell.kaavidesam;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class SooriyaOraiReceiver extends BroadcastReceiver {
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
                .setContentText("சூரிய ஓரை - அரசு சம்பந்தப்பட்ட வேலைகள், பெரியவர்களை பார்த்து உதவி பெறுதல், வேலைக்கு விண்ணப்பித்தல், சொத்து சம்பந்தமாக ஒப்பந்தம் போடுதல், உயில் எழுதுதல், உத்தியோக பதவி ஏற்றல், வியாதிக்கு மருந்து உண்ணுதல் இவை செய்ய உத்தமம் நன்மை.").setSound(alarmSound)
                .setAutoCancel(true).setWhen(when)
                .setContentIntent(pendingIntent)
                .setVibrate(new long[]{1000, 1000});
        notificationManager.notify(MID, mNotifyBuilder.build());
        MID++;

    }

}
