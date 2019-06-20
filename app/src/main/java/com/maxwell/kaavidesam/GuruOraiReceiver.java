package com.maxwell.kaavidesam;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class GuruOraiReceiver extends BroadcastReceiver {
    public static  int MID =0 ;
    int requestcode;

    @Override
    public void onReceive(Context context, Intent intent) {
        long when = System.currentTimeMillis();
        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        Intent notificationIntent = new Intent(context, HomePageActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        requestcode=intent.getIntExtra("requestCode",0);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, requestcode,
                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(
                context).setSmallIcon(R.drawable.shortcut_logo)
                .setContentTitle("காவி தேசம்")
                .setContentText("குரு ஓரை - உயர் கல்விக்கு பிள்ளைகளை சேர்த்தல், மகான் சாதுக்கள் முக்கிய பொறுப்பில் உள்ளவரை சந்தித்தல், தெய்வ காரியம், தெய்வ தரிசனம் செய்தல், விதை விதைத்தல், பயிர் வகைகளை நடுதல் உத்தமம் நன்மை.").setSound(alarmSound)
                .setAutoCancel(true).setWhen(when)
                .setContentIntent(pendingIntent)
                .setVibrate(new long[]{1000, 1000});
        notificationManager.notify(MID, mNotifyBuilder.build());
        MID++;

    }

}
