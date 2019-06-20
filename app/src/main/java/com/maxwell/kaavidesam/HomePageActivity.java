package com.maxwell.kaavidesam;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.maxwell.kaavidesam.DataBaseHelper.MyDataBaseHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class HomePageActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private MyDataBaseHelper myDataBaseHelper;
    TableDetails tableDetails;
    private AdView mAdView;



    String nallaneram,rahu,kuligai,yamakanta,soolai,parigaram;

    int h_rahustart_time,m_rahustarttime,h_kuligaistart_time,m_kuligai_starttime,h_yamakanta_start_time,m_yamakantam_start_time,h_nallaneram,m_nallaneram,h_nallanera_evening,m_nallaneram_evening,h_kuligai_evening,m_kuligai_evening;
    int am_pm;

    private InterstitialAd mInterstitialAd;
    private PendingIntent pi_nalla_neram,pi_rahukalam,pi_kuligai,pi_yamakandam,pi_sooriya_oarai,pi_chandira_oarai,pi_chevvay_oarai,pi_butha_oarai,pi_guru_oarai,pi_sukkira_oarai,pi_sani_oarai;

    AlarmManager am_nallaneram,am_rahukaalam,am_kuligai,am_yamakandam,am_sooriya_orai,am_chandira_oarai,am_chevvay_oarai,am_butha_oarai,am_guru_oarai,am_sukira_orai,am_sania_oarai;


    Boolean isRemindNallaneram,isRemindRahukalam,isRemindKuligai,isRemindYamakantam,isRemindSooriyaOrai,isRemindChandiraOrai,isRemindChevvayOrai,isRemindButhaOrai,isRemindGuruOrai,isRemindSukkiraOrai,isRemoindSaniOrai;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       /* FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        FirebaseMessaging.getInstance().subscribeToTopic("all");

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
        myDataBaseHelper = new MyDataBaseHelper(HomePageActivity.this);

        MobileAds.initialize(this, getString(R.string.ad_app_id));

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("DFCE7161E1D9C911DCA3D628AB36DCC0")
                .addTestDevice("256AA11187CE40F71C67CB07007F73AC")
                .addTestDevice("1DB505E6A79509FCE5121588C5F86063")
                .build();
        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();

            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();

            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();

            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);


            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();

            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();

            }

        });
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        //mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.loadAd(new AdRequest.Builder()
                .addTestDevice("1DB505E6A79509FCE5121588C5F86063")
                .addTestDevice("256AA11187CE40F71C67CB07007F73AC")
                .build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.d("TAG", "Ad loaded");

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.d("TAG", "Failed to load "+errorCode);
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

            @Override
            public void onAdOpened() {
                //  mInterstitialAd.loadAd(new AdRequest.Builder().build());
                // Code to be executed when the ad is displayed.
                Log.d("TAG", "The interstitial opened.");
            }

            @Override
            public void onAdLeftApplication() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                // Code to be executed when the user has left the app.
                Log.d("TAG", "The interstitial left the application.");
            }

            @Override
            public void onAdClosed() {

                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                // Code to be executed when when the interstitial ad is closed.
                Log.d("TAG", "The interstitial Closed.");
            }
        });

        /*Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "10");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "KaaviDesam");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);*/
        for(int i=0;i<7;i++){
            tableDetails=new TableDetails();
            if(i==0){
                tableDetails.setWeek("Sunday");
                tableDetails.setRahukalam("4.30 PM-6.00 PM");
                tableDetails.setNallaneram("6.30 AM-7.30 AM\n\n 3.30 PM-4.30 PM");
                tableDetails.setKuligai("3.00 PM-4.30 PM\n\n 9.00 PM-10.30 PM");
                tableDetails.setYamakantam("12.00 PM-1.30 PM");
                tableDetails.setSoolai("மேற்கு");
                tableDetails.setParigaram("வெல்லம்");
            }
            if(i==1){
                tableDetails.setWeek("Monday");
                tableDetails.setRahukalam("7.30 AM-9.00 AM");
                tableDetails.setNallaneram("6.30 AM-7.30 AM\n\n 4.30 PM-5.30 PM");
                tableDetails.setKuligai("1.30 PM-3.00 PM\n\n 7.30 PM- 9.00 PM");
                tableDetails.setYamakantam("10.30 AM-12.00 PM");
                tableDetails.setSoolai("கிழக்கு");
                tableDetails.setParigaram("தயிர்");
            }
            if(i==2){
                tableDetails.setWeek("Tuesday");
                tableDetails.setRahukalam("3.00 PM-4.30 PM");
                tableDetails.setNallaneram("7.30 AM-8.30 AM\n\n 4.30 PM-5.30 PM");
                tableDetails.setKuligai("12.00 PM-1.30 PM\n\n 6.00 PM-7.30 PM");
                tableDetails.setYamakantam("9.00 AM-10.30 AM");
                tableDetails.setSoolai("வடக்கு");
                tableDetails.setParigaram("பால்");
            }
            if(i==3){
                tableDetails.setWeek("Wednesday");
                tableDetails.setRahukalam("12.00 PM-1.30 PM");
                tableDetails.setNallaneram("9.30 AM-10.30 AM\n\n 3.00 PM-4.00 PM");
                tableDetails.setKuligai("10.30 AM-12.00 PM\n\n 3.00 PM-4.30 PM");
                tableDetails.setYamakantam("7.30 AM-9.00 AM");
                tableDetails.setSoolai("வடக்கு");
                tableDetails.setParigaram("பால்");
            }
            if(i==4){
                tableDetails.setWeek("Thursday");
                tableDetails.setRahukalam("1.30 PM-3.00 PM");
                tableDetails.setNallaneram("10.30 AM-11.30 AM");
                tableDetails.setKuligai("9.00 AM-10.30 AM\n\n 1.30 PM- 3.00 PM");
                tableDetails.setYamakantam("6.00 AM-7.30 AM");
                tableDetails.setSoolai("தெற்கு");
                tableDetails.setParigaram("தைலம்");
            }
            if(i==5){
                tableDetails.setWeek("Friday");
                tableDetails.setRahukalam("10.30 AM-12.00 PM");
                tableDetails.setNallaneram("9.30 AM-10.30 AM\n\n 4.30 PM-5.30 PM");
                tableDetails.setKuligai("7.30 AM-9.00 AM\n\n 12.00 PM-1.30 PM");
                tableDetails.setYamakantam("3.00 PM-4.30 PM");
                tableDetails.setSoolai("மேற்கு");
                tableDetails.setParigaram("வெல்லம்");
            }
            if(i==6){
                tableDetails.setWeek("Saturday");
                tableDetails.setRahukalam("9.00 AM-10.30 AM");
                tableDetails.setNallaneram("7.30 AM-8.30 AM\n\n 4.30 PM-5.30 PM");
                tableDetails.setKuligai("6.00 AM-7.30 AM\n\n 10.30 PM-12.00 AM");
                tableDetails.setYamakantam("1.30 PM-3.00 PM");
                tableDetails.setSoolai("கிழக்கு");
                tableDetails.setParigaram("தயிர்");
            }

            if(!(myDataBaseHelper.getData(tableDetails.getWeek()).getCount()>0)){

                myDataBaseHelper.addEntry(tableDetails);
            }else
                myDataBaseHelper.updateCart(tableDetails);

        }

        preferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor=preferences.edit();

        isRemindNallaneram=preferences.getBoolean(StringConstants.prefNallaneram,false);
        isRemindRahukalam=preferences.getBoolean(StringConstants.prefRahukalam,false);
        isRemindKuligai=preferences.getBoolean(StringConstants.prefKuligai,false);
       /* isRemindYamakantam=preferences.getBoolean(StringConstants.prefYamakantam,false);
        isRemindSooriyaOrai=preferences.getBoolean(StringConstants.prefSooriyaOrai,false);
        isRemindChandiraOrai=preferences.getBoolean(StringConstants.prefChandiraOrai,false);
        isRemindChevvayOrai=preferences.getBoolean(StringConstants.prefSevvayOrai,false);
        isRemindButhaOrai=preferences.getBoolean(StringConstants.prefButhaOrai,false);
        isRemindGuruOrai=preferences.getBoolean(StringConstants.prefGuruOrai,false);
        isRemindSukkiraOrai=preferences.getBoolean(StringConstants.prefSukkiraOrai,false);
        isRemoindSaniOrai=preferences.getBoolean(StringConstants.prefSaniOrai,false);*/







        String weekday_name = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(System.currentTimeMillis());
        Cursor cursor=myDataBaseHelper.getData(weekday_name);

        while(cursor.moveToNext()){
            nallaneram=cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_NALLA_NERAM));
            rahu= cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_RAHUKALA_TIME));
            kuligai=cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_KULIGAI));
         yamakanta=cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_YAMAKANTAKALA_TIME));
           soolai=cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_VAARASOOLAI));
            parigaram=cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_PARIGARAM));
            //  Toast.makeText(getActivity(),rahu+" "+kuligai+" "+yamakanta+" "+soolai+" "+parigaram,Toast.LENGTH_SHORT).show();

        }
            String[] separated = rahu.split("-");
            String sep=separated[0];
            String[] hr=sep.split("\\.");
            String[] minutes=hr[1].split(" ");
            h_rahustart_time=Integer.parseInt(hr[0]);
            m_rahustarttime=Integer.parseInt(minutes[0]);
        String[] s_nallneram=nallaneram.split("-");
        if(nallaneram.contains("\n\n")){
            String[]s_naalaneram_evening=nallaneram.split("\n\n");
            //  Toast.makeText(getApplicationContext(),s_naalaneram_evening[1],Toast.LENGTH_SHORT).show();
            String[] s_nalla_neram_evening=s_naalaneram_evening[1].split("-");
            String snallaneramEvening=s_nalla_neram_evening[0];
            String[] hour_naal_neram_evening=snallaneramEvening.split("\\.");
            String[] minutes_nalla_neram_evening=hour_naal_neram_evening[1].split(" ");
            h_nallanera_evening=Integer.parseInt(hour_naal_neram_evening[0].trim());
            m_nallaneram_evening=Integer.parseInt(minutes_nalla_neram_evening[0]);
        }

        //Toast.makeText(getApplicationContext(),String.valueOf(h_nallanera_evening)+"-"+String.valueOf(m_nallaneram_evening),Toast.LENGTH_SHORT).show();
        String snallaneram=s_nallneram[0];
        String[] hr_nalla_neram=snallaneram.split("\\.");
        String[] minutes_nalla_neram=hr_nalla_neram[1].split(" ");
        h_nallaneram=Integer.parseInt(hr_nalla_neram[0]);
        m_nallaneram=Integer.parseInt(minutes_nalla_neram[0]);
        String[] s_kuligai=kuligai.split("-");
        String[]s_kuligai_evening=kuligai.split("\n\n");
        //  Toast.makeText(getApplicationContext(),s_naalaneram_evening[1],Toast.LENGTH_SHORT).show();
        String[] s_kuligai_neram_evening=s_kuligai_evening[1].split("-");
        String sKuligaiEvening=s_kuligai_neram_evening[0];
        String[] hour_kuligai_evening=sKuligaiEvening.split("\\.");
        String[] minutes_kuligai_evening=hour_kuligai_evening[1].split(" ");
        h_kuligai_evening=Integer.parseInt(hour_kuligai_evening[0].trim());
        m_kuligai_evening=Integer.parseInt(minutes_kuligai_evening[0]);
       // Toast.makeText(getApplicationContext(),String.valueOf(h_kuligai_evening)+"-"+String.valueOf(m_kuligai_evening),Toast.LENGTH_SHORT).show();
        String skuligai=s_kuligai[0];
        String[] hrkuligai=skuligai.split("\\.");
        String[] minutes_kuligai=hrkuligai[1].split(" ");
        h_kuligaistart_time=Integer.parseInt(hrkuligai[0]);
        m_kuligai_starttime=Integer.parseInt(minutes_kuligai[0]);
        String[] s_yamakandam=yamakanta.split("-");
        String syamakantam=s_yamakandam[0];
            String[] hryamakantam=syamakantam.split("\\.");
        String[] minutes_yamakandam=hryamakantam[1].split(" ");
            h_yamakanta_start_time=Integer.parseInt(hryamakantam[0]);
            m_yamakantam_start_time=Integer.parseInt(minutes_yamakandam[0]);

            if(isRemindNallaneram){
             //   getPackageManager().setComponentEnabledSetting(componentNameNallaNeram, PackageManager.COMPONENT_ENABLED_STATE_ENABLED , PackageManager.DONT_KILL_APP);
                if(weekday_name.matches("Sunday")){
                    setalarm1(1,0,h_nallaneram,m_nallaneram,0);
                    setalarm1(1,1,h_nallanera_evening,m_nallaneram_evening,1);
                }
                if(weekday_name.matches("Monday")){
                    setalarm1(2,0,h_nallaneram,m_nallaneram,0);
                    setalarm1(2,1,h_nallanera_evening,m_nallaneram_evening,1);
                }
                if(weekday_name.matches("Tuesday")){
                    setalarm1(3,0,h_nallaneram,m_nallaneram,0);
                    setalarm1(3,1,h_nallanera_evening,m_nallaneram_evening,1);
                }
                if(weekday_name.matches("Wednesday")){
                    setalarm1(4,0,h_nallaneram,m_nallaneram,0);
                    setalarm1(4,1,h_nallanera_evening,m_nallaneram_evening,1);
                }
                if(weekday_name.matches("Thursday")){
                    setalarm1(5,0,h_nallaneram,m_nallaneram,0);
                   // setalarm1(1,1,h_nallanera_evening,m_nallaneram_evening,1);
                }
                if(weekday_name.matches("Friday")){
                    setalarm1(6,0,h_nallaneram,m_nallaneram,0);
                    setalarm1(6,1,h_nallanera_evening,m_nallaneram_evening,1);
                }
                if(weekday_name.matches("Saturday")){
                    setalarm1(7,0,h_nallaneram,m_nallaneram,0);
                    setalarm1(7,1,h_nallanera_evening,m_nallaneram_evening,1);
                }
            }else {
                stopNallaNeramAlarm();
               // getPackageManager().setComponentEnabledSetting(componentNameNallaNeram, PackageManager.COMPONENT_ENABLED_STATE_DISABLED , PackageManager.DONT_KILL_APP);
            }

            if(isRemindRahukalam){
              //  getPackageManager().setComponentEnabledSetting(componentNameRahukalam, PackageManager.COMPONENT_ENABLED_STATE_ENABLED , PackageManager.DONT_KILL_APP);
                if(weekday_name.matches("Sunday")){
                    setalarm(1,1);
                }
                if(weekday_name.matches("Monday")){
                    setalarm(2,0);
                }
                if(weekday_name.matches("Tuesday")){
                    setalarm(3,1);
                }
                if(weekday_name.matches("Wednesday")){
                    setalarm(4,1);
                }
                if(weekday_name.matches("Thursday")){
                    setalarm(5,1);
                }
                if(weekday_name.matches("Friday")){
                    setalarm(6,0);
                }

                if(weekday_name.matches("Saturday")){
                    setalarm(7,0);
                }
            }else {

                stopRahukalamAlarm();
                //getPackageManager().setComponentEnabledSetting(componentNameRahukalam, PackageManager.COMPONENT_ENABLED_STATE_DISABLED , PackageManager.DONT_KILL_APP);
/*
                try {
                    if (alarmReceiver!=null) {
                        HomePageActivity.this.unregisterReceiver(alarmReceiver);
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
*/
            }
            if(isRemindKuligai){
              //  getPackageManager().setComponentEnabledSetting(componentNameKuligai, PackageManager.COMPONENT_ENABLED_STATE_ENABLED , PackageManager.DONT_KILL_APP);
                if(weekday_name.matches("Sunday")){
                    setalarm2(1,1,h_kuligaistart_time,m_kuligai_starttime,0);
                    setalarm2(1,1,h_kuligai_evening,m_kuligai_evening,1);
                }
                if(weekday_name.matches("Monday")){
                    setalarm2(2,1,h_kuligaistart_time,m_kuligai_starttime,0);
                    setalarm2(2,1,h_kuligai_evening,m_kuligai_evening,1);
                }
                if(weekday_name.matches("Tuesday")){
                    setalarm2(3,1,h_kuligaistart_time,m_kuligai_starttime,0);
                    setalarm2(3,1,h_kuligai_evening,m_kuligai_evening,1);
                }
                if(weekday_name.matches("Wednesday")){
                    setalarm2(4,0,h_kuligaistart_time,m_kuligai_starttime,0);
                    setalarm2(4,1,h_kuligai_evening,m_kuligai_evening,1);
                }
                if(weekday_name.matches("Thursday")){
                    setalarm2(5,0,h_kuligaistart_time,m_kuligai_starttime,0);
                    setalarm2(5,1,h_kuligai_evening,m_kuligai_evening,1);
                }
                if(weekday_name.matches("Friday")){
                    setalarm2(6,0,h_kuligaistart_time,m_kuligai_starttime,0);
                    setalarm2(6,1,h_kuligai_evening,m_kuligai_evening,1);
                }
                if(weekday_name.matches("Saturday")){
                    setalarm2(1,0,h_kuligaistart_time,m_kuligai_starttime,0);
                    setalarm2(1,1,h_kuligai_evening,m_kuligai_evening,1);
                }
            }else {

                stopKuligaiAlarm();
               // getPackageManager().setComponentEnabledSetting(componentNameKuligai, PackageManager.COMPONENT_ENABLED_STATE_DISABLED , PackageManager.DONT_KILL_APP);
            }
        Log.d("YamakantamTime", String.valueOf(h_yamakanta_start_time)+"-"+String.valueOf(m_yamakantam_start_time));
    //  Toast.makeText(getApplicationContext(),String.valueOf(h_nallaneram)+" - "+String.valueOf(m_nallaneram),Toast.LENGTH_SHORT).show();
        HomeFragment homeFragment = new HomeFragment();
        insertFragment(homeFragment);
    }

    public void setalarm(int weekno,int am_pm) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, weekno);
        cal.set(Calendar.HOUR,h_rahustart_time);
        cal.set(Calendar.MINUTE, m_rahustarttime);
      cal.set(Calendar.AM_PM,am_pm);
        Calendar now = Calendar.getInstance();
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        if (cal.before(now)) {    //this condition is used for future reminder that means your reminder not fire for past time
            cal.add(Calendar.DATE, 7);
        }
        Intent intent1 = new Intent(HomePageActivity.this, AlarmReceiver.class);
         pi_rahukalam = PendingIntent.getBroadcast(HomePageActivity.this, 0,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
         am_rahukaalam = (AlarmManager) HomePageActivity.this.getSystemService(HomePageActivity.this.ALARM_SERVICE);
       // am.set(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),24*7*60*60*1000,pendingIntent);
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am_rahukaalam.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_rahukalam);
            am_rahukaalam.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_rahukalam);
        }*/
        am_rahukaalam.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),24*7*60 * 60 * 1000,pi_rahukalam);
        //am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  24*7*60 * 60 * 1000, pendingIntent);
    }
    public void setalarm1(int weekno,int am_pm,int hr,int min,int requestCode) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, weekno);
        cal.set(Calendar.HOUR,hr);
        cal.set(Calendar.MINUTE, min);
      cal.set(Calendar.AM_PM,am_pm);
        Calendar now = Calendar.getInstance();
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        if (cal.before(now)) {    //this condition is used for future reminder that means your reminder not fire for past time
            cal.add(Calendar.DATE, 7);
        }
        Intent intent1 = new Intent(HomePageActivity.this, NallaNeramAlarmReceiver.class);
        intent1.putExtra("requestCode",requestCode);
         pi_nalla_neram = PendingIntent.getBroadcast(HomePageActivity.this, requestCode,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
         am_nallaneram = (AlarmManager) HomePageActivity.this.getSystemService(HomePageActivity.this.ALARM_SERVICE);
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am_nallaneram.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_nalla_neram);
            am_nallaneram.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_nalla_neram);
        }*/
        am_nallaneram.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),24*7*60 * 60 * 1000,pi_nalla_neram);
        //am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  24*7*60 * 60 * 1000, pendingIntent);
    }
    public void setalarm2(int weekno,int am_pm,int hr,int min,int requestCode) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, weekno);
        cal.set(Calendar.HOUR,hr);
        cal.set(Calendar.MINUTE, min);
      cal.set(Calendar.AM_PM,am_pm);
        Calendar now = Calendar.getInstance();
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        if (cal.before(now)) {    //this condition is used for future reminder that means your reminder not fire for past time
            cal.add(Calendar.DATE, 7);
        }
        Intent intent1 = new Intent(HomePageActivity.this, KuligaiAlarmReceiver.class);
        intent1.putExtra("requestCode",requestCode);
         pi_kuligai = PendingIntent.getBroadcast(HomePageActivity.this, requestCode,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
         am_kuligai = (AlarmManager) HomePageActivity.this.getSystemService(HomePageActivity.this.ALARM_SERVICE);
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am_kuligai.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_kuligai);
            am_kuligai.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_kuligai);
        }*/
        am_kuligai.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),24*7*60 * 60 * 1000,pi_kuligai);
        //am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  24*7*60 * 60 * 1000, pendingIntent);
    }
    public void setalarm3(int weekno,int am_pm) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, weekno);
        cal.set(Calendar.HOUR,h_yamakanta_start_time);
        cal.set(Calendar.MINUTE, m_yamakantam_start_time);
      cal.set(Calendar.AM_PM,am_pm);
        Calendar now = Calendar.getInstance();
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        if (cal.before(now)) {    //this condition is used for future reminder that means your reminder not fire for past time
            cal.add(Calendar.DATE, 7);
        }
        Intent intent1 = new Intent(HomePageActivity.this, YamagandamAlarmReceiver.class);
         pi_yamakandam = PendingIntent.getBroadcast(HomePageActivity.this, 0,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
         am_yamakandam = (AlarmManager) HomePageActivity.this.getSystemService(HomePageActivity.this.ALARM_SERVICE);
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am_yamakandam.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_yamakandam);
            am_yamakandam.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_yamakandam);
        }*/
        am_yamakandam.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),24*7*60 * 60 * 1000,pi_yamakandam);
       // am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  24*7*60 * 60 * 1000, pendingIntent);
    }

    public void setalarmSooriyaOrai(int weekno,int am_pm,int hr,int m,int requsetcode) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, weekno);
        cal.set(Calendar.HOUR,hr);
        cal.set(Calendar.MINUTE, m);
        cal.set(Calendar.AM_PM,am_pm);
        Calendar now = Calendar.getInstance();
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        if (cal.before(now)) {    //this condition is used for future reminder that means your reminder not fire for past time
            cal.add(Calendar.DATE, 7);
        }
        Intent intent1 = new Intent(HomePageActivity.this, SooriyaOraiReceiver.class);
        intent1.putExtra("requstCode",requsetcode);
         pi_sooriya_oarai = PendingIntent.getBroadcast(HomePageActivity.this, requsetcode,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        am_sooriya_orai = (AlarmManager)getSystemService(ALARM_SERVICE);
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am_sooriya_orai.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_sooriya_oarai);
            am_sooriya_orai.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_sooriya_oarai);
        }*/
        am_sooriya_orai.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),24*7*60 * 60 * 1000,pi_sooriya_oarai);
        //am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  24*7*60 * 60 * 1000, pendingIntent);
    }
    public void setalarmChandiraOrai(int weekno,int am_pm,int hr,int m,int requestcode) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, weekno);
        cal.set(Calendar.HOUR,hr);
        cal.set(Calendar.MINUTE, m);
        cal.set(Calendar.AM_PM,am_pm);
        Calendar now = Calendar.getInstance();
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        if (cal.before(now)) {    //this condition is used for future reminder that means your reminder not fire for past time
            cal.add(Calendar.DATE, 7);
        }
        Intent intent1 = new Intent(HomePageActivity.this, ChandiraOraiReceiver.class);
        intent1.putExtra("requstCode",requestcode);
         pi_chandira_oarai = PendingIntent.getBroadcast(HomePageActivity.this, requestcode,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
         am_chandira_oarai = (AlarmManager)getSystemService(ALARM_SERVICE);
      /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am_chandira_oarai.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_chandira_oarai);
            am_chandira_oarai.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_chandira_oarai);
        }*/
        am_chandira_oarai.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),24*7*60 * 60 * 1000,pi_chandira_oarai);
        //am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  24*7*60 * 60 * 1000, pendingIntent);
    }
    public void setalarmSevvayOrai(int weekno,int am_pm,int hr,int m,int requestcode) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, weekno);
        cal.set(Calendar.HOUR,hr);
        cal.set(Calendar.MINUTE, m);
        cal.set(Calendar.AM_PM,am_pm);
        Calendar now = Calendar.getInstance();
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        if (cal.before(now)) {    //this condition is used for future reminder that means your reminder not fire for past time
            cal.add(Calendar.DATE, 7);
        }
        Intent intent1 = new Intent(HomePageActivity.this, ChevvayOraiReceiver.class);
        intent1.putExtra("requestCode",requestcode);
         pi_chevvay_oarai = PendingIntent.getBroadcast(HomePageActivity.this, requestcode,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
         am_chevvay_oarai = (AlarmManager) getSystemService(ALARM_SERVICE);
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am_chevvay_oarai.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_chevvay_oarai);
            am_chevvay_oarai.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_chevvay_oarai);
        }*/
        am_chevvay_oarai.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),24*7*60 * 60 * 1000,pi_chevvay_oarai);
       // am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  24*7*60 * 60 * 1000, pendingIntent);
    }
    public void setalarmButhaOrai(int weekno,int am_pm,int hr,int m,int requestCode) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, weekno);
        cal.set(Calendar.HOUR,hr);
        cal.set(Calendar.MINUTE, m);
        cal.set(Calendar.AM_PM,am_pm);
        Calendar now = Calendar.getInstance();
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        if (cal.before(now)) {    //this condition is used for future reminder that means your reminder not fire for past time
            cal.add(Calendar.DATE, 7);
        }

        Intent intent1 = new Intent(HomePageActivity.this, ButhaOraiReceiver.class);
        intent1.putExtra("requestCode",requestCode);
         pi_butha_oarai = PendingIntent.getBroadcast(HomePageActivity.this, requestCode,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
         am_butha_oarai = (AlarmManager) getSystemService(ALARM_SERVICE);
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am_butha_oarai.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pi_butha_oarai);
            am_butha_oarai.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pi_butha_oarai);
        }*/
        //am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  24*7*60 * 60 * 1000, pendingIntent);
        am_butha_oarai.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),24*7*60 * 60 * 1000,pi_butha_oarai);
    }
    public void setalarmGuruOrai(int weekno,int am_pm,int hr,int m,int requestcode) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, weekno);
        cal.set(Calendar.HOUR,hr);
        cal.set(Calendar.MINUTE, m);
        cal.set(Calendar.AM_PM,am_pm);
        Calendar now = Calendar.getInstance();
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        if (cal.before(now)) {    //this condition is used for future reminder that means your reminder not fire for past time
            cal.add(Calendar.DATE, 7);
        }
        Intent intent1 = new Intent(HomePageActivity.this, GuruOraiReceiver.class);
        intent1.putExtra("requestCode",requestcode);
         pi_guru_oarai = PendingIntent.getBroadcast(HomePageActivity.this, requestcode,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
         am_guru_oarai = (AlarmManager) getSystemService(ALARM_SERVICE);
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am_guru_oarai.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_guru_oarai);
            am_guru_oarai.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_guru_oarai);
        }*/
        //am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  24*7*60 * 60 * 1000, pendingIntent);
        am_guru_oarai.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),24*7*60 * 60 * 1000,pi_guru_oarai);
    }
    public void setalarmSukkiraOrai(int weekno,int am_pm,int hr,int m,int requsetCode) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, weekno);
        cal.set(Calendar.HOUR,hr);
        cal.set(Calendar.MINUTE, m);
        cal.set(Calendar.AM_PM,am_pm);
        Calendar now = Calendar.getInstance();
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);

        if (cal.before(now)) {    //this condition is used for future reminder that means your reminder not fire for past time
            cal.add(Calendar.DATE, 7);
        }

        Intent intent1 = new Intent(HomePageActivity.this, SukkiraOraiReceiver.class);
        intent1.putExtra("requestCode",requsetCode);
        pi_sukkira_oarai = PendingIntent.getBroadcast(HomePageActivity.this, requsetCode,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
         am_sukira_orai = (AlarmManager) getSystemService(ALARM_SERVICE);
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am_sukira_orai.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_sukkira_oarai);
            am_sukira_orai.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_sukkira_oarai);
        }*/
       // am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  24*7*60 * 60 * 1000, pendingIntent);
        am_sukira_orai.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),24*7*60 * 60 * 1000,pi_sukkira_oarai);
    }
    public void setalarmSaniOrai(int weekno,int am_pm,int hr,int m,int requestCode) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, weekno);
        cal.set(Calendar.HOUR,hr);
        cal.set(Calendar.MINUTE, m);
        cal.set(Calendar.AM_PM,am_pm);
        Calendar now = Calendar.getInstance();
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);

        if (cal.before(now)) {    //this condition is used for future reminder that means your reminder not fire for past time
            cal.add(Calendar.DATE, 7);
        }
        Intent intent1 = new Intent(HomePageActivity.this, SaniOraiReceiver.class);
        intent1.putExtra("requestCode",requestCode);
        pi_sani_oarai = PendingIntent.getBroadcast(HomePageActivity.this, requestCode,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
         am_sania_oarai = (AlarmManager) getSystemService(ALARM_SERVICE);
      /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am_sania_oarai.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_sani_oarai);
            am_sania_oarai.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_sani_oarai);
        }*/
       // am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  24*7*60 * 60 * 1000, pendingIntent);
        am_sania_oarai.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),24*7*60 * 60 * 1000,pi_sani_oarai);
    }

    /*
    public void start() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int interval = 8000;

        manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);
        Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show();
    }
    */

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
                finish();
        }
    }
    public void showinertialAds(){


        MobileAds.initialize(this, getString(R.string.ad_app_id));
        mInterstitialAd = new InterstitialAd(this);
       // mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
       mInterstitialAd.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));
        AdRequest adRequest=new AdRequest.Builder().addTestDevice("1DB505E6A79509FCE5121588C5F86063").build();
        mInterstitialAd.loadAd(new AdRequest.Builder()
                .addTestDevice("DFCE7161E1D9C911DCA3D628AB36DCC0")
                .addTestDevice("256AA11187CE40F71C67CB07007F73AC")
                .addTestDevice("1DB505E6A79509FCE5121588C5F86063").build());
        mInterstitialAd.loadAd(adRequest);
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.d("TAG", "Ad loaded");
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.d("TAG", "Failed to load "+errorCode);
                HomeFragment homeFragment = new HomeFragment();
                insertFragment(homeFragment);
            }
            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
                Log.d("TAG", "The interstitial wasn't loaded yet.");
                HomeFragment homeFragment = new HomeFragment();
                insertFragment(homeFragment);
            }
            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.d("TAG", "The interstitial wasn't loaded yet.");
                HomeFragment homeFragment = new HomeFragment();
                insertFragment(homeFragment);
            }
            @Override
            public void onAdClosed() {
                HomeFragment homeFragment = new HomeFragment();
                insertFragment(homeFragment);

                // mInterstitialAd.loadAd(new AdRequest.Builder().build());
                // Code to be executed when when the interstitial ad is closed.
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
        });

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_day_indicator) {
           /* if(isNetworkAvailable())
                showinertialAds();
            else {
                HomeFragment homeFragment = new HomeFragment();
                insertFragment(homeFragment);
            }*/
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
            HomeFragment homeFragment = new HomeFragment();
            insertFragment(homeFragment);

            // Handle the camera action
        } else if (id == R.id.nav_montly_sheet) {

            MonthlyIndicatorFragment monthlyFragment=new MonthlyIndicatorFragment();
            insertFragment(monthlyFragment);

        }else if (id == R.id.nav_vaasthu_kuripugal) {

            VaasthuTipsFragment vaasthuTipsFragment=new VaasthuTipsFragment();
            insertFragment(vaasthuTipsFragment);

        }else if (id == R.id.nav_unavu_murai) {

            UnavuMuraiFragment unavuMuraiFragment=new UnavuMuraiFragment();
            insertFragment(unavuMuraiFragment);

        }else if(id==R.id.nav_suba_vorai){

            NewOraikalFragment oraikalFragment=new NewOraikalFragment();
            insertFragment(oraikalFragment);

        } else if (id == R.id.nav_settings) {

            SettingsFragment settingsFragment=new SettingsFragment();
            insertFragment(settingsFragment);

        }else if (id == R.id.nav_kaavidesam) {

            KaaviDesamContentFragment kaaviDesamContentFragment=new KaaviDesamContentFragment();
            insertFragment(kaaviDesamContentFragment);

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void insertFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.addToBackStack("mainstack");
        transaction.commit();
    }


    public void stopNallaNeramAlarm() {

        if(am_nallaneram!=null){
            am_nallaneram.cancel(pi_nalla_neram);
            stopService(new Intent(getApplicationContext(), NallaNeramAlarmReceiver.class));
            //remove the notification from notification tray
            NotificationManager notificationManager = (NotificationManager) this
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(NallaNeramAlarmReceiver.MID);
        }
        //Stop the Media Player Service to stop sound


    }
    public void stopRahukalamAlarm() {

        if(am_rahukaalam!=null){
            am_rahukaalam.cancel(pi_rahukalam);
            //Stop the Media Player Service to stop sound
            stopService(new Intent(getApplicationContext(), AlarmReceiver.class));
            //remove the notification from notification tray
            NotificationManager notificationManager = (NotificationManager) this
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(AlarmReceiver.MID);
        }
    }
    public void stopKuligaiAlarm() {

        if(am_kuligai!=null) {
            am_kuligai.cancel(pi_kuligai);//cancel the alarm manager of the pending intent
            //Stop the Media Player Service to stop sound
            stopService(new Intent(getApplicationContext(), KuligaiAlarmReceiver.class));
            //remove the notification from notification tray
            NotificationManager notificationManager = (NotificationManager) this
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(KuligaiAlarmReceiver.MID);
        }
    }
    public void stopYamagandamAlarm() {

        if(am_yamakandam!=null){
            am_yamakandam.cancel(pi_yamakandam);//cancel the alarm manager of the pending intent
            //Stop the Media Player Service to stop sound
            stopService(new Intent(getApplicationContext(), YamagandamAlarmReceiver.class));
            //remove the notification from notification tray
            NotificationManager notificationManager = (NotificationManager) this
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(YamagandamAlarmReceiver.MID);
        }
    }
    public void stopSooriyaOraiAlarm() {

        if(am_sooriya_orai!=null){

            am_sooriya_orai.cancel(pi_sooriya_oarai);//cancel the alarm manager of the pending intent
            //Stop the Media Player Service to stop sound
            stopService(new Intent(getApplicationContext(), SooriyaOraiReceiver.class));
            //remove the notification from notification tray
            NotificationManager notificationManager = (NotificationManager) this
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(SooriyaOraiReceiver.MID);
        }
    }
    public void stopChandiraOraiAlarm() {

        if(am_chandira_oarai!=null) {
            am_chandira_oarai.cancel(pi_chandira_oarai);//cancel the alarm manager of the pending intent
            //Stop the Media Player Service to stop sound
            stopService(new Intent(getApplicationContext(), ChandiraOraiReceiver.class));
            //remove the notification from notification tray
            NotificationManager notificationManager = (NotificationManager) this
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(ChandiraOraiReceiver.MID);
        }
    }
    public void stopChevaiOraiAlarm() {
        if(am_chevvay_oarai!=null){
            am_chevvay_oarai.cancel(pi_chevvay_oarai);//cancel the alarm manager of the pending intent
            //Stop the Media Player Service to stop sound
           stopService(new Intent(getApplicationContext(), ChevvayOraiReceiver.class));
            //remove the notification from notification tray
            NotificationManager notificationManager = (NotificationManager) this
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(ChevvayOraiReceiver.MID);
        }
    }
    public void stopButhaOraiAlarm() {
        if(am_butha_oarai!=null){
            am_butha_oarai.cancel(pi_butha_oarai);//cancel the alarm manager of the pending intent
            //Stop the Media Player Service to stop sound
            stopService(new Intent(getApplicationContext(), ButhaOraiReceiver.class));
            //remove the notification from notification tray
            NotificationManager notificationManager = (NotificationManager) this
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(ButhaOraiReceiver.MID);
        }


    }
    public void stopGuruOraiAlarm() {

        if(am_guru_oarai!=null) {

            am_guru_oarai.cancel(pi_guru_oarai);//cancel the alarm manager of the pending intent
            //Stop the Media Player Service to stop sound
           stopService(new Intent(getApplicationContext(), GuruOraiReceiver.class));
            //remove the notification from notification tray
            NotificationManager notificationManager = (NotificationManager) this
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(GuruOraiReceiver.MID);
        }
    }
    public void stopSukiraOraiAlarm() {
        if(am_sukira_orai!=null) {
            am_sukira_orai.cancel(pi_sukkira_oarai);//cancel the alarm manager of the pending intent
            //Stop the Media Player Service to stop sound
            stopService(new Intent(getApplicationContext(), SukkiraOraiReceiver.class));
            //remove the notification from notification tray
            NotificationManager notificationManager = (NotificationManager) this
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(SukkiraOraiReceiver.MID);
        }
    }
    public void stopSaniOraiAlarm() {
        if(am_sania_oarai!=null){
            am_sania_oarai.cancel(pi_sani_oarai);//cancel the alarm manager of the pending intent
            //Stop the Media Player Service to stop sound
            stopService(new Intent(getApplicationContext(), SaniOraiReceiver.class));
            //remove the notification from notification tray
            NotificationManager notificationManager = (NotificationManager)this
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(SaniOraiReceiver.MID);
        }
    }
}
