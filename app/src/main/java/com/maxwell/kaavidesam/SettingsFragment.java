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
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.maxwell.kaavidesam.DataBaseHelper.MyDataBaseHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SettingsFragment extends Fragment {

    View view;

    Switch switchNallaNeram,switchRahukalam,switchKuligai,switchYamakandam,switchSooriyaOrai,switchChndiraOrai,switchSevvayOrai,switchButhaOrai,switchGuruOrai,switchSukkiraOrai,switchSaniOrai;

    Boolean isRemindNallaneram,isRemindRahukalam,isRemindKuligai,isRemindYamakantam,isRemindSooriyaOrai,isRemindChandiraOrai,isRemindChevvayOrai,isRemindButhaOrai,isRemindGuruOrai,isRemindSukkiraOrai,isRemoindSaniOrai;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private MyDataBaseHelper myDataBaseHelper;
    String nallaneram,rahu,kuligai,yamakanta,soolai,parigaram;
    String weekday_name;
    String am_pm;
    String now_hr;
    int h_rahustart_time,m_rahustarttime,h_kuligaistart_time,m_kuligai_starttime,h_yamakanta_start_time,m_yamakantam_start_time,h_nallaneram,m_nallaneram,h_nallanera_evening,m_nallaneram_evening,h_kuligai_evening,m_kuligai_evening;
    private PendingIntent pi_nalla_neram,pi_rahukalam,pi_kuligai,pi_yamakandam,pi_sooriya_oarai,pi_chandira_oarai,pi_chevvay_oarai,pi_butha_oarai,pi_guru_oarai,pi_sukkira_oarai,pi_sani_oarai;

    AlarmManager am_nallaneram,am_rahukaalam,am_kuligai,am_yamakandam,am_sooriya_orai,am_chandira_oarai,am_chevvay_oarai,am_butha_oarai,am_guru_oarai,am_sukira_orai,am_sania_oarai;


    ComponentName componentNameRahukalam,componentNameNallaNeram,componentNameYamakandam,componentNameKuligai,componentNameSooriyaOrai,componentNameChandiraOrai,componentNameChevvaiOrai,componentNameButhaOrai,componentNameGuruOrai,componentNameSukraOrai,componentNameSaniOrai;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.layout_settings_content,container,false);
        Toolbar toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
       TextView tv_screen_name=toolbar.findViewById(R.id.text_screen_name);
        tv_screen_name.setText("காவி தேசம் - நினைவூட்டல்");
        myDataBaseHelper = new MyDataBaseHelper(getActivity());


        switchNallaNeram=(Switch)view.findViewById(R.id.switch_nalaneram);
        switchRahukalam=(Switch)view.findViewById(R.id.switch_rahukalam);
        switchKuligai=(Switch)view.findViewById(R.id.switch_kuligai);
        switchYamakandam=(Switch)view.findViewById(R.id.switch_yamagandam);
        switchSooriyaOrai=(Switch)view.findViewById(R.id.switch_sooria_orai);
        switchChndiraOrai=(Switch)view.findViewById(R.id.switch_chandira_orai);
        switchSevvayOrai=(Switch)view.findViewById(R.id.switch_chevvay_orai);
        switchButhaOrai=(Switch)view.findViewById(R.id.switch_butha_orai);
        switchGuruOrai=(Switch)view.findViewById(R.id.switch_guuru_orai);
        switchSukkiraOrai=(Switch)view.findViewById(R.id.switch_sukira_orai);
        switchSaniOrai=(Switch)view.findViewById(R.id.switch_sani_orai);

        preferences= PreferenceManager.getDefaultSharedPreferences(getActivity());
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
        isRemoindSaniOrai=preferences.getBoolean(StringConstants.prefSaniOrai,false);
*/


        if(isRemindNallaneram) {
           // getActivity().getPackageManager().setComponentEnabledSetting(componentNameNallaNeram ,PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
            switchNallaNeram.setChecked(true);
        }
        if(isRemindRahukalam) {
          // getActivity(). getPackageManager().setComponentEnabledSetting(componentNameRahukalam, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

            switchRahukalam.setChecked(true);
        }
        if(isRemindKuligai){
           // getActivity(). getPackageManager().setComponentEnabledSetting(componentNameKuligai, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
            switchKuligai.setChecked(true);
        }
