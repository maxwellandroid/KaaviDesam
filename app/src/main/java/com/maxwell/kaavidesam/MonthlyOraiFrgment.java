package com.maxwell.kaavidesam;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MonthlyOraiFrgment extends Fragment {

    View view;
    CalendarView calendarView;

    String selectedDate;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;
    TextView tv_week_name,tv_orai_now;
    String selectedWeek;
    TextView tv_oarai1, tv_oarai2,tv_oarai3,tv_oarai4,tv_oarai5,tv_oarai6,tv_oarai7,tv_oarai8, tv_oarai9,tv_oarai10,tv_oarai11,tv_oarai12,tv_oarai13,tv_oarai14,tv_oarai15, tv_oarai16,tv_oarai17,tv_oarai18,tv_oarai19,tv_oarai20,tv_oarai21,tv_oarai22, tv_oarai23,tv_oarai24;
    TextView tv_time1, tv_time2,tv_time3,tv_time4,tv_time5,tv_time6,tv_time7,tv_time8, tv_time9,tv_time10,tv_time11,tv_time12,tv_time13,tv_time14,tv_time15, tv_time16,tv_time17,tv_time18,tv_time19,tv_time20,tv_time21,tv_time22, tv_time23,tv_time24;
    TextView tv_palan1, tv_palan2,tv_palan3,tv_palan4,tv_palan5,tv_palan6,tv_palan7,tv_palan8, tv_palan9,tv_palan10,tv_palan11,tv_palan12,tv_palan13,tv_palan14,tv_palan15, tv_palan16,tv_palan17,tv_palan18,tv_palan19,tv_palan20,tv_palan21,tv_palan22, tv_palan23,tv_palan24;
    String content="";


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.layout_monthly_oarai,container,false);

        initializeViews();
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void initializeViews(){
        calendarView=(CalendarView)view.findViewById(R.id.calendarView);


        tv_week_name=(TextView)view.findViewById(R.id.text_day_name) ;
        tv_orai_now=(TextView)view.findViewById(R.id.textview_view_now) ;
        tv_oarai1=(TextView)view.findViewById(R.id.textview_oarai1);
        tv_oarai2 =(TextView)view.findViewById(R.id.textview_oarai2);
        tv_oarai3=(TextView)view.findViewById(R.id.textview_oarai3);
        tv_oarai4=(TextView)view.findViewById(R.id.textview_oarai4);
        tv_oarai5=(TextView)view.findViewById(R.id.textview_oarai5);
        tv_oarai6=(TextView)view.findViewById(R.id.textview_oarai6);
        tv_oarai7=(TextView)view.findViewById(R.id.textview_oarai7);
        tv_oarai8=(TextView)view.findViewById(R.id.textview_oarai8);
        tv_oarai9 =(TextView)view.findViewById(R.id.textview_oarai9);
        tv_oarai10=(TextView)view.findViewById(R.id.textview_oarai10);
        tv_oarai11=(TextView)view.findViewById(R.id.textview_oarai11);
        tv_oarai12=(TextView)view.findViewById(R.id.textview_oarai12);
        tv_oarai13=(TextView)view.findViewById(R.id.textview_oarai13);
        tv_oarai14=(TextView)view.findViewById(R.id.textview_oarai14);
        tv_oarai15=(TextView)view.findViewById(R.id.textview_oarai15);
        tv_oarai16 =(TextView)view.findViewById(R.id.textview_oarai16);
        tv_oarai17=(TextView)view.findViewById(R.id.textview_oarai17);
        tv_oarai18=(TextView)view.findViewById(R.id.textview_oarai18);
        tv_oarai19=(TextView)view.findViewById(R.id.textview_oarai19);
        tv_oarai20=(TextView)view.findViewById(R.id.textview_oarai20);
        tv_oarai21=(TextView)view.findViewById(R.id.textview_oarai21);
        tv_oarai22=(TextView)view.findViewById(R.id.textview_oarai22);
        tv_oarai23=(TextView)view.findViewById(R.id.textview_oarai23);
        tv_oarai24=(TextView)view.findViewById(R.id.textview_oarai24);

        tv_time1=(TextView)view.findViewById(R.id.textview_time1);
        tv_time2 =(TextView)view.findViewById(R.id.textview_time2);
        tv_time3=(TextView)view.findViewById(R.id.textview_time3);
        tv_time4=(TextView)view.findViewById(R.id.textview_time4);
        tv_time5=(TextView)view.findViewById(R.id.textview_time5);
        tv_time6=(TextView)view.findViewById(R.id.textview_time6);
        tv_time7=(TextView)view.findViewById(R.id.textview_time7);
        tv_time8=(TextView)view.findViewById(R.id.textview_time8);
        tv_time9 =(TextView)view.findViewById(R.id.textview_time9);
        tv_time10=(TextView)view.findViewById(R.id.textview_time10);
        tv_time11=(TextView)view.findViewById(R.id.textview_time11);
        tv_time12=(TextView)view.findViewById(R.id.textview_time12);
        tv_time13=(TextView)view.findViewById(R.id.textview_time13);
        tv_time14=(TextView)view.findViewById(R.id.textview_time14);
        tv_time15=(TextView)view.findViewById(R.id.textview_time15);
        tv_time16 =(TextView)view.findViewById(R.id.textview_time16);
        tv_time17=(TextView)view.findViewById(R.id.textview_time17);
        tv_time18=(TextView)view.findViewById(R.id.textview_time18);
        tv_time19=(TextView)view.findViewById(R.id.textview_time19);
        tv_time20=(TextView)view.findViewById(R.id.textview_time20);
        tv_time21=(TextView)view.findViewById(R.id.textview_time21);
        tv_time22=(TextView)view.findViewById(R.id.textview_time22);
        tv_time23=(TextView)view.findViewById(R.id.textview_time23);
        tv_time24=(TextView)view.findViewById(R.id.textview_time24);

        tv_palan1=(TextView)view.findViewById(R.id.textview_palan1);
        tv_palan2 =(TextView)view.findViewById(R.id.textview_palan2);
        tv_palan3=(TextView)view.findViewById(R.id.textview_palan3);
        tv_palan4=(TextView)view.findViewById(R.id.textview_palan4);
        tv_palan5=(TextView)view.findViewById(R.id.textview_palan5);
        tv_palan6=(TextView)view.findViewById(R.id.textview_palan6);
        tv_palan7=(TextView)view.findViewById(R.id.textview_palan7);
        tv_palan8=(TextView)view.findViewById(R.id.textview_palan8);
        tv_palan9 =(TextView)view.findViewById(R.id.textview_palan9);
        tv_palan10=(TextView)view.findViewById(R.id.textview_palan10);
        tv_palan11=(TextView)view.findViewById(R.id.textview_palan11);
        tv_palan12=(TextView)view.findViewById(R.id.textview_palan12);
        tv_palan13=(TextView)view.findViewById(R.id.textview_palan13);
        tv_palan14=(TextView)view.findViewById(R.id.textview_palan14);
        tv_palan15=(TextView)view.findViewById(R.id.textview_palan15);
        tv_palan16 =(TextView)view.findViewById(R.id.textview_palan16);
        tv_palan17=(TextView)view.findViewById(R.id.textview_palan17);
        tv_palan18=(TextView)view.findViewById(R.id.textview_palan18);
        tv_palan19=(TextView)view.findViewById(R.id.textview_palan19);
        tv_palan20=(TextView)view.findViewById(R.id.textview_palan20);
        tv_palan21=(TextView)view.findViewById(R.id.textview_palan21);
        tv_palan22=(TextView)view.findViewById(R.id.textview_palan22);
        tv_palan23=(TextView)view.findViewById(R.id.textview_palan23);
        tv_palan24=(TextView)view.findViewById(R.id.textview_palan24);

        tv_orai_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                swapFragment();
            }
        });

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c);
        String formattedDate1 = df1.format(c);

        Date dt= null;
        try {
            dt = df.parse(formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat format2=new SimpleDateFormat("EEEE");
        selectedWeek =format2.format(dt);

        if(selectedWeek.matches("Sunday")){
            tv_week_name.setText(formattedDate1+" ( ஞாயிறு )");
            tv_oarai1.setText("சூரிய");
            tv_oarai2.setText("சுக்கிர");
            tv_oarai2.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai2.setTextColor(getResources().getColor(R.color.white));
            tv_oarai3.setText("புத");
            tv_oarai3.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai3.setTextColor(getResources().getColor(R.color.white));
            tv_oarai4.setText("சந்திர");
            tv_oarai4.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai4.setTextColor(getResources().getColor(R.color.white));
            tv_oarai5.setText("சனி");
            tv_oarai5.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai5.setTextColor(getResources().getColor(R.color.white));
            tv_oarai6.setText("குரு");
            tv_oarai6.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai6.setTextColor(getResources().getColor(R.color.white));
            tv_oarai7.setText("செவ்வாய்");
            tv_oarai7.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai7.setTextColor(getResources().getColor(R.color.white));
            tv_oarai8.setText("சூரிய");
            tv_oarai9.setText("சுக்கிர");
            tv_oarai9.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai9.setTextColor(getResources().getColor(R.color.white));
            tv_oarai10.setText("புத");
            tv_oarai10.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai10.setTextColor(getResources().getColor(R.color.white));
            tv_oarai11.setText("சந்திர");
            tv_oarai11.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai11.setTextColor(getResources().getColor(R.color.white));
            tv_oarai12.setText("சனி");
            tv_oarai12.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai12.setTextColor(getResources().getColor(R.color.white));
            tv_oarai13.setText("குரு");
            tv_oarai13.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai13.setTextColor(getResources().getColor(R.color.white));
            tv_oarai14.setText("செவ்வாய்");
            tv_oarai14.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai14.setTextColor(getResources().getColor(R.color.white));
            tv_oarai15.setText("சூரிய");
            tv_oarai16.setText("சுக்கிர");
            tv_oarai16.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai16.setTextColor(getResources().getColor(R.color.white));
            tv_oarai17.setText("புத");
            tv_oarai17.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai17.setTextColor(getResources().getColor(R.color.white));
            tv_oarai18.setText("சந்திர");
            tv_oarai18.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai18.setTextColor(getResources().getColor(R.color.white));
            tv_oarai19.setText("சனி");
            tv_oarai19.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai19.setTextColor(getResources().getColor(R.color.white));
            tv_oarai20.setText("குரு");
            tv_oarai20.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai20.setTextColor(getResources().getColor(R.color.white));
            tv_oarai21.setText("செவ்வாய்");
            tv_oarai21.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai21.setTextColor(getResources().getColor(R.color.white));
            tv_oarai22.setText("சூரிய");
            tv_oarai23.setText("சுக்கிர");
            tv_oarai23.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai23.setTextColor(getResources().getColor(R.color.white));
            tv_oarai24.setText("புத");
            tv_oarai24.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai24.setTextColor(getResources().getColor(R.color.white));
        } if(selectedWeek.matches("Monday")){
            tv_week_name.setText(formattedDate1+" ( திங்கள் )");
            tv_oarai1.setText("சந்திர");
            tv_oarai2.setText("சனி");
            tv_oarai2.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai2.setTextColor(getResources().getColor(R.color.white));
            tv_oarai3.setText("குரு");
            tv_oarai3.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai3.setTextColor(getResources().getColor(R.color.white));
            tv_oarai4.setText("செவ்வாய்");
            tv_oarai4.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai4.setTextColor(getResources().getColor(R.color.white));
            tv_oarai5.setText("சூரிய");
            tv_oarai5.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai5.setTextColor(getResources().getColor(R.color.white));
            tv_oarai6.setText("சுக்கிர");
            tv_oarai6.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai6.setTextColor(getResources().getColor(R.color.white));
            tv_oarai7.setText("புத");
            tv_oarai7.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai7.setTextColor(getResources().getColor(R.color.white));
            tv_oarai8.setText("சந்திர");
            tv_oarai9.setText("சனி");
            tv_oarai9.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai9.setTextColor(getResources().getColor(R.color.white));
            tv_oarai10.setText("குரு");
            tv_oarai10.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai10.setTextColor(getResources().getColor(R.color.white));
            tv_oarai11.setText("செவ்வாய்");
            tv_oarai11.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai11.setTextColor(getResources().getColor(R.color.white));
            tv_oarai12.setText("சூரிய");
            tv_oarai12.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai12.setTextColor(getResources().getColor(R.color.white));
            tv_oarai13.setText("சுக்கிர");
            tv_oarai13.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai13.setTextColor(getResources().getColor(R.color.white));
            tv_oarai14.setText("புத");
            tv_oarai14.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai14.setTextColor(getResources().getColor(R.color.white));
            tv_oarai15.setText("சந்திர");
            tv_oarai16.setText("சனி");
            tv_oarai16.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai16.setTextColor(getResources().getColor(R.color.white));
            tv_oarai17.setText("குரு");
            tv_oarai17.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai17.setTextColor(getResources().getColor(R.color.white));
            tv_oarai18.setText("செவ்வாய்");
            tv_oarai18.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai18.setTextColor(getResources().getColor(R.color.white));
            tv_oarai19.setText("சூரிய");
            tv_oarai19.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai19.setTextColor(getResources().getColor(R.color.white));
            tv_oarai20.setText("சுக்கிர");
            tv_oarai20.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai20.setTextColor(getResources().getColor(R.color.white));
            tv_oarai21.setText("புத");
            tv_oarai21.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai21.setTextColor(getResources().getColor(R.color.white));
            tv_oarai22.setText("சந்திர");
            tv_oarai23.setText("சனி");
            tv_oarai23.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai23.setTextColor(getResources().getColor(R.color.white));
            tv_oarai24.setText("குரு");
            tv_oarai24.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai24.setTextColor(getResources().getColor(R.color.white));
        }
        if(selectedWeek.matches("Tuesday")){
            tv_week_name.setText(formattedDate1+" ( செவ்வாய் )");
            tv_oarai1.setText("செவ்வாய்");
            tv_oarai2.setText("சூரிய");
            tv_oarai2.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai2.setTextColor(getResources().getColor(R.color.white));
            tv_oarai3.setText("சுக்கிர");
            tv_oarai3.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai3.setTextColor(getResources().getColor(R.color.white));
            tv_oarai4.setText("புத");
            tv_oarai4.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai4.setTextColor(getResources().getColor(R.color.white));
            tv_oarai5.setText("சந்திர");
            tv_oarai5.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai5.setTextColor(getResources().getColor(R.color.white));
            tv_oarai6.setText("சனி");
            tv_oarai6.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai6.setTextColor(getResources().getColor(R.color.white));
            tv_oarai7.setText("குரு");
            tv_oarai7.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai7.setTextColor(getResources().getColor(R.color.white));
            tv_oarai8.setText("செவ்வாய்");
            tv_oarai9.setText("சூரிய");
            tv_oarai9.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai9.setTextColor(getResources().getColor(R.color.white));
            tv_oarai10.setText("சுக்கிர");
            tv_oarai10.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai10.setTextColor(getResources().getColor(R.color.white));
            tv_oarai11.setText("புத");
            tv_oarai11.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai11.setTextColor(getResources().getColor(R.color.white));
            tv_oarai12.setText("சந்திர");
            tv_oarai12.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai12.setTextColor(getResources().getColor(R.color.white));
            tv_oarai13.setText("சனி");
            tv_oarai13.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai13.setTextColor(getResources().getColor(R.color.white));
            tv_oarai14.setText("குரு");
            tv_oarai14.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai14.setTextColor(getResources().getColor(R.color.white));
            tv_oarai15.setText("செவ்வாய்");
            tv_oarai16.setText("சூரிய");
            tv_oarai16.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai16.setTextColor(getResources().getColor(R.color.white));
            tv_oarai17.setText("சுக்கிர");
            tv_oarai17.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai17.setTextColor(getResources().getColor(R.color.white));
            tv_oarai18.setText("புத");
            tv_oarai18.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai18.setTextColor(getResources().getColor(R.color.white));
            tv_oarai19.setText("சந்திர");
            tv_oarai19.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai19.setTextColor(getResources().getColor(R.color.white));
            tv_oarai20.setText("சனி");
            tv_oarai20.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai20.setTextColor(getResources().getColor(R.color.white));
            tv_oarai21.setText("குரு");
            tv_oarai21.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai21.setTextColor(getResources().getColor(R.color.white));
            tv_oarai22.setText("செவ்வாய்");
            tv_oarai23.setText("சூரிய");
            tv_oarai23.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai23.setTextColor(getResources().getColor(R.color.white));
            tv_oarai24.setText("சுக்கிர");
            tv_oarai24.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai24.setTextColor(getResources().getColor(R.color.white));
        } if(selectedWeek.matches("Wednesday")){
            tv_week_name.setText(formattedDate1+" ( புதன் )");
            tv_oarai1.setText("புத");
            tv_oarai2.setText("சந்திர");
            tv_oarai2.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai2.setTextColor(getResources().getColor(R.color.white));
            tv_oarai3.setText("சனி");
            tv_oarai3.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai3.setTextColor(getResources().getColor(R.color.white));
            tv_oarai4.setText("குரு");
            tv_oarai4.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai4.setTextColor(getResources().getColor(R.color.white));
            tv_oarai5.setText("செவ்வாய்");
            tv_oarai5.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai5.setTextColor(getResources().getColor(R.color.white));
            tv_oarai6.setText("சூரிய");
            tv_oarai6.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai6.setTextColor(getResources().getColor(R.color.white));
            tv_oarai7.setText("சுக்கிர");
            tv_oarai7.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai7.setTextColor(getResources().getColor(R.color.white));
            tv_oarai8.setText("புத");
            tv_oarai9.setText("சந்திர");
            tv_oarai9.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai9.setTextColor(getResources().getColor(R.color.white));
            tv_oarai10.setText("சனி");
            tv_oarai10.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai10.setTextColor(getResources().getColor(R.color.white));
            tv_oarai11.setText("குரு");
            tv_oarai11.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai11.setTextColor(getResources().getColor(R.color.white));
            tv_oarai12.setText("செவ்வாய்");
            tv_oarai12.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai12.setTextColor(getResources().getColor(R.color.white));
            tv_oarai13.setText("சூரிய");
            tv_oarai13.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai13.setTextColor(getResources().getColor(R.color.white));
            tv_oarai14.setText("சுக்கிர");
            tv_oarai14.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai14.setTextColor(getResources().getColor(R.color.white));
            tv_oarai15.setText("புத");
            tv_oarai16.setText("சந்திர");
            tv_oarai16.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai16.setTextColor(getResources().getColor(R.color.white));
            tv_oarai17.setText("சனி");
            tv_oarai17.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai17.setTextColor(getResources().getColor(R.color.white));
            tv_oarai18.setText("குரு");
            tv_oarai18.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai18.setTextColor(getResources().getColor(R.color.white));
            tv_oarai19.setText("செவ்வாய்");
            tv_oarai19.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai19.setTextColor(getResources().getColor(R.color.white));
            tv_oarai20.setText("சூரிய");
            tv_oarai20.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai20.setTextColor(getResources().getColor(R.color.white));
            tv_oarai21.setText("சுக்கிர");
            tv_oarai21.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai21.setTextColor(getResources().getColor(R.color.white));
            tv_oarai22.setText("புத");
            tv_oarai23.setText("சந்திர");
            tv_oarai23.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai23.setTextColor(getResources().getColor(R.color.white));
            tv_oarai24.setText("சனி");
            tv_oarai24.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai24.setTextColor(getResources().getColor(R.color.white));
        } if(selectedWeek.matches("Thursday")){
            tv_week_name.setText(formattedDate1+" ( வியாழன் )");
            tv_oarai1.setText("குரு");
            tv_oarai2.setText("செவ்வாய்");
            tv_oarai2.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai2.setTextColor(getResources().getColor(R.color.white));
            tv_oarai3.setText("சூரிய");
            tv_oarai3.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai3.setTextColor(getResources().getColor(R.color.white));
            tv_oarai4.setText("சுக்கிர");
            tv_oarai4.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai4.setTextColor(getResources().getColor(R.color.white));
            tv_oarai5.setText("புத");
            tv_oarai5.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai5.setTextColor(getResources().getColor(R.color.white));
            tv_oarai6.setText("சந்திர");
            tv_oarai6.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai6.setTextColor(getResources().getColor(R.color.white));
            tv_oarai7.setText("சனி");
            tv_oarai7.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai7.setTextColor(getResources().getColor(R.color.white));
            tv_oarai8.setText("குரு");
            tv_oarai9.setText("செவ்வாய்");
            tv_oarai9.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai9.setTextColor(getResources().getColor(R.color.white));
            tv_oarai10.setText("சூரிய");
            tv_oarai10.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai10.setTextColor(getResources().getColor(R.color.white));
            tv_oarai11.setText("சுக்கிர");
            tv_oarai11.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai11.setTextColor(getResources().getColor(R.color.white));
            tv_oarai12.setText("புத");
            tv_oarai12.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai12.setTextColor(getResources().getColor(R.color.white));
            tv_oarai13.setText("சந்திர");
            tv_oarai13.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai13.setTextColor(getResources().getColor(R.color.white));
            tv_oarai14.setText("சனி");
            tv_oarai14.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai14.setTextColor(getResources().getColor(R.color.white));
            tv_oarai15.setText("குரு");
            tv_oarai16.setText("செவ்வாய்");
            tv_oarai16.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai16.setTextColor(getResources().getColor(R.color.white));
            tv_oarai17.setText("சூரிய");
            tv_oarai17.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai17.setTextColor(getResources().getColor(R.color.white));
            tv_oarai18.setText("சுக்கிர");
            tv_oarai18.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai18.setTextColor(getResources().getColor(R.color.white));
            tv_oarai19.setText("புத");
            tv_oarai19.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai19.setTextColor(getResources().getColor(R.color.white));
            tv_oarai20.setText("சந்திர");
            tv_oarai20.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai20.setTextColor(getResources().getColor(R.color.white));
            tv_oarai21.setText("சனி");
            tv_oarai21.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai21.setTextColor(getResources().getColor(R.color.white));
            tv_oarai22.setText("குரு");
            tv_oarai23.setText("செவ்வாய்");
            tv_oarai23.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai23.setTextColor(getResources().getColor(R.color.white));
            tv_oarai24.setText("சூரிய");
            tv_oarai24.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai24.setTextColor(getResources().getColor(R.color.white));
        } if(selectedWeek.matches("Friday")){
            tv_week_name.setText(formattedDate1+" ( வெள்ளி )");
            tv_oarai1.setText("சுக்கிர");
            tv_oarai2.setText("புத");
            tv_oarai2.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai2.setTextColor(getResources().getColor(R.color.white));
            tv_oarai3.setText("சந்திர");
            tv_oarai3.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai3.setTextColor(getResources().getColor(R.color.white));
            tv_oarai4.setText("சனி");
            tv_oarai4.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai4.setTextColor(getResources().getColor(R.color.white));
            tv_oarai5.setText("குரு");
            tv_oarai5.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai5.setTextColor(getResources().getColor(R.color.white));
            tv_oarai6.setText("செவ்வாய்");
            tv_oarai6.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai6.setTextColor(getResources().getColor(R.color.white));
            tv_oarai7.setText("சூரிய");
            tv_oarai7.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai7.setTextColor(getResources().getColor(R.color.white));
            tv_oarai8.setText("சுக்கிர");
            tv_oarai9.setText("புத");
            tv_oarai9.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai9.setTextColor(getResources().getColor(R.color.white));
            tv_oarai10.setText("சந்திர");
            tv_oarai10.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai10.setTextColor(getResources().getColor(R.color.white));
            tv_oarai11.setText("சனி");
            tv_oarai11.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai11.setTextColor(getResources().getColor(R.color.white));
            tv_oarai12.setText("குரு");
            tv_oarai12.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai12.setTextColor(getResources().getColor(R.color.white));
            tv_oarai13.setText("செவ்வாய்");
            tv_oarai13.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai13.setTextColor(getResources().getColor(R.color.white));
            tv_oarai14.setText("சூரிய");
            tv_oarai14.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai14.setTextColor(getResources().getColor(R.color.white));
            tv_oarai15.setText("சுக்கிர");
            tv_oarai16.setText("புத");
            tv_oarai16.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai16.setTextColor(getResources().getColor(R.color.white));
            tv_oarai17.setText("சந்திர");
            tv_oarai17.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai17.setTextColor(getResources().getColor(R.color.white));
            tv_oarai18.setText("சனி");
            tv_oarai18.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai18.setTextColor(getResources().getColor(R.color.white));
            tv_oarai19.setText("குரு");
            tv_oarai19.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai19.setTextColor(getResources().getColor(R.color.white));
            tv_oarai20.setText("செவ்வாய்");
            tv_oarai20.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai20.setTextColor(getResources().getColor(R.color.white));
            tv_oarai21.setText("சூரிய");
            tv_oarai21.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai21.setTextColor(getResources().getColor(R.color.white));
            tv_oarai22.setText("சுக்கிர");
            tv_oarai23.setText("புத");
            tv_oarai23.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai23.setTextColor(getResources().getColor(R.color.white));
            tv_oarai24.setText("சந்திர");
            tv_oarai24.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai24.setTextColor(getResources().getColor(R.color.white));

        } if(selectedWeek.matches("Saturday")){
            tv_week_name.setText(formattedDate1+" ( சனிக்கிழமை )");
            tv_oarai1.setText("சனி");
            tv_oarai2.setText("குரு");
            tv_oarai2.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai2.setTextColor(getResources().getColor(R.color.white));
            tv_oarai3.setText("செவ்வாய்");
            tv_oarai3.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai3.setTextColor(getResources().getColor(R.color.white));
            tv_oarai4.setText("சூரிய");
            tv_oarai4.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai4.setTextColor(getResources().getColor(R.color.white));
            tv_oarai5.setText("சுக்கிர");
            tv_oarai5.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai5.setTextColor(getResources().getColor(R.color.white));
            tv_oarai6.setText("புத");
            tv_oarai6.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai6.setTextColor(getResources().getColor(R.color.white));
            tv_oarai7.setText("சந்திர");
            tv_oarai7.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai7.setTextColor(getResources().getColor(R.color.white));
            tv_oarai8.setText("சனி");
            tv_oarai9.setText("குரு");
            tv_oarai9.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai9.setTextColor(getResources().getColor(R.color.white));
            tv_oarai10.setText("செவ்வாய்");
            tv_oarai10.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai10.setTextColor(getResources().getColor(R.color.white));
            tv_oarai11.setText("சூரிய");
            tv_oarai11.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai11.setTextColor(getResources().getColor(R.color.white));
            tv_oarai12.setText("சுக்கிர");
            tv_oarai12.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai12.setTextColor(getResources().getColor(R.color.white));
            tv_oarai13.setText("புத");
            tv_oarai13.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai13.setTextColor(getResources().getColor(R.color.white));
            tv_oarai14.setText("சந்திர");
            tv_oarai14.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai14.setTextColor(getResources().getColor(R.color.white));
            tv_oarai15.setText("சனி");
            tv_oarai16.setText("குரு");
            tv_oarai16.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai16.setTextColor(getResources().getColor(R.color.white));
            tv_oarai17.setText("செவ்வாய்");
            tv_oarai17.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai17.setTextColor(getResources().getColor(R.color.white));
            tv_oarai18.setText("சூரிய");
            tv_oarai18.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai18.setTextColor(getResources().getColor(R.color.white));
            tv_oarai19.setText("சுக்கிர");
            tv_oarai19.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai19.setTextColor(getResources().getColor(R.color.white));
            tv_oarai20.setText("புத");
            tv_oarai20.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
            tv_oarai20.setTextColor(getResources().getColor(R.color.white));
            tv_oarai21.setText("சந்திர");
            tv_oarai21.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai21.setTextColor(getResources().getColor(R.color.white));
            tv_oarai22.setText("சனி");
            tv_oarai23.setText("குரு");
            tv_oarai23.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
            tv_oarai23.setTextColor(getResources().getColor(R.color.white));
            tv_oarai24.setText("செவ்வாய்");
            tv_oarai24.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
            tv_oarai24.setTextColor(getResources().getColor(R.color.white));
        }

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int selectedyear, int selectedmonth, int selectedDay) {

                selectedDate=String.valueOf(selectedDay)+"/"+String.valueOf(selectedmonth+1)+"/"+String.valueOf(selectedyear);
                year=selectedyear;
                month=selectedmonth;
                dayOfMonth=selectedDay;


                SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
                Date dt1= null;
                try {
                    dt1 = format1.parse(selectedDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                DateFormat format2=new SimpleDateFormat("EEEE");
                selectedWeek =format2.format(dt1);

                if(selectedWeek.matches("Sunday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( ஞாயிறு ) ");
                    {
                        tv_oarai1.setText("சூரிய");
                        tv_oarai2.setText("சுக்கிர");
                        tv_oarai2.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai2.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai3.setText("புத");
                        tv_oarai3.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai3.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai4.setText("சந்திர");
                        tv_oarai4.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai4.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai5.setText("சனி");
                        tv_oarai5.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai5.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai6.setText("குரு");
                        tv_oarai6.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai6.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai7.setText("செவ்வாய்");
                        tv_oarai7.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai7.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai8.setText("சூரிய");
                        tv_oarai9.setText("சுக்கிர");
                        tv_oarai9.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai9.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai10.setText("புத");
                        tv_oarai10.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai10.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai11.setText("சந்திர");
                        tv_oarai11.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai11.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai12.setText("சனி");
                        tv_oarai12.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai12.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai13.setText("குரு");
                        tv_oarai13.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai13.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai14.setText("செவ்வாய்");
                        tv_oarai14.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai14.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai15.setText("சூரிய");
                        tv_oarai16.setText("சுக்கிர");
                        tv_oarai16.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai16.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai17.setText("புத");
                        tv_oarai17.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai17.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai18.setText("சந்திர");
                        tv_oarai18.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai18.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai19.setText("சனி");
                        tv_oarai19.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai19.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai20.setText("குரு");
                        tv_oarai20.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai20.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai21.setText("செவ்வாய்");
                        tv_oarai21.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai21.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai22.setText("சூரிய");
                        tv_oarai23.setText("சுக்கிர");
                        tv_oarai23.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai23.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai24.setText("புத");
                        tv_oarai24.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai24.setTextColor(getResources().getColor(R.color.white));
                    }

                } if(selectedWeek.matches("Monday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( திங்கள் ) ");
                    {

                        tv_oarai1.setText("சந்திர");
                        tv_oarai2.setText("சனி");
                        tv_oarai2.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai2.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai3.setText("குரு");
                        tv_oarai3.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai3.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai4.setText("செவ்வாய்");
                        tv_oarai4.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai4.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai5.setText("சூரிய");
                        tv_oarai5.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai5.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai6.setText("சுக்கிர");
                        tv_oarai6.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai6.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai7.setText("புத");
                        tv_oarai7.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai7.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai8.setText("சந்திர");
                        tv_oarai9.setText("சனி");
                        tv_oarai9.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai9.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai10.setText("குரு");
                        tv_oarai10.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai10.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai11.setText("செவ்வாய்");
                        tv_oarai11.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai11.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai12.setText("சூரிய");
                        tv_oarai12.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai12.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai13.setText("சுக்கிர");
                        tv_oarai13.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai13.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai14.setText("புத");
                        tv_oarai14.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai14.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai15.setText("சந்திர");
                        tv_oarai16.setText("சனி");
                        tv_oarai16.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai16.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai17.setText("குரு");
                        tv_oarai17.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai17.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai18.setText("செவ்வாய்");
                        tv_oarai18.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai18.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai19.setText("சூரிய");
                        tv_oarai19.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai19.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai20.setText("சுக்கிர");
                        tv_oarai20.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai20.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai21.setText("புத");
                        tv_oarai21.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai21.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai22.setText("சந்திர");
                        tv_oarai23.setText("சனி");
                        tv_oarai23.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai23.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai24.setText("குரு");
                        tv_oarai24.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai24.setTextColor(getResources().getColor(R.color.white));
                    }

                } if(selectedWeek.matches("Tuesday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( செவ்வாய் ) ");
                    {

                        tv_oarai1.setText("செவ்வாய்");
                        tv_oarai2.setText("சூரிய");
                        tv_oarai2.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai2.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai3.setText("சுக்கிர");
                        tv_oarai3.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai3.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai4.setText("புத");
                        tv_oarai4.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai4.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai5.setText("சந்திர");
                        tv_oarai5.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai5.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai6.setText("சனி");
                        tv_oarai6.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai6.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai7.setText("குரு");
                        tv_oarai7.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai7.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai8.setText("செவ்வாய்");
                        tv_oarai9.setText("சூரிய");
                        tv_oarai9.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai9.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai10.setText("சுக்கிர");
                        tv_oarai10.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai10.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai11.setText("புத");
                        tv_oarai11.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai11.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai12.setText("சந்திர");
                        tv_oarai12.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai12.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai13.setText("சனி");
                        tv_oarai13.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai13.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai14.setText("குரு");
                        tv_oarai14.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai14.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai15.setText("செவ்வாய்");
                        tv_oarai16.setText("சூரிய");
                        tv_oarai16.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai16.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai17.setText("சுக்கிர");
                        tv_oarai17.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai17.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai18.setText("புத");
                        tv_oarai18.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai18.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai19.setText("சந்திர");
                        tv_oarai19.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai19.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai20.setText("சனி");
                        tv_oarai20.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai20.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai21.setText("குரு");
                        tv_oarai21.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai21.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai22.setText("செவ்வாய்");
                        tv_oarai23.setText("சூரிய");
                        tv_oarai23.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai23.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai24.setText("சுக்கிர");
                        tv_oarai24.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai24.setTextColor(getResources().getColor(R.color.white));
                    }
                    // tv_day.setText("செவ்வாய்");
                } if(selectedWeek.matches("Wednesday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( புதன் ) ");
                    {

                        tv_oarai1.setText("புத");
                        tv_oarai2.setText("சந்திர");
                        tv_oarai2.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai2.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai3.setText("சனி");
                        tv_oarai3.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai3.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai4.setText("குரு");
                        tv_oarai4.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai4.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai5.setText("செவ்வாய்");
                        tv_oarai5.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai5.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai6.setText("சூரிய");
                        tv_oarai6.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai6.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai7.setText("சுக்கிர");
                        tv_oarai7.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai7.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai8.setText("புத");
                        tv_oarai9.setText("சந்திர");
                        tv_oarai9.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai9.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai10.setText("சனி");
                        tv_oarai10.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai10.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai11.setText("குரு");
                        tv_oarai11.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai11.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai12.setText("செவ்வாய்");
                        tv_oarai12.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai12.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai13.setText("சூரிய");
                        tv_oarai13.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai13.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai14.setText("சுக்கிர");
                        tv_oarai14.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai14.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai15.setText("புத");
                        tv_oarai16.setText("சந்திர");
                        tv_oarai16.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai16.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai17.setText("சனி");
                        tv_oarai17.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai17.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai18.setText("குரு");
                        tv_oarai18.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai18.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai19.setText("செவ்வாய்");
                        tv_oarai19.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai19.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai20.setText("சூரிய");
                        tv_oarai20.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai20.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai21.setText("சுக்கிர");
                        tv_oarai21.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai21.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai22.setText("புத");
                        tv_oarai23.setText("சந்திர");
                        tv_oarai23.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai23.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai24.setText("சனி");
                        tv_oarai24.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai24.setTextColor(getResources().getColor(R.color.white));
                    }
                } if(selectedWeek.matches("Thursday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( வியாழன் ) ");
                    {
                        tv_oarai1.setText("குரு");
                        tv_oarai2.setText("செவ்வாய்");
                        tv_oarai2.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai2.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai3.setText("சூரிய");
                        tv_oarai3.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai3.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai4.setText("சுக்கிர");
                        tv_oarai4.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai4.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai5.setText("புத");
                        tv_oarai5.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai5.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai6.setText("சந்திர");
                        tv_oarai6.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai6.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai7.setText("சனி");
                        tv_oarai7.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai7.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai8.setText("குரு");
                        tv_oarai9.setText("செவ்வாய்");
                        tv_oarai9.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai9.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai10.setText("சூரிய");
                        tv_oarai10.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai10.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai11.setText("சுக்கிர");
                        tv_oarai11.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai11.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai12.setText("புத");
                        tv_oarai12.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai12.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai13.setText("சந்திர");
                        tv_oarai13.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai13.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai14.setText("சனி");
                        tv_oarai14.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai14.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai15.setText("குரு");
                        tv_oarai16.setText("செவ்வாய்");
                        tv_oarai16.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai16.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai17.setText("சூரிய");
                        tv_oarai17.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai17.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai18.setText("சுக்கிர");
                        tv_oarai18.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai18.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai19.setText("புத");
                        tv_oarai19.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai19.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai20.setText("சந்திர");
                        tv_oarai20.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai20.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai21.setText("சனி");
                        tv_oarai21.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai21.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai22.setText("குரு");
                        tv_oarai23.setText("செவ்வாய்");
                        tv_oarai23.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai23.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai24.setText("சூரிய");
                        tv_oarai24.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai24.setTextColor(getResources().getColor(R.color.white));
                    }
                } if(selectedWeek.matches("Friday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( வெள்ளி ) ");

                    {

                        tv_oarai1.setText("சுக்கிர");
                        tv_oarai2.setText("புத");
                        tv_oarai2.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai2.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai3.setText("சந்திர");
                        tv_oarai3.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai3.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai4.setText("சனி");
                        tv_oarai4.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai4.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai5.setText("குரு");
                        tv_oarai5.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai5.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai6.setText("செவ்வாய்");
                        tv_oarai6.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai6.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai7.setText("சூரிய");
                        tv_oarai7.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai7.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai8.setText("சுக்கிர");
                        tv_oarai9.setText("புத");
                        tv_oarai9.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai9.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai10.setText("சந்திர");
                        tv_oarai10.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai10.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai11.setText("சனி");
                        tv_oarai11.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai11.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai12.setText("குரு");
                        tv_oarai12.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai12.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai13.setText("செவ்வாய்");
                        tv_oarai13.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai13.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai14.setText("சூரிய");
                        tv_oarai14.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai14.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai15.setText("சுக்கிர");
                        tv_oarai16.setText("புத");
                        tv_oarai16.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai16.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai17.setText("சந்திர");
                        tv_oarai17.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai17.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai18.setText("சனி");
                        tv_oarai18.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai18.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai19.setText("குரு");
                        tv_oarai19.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai19.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai20.setText("செவ்வாய்");
                        tv_oarai20.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai20.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai21.setText("சூரிய");
                        tv_oarai21.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai21.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai22.setText("சுக்கிர");
                        tv_oarai23.setText("புத");
                        tv_oarai23.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai23.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai24.setText("சந்திர");
                        tv_oarai24.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai24.setTextColor(getResources().getColor(R.color.white));

                    }

                } if(selectedWeek.matches("Saturday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( சனிக்கிழமை ) ");
                    {
                        tv_oarai1.setText("சனி");
                        tv_oarai2.setText("குரு");
                        tv_oarai2.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai2.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai3.setText("செவ்வாய்");
                        tv_oarai3.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai3.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai4.setText("சூரிய");
                        tv_oarai4.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai4.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai5.setText("சுக்கிர");
                        tv_oarai5.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai5.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai6.setText("புத");
                        tv_oarai6.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai6.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai7.setText("சந்திர");
                        tv_oarai7.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai7.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai8.setText("சனி");
                        tv_oarai9.setText("குரு");
                        tv_oarai9.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai9.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai10.setText("செவ்வாய்");
                        tv_oarai10.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai10.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai11.setText("சூரிய");
                        tv_oarai11.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai11.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai12.setText("சுக்கிர");
                        tv_oarai12.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai12.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai13.setText("புத");
                        tv_oarai13.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai13.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai14.setText("சந்திர");
                        tv_oarai14.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai14.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai15.setText("சனி");
                        tv_oarai16.setText("குரு");
                        tv_oarai16.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai16.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai17.setText("செவ்வாய்");
                        tv_oarai17.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai17.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai18.setText("சூரிய");
                        tv_oarai18.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai18.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai19.setText("சுக்கிர");
                        tv_oarai19.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai19.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai20.setText("புத");
                        tv_oarai20.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_green));
                        tv_oarai20.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai21.setText("சந்திர");
                        tv_oarai21.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai21.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai22.setText("சனி");
                        tv_oarai23.setText("குரு");
                        tv_oarai23.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_kaavi));
                        tv_oarai23.setTextColor(getResources().getColor(R.color.white));
                        tv_oarai24.setText("செவ்வாய்");
                        tv_oarai24.setBackground(getResources().getDrawable(R.drawable.rounded_edittext_red));
                        tv_oarai24.setTextColor(getResources().getColor(R.color.white));
                    }
                }
                }

        });


        tv_oarai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai1.getText().toString().trim(),tv_time1.getText().toString().trim());
            }
        });
        tv_oarai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai2.getText().toString().trim(),tv_time2.getText().toString().trim());
            }
        });
        tv_oarai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai3.getText().toString().trim(),tv_time3.getText().toString().trim());
            }
        });
        tv_oarai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai4.getText().toString().trim(),tv_time4.getText().toString().trim());
            }
        });
        tv_oarai5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai5.getText().toString().trim(),tv_time5.getText().toString().trim());
            }
        });
        tv_oarai6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai6.getText().toString().trim(),tv_time6.getText().toString().trim());
            }
        });
        tv_oarai7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai7.getText().toString().trim(),tv_time7.getText().toString().trim());
            }
        });
        tv_oarai8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai8.getText().toString().trim(),tv_time8.getText().toString().trim());
            }
        });
        tv_oarai9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai9.getText().toString().trim(),tv_time9.getText().toString().trim());
            }
        });
        tv_oarai10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai10.getText().toString().trim(),tv_time10.getText().toString().trim());
            }
        });
        tv_oarai11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai11.getText().toString().trim(),tv_time11.getText().toString().trim());
            }
        });
        tv_oarai12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai12.getText().toString().trim(),tv_time12.getText().toString().trim());
            }
        });
        tv_oarai13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai13.getText().toString().trim(),tv_time13.getText().toString().trim());
            }
        });
        tv_oarai14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai14.getText().toString().trim(),tv_time14.getText().toString().trim());
            }
        });
        tv_oarai15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai15.getText().toString().trim(),tv_time15.getText().toString().trim());
            }
        });
        tv_oarai16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai16.getText().toString().trim(),tv_time16.getText().toString().trim());
            }
        });
        tv_oarai17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai17.getText().toString().trim(),tv_time17.getText().toString().trim());
            }
        });
        tv_oarai18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai18.getText().toString().trim(),tv_time18.getText().toString().trim());
            }
        });
        tv_oarai19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai19.getText().toString().trim(),tv_time19.getText().toString().trim());
            }
        });
        tv_oarai20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai20.getText().toString().trim(),tv_time20.getText().toString().trim());
            }
        });
        tv_oarai21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai21.getText().toString().trim(),tv_time21.getText().toString().trim());
            }
        });
        tv_oarai22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai22.getText().toString().trim(),tv_time22.getText().toString().trim());
            }
        });
        tv_oarai23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai23.getText().toString().trim(),tv_time23.getText().toString().trim());
            }
        });
        tv_oarai24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai24.getText().toString().trim(),tv_time24.getText().toString().trim());
            }
        });
        tv_time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai1.getText().toString().trim(),tv_time1.getText().toString().trim());
            }
        });
        tv_time2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai2.getText().toString().trim(),tv_time2.getText().toString().trim());
            }
        });
        tv_time3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai3.getText().toString().trim(),tv_time3.getText().toString().trim());
            }
        });
        tv_time4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai4.getText().toString().trim(),tv_time4.getText().toString().trim());
            }
        });
        tv_time5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai5.getText().toString().trim(),tv_time5.getText().toString().trim());
            }
        });
        tv_time6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai6.getText().toString().trim(),tv_time6.getText().toString().trim());
            }
        });
        tv_time7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai7.getText().toString().trim(),tv_time7.getText().toString().trim());
            }
        });
        tv_time8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai8.getText().toString().trim(),tv_time8.getText().toString().trim());
            }
        });
        tv_time9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai9.getText().toString().trim(),tv_time9.getText().toString().trim());
            }
        });
        tv_time10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai10.getText().toString().trim(),tv_time10.getText().toString().trim());
            }
        });
        tv_time11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai11.getText().toString().trim(),tv_time11.getText().toString().trim());
            }
        });
        tv_time12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai12.getText().toString().trim(),tv_time12.getText().toString().trim());
            }
        });
        tv_time13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai13.getText().toString().trim(),tv_time13.getText().toString().trim());
            }
        });
        tv_time14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai14.getText().toString().trim(),tv_time14.getText().toString().trim());
            }
        });
        tv_time15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai15.getText().toString().trim(),tv_time15.getText().toString().trim());
            }
        });
        tv_time16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai16.getText().toString().trim(),tv_time16.getText().toString().trim());
            }
        });
        tv_time17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai17.getText().toString().trim(),tv_time17.getText().toString().trim());
            }
        });
        tv_time18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai18.getText().toString().trim(),tv_time18.getText().toString().trim());
            }
        });
        tv_time19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai19.getText().toString().trim(),tv_time19.getText().toString().trim());
            }
        });
        tv_time20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai20.getText().toString().trim(),tv_time20.getText().toString().trim());
            }
        });
        tv_time21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai21.getText().toString().trim(),tv_time21.getText().toString().trim());
            }
        });
        tv_time22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai22.getText().toString().trim(),tv_time22.getText().toString().trim());
            }
        });
        tv_time23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai23.getText().toString().trim(),tv_time23.getText().toString().trim());
            }
        });
        tv_time24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai24.getText().toString().trim(),tv_time24.getText().toString().trim());
            }
        });
        tv_palan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai1.getText().toString().trim(),tv_time1.getText().toString().trim());
            }
        });
        tv_palan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai2.getText().toString().trim(),tv_time2.getText().toString().trim());
            }
        });
        tv_palan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai3.getText().toString().trim(),tv_time3.getText().toString().trim());
            }
        });
        tv_palan4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai4.getText().toString().trim(),tv_time4.getText().toString().trim());
            }
        });
        tv_palan5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai5.getText().toString().trim(),tv_time5.getText().toString().trim());
            }
        });
        tv_palan6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai6.getText().toString().trim(),tv_time6.getText().toString().trim());
            }
        });
        tv_palan7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai7.getText().toString().trim(),tv_time7.getText().toString().trim());
            }
        });
        tv_palan8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai8.getText().toString().trim(),tv_time8.getText().toString().trim());
            }
        });
        tv_palan9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai9.getText().toString().trim(),tv_time9.getText().toString().trim());
            }
        });
        tv_palan10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai10.getText().toString().trim(),tv_time10.getText().toString().trim());
            }
        });
        tv_palan11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai11.getText().toString().trim(),tv_time11.getText().toString().trim());
            }
        });
        tv_palan12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai12.getText().toString().trim(),tv_time12.getText().toString().trim());
            }
        });
        tv_palan13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai13.getText().toString().trim(),tv_time13.getText().toString().trim());
            }
        });
        tv_palan14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai14.getText().toString().trim(),tv_time14.getText().toString().trim());
            }
        });
        tv_palan15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai15.getText().toString().trim(),tv_time15.getText().toString().trim());
            }
        });
        tv_palan16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai16.getText().toString().trim(),tv_time16.getText().toString().trim());
            }
        });
        tv_palan17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai17.getText().toString().trim(),tv_time17.getText().toString().trim());
            }
        });
        tv_palan18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai18.getText().toString().trim(),tv_time18.getText().toString().trim());
            }
        });
        tv_palan19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai19.getText().toString().trim(),tv_time19.getText().toString().trim());
            }
        });
        tv_palan20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai20.getText().toString().trim(),tv_time20.getText().toString().trim());
            }
        });
        tv_palan21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai21.getText().toString().trim(),tv_time21.getText().toString().trim());
            }
        });
        tv_palan22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai22.getText().toString().trim(),tv_time22.getText().toString().trim());
            }
        });
        tv_palan23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai23.getText().toString().trim(),tv_time23.getText().toString().trim());
            }
        });
        tv_palan24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClic(tv_oarai24.getText().toString().trim(),tv_time24.getText().toString().trim());
            }
        });





    }

    public void  onClic(String message,String time){
      /*  TextView textView=(TextView)view;
     String message=textView.getText().toString();*/
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

        showDialog(content,message,time);
    }
    private void showDialog(String message,String title,String time) {

        // custom dialog
        final Dialog dialog = new Dialog(getActivity());
        // dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_popup_window);

        // dialog.setTitle("Select Language");


        TextView tv_message=(TextView)dialog.findViewById(R.id.text_oarai_description);
        TextView tv_title=(TextView)dialog.findViewById(R.id.text_oarai);

        tv_title.setText(time+" "+title+" ஓரை");

        tv_message.setText(message);


        dialog.show();

    }

    private void swapFragment(){
        NewOraikalFragment newGamefragment = new NewOraikalFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, newGamefragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}
