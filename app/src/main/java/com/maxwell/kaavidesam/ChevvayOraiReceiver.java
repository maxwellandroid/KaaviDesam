package com.maxwell.kaavidesam;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class ChevvayOraiReceiver extends BroadcastReceiver {
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
                .setContentText("செவ்வாய் ஓரை - நிலம் வாங்குதல் - விற்றல் வெல்டிங் பட்டறை மின்சாரம் சம்பந்தப்பட்ட வேலைகள் செய்தல், உடலில் ஆபரேஷன் அறுவை சிகிச்சை செய்தல், எந்திரம் வாங்குதல், விவசாயம் விதை விதைத்தல் நன்று. தேய்பிறை செவ்வாய் ஓரையில் இரகசியத்தை யாரிடமும் சொல்லக்கூடாது. சொன்னால் அதுவே நமக்கு பாதகமாக முடியும்.").setSound(alarmSound)
                .setAutoCancel(true).setWhen(when)
                .setContentIntent(pendingIntent)
                .setVibrate(new long[]{1000, 1000});
        notificationManager.notify(MID, mNotifyBuilder.build());
        MID++;
    }
}