/*if(isRemindYamakantam) {
    //getActivity().getPackageManager().setComponentEnabledSetting(componentNameYamakandam, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
    switchYamakandam.setChecked(true);
}
if(isRemindSooriyaOrai) {
    //getActivity().getPackageManager().setComponentEnabledSetting(componentNameSooriyaOrai, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
    switchSooriyaOrai.setChecked(true);
}
if(isRemindChandiraOrai){
   // getActivity(). getPackageManager().setComponentEnabledSetting(componentNameChandiraOrai, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

            switchChndiraOrai.setChecked(true);
}
if(isRemindChevvayOrai){
    //getActivity(). getPackageManager().setComponentEnabledSetting(componentNameChevvaiOrai, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

            switchSevvayOrai.setChecked(true);}
if(isRemindButhaOrai){
    //getActivity(). getPackageManager().setComponentEnabledSetting(componentNameButhaOrai, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
            switchButhaOrai.setChecked(true);}
if(isRemindGuruOrai){
    //getActivity(). getPackageManager().setComponentEnabledSetting(componentNameGuruOrai, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
            switchGuruOrai.setChecked(true);}
if(isRemindSukkiraOrai){
   // getActivity(). getPackageManager().setComponentEnabledSetting(componentNameSukraOrai, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
            switchSukkiraOrai.setChecked(true);}
if(isRemoindSaniOrai){
   // getActivity(). getPackageManager().setComponentEnabledSetting(componentNameSaniOrai, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
            switchSaniOrai.setChecked(true);
}*/


         weekday_name = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(System.currentTimeMillis());
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
        String snallaneram=s_nallneram[0];
        String[] hr_nalla_neram=snallaneram.split("\\.");
        String[] minutes_nalla_neram=hr_nalla_neram[1].split(" ");
        h_nallaneram=Integer.parseInt(hr_nalla_neram[0]);
        m_nallaneram=Integer.parseInt(minutes_nalla_neram[0]);
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

        String[] s_kuligai=kuligai.split("-");
        String skuligai=s_kuligai[0];
        String[] hrkuligai=skuligai.split("\\.");
        String[] minutes_kuligai=hrkuligai[1].split(" ");
        h_kuligaistart_time=Integer.parseInt(hrkuligai[0]);
        m_kuligai_starttime=Integer.parseInt(minutes_kuligai[0]);
        String[]s_kuligai_evening=kuligai.split("\n\n");
        //  Toast.makeText(getApplicationContext(),s_naalaneram_evening[1],Toast.LENGTH_SHORT).show();
        String[] s_kuligai_neram_evening=s_kuligai_evening[1].split("-");
        String sKuligaiEvening=s_kuligai_neram_evening[0];
        String[] hour_kuligai_evening=sKuligaiEvening.split("\\.");
        String[] minutes_kuligai_evening=hour_kuligai_evening[1].split(" ");
        h_kuligai_evening=Integer.parseInt(hour_kuligai_evening[0].trim());
        m_kuligai_evening=Integer.parseInt(minutes_kuligai_evening[0]);
        String[] s_yamakandam=yamakanta.split("-");
        String syamakantam=s_yamakandam[0];
        String[] hryamakantam=syamakantam.split("\\.");
        String[] minutes_yamakandam=hryamakantam[1].split(" ");
        h_yamakanta_start_time=Integer.parseInt(hryamakantam[0]);
        m_yamakantam_start_time=Integer.parseInt(minutes_yamakandam[0]);

        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
        String currentDate=sdf.format(currentTime);

        String[] splitteddate=currentDate.split(" ");
        String date=splitteddate[0];
        String time=splitteddate[1];
         am_pm=splitteddate[2];
        if(am_pm.matches("a.m."))
            am_pm="AM";
        else if(am_pm.matches("p.m."))
            am_pm="PM";

        String[] h_time=time.split(":");
         now_hr=h_time[0];


    switchNallaNeram.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(switchNallaNeram.isChecked()){
           // getActivity(). getPackageManager().setComponentEnabledSetting(componentNameNallaNeram, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
            isRemindNallaneram=true;
            editor.putBoolean(StringConstants.prefNallaneram,true);
            editor.apply();
            editor.commit();

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

        }else{
           // getActivity().getPackageManager().setComponentEnabledSetting(componentNameNallaNeram, PackageManager.COMPONENT_ENABLED_STATE_DISABLED , PackageManager.DONT_KILL_APP);
            isRemindNallaneram=false;
            editor.putBoolean(StringConstants.prefNallaneram,false);
            editor.apply();
            editor.commit();
/*
            try {
                if (nallaNeramAlarmReceiver!=null) {
                    getActivity().unregisterReceiver(nallaNeramAlarmReceiver);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
*/

stopNallaNeramAlarm();
        }

    }
});

    switchRahukalam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(switchRahukalam.isChecked()){
           // getActivity().getPackageManager().setComponentEnabledSetting(componentNameRahukalam, PackageManager.COMPONENT_ENABLED_STATE_ENABLED , PackageManager.DONT_KILL_APP);
            isRemindRahukalam=true;
            editor.putBoolean(StringConstants.prefRahukalam,true);
            editor.apply();
            editor.commit();
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

        }else{
            stopRahukalamAlarm();
          //  getActivity().getPackageManager().setComponentEnabledSetting(componentNameRahukalam, PackageManager.COMPONENT_ENABLED_STATE_DISABLED , PackageManager.DONT_KILL_APP);
            isRemindRahukalam=false;
            editor.putBoolean(StringConstants.prefRahukalam,false);
            editor.apply();
            editor.commit();

        }

    }
});

       switchKuligai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(switchKuligai.isChecked()){
                 //  getActivity(). getPackageManager().setComponentEnabledSetting(componentNameKuligai, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                   isRemindKuligai=true;
                   editor.putBoolean(StringConstants.prefKuligai,true);
                   editor.apply();
                   editor.commit();


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

               }else{
                   stopKuligaiAlarm();
                   //getActivity().getPackageManager().setComponentEnabledSetting(componentNameKuligai, PackageManager.COMPONENT_ENABLED_STATE_DISABLED , PackageManager.DONT_KILL_APP);
                   isRemindKuligai=false;
                   editor.putBoolean(StringConstants.prefKuligai,false);
                   editor.apply();
                   editor.commit();

               }

           }
       });

       switchYamakandam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(switchYamakandam.isChecked()){
                   //getActivity(). getPackageManager().setComponentEnabledSetting(componentNameYamakandam, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                   isRemindYamakantam=true;
                   editor.putBoolean(StringConstants.prefYamakantam,true);
                   editor.apply();
                   editor.commit();

                       if(weekday_name.matches("Sunday")){
                           setalarm3(1,1);
                       }
                       if(weekday_name.matches("Monday")){
                           setalarm3(2,0);
                       }
                       if(weekday_name.matches("Tuesday")){
                           setalarm3(3,0);
                       }
                       if(weekday_name.matches("Wednesday")){
                           setalarm3(4,0);
                       }
                       if(weekday_name.matches("Thursday")){
                           setalarm3(5,0);
                       }
                       if(weekday_name.matches("Friday")){
                           setalarm3(6,1);
                       }
                       if(weekday_name.matches("Saturday")){
                           setalarm3(7,1);
                       }


               }else{
                   stopYamagandamAlarm();
                   //getActivity().getPackageManager().setComponentEnabledSetting(componentNameYamakandam, PackageManager.COMPONENT_ENABLED_STATE_DISABLED , PackageManager.DONT_KILL_APP);
                   isRemindYamakantam=false;
                   editor.putBoolean(StringConstants.prefYamakantam,false);
                   editor.apply();
                   editor.commit();

               }

           }
       });
       switchSooriyaOrai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(switchSooriyaOrai.isChecked()){
                   //getActivity(). getPackageManager().setComponentEnabledSetting(componentNameSooriyaOrai, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                   isRemindSooriyaOrai=true;
                   editor.putBoolean(StringConstants.prefSooriyaOrai,true);
                   editor.apply();
                   editor.commit();


                       if(weekday_name.matches("Sunday")){
                           setalarmSooriyaOrai(1,0,6,0,0);
                           setalarmSooriyaOrai(1,1,1,0,1);
                           setalarmSooriyaOrai(1,1,8,0,2);
                           setalarmSooriyaOrai(1,0,3,0,3);

                       }
                       if(weekday_name.matches("Monday")){
                           setalarmSooriyaOrai(2,0,10,0,0);
                           setalarmSooriyaOrai(2,1,5,0,1);
                           setalarmSooriyaOrai(2,0,12,0,2);


                       }
                       if(weekday_name.matches("Tuesday")){
                           setalarmSooriyaOrai(3,0,7,0,0);
                           setalarmSooriyaOrai(3,1,2,0,1);
                           setalarmSooriyaOrai(3,1,9,0,2);
                           setalarmSooriyaOrai(3,0,4,0,3);
                       }
                       if(weekday_name.matches("Wednesday")){

                           setalarmSooriyaOrai(4,0,11,0,0);
                           setalarmSooriyaOrai(4,1,6,0,1);
                           setalarmSooriyaOrai(4,0,1,0,2);

                       }
                       if(weekday_name.matches("Thursday")){
                           setalarmSooriyaOrai(5,0,8,0,0);
                           setalarmSooriyaOrai(5,1,3,0,1);
                           setalarmSooriyaOrai(5,1,10,0,2);
                           setalarmSooriyaOrai(5,0,5,0,3);
                       }

                       if(weekday_name.matches("Friday")){
                           setalarmSooriyaOrai(6,1,12,0,0);
                           setalarmSooriyaOrai(6,1,7,0,1);
                           setalarmSooriyaOrai(6,0,2,0,2);
                       }

                       if(weekday_name.matches("Saturday")){
                           setalarmSooriyaOrai(7,0,9,0,0);
                           setalarmSooriyaOrai(7,1,4,0,1);
                           setalarmSooriyaOrai(7,1,11,0,2);
                       }


               }else{
                   stopSooriyaOraiAlarm();
                  // getActivity().getPackageManager().setComponentEnabledSetting(componentNameSooriyaOrai, PackageManager.COMPONENT_ENABLED_STATE_DISABLED , PackageManager.DONT_KILL_APP);
                   isRemindSooriyaOrai=false;
                   editor.putBoolean(StringConstants.prefSooriyaOrai,false);
                   editor.apply();
                   editor.commit();


               }

           }
       });
       switchChndiraOrai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

               if(switchChndiraOrai.isChecked()){
                //   getActivity(). getPackageManager().setComponentEnabledSetting(componentNameChandiraOrai, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                   isRemindChandiraOrai=true;
                   editor.putBoolean(StringConstants.prefChandiraOrai,true);
                   editor.apply();
                   editor.commit();


                       if(weekday_name.matches("Sunday")){
                           setalarmChandiraOrai(1,0,9,0,0);
                           setalarmChandiraOrai(1,1,4,0,1);
                           setalarmChandiraOrai(1,1,11,0,2);
                       }
                       if(weekday_name.matches("Monday")){
                           setalarmChandiraOrai(2,0,6,0,0);
                           setalarmChandiraOrai(2,1,1,0,1);
                           setalarmChandiraOrai(2,1,8,0,2);
                           setalarmChandiraOrai(2,0,3,0,3);
                       }
                       if(weekday_name.matches("Tuesday")){
                           setalarmChandiraOrai(3,0,10,0,0);
                           setalarmChandiraOrai(3,1,5,0,1);
                           setalarmChandiraOrai(3,0,12,0,2);
                       }
                       if(weekday_name.matches("Wednesday")){
                           setalarmChandiraOrai(4,0,7,0,0);
                           setalarmChandiraOrai(4,1,2,0,1);
                           setalarmChandiraOrai(4,1,9,0,2);
                           setalarmChandiraOrai(4,0,4,0,3);
                       }
                       if(weekday_name.matches("Thursday")){
                           setalarmChandiraOrai(5,0,11,0,0);
                           setalarmChandiraOrai(5,1,6,0,1);
                           setalarmChandiraOrai(5,0,1,0,2);
                       }

                       if(weekday_name.matches("Friday")){
                           setalarmChandiraOrai(6,0,8,0,0);
                           setalarmChandiraOrai(6,1,3,0,2);
                           setalarmChandiraOrai(6,1,10,0,2);
                           setalarmChandiraOrai(6,0,5,0,3);

                       }

                       if(weekday_name.matches("Saturday")){
                           setalarmChandiraOrai(7,1,12,0,0);
                           setalarmChandiraOrai(7,1,7,0,1);
                           setalarmChandiraOrai(7,0,2,0,2);

                       }



               }else {
                   stopChandiraOraiAlarm();
                 //  getActivity().getPackageManager().setComponentEnabledSetting(componentNameChandiraOrai, PackageManager.COMPONENT_ENABLED_STATE_DISABLED , PackageManager.DONT_KILL_APP);
                   isRemindChandiraOrai = false;
                   editor.putBoolean(StringConstants.prefChandiraOrai,false);
                   editor.apply();
                   editor.commit();

               }
           }
       });
        switchSevvayOrai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switchSevvayOrai.isChecked()){
                   // getActivity(). getPackageManager().setComponentEnabledSetting(componentNameChevvaiOrai, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                    isRemindChevvayOrai=true;
                    editor.putBoolean(StringConstants.prefSevvayOrai,true);
                    editor.apply();
                    editor.commit();
                    if(weekday_name.matches("Sunday")){
                            setalarmSevvayOrai(1,1,12,0,0);
                            setalarmSevvayOrai(1,1,7,0,1);
                            setalarmSevvayOrai(1,0,2,0,2);

                        }
                        if(weekday_name.matches("Monday")){
                            setalarmSevvayOrai(2,0,9,0,0);
                            setalarmSevvayOrai(2,1,4,0,1);
                            setalarmSevvayOrai(2,1,11,0,2);
                        }
                        if(weekday_name.matches("Tuesday")){
                            setalarmSevvayOrai(3,0,6,0,0);
                            setalarmSevvayOrai(3,1,1,0,1);
                            setalarmSevvayOrai(3,1,8,0,2);
                            setalarmSevvayOrai(3,0,3,0,3);
                        }
                        if(weekday_name.matches("Wednesday")){
                            setalarmSevvayOrai(4,0,10,0,0);
                            setalarmSevvayOrai(4,1,5,0,1);
                            setalarmSevvayOrai(4,0,12,0,2);
                        }
                        if(weekday_name.matches("Thursday")){
                            setalarmSevvayOrai(5,0,7,0,0);
                            setalarmSevvayOrai(5,1,2,0,1);
                            setalarmSevvayOrai(5,1,9,0,2);
                            setalarmSevvayOrai(5,0,4,0,3);

                        }
                        if(weekday_name.matches("Friday")){
                            setalarmSevvayOrai(6,0,11,0,0);
                            setalarmSevvayOrai(6,1,6,0,1);
                            setalarmSevvayOrai(6,0,1,0,2);
                        }
                        if(weekday_name.matches("Saturday")){
                            setalarmSevvayOrai(7,0,8,0,0);
                            setalarmSevvayOrai(7,1,3,0,1);
                            setalarmSevvayOrai(7,1,10,0,2);
                            setalarmSevvayOrai(7,0,5,0,3);
                        }


                }else {
                    stopChevaiOraiAlarm();
                   // getActivity().getPackageManager().setComponentEnabledSetting(componentNameChevvaiOrai, PackageManager.COMPONENT_ENABLED_STATE_DISABLED , PackageManager.DONT_KILL_APP);
                    isRemindChevvayOrai = false;
                    editor.putBoolean(StringConstants.prefSevvayOrai,false);
                    editor.apply();
                    editor.commit();

                }
            }
        });
         switchButhaOrai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(switchButhaOrai.isChecked()){
                    // getActivity(). getPackageManager().setComponentEnabledSetting(componentNameButhaOrai, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                     isRemindButhaOrai=true;
                     editor.putBoolean(StringConstants.prefButhaOrai,true);
                     editor.apply();
                     editor.commit();

                         if(weekday_name.matches("Sunday")){
                             setalarmButhaOrai(1,0,8,0,0);
                             setalarmButhaOrai(1,1,3,0,1);
                             setalarmButhaOrai(1,1,10,0,2);
                             setalarmButhaOrai(1,0,5,0,3);
                         }
                         if(weekday_name.matches("Monday")){
                             setalarmButhaOrai(2,1,12,0,0);
                             setalarmButhaOrai(2,1,7,0,1);
                             setalarmButhaOrai(2,0,2,0,2);
                         }
                         if(weekday_name.matches("Tuesday")){
                             setalarmButhaOrai(3,0,9,0,0);
                             setalarmButhaOrai(3,1,4,0,1);
                             setalarmButhaOrai(3,1,11,0,2);
                         }
                         if(weekday_name.matches("Wednesday")){
                             setalarmButhaOrai(4,0,6,0,0);
                             setalarmButhaOrai(4,1,1,0,1);
                             setalarmButhaOrai(4,1,8,0,2);
                             setalarmButhaOrai(4,0,3,0,3);
                         }
                         if(weekday_name.matches("Thursday")){
                             setalarmButhaOrai(5,0,10,0,0);
                             setalarmButhaOrai(5,1,5,0,1);
                             setalarmButhaOrai(5,0,12,0,2);
                         }
                         if(weekday_name.matches("Friday")){
                             setalarmButhaOrai(6,0,7,0,0);
                             setalarmButhaOrai(6,1,2,0,1);
                             setalarmButhaOrai(6,1,9,0,2);
                             setalarmButhaOrai(6,0,4,0,3);
                         }
                         if(weekday_name.matches("Saturday")){
                             setalarmButhaOrai(7,0,11,0,0);
                             setalarmButhaOrai(7,1,6,0,1);
                             setalarmButhaOrai(7,0,1,0,2);
                         }


                 }else {
                     stopButhaOraiAlarm();
                    // getActivity().getPackageManager().setComponentEnabledSetting(componentNameButhaOrai, PackageManager.COMPONENT_ENABLED_STATE_DISABLED , PackageManager.DONT_KILL_APP);
                     isRemindButhaOrai = false;
                     editor.putBoolean(StringConstants.prefButhaOrai,false);
                     editor.apply();
                     editor.commit();

                 }
             }
         });

         switchGuruOrai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(switchGuruOrai.isChecked()){
                     //getActivity(). getPackageManager().setComponentEnabledSetting(componentNameGuruOrai, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                     isRemindGuruOrai=true;
                     editor.putBoolean(StringConstants.prefGuruOrai,true);
                     editor.apply();
                     editor.commit();
                         if(weekday_name.matches("Sunday")){
                             setalarmGuruOrai(1,0,11,0,0);
                             setalarmGuruOrai(1,1,6,0,1);
                             setalarmGuruOrai(1,0,1,0,2);
                         }
                         if(weekday_name.matches("Monday")){
                             setalarmGuruOrai(2,0,8,0,0);
                             setalarmGuruOrai(2,1,3,0,1);
                             setalarmGuruOrai(2,1,10,0,2);
                             setalarmGuruOrai(2,0,5,0,3);
                         }

                         if(weekday_name.matches("Tuesday")){
                             setalarmGuruOrai(3,1,12,0,0);
                             setalarmGuruOrai(3,1,7,0,1);
                             setalarmGuruOrai(3,0,2,0,2);
                         }
                         if(weekday_name.matches("Wednesday")){
                             setalarmGuruOrai(4,0,9,0,0);
                             setalarmGuruOrai(4,1,4,0,1);
                             setalarmGuruOrai(4,1,11,0,2);
                         }
                         if(weekday_name.matches("Thursday")){
                             setalarmGuruOrai(5,0,6,0,0);
                             setalarmGuruOrai(5,1,1,0,1);
                             setalarmGuruOrai(5,1,8,0,2);
                             setalarmGuruOrai(5,0,3,0,3);
                         }
                         if(weekday_name.matches("Friday")){
                             setalarmGuruOrai(6,0,10,0,0);
                             setalarmGuruOrai(6,1,5,0,1);
                             setalarmGuruOrai(6,0,12,0,2);
                         }
                         if(weekday_name.matches("Saturday")){
                             setalarmGuruOrai(7,0,7,0,0);
                             setalarmGuruOrai(7,1,2,0,1);
                             setalarmGuruOrai(7,1,9,0,2);
                             setalarmGuruOrai(7,0,4,0,3);
                         }


                 }else {
                     stopGuruOraiAlarm();
                    // getActivity().getPackageManager().setComponentEnabledSetting(componentNameGuruOrai, PackageManager.COMPONENT_ENABLED_STATE_DISABLED , PackageManager.DONT_KILL_APP);
                     isRemindGuruOrai = false;
                     editor.putBoolean(StringConstants.prefGuruOrai,false);
                     editor.apply();
                     editor.commit();

                 }
             }
         });
      switchSukkiraOrai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              if(switchSukkiraOrai.isChecked()){
                 // getActivity(). getPackageManager().setComponentEnabledSetting(componentNameSukraOrai, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                  isRemindSukkiraOrai=true;
                  editor.putBoolean(StringConstants.prefSukkiraOrai,true);
                  editor.apply();
                  editor.commit();
                      if(weekday_name.matches("Sunday")){
                          setalarmSukkiraOrai(1,0,7,0,0);
                          setalarmSukkiraOrai(1,1,2,0,1);
                          setalarmSukkiraOrai(1,1,9,0,2);
                          setalarmSukkiraOrai(1,0,4,0,3);
                      }
                      if(weekday_name.matches("Monday")){
                          setalarmSukkiraOrai(2,0,11,0,0);
                          setalarmSukkiraOrai(2,1,6,0,1);
                          setalarmSukkiraOrai(2,0,1,0,2);
                      }
                      if(weekday_name.matches("Tuesday")){
                          setalarmSukkiraOrai(3,0,8,0,0);
                          setalarmSukkiraOrai(3,1,3,0,1);
                          setalarmSukkiraOrai(3,1,10,0,2);
                          setalarmSukkiraOrai(3,0,5,0,3);
                      }

                      if(weekday_name.matches("Wednesday")){
                          setalarmSukkiraOrai(4,1,12,0,0);
                          setalarmSukkiraOrai(4,1,7,0,1);
                          setalarmSukkiraOrai(4,0,2,0,2);
                      }
                      if(weekday_name.matches("Thursday")){
                          setalarmSukkiraOrai(5,0,9,0,0);
                          setalarmSukkiraOrai(5,1,4,0,1);
                          setalarmSukkiraOrai(5,1,11,0,2);
                      }
                      if(weekday_name.matches("Friday")){
                          setalarmSukkiraOrai(6,0,6,0,0);
                          setalarmSukkiraOrai(6,1,1,0,1);
                          setalarmSukkiraOrai(6,1,8,0,2);
                          setalarmSukkiraOrai(6,0,3,0,3);
                      }
                      if(weekday_name.matches("Saturday")){
                          setalarmSukkiraOrai(7,0,10,0,0);
                          setalarmSukkiraOrai(7,1,5,0,1);
                          setalarmSukkiraOrai(7,0,12,0,2);
                      }


              }else{
                  stopSukiraOraiAlarm();
                 // getActivity().getPackageManager().setComponentEnabledSetting(componentNameSukraOrai, PackageManager.COMPONENT_ENABLED_STATE_DISABLED , PackageManager.DONT_KILL_APP);
                  isRemindSukkiraOrai=false;
                  editor.putBoolean(StringConstants.prefSukkiraOrai,false);
                  editor.apply();
                  editor.commit();

              }

          }
      });
     switchSaniOrai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
             if(switchSaniOrai.isChecked()){
                // getActivity(). getPackageManager().setComponentEnabledSetting(componentNameSaniOrai, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                 isRemoindSaniOrai=true;
                 editor.putBoolean(StringConstants.prefSaniOrai,true);
                 editor.apply();
                 editor.commit();
                     if(weekday_name.matches("Sunday")){
                         setalarmSaniOrai(1,0,10,0,0);
                         setalarmSaniOrai(1,1,5,0,1);
                         setalarmSaniOrai(1,0,12,0,2);
                     }
                     if(weekday_name.matches("Monday")){
                         setalarmSaniOrai(2,0,7,0,0);
                         setalarmSaniOrai(2,1,2,0,1);
                         setalarmSaniOrai(2,1,9,0,2);
                         setalarmSaniOrai(2,0,4,0,3);

                     }
                     if(weekday_name.matches("Tuesday")){
                         setalarmSaniOrai(3,0,11,0,0);
                         setalarmSaniOrai(3,1,6,0,1);
                         setalarmSaniOrai(3,0,1,0,2);
                     }

                     if(weekday_name.matches("Wednesday")){
                         setalarmSaniOrai(4,0,8,0,0);
                         setalarmSaniOrai(4,1,3,0,1);
                         setalarmSaniOrai(4,1,10,0,2);
                         setalarmSaniOrai(4,0,5,0,3);
                     }

                     if(weekday_name.matches("Thursday")){
                         setalarmSaniOrai(5,1,12,0,0);
                         setalarmSaniOrai(5,1,7,0,1);
                         setalarmSaniOrai(5,0,2,0,2);
                     }
                     if(weekday_name.matches("Friday")){
                         setalarmSaniOrai(6,0,9,0,0);
                         setalarmSaniOrai(6,1,4,0,1);
                         setalarmSaniOrai(6,1,11,0,2);
                     }
                     if(weekday_name.matches("Saturday")){
                         setalarmSaniOrai(7,0,6,0,0);
                         setalarmSaniOrai(7,1,1,0,1);
                         setalarmSaniOrai(7,1,8,0,2);
                         setalarmSaniOrai(7,0,3,0,3);
                     }
             }else {
                 stopSaniOraiAlarm();
                // getActivity().getPackageManager().setComponentEnabledSetting(componentNameSaniOrai, PackageManager.COMPONENT_ENABLED_STATE_DISABLED , PackageManager.DONT_KILL_APP);
                 isRemoindSaniOrai = false;
                 editor.putBoolean(StringConstants.prefSaniOrai,false);
                 editor.apply();
                 editor.commit();


             }
         }
     });

        return view;

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
        Intent intent1 = new Intent(getActivity(), AlarmReceiver.class);
         pi_rahukalam = PendingIntent.getBroadcast(getActivity(), 0,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
         am_rahukaalam = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
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
        Intent intent1 = new Intent(getActivity(), NallaNeramAlarmReceiver.class);
        intent1.putExtra("requestCode",requestCode);
         pi_nalla_neram = PendingIntent.getBroadcast(getActivity(), requestCode,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        am_nallaneram = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
      /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
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
        Intent intent1 = new Intent(getActivity(), KuligaiAlarmReceiver.class);
        intent1.putExtra("requestCode",requestCode);
         pi_kuligai = PendingIntent.getBroadcast(getActivity(), requestCode,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
         am_kuligai = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
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
        Intent intent1 = new Intent(getActivity(), YamagandamAlarmReceiver.class);
         pi_yamakandam = PendingIntent.getBroadcast(getActivity(), 0,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
         am_yamakandam = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am_yamakandam.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_yamakandam);
            am_yamakandam.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_yamakandam);
        }*/
        am_yamakandam.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),24*7*60 * 60 * 1000,pi_yamakandam);
       // am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  24*7*60 * 60 * 1000, pendingIntent);
    }



    public void setalarmSooriyaOrai(int weekno,int am_pm,int hr,int m,int requestcode) {
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
    Intent intent1 = new Intent(getActivity(), SooriyaOraiReceiver.class);
        intent1.putExtra("requstCode",requestcode);
         pi_sooriya_oarai = PendingIntent.getBroadcast(getActivity(), requestcode,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
         am_sooriya_orai = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
      /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
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
        Intent intent1 = new Intent(getActivity(), ChandiraOraiReceiver.class);
        intent1.putExtra("requstCode",requestcode);
         pi_chandira_oarai = PendingIntent.getBroadcast(getActivity(), requestcode,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
         am_chandira_oarai = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am_chandira_oarai.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_chandira_oarai);
            am_chandira_oarai.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_chandira_oarai);
        }*/
        am_chandira_oarai.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),24*7*60 * 60 * 1000,pi_chandira_oarai);
        //am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  24*7*60 * 60 * 1000, pendingIntent);
    }
    public void setalarmSevvayOrai(int weekno,int am_pm,int hr,int m,int requsetCode) {
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
        Intent intent1 = new Intent(getActivity(), ChevvayOraiReceiver.class);
        intent1.putExtra("requestCode",requsetCode);
         pi_chevvay_oarai = PendingIntent.getBroadcast(getActivity(), requsetCode,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
         am_chevvay_oarai = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
      /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am_chevvay_oarai.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_chevvay_oarai);
            am_chevvay_oarai.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_chevvay_oarai);
        }*/
        am_chevvay_oarai.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),24*7*60 * 60 * 1000,pi_chevvay_oarai);
        //am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  24*7*60 * 60 * 1000, pendingIntent);
    }
    public void setalarmButhaOrai(int weekno,int am_pm,int hr,int m,int requsetcode) {
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
        Intent intent1 = new Intent(getActivity(), ButhaOraiReceiver.class);
        intent1.putExtra("requestCode",requsetcode);
         pi_butha_oarai = PendingIntent.getBroadcast(getActivity(), requsetcode,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
         am_butha_oarai = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am_butha_oarai.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_butha_oarai);
            am_butha_oarai.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_butha_oarai);
        }*/
        am_butha_oarai.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),24*7*60 * 60 * 1000,pi_butha_oarai);
        //am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  24*7*60 * 60 * 1000, pendingIntent);
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
        Intent intent1 = new Intent(getActivity(), GuruOraiReceiver.class);
        intent1.putExtra("requestCode",requestcode);
         pi_guru_oarai = PendingIntent.getBroadcast(getActivity(), requestcode,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
         am_guru_oarai = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am_guru_oarai.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_guru_oarai);
            am_guru_oarai.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_guru_oarai);
        }*/
        am_guru_oarai.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),24*7*60 * 60 * 1000,pi_guru_oarai);
        //am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  24*7*60 * 60 * 1000, pendingIntent);
    }
    public void setalarmSukkiraOrai(int weekno,int am_pm,int hr,int m,int requestCode) {
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
        Intent intent1 = new Intent(getActivity(), SukkiraOraiReceiver.class);
        intent1.putExtra("requestCode",requestCode);
         pi_sukkira_oarai = PendingIntent.getBroadcast(getActivity(), requestCode,intent1, PendingIntent.FLAG_UPDATE_CURRENT);
         am_sukira_orai = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am_sukira_orai.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_sukkira_oarai);
            am_sukira_orai.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_sukkira_oarai);
        }*/
        am_sukira_orai.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),24*7*60 * 60 * 1000,pi_sukkira_oarai);
        //am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  24*7*60 * 60 * 1000, pendingIntent);
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
        Intent intent1 = new Intent(getActivity(), SaniOraiReceiver.class);
        intent1.putExtra("requestCode",requestCode);
         pi_sani_oarai = PendingIntent.getBroadcast(getActivity(), requestCode,intent1, PendingIntent.FLAG_UPDATE_CURRENT);

         am_sania_oarai = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am_sania_oarai.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_sani_oarai);
            am_sania_oarai.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi_sani_oarai);
        }*/

        am_sania_oarai.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),24*7*60 * 60 * 1000,pi_sani_oarai);
       // am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  24*7*60 * 60 * 1000, pendingIntent);
    }

    public void stopNallaNeramAlarm() {

        if(am_nallaneram!=null){
            am_nallaneram.cancel(pi_nalla_neram);
            getActivity().stopService(new Intent(getActivity(), NallaNeramAlarmReceiver.class));
            //remove the notification from notification tray
            NotificationManager notificationManager = (NotificationManager) getActivity()
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(NallaNeramAlarmReceiver.MID);
        }
        //Stop the Media Player Service to stop sound


    }
    public void stopRahukalamAlarm() {

        if(am_rahukaalam!=null){
            am_rahukaalam.cancel(pi_rahukalam);
        //Stop the Media Player Service to stop sound
        getActivity().stopService(new Intent(getActivity(), AlarmReceiver.class));
        //remove the notification from notification tray
        NotificationManager notificationManager = (NotificationManager) getActivity()
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(AlarmReceiver.MID);
        }
    }
    public void stopKuligaiAlarm() {

        if(am_kuligai!=null) {
            am_kuligai.cancel(pi_kuligai);//cancel the alarm manager of the pending intent
            //Stop the Media Player Service to stop sound
            getActivity().stopService(new Intent(getActivity(), KuligaiAlarmReceiver.class));
            //remove the notification from notification tray
            NotificationManager notificationManager = (NotificationManager) getActivity()
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(KuligaiAlarmReceiver.MID);
        }
    }
    public void stopYamagandamAlarm() {

        if(am_yamakandam!=null){
            am_yamakandam.cancel(pi_yamakandam);//cancel the alarm manager of the pending intent
        //Stop the Media Player Service to stop sound
        getActivity().stopService(new Intent(getActivity(), YamagandamAlarmReceiver.class));
        //remove the notification from notification tray
        NotificationManager notificationManager = (NotificationManager) getActivity()
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(YamagandamAlarmReceiver.MID);
        }
    }
    public void stopSooriyaOraiAlarm() {

        if(am_sooriya_orai!=null){

        am_sooriya_orai.cancel(pi_sooriya_oarai);//cancel the alarm manager of the pending intent
        //Stop the Media Player Service to stop sound
        getActivity().stopService(new Intent(getActivity(), SooriyaOraiReceiver.class));
        //remove the notification from notification tray
        NotificationManager notificationManager = (NotificationManager) getActivity()
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(SooriyaOraiReceiver.MID);
        }
    }
    public void stopChandiraOraiAlarm() {

        if(am_chandira_oarai!=null) {
            am_chandira_oarai.cancel(pi_chandira_oarai);//cancel the alarm manager of the pending intent
            //Stop the Media Player Service to stop sound
            getActivity().stopService(new Intent(getActivity(), ChandiraOraiReceiver.class));
            //remove the notification from notification tray
            NotificationManager notificationManager = (NotificationManager) getActivity()
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(ChandiraOraiReceiver.MID);
        }
    }
    public void stopChevaiOraiAlarm() {
        if(am_chevvay_oarai!=null){
            am_chevvay_oarai.cancel(pi_chevvay_oarai);//cancel the alarm manager of the pending intent
        //Stop the Media Player Service to stop sound
        getActivity().stopService(new Intent(getActivity(), ChevvayOraiReceiver.class));
        //remove the notification from notification tray
        NotificationManager notificationManager = (NotificationManager) getActivity()
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(ChevvayOraiReceiver.MID);
        }
    }
    public void stopButhaOraiAlarm() {
        if(am_butha_oarai!=null){
            am_butha_oarai.cancel(pi_butha_oarai);//cancel the alarm manager of the pending intent
            //Stop the Media Player Service to stop sound
            getActivity().stopService(new Intent(getActivity(), ButhaOraiReceiver.class));
            //remove the notification from notification tray
            NotificationManager notificationManager = (NotificationManager) getActivity()
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(ButhaOraiReceiver.MID);
        }


    }
    public void stopGuruOraiAlarm() {

        if(am_guru_oarai!=null) {

            am_guru_oarai.cancel(pi_guru_oarai);//cancel the alarm manager of the pending intent
            //Stop the Media Player Service to stop sound
            getActivity().stopService(new Intent(getActivity(), GuruOraiReceiver.class));
            //remove the notification from notification tray
            NotificationManager notificationManager = (NotificationManager) getActivity()
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(GuruOraiReceiver.MID);
        }
    }
    public void stopSukiraOraiAlarm() {
        if(am_sukira_orai!=null) {
            am_sukira_orai.cancel(pi_sukkira_oarai);//cancel the alarm manager of the pending intent
            //Stop the Media Player Service to stop sound
            getActivity().stopService(new Intent(getActivity(), SukkiraOraiReceiver.class));
            //remove the notification from notification tray
            NotificationManager notificationManager = (NotificationManager) getActivity()
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(SukkiraOraiReceiver.MID);
        }
    }
    public void stopSaniOraiAlarm() {
        if(am_sania_oarai!=null){
            am_sania_oarai.cancel(pi_sani_oarai);//cancel the alarm manager of the pending intent
        //Stop the Media Player Service to stop sound
        getActivity().stopService(new Intent(getActivity(), SaniOraiReceiver.class));
        //remove the notification from notification tray
        NotificationManager notificationManager = (NotificationManager) getActivity()
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(SaniOraiReceiver.MID);
        }
    }
}
