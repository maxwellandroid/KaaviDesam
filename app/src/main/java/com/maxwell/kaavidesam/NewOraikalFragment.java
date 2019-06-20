package com.maxwell.kaavidesam;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class NewOraikalFragment extends Fragment {

    View view;

    TextView tv_today,tv_time,tv_oarai,tv_palan,tv_view_today,tv_view_month;
    String content="";

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.layout_new_oaraikal,container,false);
        Toolbar toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
       TextView tv_screen_name=toolbar.findViewById(R.id.text_screen_name);
        tv_screen_name.setText("காவி தேசம் - சுப ஓரை");
        initializeViews();
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void initializeViews(){
        String weekday_name = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(System.currentTimeMillis());
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
        String currentDate=sdf.format(currentTime);

        String[] splitteddate=currentDate.split(" ");
        String date=splitteddate[0];
        String time=splitteddate[1];
        String am_pm=splitteddate[2];
        if(am_pm.matches("a.m.")||am_pm.matches("am")||am_pm.matches("a.m"))
            am_pm="AM";
       else if(am_pm.matches("p.m")||am_pm.matches("pm")||am_pm.matches("p.m"))
            am_pm="PM";

       String[] h_time=time.split(":");
       String now_hr=h_time[0];

        tv_today=(TextView)view.findViewById(R.id.text_day_name);
        tv_time=(TextView)view.findViewById(R.id.textview_time);
        tv_oarai=(TextView)view.findViewById(R.id.textview_oarai);
        tv_palan=(TextView)view.findViewById(R.id.textview_palangal);
        tv_view_today=(TextView)view.findViewById(R.id.textview_view_today);
        tv_view_month=(TextView)view.findViewById(R.id.textview_view_month);

        if(weekday_name.matches("Sunday")){
            tv_today.setText(date+" ( ஞாயிறு )");

            {

                if(now_hr.matches("06")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சூரிய");

                }
                if(now_hr.matches("07")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("08")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("09")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("10")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("11")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("12")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("01")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சூரிய");
                }
                if(now_hr.matches("02")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("03")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("04")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("05")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("06")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("07")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("08")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சூரிய");
                }
                if(now_hr.matches("09")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("10")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("11")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("12")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("01")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("02")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("03")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சூரிய");
                }
                if(now_hr.matches("04")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("05")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }

            }


        }
        if(weekday_name.matches("Monday")){
            tv_today.setText(date+" ( திங்கள் )");

            {

                if(now_hr.matches("06")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சந்திர");
                }
                if(now_hr.matches("07")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("08")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("09")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("10")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("11")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("12")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("01")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சந்திர");
                }
                if(now_hr.matches("02")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("03")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("04")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("05")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("06")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("07")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("08")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சந்திர");
                }
                if(now_hr.matches("09")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("10")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("11")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("12")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("01")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("02")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("03")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சந்திர");
                }
                if(now_hr.matches("04")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("05")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }

            }


        }
        if(weekday_name.matches("Tuesday")){
            tv_today.setText(date+" ( செவ்வாய் )");
            {

                if(now_hr.matches("06")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("செவ்வாய்");
                }
                if(now_hr.matches("07")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("08")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("09")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("10")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("11")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("12")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("01")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("செவ்வாய்");
                }
                if(now_hr.matches("02")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("03")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("04")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("05")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("06")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("07")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("08")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("செவ்வாய்");
                }
                if(now_hr.matches("09")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("10")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("11")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("12")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("01")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("02")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("03")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("செவ்வாய்");
                }
                if(now_hr.matches("04")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("05")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
            }
        }
        if(weekday_name.matches("Wednesday")){
            tv_today.setText(date+" ( புதன் )");

            {

                if(now_hr.matches("06")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("புத");
                }
                if(now_hr.matches("07")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("08")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("09")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("10")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("11")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("12")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("01")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("புத");
                }
                if(now_hr.matches("02")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("03")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("04")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("05")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("06")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("07")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));

                }
                if(now_hr.matches("08")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("புத");
                }
                if(now_hr.matches("09")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("10")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("11")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("12")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("01")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("02")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("03")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("புத");
                }
                if(now_hr.matches("04")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("05")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
            }

        }
        if(weekday_name.matches("Thursday")){
            tv_today.setText(date+" ( வியாழன் )");
            {

                if(now_hr.matches("06")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("குரு");
                }
                if(now_hr.matches("07")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("08")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("09")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("10")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("11")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("12")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));

                }
                if(now_hr.matches("01")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("குரு");
                }
                if(now_hr.matches("02")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("03")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("04")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("05")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("06")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("07")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("08")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("குரு");
                }
                if(now_hr.matches("09")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("10")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("11")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("12")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("01")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("02")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("03")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("குரு");
                }
                if(now_hr.matches("04")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("05")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
            }
        }
        if(weekday_name.matches("Friday")){
            tv_today.setText(date+" ( வெள்ளி )");

            {

                if(now_hr.matches("06")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சுக்கிர");
                }
                if(now_hr.matches("07")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("08")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("09")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("10")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("11")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("12")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("01")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சுக்கிர");
                }
                if(now_hr.matches("02")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("03")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("04")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("05")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("06")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("07")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("08")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சுக்கிர");
                }
                if(now_hr.matches("09")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("10")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("11")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சனி");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("12")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("01")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("02")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("03")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சுக்கிர");
                }
                if(now_hr.matches("04")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("05")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
            }
        }
        if(weekday_name.matches("Saturday")){
            tv_today.setText(date+" ( சனிக்கிழமை )");

            {

                if(now_hr.matches("06")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சனி");
                }
                if(now_hr.matches("07")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("08")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("09")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("10")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("11")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("12")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("01")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சனி");
                }
                if(now_hr.matches("02")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("03")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("04")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("05")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("06")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("07")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("08")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சனி");
                }
                if(now_hr.matches("09")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("10")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("11")&&(am_pm.matches("PM"))){
                    tv_oarai.setText("சூரிய");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("12")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சுக்கிர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("01")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("புத");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("02")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சந்திர");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("03")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("சனி");
                }
                if(now_hr.matches("04")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("குரு");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
                if(now_hr.matches("05")&&(am_pm.matches("AM"))){
                    tv_oarai.setText("செவ்வாய்");
                    tv_oarai.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                    tv_oarai.setTextColor(getResources().getColor(R.color.white));
                }
            }
        }


        if(now_hr.matches("12")){
            tv_time.setText(now_hr+" "+am_pm+" - "+"1 "+am_pm);
        }
        else if(Integer.parseInt(now_hr)<9){
            tv_time.setText(now_hr+" "+am_pm+" - "+"0"+String.valueOf(Integer.parseInt(now_hr)+1)+" "+am_pm);
        }else {
            tv_time.setText(now_hr+" "+am_pm+" - "+String.valueOf(Integer.parseInt(now_hr)+1)+" "+am_pm);
        }


        tv_view_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapFragment();
            }
        });

        tv_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message=tv_oarai.getText().toString().trim();
                onClic(message);
            }
        });

        tv_oarai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message=tv_oarai.getText().toString().trim();
                onClic(message);
            }
        });

        tv_palan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message=tv_oarai.getText().toString().trim();
                onClic(message);
            }
        });

        tv_view_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                swapFragment1();
            }
        });


    }

    public void  onClic(String message){
       /// String message=textView.getText().toString();
        if(message.matches("சூரிய")){
            content="அரசு சம்பந்தப்பட்ட வேலைகள், பெரியவர்களை பார்த்து உதவி பெறுதல், வேலைக்கு விண்ணப்பித்தல், சொத்து சம்பந்தமாக ஒப்பந்தம் போடுதல், உயில் எழுதுதல், உத்தியோக பதவி ஏற்றல், வியாதிக்கு மருந்து உண்ணுதல் இவை செய்ய உத்தமம் நன்மை.";
        }
        if(message.matches("சந்திர")){
            content="பயணம் தொடங்குதல், பாஸ்போர்ட் விசா டிக்கெட் சம்பந்தப்பட்ட வேலைகள், திருமனதிக்குப் பெண் பார்த்தல், கலைத் துறையில் புதிய உத்திக்க கையாளுதல், ஆடை ஆபரணம் வாங்குதல், சரக்குகளை வெளியே எடுத்து செல்லுதல், நிலத்தில் போர் போடுதல் ஆகியவற்றை வளர்பிறை சந்திர ஓரையில் செய்வது உத்தமம் நன்மை.";
        }
        if(message.matches("செவ்வாய்")){
            content="நிலம் வாங்குதல் - விற்றல் வெல்டிங் பட்டறை மின்சாரம் சம்பந்தப்பட்ட வேலைகள் செய்தல், உடலில் ஆபரேஷன் அறுவை சிகிச்சை செய்தல், எந்திரம் வாங்குதல், விவசாயம் விதை விதைத்தல் நன்று. தேய்பிறை செவ்வாய் ஓரையில் இரகசியத்தை யாரிடமும் சொல்லக்கூடாது. சொன்னால் அதுவே நமக்கு பாதகமாக முடியும்.";
        }
        if(message.matches("புத")){
            content="வியாபாரம் விஷயத்தில் கவனம் செலுத்துதல், புதுக்கணக்கு போடுதல், கமிஷன் வியாபாரம் ஆரம்பித்தாள், குழந்தையை பள்ளிக்கு சேர்த்தல், கால்நடை வாங்குதல், டாக்குமெண்ட் சம்பந்தமாக அக்ரீமெண்ட் போடுதல் உத்தமம் நன்மை.";
        }
        if(message.matches("குரு")){
            content="உயர் கல்விக்கு பிள்ளைகளை சேர்த்தல், மகான் சாதுக்கள் முக்கிய பொறுப்பில் உள்ளவரை சந்தித்தல், தெய்வ காரியம், தெய்வ தரிசனம் செய்தல், விதை விதைத்தல், பயிர் வகைகளை நடுதல் உத்தமம் நன்மை.";
        }
        if(message.matches("சுக்கிர")){
            content="திருமண விஷயமாகச் செல்லுதல், நகை வாங்குதல், கலை துறை சம்பந்தமான காரியம் செய்தல், கறவைமாடு வாங்குதல், நிலத்தில் போர் போடுதல், கடன் வசூல் செய்தல், கலைத் துறை சம்பந்தப்பட்ட கடை வைத்தல், சொகுசு வண்டி வாங்குதல் உத்தமம் நன்மை.";

        }
        if(message.matches("சனி")){
            content="விவசாயம் சம்பந்தப்பட்ட வாகனம் வாங்குதல், நிலை சம்பந்தப்பட்டவகைகள் தீர்வு காணுதல், தோப்புகளை உற்பத்தி செய்தல் இரும்பு சம்பந்தப்பட்ட கடைகள், பட்டறை வைத்தல் உத்தமம் நன்மை.";
        }

        showDialog(content,message);
    }
    private void showDialog(String message,String title) {

        // custom dialog
        final Dialog dialog = new Dialog(getActivity());
        // dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_popup_window);

        // dialog.setTitle("Select Language");


        TextView tv_message=(TextView)dialog.findViewById(R.id.text_oarai_description);
        TextView tv_title=(TextView)dialog.findViewById(R.id.text_oarai);

        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
        String currentDate=sdf.format(currentTime);

        String[] splitteddate=currentDate.split(" ");
        String time=splitteddate[1];
        String am_pm=splitteddate[2];
        if(am_pm.matches("a.m."))
            am_pm="AM";
        else if(am_pm.matches("p.m"))
            am_pm="PM";

        String[] h_time=time.split(":");
        String now_hr=h_time[0];
        if(now_hr.matches("12")){
            tv_title.setText(now_hr+" "+am_pm+" - "+"1 "+am_pm+" "+title+" "+"ஓரை");
        }
        else if(Integer.parseInt(now_hr)<9){
            tv_title.setText(now_hr+" "+am_pm+" - "+"0"+String.valueOf(Integer.parseInt(now_hr)+1)+" "+am_pm+" "+title+" ஓரை");
        }else {
            tv_title.setText(now_hr+" "+am_pm+" - "+String.valueOf(Integer.parseInt(now_hr)+1)+" "+am_pm+" "+title+" ஓரை");
        }

        tv_message.setText(message);


        dialog.show();

    }


    private void swapFragment(){
        OraikalFragment newGamefragment = new OraikalFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, newGamefragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void swapFragment1(){
        MonthlyOraiFrgment newGamefragment = new MonthlyOraiFrgment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, newGamefragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}
