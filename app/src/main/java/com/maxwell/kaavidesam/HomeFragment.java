package com.maxwell.kaavidesam;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.maxwell.kaavidesam.DataBaseHelper.MyDataBaseHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class HomeFragment extends Fragment {

    View view;
    private MyDataBaseHelper myDataBaseHelper;

    TextView tv_week_name,tv_rahukala_time,tv_kuligai_time,tv_yamakanta_time,tv_vaarasoolai,tv_parigaram,tv_entire,tv_nall_neram,tv_tamil_date;

    String rahu,kuligai,yamakanta,soolai,parigaram,nallaneram;

    TextView tv_screen_name;
    TextView tv_day;

    TextView tv_time,tv_oarai,tv_palan,tv_view_today,tv_view_month;
    String content="";

    TextView tv_viratha_naal,tv_virathanaal_info,tv_today_special,tv_thithi,tv_yogam,tv_natchathiram,tv_chandirastamam,tv_mesham_palan,tv_rishabam_palan,tv_midhunam_palan,tv_kadagam_palan,tv_simham_palan,tv_kanni_palan,tv_thulam_palan,tv_viruchigam_palan,tv_danusu_palan,tv_magaram_palan,tv_kumbam_palan,tv_meenam_palan,tv_dhinam_oru_thagaval,tv_maruthuva_kurippu,tv_mukkiya_valipaadu,tv_unavu_murai,tv_vaasthu_kuripugal,tv_karinaal,tv_arasu_vidumurai,tv_subha_muhutrtha_naal;

    String s_tamil_day,s_today_special,s_thithi,s_yogam,s_natchathiram,s_chandirastamam,s_mesham_palan,s_rishabam_palan,s_midhunam_palan,s_kadagam_palan, s_simmam_palan,s_kanni_palan,s_thulam_palan,s_viruchigam_palan,s_dhanusu_palan,s_magaram_palan,s_kumbam_palan,s_meenam_palan,s_dhinam_oru_thagaval,s_maruthuva_kurippu,s_mukkiya_valipadu,s_unavu_murai,s_vaasthu_kurippu,s_viratham_name,s_virathanal_info;

    String s_karinaal,s_arasuvidumurai_content,s_subha_muhurthanalinfo,s_suba_muhurtha_nal_start_time,s_subha_muhurth_nal_end_time;
    String currentDate;
    LinearLayout layout_maruthuva_kurippu,layout_today_special,layout_daily_calender,layout_rasi_palan,layout_thinam_oru_thagaval,layout_mukkiya_valipaadu;

    LinearLayout layout_viratha_naal;
    TextView tv_sooranam,tv_surya_udhayam;
    String s_sooranam,s_sooriyaudhayam;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.content_home_page,container,false);
        myDataBaseHelper = new MyDataBaseHelper(getActivity());
        Toolbar toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        tv_screen_name=toolbar.findViewById(R.id.text_screen_name);
        tv_screen_name.setText("காவி தேசம் - நாள் காட்டி");
        initializeViews();
        initializeViews1();
        return view;
    }

    public void initializeViews(){
        String weekday_name = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(System.currentTimeMillis());
        tv_week_name=(TextView)view.findViewById(R.id.text_day_name) ;
        tv_tamil_date=(TextView)view.findViewById(R.id.text_tamil_date) ;
        tv_rahukala_time=(TextView)view.findViewById(R.id.textview_rahu_time) ;
        tv_kuligai_time=(TextView)view.findViewById(R.id.textview_kuligai_time) ;
        tv_yamakanta_time=(TextView)view.findViewById(R.id.textview_yamakanta_time);
        tv_vaarasoolai=(TextView)view.findViewById(R.id.textview_vaarasoolai_content) ;
        tv_parigaram=(TextView)view.findViewById(R.id.textview_parigaram_content) ;
        tv_entire=(TextView)view.findViewById(R.id.textview_view_entire) ;
        tv_nall_neram=(TextView)view.findViewById(R.id.textview_nalla_neram);
        tv_view_today=(TextView)view.findViewById(R.id.textview_today_orai);
        tv_view_month=(TextView)view.findViewById(R.id.textview_monthly_orai);


        tv_viratha_naal=(TextView)view.findViewById(R.id.text_virathanall);
        tv_virathanaal_info=(TextView)view.findViewById(R.id.text_virathanal_info);
        tv_today_special=(TextView)view.findViewById(R.id.text_today_special);
        tv_thithi=(TextView)view.findViewById(R.id.text_thithi);
        tv_yogam=(TextView)view.findViewById(R.id.text_yogam);
        tv_natchathiram=(TextView)view.findViewById(R.id.text_natchathiram);
        tv_chandirastamam=(TextView)view.findViewById(R.id.text_chandrasatamam);
        tv_mesham_palan=(TextView)view.findViewById(R.id.text_mesham_palan);
        tv_rishabam_palan=(TextView)view.findViewById(R.id.text_rishabam_palan);
        tv_midhunam_palan=(TextView)view.findViewById(R.id.text_midunam_palan);
        tv_kadagam_palan=(TextView)view.findViewById(R.id.text_kadagam_palan);
        tv_simham_palan=(TextView)view.findViewById(R.id.text_simham_palan);
        tv_kanni_palan=(TextView)view.findViewById(R.id.text_kanni_palan);
        tv_thulam_palan=(TextView)view.findViewById(R.id.text_thulam_palan);
        tv_viruchigam_palan=(TextView)view.findViewById(R.id.text_viruchigam_palan);
        tv_danusu_palan=(TextView)view.findViewById(R.id.text_danusu_palan);
        tv_magaram_palan=(TextView)view.findViewById(R.id.text_magaram_palan);
        tv_kumbam_palan=(TextView)view.findViewById(R.id.text_kumbam_palan);
        tv_meenam_palan=(TextView)view.findViewById(R.id.text_meenam_palan);
        tv_dhinam_oru_thagaval=(TextView)view.findViewById(R.id.text_dinam_oru_thagaval);
        tv_maruthuva_kurippu=(TextView)view.findViewById(R.id.text_maruthuva_kurippu);
        tv_unavu_murai=(TextView)view.findViewById(R.id.text_unavu_murai);
        tv_mukkiya_valipaadu=(TextView)view.findViewById(R.id.text_mukkiya_valipadu);
        tv_vaasthu_kuripugal=(TextView)view.findViewById(R.id.text_vasthu_kuripugal);
        tv_karinaal=(TextView)view.findViewById(R.id.text_karinall);
        tv_arasu_vidumurai=(TextView)view.findViewById(R.id.text_arasu_vidumaurai);
        tv_subha_muhutrtha_naal=(TextView)view.findViewById(R.id.text_subhamuhurtha_naal);

        tv_day=(TextView)view.findViewById(R.id.text_day);

        layout_maruthuva_kurippu=(LinearLayout)view.findViewById(R.id.layout_maruthuva_kurippu);
        layout_today_special=(LinearLayout)view.findViewById(R.id.layout_today_special);
        layout_daily_calender=(LinearLayout)view.findViewById(R.id.layout_daily_calender);
        layout_rasi_palan=(LinearLayout)view.findViewById(R.id.layout_rasi_palan);
        layout_thinam_oru_thagaval=(LinearLayout)view.findViewById(R.id.layout_dinam_oru_thagaval);
        layout_mukkiya_valipaadu=(LinearLayout)view.findViewById(R.id.layout_mukhiya_valipadu);
        layout_viratha_naal=(LinearLayout)view.findViewById(R.id.layout_viratham);

        tv_sooranam=(TextView)view.findViewById(R.id.textview_sooranam);
        tv_surya_udhayam=(TextView)view.findViewById(R.id.textview_suriya_udhayam);



        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c);
        currentDate=formattedDate;
        if(weekday_name.matches("Sunday")){
            tv_week_name.setText(formattedDate);
            tv_day.setText("ஞாயிறு");
        }
        if(weekday_name.matches("Monday")){
            tv_week_name.setText(formattedDate);
            tv_day.setText("திங்கள்");
        }
        if(weekday_name.matches("Tuesday")){
            tv_week_name.setText(formattedDate);
            tv_day.setText("செவ்வாய்");
        }
        if(weekday_name.matches("Wednesday")){
            tv_week_name.setText(formattedDate);
            tv_day.setText("புதன்");
        }
        if(weekday_name.matches("Thursday")){
            tv_week_name.setText(formattedDate);
            tv_day.setText("வியாழன்");
        }
        if(weekday_name.matches("Friday")){
            tv_week_name.setText(formattedDate);
            tv_day.setText("வெள்ளி");
        }
        if(weekday_name.matches("Saturday")){
            tv_week_name.setText(formattedDate);
            tv_day.setText("சனிக்கிழமை");
        }


        int numofrows=myDataBaseHelper.numberOfRows();
         Cursor cursor=myDataBaseHelper.getData(weekday_name);
        while(cursor.moveToNext()){
             rahu= cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_RAHUKALA_TIME));
             nallaneram=cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_NALLA_NERAM));
             kuligai=cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_KULIGAI));
             yamakanta=cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_YAMAKANTAKALA_TIME));
             soolai=cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_VAARASOOLAI));
             parigaram=cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_PARIGARAM));
          //  Toast.makeText(getActivity(),rahu+" "+kuligai+" "+yamakanta+" "+soolai+" "+parigaram,Toast.LENGTH_SHORT).show();

        }

        tv_rahukala_time.setText(rahu);
        tv_kuligai_time.setText(kuligai);
        tv_yamakanta_time.setText(yamakanta);
        tv_vaarasoolai.setText(soolai);
        tv_parigaram.setText(parigaram);
        tv_nall_neram.setText(nallaneram);

        tv_entire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapFragment();
            }
        });
        tv_view_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapFragment1();
            }
        });
        tv_view_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapFragment2();
            }
        });

        dailyDetails();
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void initializeViews1(){
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
        else if(am_pm.matches("p.m.")||am_pm.matches("pm")||am_pm.matches("p.m"))
            am_pm="PM";
        String[] h_time=time.split(":");
        String now_hr=h_time[0];
        tv_time=(TextView)view.findViewById(R.id.textview_time);
        tv_oarai=(TextView)view.findViewById(R.id.textview_oarai);
        tv_palan=(TextView)view.findViewById(R.id.textview_palangal);
        if(weekday_name.matches("Sunday")){
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
        if(weekday_name.matches("Monday")){
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
        if(weekday_name.matches("Tuesday")){

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
        if(weekday_name.matches("Wednesday")){

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
        if(weekday_name.matches("Thursday")){

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
        if(weekday_name.matches("Friday")){

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
        if(weekday_name.matches("Saturday")){

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


        if(now_hr.matches("12")){
            tv_time.setText(now_hr+" "+am_pm+" - "+"1 "+am_pm);
        }
        else if(Integer.parseInt(now_hr)<9){
            tv_time.setText(now_hr+" "+am_pm+" - "+"0"+String.valueOf(Integer.parseInt(now_hr)+1)+" "+am_pm);
        }else {
            tv_time.setText(now_hr+" "+am_pm+" - "+String.valueOf(Integer.parseInt(now_hr)+1)+" "+am_pm);
        }


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
        else if(am_pm.matches("p.m."))
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
        EntireWeekFragment newGamefragment = new EntireWeekFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, newGamefragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void swapFragment1(){
        OraikalFragment newOraigalFragment = new OraikalFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, newOraigalFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void swapFragment2(){
        MonthlyOraiFrgment monthlyOraiFrgment = new MonthlyOraiFrgment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, monthlyOraiFrgment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    public void dailyDetails(){
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, StringConstants.mainUrl + StringConstants.dailyDetailUrl+currentDate, null,
                new Response.Listener<JSONObject>()
                {

                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        Log.d("Response", response.toString());

                        try {

                            if(response.has("daily")){

                                String key;
                                JSONObject dailyObject=response.getJSONObject("daily");
                                try {
                                    if(dailyObject.has("raasipalen")){
                                        JSONArray rasipalanArray=dailyObject.getJSONArray("raasipalen");

                                        for(int i=0;i<rasipalanArray.length();i++){
                                            JSONObject rasipalanObject=rasipalanArray.getJSONObject(i);
                                            JSONObject mesham=rasipalanObject.getJSONObject("mesam");
                                            s_mesham_palan=mesham.getString("data");
                                            JSONObject rishabam=rasipalanObject.getJSONObject("rishabam");
                                            s_rishabam_palan=rishabam.getString("data");
                                            JSONObject midunam=rasipalanObject.getJSONObject("mithunam");
                                            s_midhunam_palan=midunam.getString("data");
                                            JSONObject kadagam=rasipalanObject.getJSONObject("katakam");
                                            s_kadagam_palan=kadagam.getString("data");
                                            JSONObject simmam=rasipalanObject.getJSONObject("simmam");
                                            s_simmam_palan =simmam.getString("data");
                                            JSONObject kanni=rasipalanObject.getJSONObject("kanni");
                                            s_kanni_palan=kanni.getString("data");
                                            JSONObject thulam=rasipalanObject.getJSONObject("thulam");
                                            s_thulam_palan=thulam.getString("data");
                                            JSONObject viruchagam=rasipalanObject.getJSONObject("viruchagam");
                                            s_viruchigam_palan=viruchagam.getString("data");
                                            JSONObject dhanus=rasipalanObject.getJSONObject("dhanus");
                                            s_dhanusu_palan=dhanus.getString("data");
                                            JSONObject magaram=rasipalanObject.getJSONObject("magaram");
                                            s_magaram_palan=magaram.getString("data");
                                            JSONObject kumbam=rasipalanObject.getJSONObject("kumbam");
                                            s_kumbam_palan=kumbam.getString("data");
                                            JSONObject meenam=rasipalanObject.getJSONObject("meenam");
                                            s_meenam_palan=meenam.getString("data");
                                        }

                                        layout_rasi_palan.setVisibility(View.VISIBLE);
                                        tv_mesham_palan.setText(s_mesham_palan);
                                        tv_rishabam_palan.setText(s_rishabam_palan);
                                        tv_midhunam_palan.setText(s_midhunam_palan);
                                        tv_kadagam_palan.setText(s_kadagam_palan);
                                        tv_simham_palan.setText(s_simmam_palan);
                                        tv_kanni_palan.setText(s_kanni_palan);
                                        tv_thulam_palan.setText(s_thulam_palan);
                                        tv_viruchigam_palan.setText(s_viruchigam_palan);
                                        tv_danusu_palan.setText(s_dhanusu_palan);
                                        tv_magaram_palan.setText(s_magaram_palan);
                                        tv_kumbam_palan.setText(s_kumbam_palan);
                                        tv_meenam_palan.setText(s_meenam_palan);
                                    }

                                }catch (JSONException e) {
                                    e.printStackTrace();

                                }

                                try {
                                    if(dailyObject.has("Daily Information")){
                                        JSONArray dialyInformationArray=dailyObject.getJSONArray("Daily Information");
                                        for(int i=0;i<dialyInformationArray.length();i++){

                                            JSONObject dailyInformationObject=dialyInformationArray.getJSONObject(i);
                                            s_dhinam_oru_thagaval=dailyInformationObject.getString("information");
                                        }
                                        if(s_dhinam_oru_thagaval.length()>1){
                                            layout_thinam_oru_thagaval.setVisibility(View.VISIBLE);
                                            tv_dhinam_oru_thagaval.setText(s_dhinam_oru_thagaval);
                                        }

                                    }

                                }catch (JSONException e1) {
                                    e1.printStackTrace();

                                }
                                try {
                                    if(dailyObject.has("Today Special")){
                                        JSONArray todaySpecialArray=dailyObject.getJSONArray("Today Special");
                                        for(int i=0;i<todaySpecialArray.length();i++){

                                            JSONObject todaySpecialObject=todaySpecialArray.getJSONObject(i);
                                            s_today_special=todaySpecialObject.getString("information");
                                        }
                                        if(s_today_special.length()>1){
                                            layout_today_special.setVisibility(View.VISIBLE);
                                            tv_today_special.setText(s_today_special);
                                        }

                                    }

                                }catch (JSONException e2) {
                                    e2.printStackTrace();

                                }
                                try {
                                    if(dailyObject.has("Daily Calender")){
                                        JSONArray dailyCalendarArray=dailyObject.getJSONArray("Daily Calender");
                                        for(int i=0;i<dailyCalendarArray.length();i++){

                                            JSONObject dailyCalenderObject=dailyCalendarArray.getJSONObject(i);
                                            s_thithi=dailyCalenderObject.getString("Thithi");
                                            s_tamil_day=dailyCalenderObject.getString("Tamil Day");
                                            s_yogam=dailyCalenderObject.getString("Yogam");
                                            s_natchathiram=dailyCalenderObject.getString("Natchatram");
                                            s_chandirastamam=dailyCalenderObject.getString("chandrastram");
                                            s_sooranam=dailyCalenderObject.getString("suranam");
                                            s_sooriyaudhayam=dailyCalenderObject.getString("suriya_uthayam");
                                        }
                                        if(s_thithi.length()>1){
                                            layout_daily_calender.setVisibility(View.VISIBLE);
                                            tv_tamil_date.setText(s_tamil_day);
                                            tv_thithi.setText(s_thithi);
                                            tv_yogam.setText(s_yogam);
                                            tv_natchathiram.setText(s_natchathiram);
                                            tv_chandirastamam.setText(s_chandirastamam);
                                            tv_sooranam.setText(s_sooranam);
                                            tv_surya_udhayam.setText(s_sooriyaudhayam);
                                        }

                                    }

                                }catch (JSONException e3) {
                                    e3.printStackTrace();

                                }
                                try {
                                    if(dailyObject.has("Maruthuva Kuripu")){
                                        JSONArray maruthuvaKuripuArray=dailyObject.getJSONArray("Maruthuva Kuripu");
                                        for(int i=0;i<maruthuvaKuripuArray.length();i++){

                                            JSONObject maruthuvaKuripuArrayJSONObject=maruthuvaKuripuArray.getJSONObject(i);
                                            s_maruthuva_kurippu=maruthuvaKuripuArrayJSONObject.getString("information");
                                        }
                                        if(s_maruthuva_kurippu.length()>4){
                                            layout_maruthuva_kurippu.setVisibility(View.VISIBLE);
                                            tv_maruthuva_kurippu.setText(s_maruthuva_kurippu);
                                        }

                                    }

                                }catch (JSONException e4) {
                                    e4.printStackTrace();

                                }
                                try {
                                    if(dailyObject.has("Mukkiya Valipaadu")){
                                        JSONArray mukkiyaValipaaduArray=dailyObject.getJSONArray("Mukkiya Valipaadu");
                                        for(int i=0;i<mukkiyaValipaaduArray.length();i++){

                                            JSONObject mukkiyaValipaaduArrayJSONObject=mukkiyaValipaaduArray.getJSONObject(i);
                                            s_mukkiya_valipadu=mukkiyaValipaaduArrayJSONObject.getString("name")+" - "+mukkiyaValipaaduArrayJSONObject.getString("information");
                                        }
                                        if(s_mukkiya_valipadu.length()>4){
                                            layout_mukkiya_valipaadu.setVisibility(View.VISIBLE);
                                            tv_mukkiya_valipaadu.setText(s_mukkiya_valipadu);
                                        }

                                    }

                                }catch (JSONException e5) {
                                    e5.printStackTrace();

                                }
                                try {
                                    if(dailyObject.has("Viratha Naatkal")){
                                        JSONArray virathaNaatkalArray=dailyObject.getJSONArray("Viratha Naatkal");
                                        for(int i=0;i<virathaNaatkalArray.length();i++){
                                            JSONObject virathaNaatkalArrayJSONObject=virathaNaatkalArray.getJSONObject(i);
                                            s_viratham_name=virathaNaatkalArrayJSONObject.getString("viratham_names");
                                            s_virathanal_info=virathaNaatkalArrayJSONObject.getString("information");
                                        }

                                        try {
                                            if(dailyObject.has("Karinaal")){
                                                JSONArray karinaalArray=dailyObject.getJSONArray("Karinaal");
                                                for(int i=0;i<karinaalArray.length();i++){
                                                    JSONObject karinaalArrayJSONObject=karinaalArray.getJSONObject(i);
                                                    s_karinaal=karinaalArrayJSONObject.getString("date");

                                                }
                                            }

                                        }catch (JSONException e6) {
                                            e6.printStackTrace();

                                        }

                                        if(s_viratham_name.length()>3){
                                            layout_viratha_naal.setVisibility(View.VISIBLE);
                                            if(s_karinaal.length()>4){
                                                tv_viratha_naal.setVisibility(View.VISIBLE);
                                                tv_viratha_naal.setText("இன்று "+s_viratham_name+", "+"கரிநாள்   ");
                                            }else {
                                                tv_viratha_naal.setVisibility(View.VISIBLE);
                                                tv_viratha_naal.setText("இன்று "+s_viratham_name);
                                            }

                                        }

                                    }

                                }catch (JSONException e6) {
                                    e6.printStackTrace();

                                }
                                try {
                                    if(dailyObject.has("Govt Holiday")){
                                        JSONArray govtHoliday=dailyObject.getJSONArray("Govt Holiday");
                                        for(int i=0;i<govtHoliday.length();i++){
                                            JSONObject govtHolidayJSONObject=govtHoliday.getJSONObject(i);
                                            s_arasuvidumurai_content=govtHolidayJSONObject.getString("information");

                                        }
                                        if(s_arasuvidumurai_content.length()>3){
                                            tv_arasu_vidumurai.setVisibility(View.VISIBLE);
                                            tv_arasu_vidumurai.setText("அரசு விடுமுறை"+" ( "+s_arasuvidumurai_content+" ) ");
                                        }
                                    }

                                }catch (JSONException e6) {
                                    e6.printStackTrace();

                                }
                                try {
                                    if(dailyObject.has("Subha Muhoortham")){
                                        JSONArray subhaMuhoortham=dailyObject.getJSONArray("Subha Muhoortham");
                                        for(int i=0;i<subhaMuhoortham.length();i++){
                                            JSONObject subhaMuhoorthamJSONObject=subhaMuhoortham.getJSONObject(i);
                                            s_subha_muhurthanalinfo=subhaMuhoorthamJSONObject.getString("information");
                                            s_suba_muhurtha_nal_start_time=subhaMuhoorthamJSONObject.getString("from_time");
                                            s_subha_muhurth_nal_end_time=subhaMuhoorthamJSONObject.getString("to_time");

                                        }
                                        if(s_subha_muhurthanalinfo.length()>3){
                                            tv_subha_muhutrtha_naal.setVisibility(View.VISIBLE);
                                            tv_subha_muhutrtha_naal.setText("சுப முகூர்த்த நாள்"+" ( "+s_subha_muhurthanalinfo+" )\n"+s_suba_muhurtha_nal_start_time+" To "+s_subha_muhurth_nal_end_time);
                                            tv_arasu_vidumurai.setText(s_arasuvidumurai_content);
                                        }
                                    }

                                }catch (JSONException e6) {
                                    e6.printStackTrace();

                                }

                            }






                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Log.d("Error.Response", error.getLocalizedMessage());
                        String errorMessage=StringConstants.ErrorMessage(error);
                        if(errorMessage.matches("Connection TimeOut! Please check your internet connection.")){

                        }else {

                        }
                        //showAlertDialog(errorMessage);

                    }
                }
        );

// add it to the RequestQueue
        queue.add(getRequest);

    }

}
