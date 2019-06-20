package com.maxwell.kaavidesam;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.WakefulBroadcastReceiver;

public class ButhaOraiReceiver extends BroadcastReceiver {
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
                .setContentText("புத ஓரை - வியாபாரம் விஷயத்தில் கவனம் செலுத்துதல், புதுக்கணக்கு போடுதல், கமிஷன் வியாபாரம் ஆரம்பித்தாள், குழந்தையை பள்ளிக்கு சேர்த்தல், கால்நடை வாங்குதல், டாக்குமெண்ட் சம்பந்தமாக அக்ரீமெண்ட் போடுதல் உத்தமம் நன்மை.").setSound(alarmSound)
                .setAutoCancel(true).setWhen(when)
                .setContentIntent(pendingIntent)
                .setVibrate(new long[]{1000, 1000});
        notificationManager.notify(MID, mNotifyBuilder.build());
        MID++;

    }

}
