package com.maxwell.kaavidesam;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class MonthlyIndicatorFragment extends Fragment {

    CalendarView calendarView;
    public static final String RESULT = "result";
    public static final String EVENT = "event";
    private static final int ADD_NOTE = 44;

    private CalendarView mCalendarView;

    String selectedDate;

    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;

    EditText et_seletcted_date;

    private MyDataBaseHelper myDataBaseHelper;

    TextView tv_week_name,tv_rahukala_time,tv_kuligai_time,tv_yamakanta_time,tv_vaarasoolai,tv_parigaram,tv_nall_neram;

    String selectedWeek;

    String rahu,kuligai,yamakanta,soolai,parigaram,nallaneram;
    View view;
    TextView tv_screen_name;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter,mAdapter1,mAdapter2,mAdapter3;
    List<SubaMuhurthaNatkalModel> subaMuhurthaNatkalModelList=new ArrayList<>();
    List<SubaMuhurthaNatkalModel> arasuVidumuraiNatkalModelList=new ArrayList<>();
    List<SubaMuhurthaNatkalModel> virathaNatkalModelList=new ArrayList<>();
    SubaMuhurthaNatkalModel subaMuhurthaNatkalModel;
    RecyclerView recyclerViewKarinaal,recyclerViewArasuVidumurai,recyclerViewVirathaNaatkal;
    List<String> karinal=new ArrayList<>();
    String currentDate;
    String dateToStr;
TextView tv_amavaasai,tv_pournami,tv_krithigai,tv_sashti,tv_eakadasi,tv_pradhosham,tv_chathurthi,tv_sangadahara_chathurthi,tv_maadha_sivarathri;
    MyEvents myEventDay;

    TextView t1,t2,t3,t4,t5,t6,t7,t8;
    public CalenderAdapter adapter;// adapter instance
    public Handler handler;// for grabbing some event values for showing the dot
    // marker.
    public ArrayList<String> items;
    public Calendar month1, itemmonth;
    ArrayList<String> virathamdatesArray =new ArrayList<>();
    ArrayList<String> virathamnamesArray =new ArrayList<>();
    ArrayList<String> subhamuhurthamDates =new ArrayList<>();
    RelativeLayout previous;
    RelativeLayout next;
    String curdate;
    GridView gridview;
    LinearLayout layout_govt_holidays,layout_subha_muhurtha_naatkal,layout_viratha_naatkal,layout_karinaal;
    TextView tv_kari_naal;
    String s_karinaal="";
    LinearLayout layout_calendar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.layout_content_monthly,container,false);
        myDataBaseHelper = new MyDataBaseHelper(getActivity());
        Toolbar toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        tv_screen_name=toolbar.findViewById(R.id.text_screen_name);
        recyclerView =(RecyclerView)view.findViewById(R.id.recyclerViewSubhaMuhurthaNatkal);
        recyclerViewKarinaal =(RecyclerView)view.findViewById(R.id.recyclerViewKarinal);
        recyclerViewArasuVidumurai =(RecyclerView)view.findViewById(R.id.recyclerViewArasuVidumuraiNatkal);
        recyclerViewVirathaNaatkal =(RecyclerView)view.findViewById(R.id.recyclerViewVirathaNatkal);
        tv_screen_name.setText("காவி தேசம் - மாத காட்டி");
      //  mCalendarView = (CalendarView)view. findViewById(R.id.calendarView1);

        initializeViews();
        return view;
    }
    public void refreshCalendar() {
        TextView title = (TextView)view. findViewById(R.id.s_title);

        adapter.refreshDays();
        adapter.notifyDataSetChanged();
      //  handler.post(calendarUpdater); // generate some calendar items

        title.setText(android.text.format.DateFormat.format("MMMM yyyy", month1));
    }
    public Runnable calendarUpdater = new Runnable() {

        @Override
        public void run() {
            items.clear();

            // Print dates of the current week
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String itemvalue;
            for (int i = 0; i < 7; i++) {
                itemvalue = df.format(itemmonth.getTime());
                itemmonth.add(Calendar.DATE, 1);
                items.add("2012-09-12");
                items.add("2012-10-07");
                items.add("2012-10-15");
                items.add("2012-10-20");
                items.add("2012-11-30");
                items.add("2012-11-28");
            }

            adapter.setItems(items);
            adapter.notifyDataSetChanged();
        }
    };


    protected void setPreviousMonth() {
        if (month1.get(Calendar.MONTH) == month1.getActualMinimum(Calendar.MONTH)) {
            month1.set((month1.get(Calendar.YEAR) - 1),
                    month1.getActualMaximum(Calendar.MONTH), 1);
        } else {
            month1.set(Calendar.MONTH, month1.get(Calendar.MONTH) - 1);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        curdate=dateFormat.format(month1.getTime());

        currentDate=curdate;
        monthlyDetails();
    }
    protected void setNextMonth() {
        if (month1.get(Calendar.MONTH) == month1.getActualMaximum(Calendar.MONTH)) {
            month1.set((month1.get(Calendar.YEAR) + 1),
                    month1.getActualMinimum(Calendar.MONTH), 1);
        } else {
            month1.set(Calendar.MONTH, month1.get(Calendar.MONTH) + 1);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        curdate=dateFormat.format(month1.getTime());
     currentDate=curdate;
        monthlyDetails();

    }

    public void initializeViews(){
        calendarView=(CalendarView)view.findViewById(R.id.calendarView);
        tv_week_name=(TextView)view.findViewById(R.id.text_day_name) ;
        tv_rahukala_time=(TextView)view.findViewById(R.id.textview_rahu_time) ;
        tv_kuligai_time=(TextView)view.findViewById(R.id.textview_kuligai_time) ;
        tv_yamakanta_time=(TextView)view.findViewById(R.id.textview_yamakanta_time) ;
        tv_vaarasoolai=(TextView)view.findViewById(R.id.textview_vaarasoolai_content) ;
        tv_parigaram=(TextView)view.findViewById(R.id.textview_parigaram_content) ;
        tv_nall_neram=(TextView)view.findViewById(R.id.textview_nalla_neram) ;

        tv_amavaasai=(TextView)view.findViewById(R.id.text_amavasai);
        tv_pournami=(TextView)view.findViewById(R.id.text_pournami);
        tv_krithigai=(TextView)view.findViewById(R.id.text_kiruthigai);
        tv_sashti=(TextView)view.findViewById(R.id.text_sashti);
        tv_eakadasi=(TextView)view.findViewById(R.id.text_eakadhasi);
        tv_pradhosham=(TextView)view.findViewById(R.id.text_pradhosham);
        tv_chathurthi=(TextView)view.findViewById(R.id.text_chathurthi);
        tv_sangadahara_chathurthi=(TextView)view.findViewById(R.id.text_sangadahara_chathurthi);
        tv_maadha_sivarathri=(TextView)view.findViewById(R.id.text_maatha_sivarathri);

        layout_govt_holidays=(LinearLayout)view.findViewById(R.id.layout_govt_holidays);
        layout_subha_muhurtha_naatkal=(LinearLayout)view.findViewById(R.id.layout_subha_muhurtha_naatkal);
        layout_viratha_naatkal=(LinearLayout)view.findViewById(R.id.layout_viratha_naatkal);
        layout_karinaal=(LinearLayout)view.findViewById(R.id.layout_karinaal);
        tv_kari_naal=(TextView)view.findViewById(R.id.text_karinaal);
        layout_calendar=(LinearLayout)view.findViewById(R.id.layout_calendar) ;

        t8=(TextView)view.findViewById(R.id.s_title);
        previous = (RelativeLayout)view. findViewById(R.id.s_previous);
        next = (RelativeLayout)view. findViewById(R.id.s_next);

        gridview = (GridView) view.findViewById(R.id.s_gridview);
        handler = new Handler();

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c);
        String formattedDate1 = df1.format(c);
        currentDate=formattedDate1;
        Date dt= null;
        try {
            dt = df.parse(formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat format2=new SimpleDateFormat("EEEE");
        selectedWeek =format2.format(dt);
        if(selectedWeek.matches("Sunday")){
            tv_week_name.setText(formattedDate1+" ( ஞாயிறு ) ");

        } if(selectedWeek.matches("Monday")){
            tv_week_name.setText(formattedDate1+" ( திங்கள் ) ");

        } if(selectedWeek.matches("Tuesday")){
            tv_week_name.setText(formattedDate1+" ( செவ்வாய் ) ");
            // tv_day.setText("செவ்வாய்");
        } if(selectedWeek.matches("Wednesday")){
            tv_week_name.setText(formattedDate1+" ( புதன் ) ");

        } if(selectedWeek.matches("Thursday")){
            tv_week_name.setText(formattedDate1+" ( வியாழன் ) ");

        } if(selectedWeek.matches("Friday")){
            tv_week_name.setText(formattedDate1+" ( வெள்ளி ) ");

        } if(selectedWeek.matches("Saturday")){
            tv_week_name.setText(formattedDate1+" ( சனிக்கிழமை ) ");

        }


        if(selectedWeek!=null) {
            Cursor cursor = myDataBaseHelper.getData(selectedWeek);

            while (cursor.moveToNext()) {
                rahu = cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_RAHUKALA_TIME));
                nallaneram = cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_NALLA_NERAM));
                kuligai = cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_KULIGAI));
                yamakanta = cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_YAMAKANTAKALA_TIME));
                soolai = cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_VAARASOOLAI));
                parigaram = cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_PARIGARAM));
                //  Toast.makeText(getActivity(),rahu+" "+kuligai+" "+yamakanta+" "+soolai+" "+parigaram,Toast.LENGTH_SHORT).show();

            }

            tv_rahukala_time.setText(rahu);
            tv_kuligai_time.setText(kuligai);
            tv_yamakanta_time.setText(yamakanta);
            tv_vaarasoolai.setText(soolai);
            tv_parigaram.setText(parigaram);
            tv_nall_neram.setText(nallaneram);
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

                if(selectedDay<10&&selectedmonth+1<10){
                    currentDate="0"+String.valueOf(selectedDay)+"-"+"0"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear);

                }else if(selectedDay<10&&selectedmonth+1>10){
                    currentDate="0"+String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear);

                }else if(selectedDay>10&&selectedmonth+1<10){
                    currentDate=String.valueOf(selectedDay)+"-"+"0"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear);

                }else {
                    currentDate=String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear);

                }

                //et_seletcted_date.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( "+ selectedWeek +" ) ");
                if(selectedWeek.matches("Sunday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( ஞாயிறு ) ");

                } if(selectedWeek.matches("Monday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( திங்கள் ) ");

                } if(selectedWeek.matches("Tuesday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( செவ்வாய் ) ");
                    // tv_day.setText("செவ்வாய்");
                } if(selectedWeek.matches("Wednesday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( புதன் ) ");

                } if(selectedWeek.matches("Thursday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( வியாழன் ) ");

                } if(selectedWeek.matches("Friday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( வெள்ளி ) ");

                } if(selectedWeek.matches("Saturday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( சனிக்கிழமை ) ");

                }


                if(selectedWeek!=null) {
                    Cursor cursor = myDataBaseHelper.getData(selectedWeek);

                    while (cursor.moveToNext()) {
                        rahu = cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_RAHUKALA_TIME));
                        nallaneram = cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_NALLA_NERAM));
                        kuligai = cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_KULIGAI));
                        yamakanta = cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_YAMAKANTAKALA_TIME));
                        soolai = cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_VAARASOOLAI));
                        parigaram = cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_PARIGARAM));
                        //  Toast.makeText(getActivity(),rahu+" "+kuligai+" "+yamakanta+" "+soolai+" "+parigaram,Toast.LENGTH_SHORT).show();

                    }

                    tv_rahukala_time.setText(rahu);
                    tv_kuligai_time.setText(kuligai);
                    tv_yamakanta_time.setText(yamakanta);
                    tv_vaarasoolai.setText(soolai);
                    tv_parigaram.setText(parigaram);
                    tv_nall_neram.setText(nallaneram);
                }

                monthlyDetails();
            }

        });


        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        month1 = Calendar.getInstance();
        t8.setText(android.text.format.DateFormat.format("MMMM yyyy", month1));


     //   et_seletcted_date=(EditText)view.findViewById(R.id.edittext_selected_date);

/*
        et_seletcted_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //showdatepicker();
            }
        });
*/

        tv_week_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showdatepicker();
            }
        });

        //showdatepicker();



        if(isNetworkAvailable()){
            monthlyDetails();
        }



        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                ((CalenderAdapter) parent.getAdapter()).setSelected(v);
              //  v.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.nallaneramColor));
                String selectedGridDate = CalenderAdapter.dayString
                        .get(position);
                String[] separatedTime = selectedGridDate.split("-");
                String gridvalueString = separatedTime[2].replaceFirst("^0*",
                        "");// taking last part of date. ie; 2 from 2012-12-02.
                int gridvalue = Integer.parseInt(gridvalueString);
                // navigate to next or previous month on clicking offdays.
                if ((gridvalue > 10) && (position < 8)) {
                    setPreviousMonth();
                    refreshCalendar();
                } else if ((gridvalue < 7) && (position > 28)) {
                    setNextMonth();
                  refreshCalendar();
                }
                ((CalenderAdapter) parent.getAdapter()).setSelected(v);

                curdate=selectedGridDate;
                // Toast.makeText(getActivity(), curdate, Toast.LENGTH_SHORT).show();
                String selecteddate[]=curdate.split("-");
                int selectedDay=Integer.parseInt(selecteddate[2]);
                int selectedmonth=Integer.parseInt(selecteddate[1]);
                int selectedyear=Integer.parseInt(selecteddate[0]);
                selectedDate=String.valueOf(selectedDay)+"/"+String.valueOf(selectedmonth)+"/"+String.valueOf(selectedyear);
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
                if(selectedDay<10&&selectedmonth+1<10){
                    currentDate="0"+String.valueOf(selectedDay)+"-"+"0"+String.valueOf(selectedmonth)+"-"+String.valueOf(selectedyear);

                }else if(selectedDay<10&&selectedmonth+1>10){
                    currentDate="0"+String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth)+"-"+String.valueOf(selectedyear);

                }else if(selectedDay>10&&selectedmonth+1<10){
                    currentDate=String.valueOf(selectedDay)+"-"+"0"+String.valueOf(selectedmonth)+"-"+String.valueOf(selectedyear);

                }else {
                    currentDate=String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth)+"-"+String.valueOf(selectedyear);

                }

                //et_seletcted_date.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( "+ selectedWeek +" ) ");
                if(selectedWeek.matches("Sunday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth)+"-"+String.valueOf(selectedyear)+" ( ஞாயிறு ) ");

                } if(selectedWeek.matches("Monday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth)+"-"+String.valueOf(selectedyear)+" ( திங்கள் ) ");

                } if(selectedWeek.matches("Tuesday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth)+"-"+String.valueOf(selectedyear)+" ( செவ்வாய் ) ");
                    // tv_day.setText("செவ்வாய்");
                } if(selectedWeek.matches("Wednesday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth)+"-"+String.valueOf(selectedyear)+" ( புதன் ) ");

                } if(selectedWeek.matches("Thursday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth)+"-"+String.valueOf(selectedyear)+" ( வியாழன் ) ");

                } if(selectedWeek.matches("Friday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth)+"-"+String.valueOf(selectedyear)+" ( வெள்ளி ) ");

                } if(selectedWeek.matches("Saturday")){
                    tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth)+"-"+String.valueOf(selectedyear)+" ( சனிக்கிழமை ) ");

                }


                if(selectedWeek!=null) {
                    Cursor cursor = myDataBaseHelper.getData(selectedWeek);

                    while (cursor.moveToNext()) {
                        rahu = cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_RAHUKALA_TIME));
                        nallaneram = cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_NALLA_NERAM));
                        kuligai = cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_KULIGAI));
                        yamakanta = cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_YAMAKANTAKALA_TIME));
                        soolai = cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_VAARASOOLAI));
                        parigaram = cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.COLUMN_PARIGARAM));
                        //  Toast.makeText(getActivity(),rahu+" "+kuligai+" "+yamakanta+" "+soolai+" "+parigaram,Toast.LENGTH_SHORT).show();

                    }

                    tv_rahukala_time.setText(rahu);
                    tv_kuligai_time.setText(kuligai);
                    tv_yamakanta_time.setText(yamakanta);
                    tv_vaarasoolai.setText(soolai);
                    tv_parigaram.setText(parigaram);
                    tv_nall_neram.setText(nallaneram);
                }

               // monthlyDetails();


            }
        });

        previous.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setPreviousMonth();
                refreshCalendar();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setNextMonth();
               refreshCalendar();

            }
        });


    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager)getActivity(). getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public void showdatepicker(){
        datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int selectedyear, int selectedmonth, int selectedDay) {

                        //  date.setText(day + "/" + (month + 1) + "/" + year);
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

                        //et_seletcted_date.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( "+ selectedWeek +" ) ");
                        if(selectedWeek.matches("Sunday")){
                            tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( ஞாயிறு ) ");

                        } if(selectedWeek.matches("Monday")){
                            tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( திங்கள் ) ");

                        } if(selectedWeek.matches("Tuesday")){
                            tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( செவ்வாய் ) ");
                           // tv_day.setText("செவ்வாய்");
                        } if(selectedWeek.matches("Wednesday")){
                            tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( புதன் ) ");

                        } if(selectedWeek.matches("Thursday")){
                            tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( வியாழன் ) ");

                        } if(selectedWeek.matches("Friday")){
                            tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( வெள்ளி ) ");

                        } if(selectedWeek.matches("Saturday")){
                            tv_week_name.setText(String.valueOf(selectedDay)+"-"+String.valueOf(selectedmonth+1)+"-"+String.valueOf(selectedyear)+" ( சனி ) ");

                        }


                        if(selectedWeek!=null){
                            Cursor cursor=myDataBaseHelper.getData(selectedWeek);

                            while(cursor.moveToNext()){
                                rahu= cursor.getString(cursor.getColumnIndex("Rahukalam"));
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

                        }

                        // Toast.makeText(getActivity(), "Selected date is "+selectedDate+" & selected day is "+ selectedWeek, Toast.LENGTH_SHORT).show();
                        //   et_dob.setText(s_dob);
                        // datePickerDialog.dismiss();


                    }


                }, year, month, dayOfMonth);
        // datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()-20000);

        datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {

                dialog.dismiss();
            }
        });
        //datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
        datePickerDialog.show();


    }

    public void monthlyDetails(){
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, StringConstants.mainUrl + StringConstants.monthDetailUrl+currentDate, null,
                new Response.Listener<JSONObject>()
                {

                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        Log.d("Response", response.toString());

                        try {

                            if(response.has("daily")){

                                JSONObject dailyObject=response.getJSONObject("daily");

                                if(dailyObject.has("Karinaal")){
                                    karinal=new ArrayList<>();
                                    s_karinaal="";
                                    JSONArray karinaalArray=dailyObject.getJSONArray("Karinaal");
                                    for(int i=0;i<karinaalArray.length();i++){
                                        JSONObject karinaalArrayJSONObject=karinaalArray.getJSONObject(i);
                                        if(karinaalArrayJSONObject.getString("date").length()>4){
                                            karinal.add(karinaalArrayJSONObject.getString("date"));

                                            String date[]=karinaalArrayJSONObject.getString("date").split("-");

                                            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                                            Date dt= null;
                                            try {
                                                dt = df.parse(karinaalArrayJSONObject.getString("date"));
                                            } catch (ParseException e) {
                                                e.printStackTrace();
                                            }
                                            DateFormat format2=new SimpleDateFormat("EEEE");
                                            String  selectedWeek =format2.format(dt);

                                            if(selectedWeek.matches("Sunday")){
                                                s_karinaal=s_karinaal+"  "+date[0]+" ஞாயிறு";


                                            } if(selectedWeek.matches("Monday")){
                                                s_karinaal=s_karinaal+"   "+date[0]+" திங்கள்";

                                            } if(selectedWeek.matches("Tuesday")){
                                                s_karinaal=s_karinaal+"  "+date[0]+" செவ்வாய்";
                                                // tv_day.setText("செவ்வாய்");
                                            } if(selectedWeek.matches("Wednesday")){
                                                s_karinaal=s_karinaal+"  "+date[0]+" புதன்";

                                            } if(selectedWeek.matches("Thursday")){
                                                s_karinaal=s_karinaal+"  "+date[0]+" வியாழன்";

                                            } if(selectedWeek.matches("Friday")){
                                                s_karinaal=s_karinaal+"  "+date[0]+" வெள்ளி";

                                            } if(selectedWeek.matches("Saturday")){

                                                s_karinaal=s_karinaal+"  "+date[0]+" சனிக்கிழமை";

                                            }

                                          //  s_karinaal=s_karinaal+" "+karinaalArrayJSONObject.getString("date");
                                        }

                                        if(karinal.size()>0){
                                            layout_karinaal.setVisibility(View.VISIBLE);
                                            tv_kari_naal.setText(s_karinaal);
                                        }else {
                                            layout_karinaal.setVisibility(View.GONE);
                                        }
                                    }
                                }
                                if(dailyObject.has("Viratha Naatkal"))
                                {
                                    virathamdatesArray =new ArrayList<>();
                                    virathamnamesArray=new ArrayList<>();
                                    JSONArray virathaNaatkal=dailyObject.getJSONArray("Viratha Naatkal");
                                    virathaNatkalModelList=new ArrayList<>();
                                    for(int i=0;i<virathaNaatkal.length();i++) {

                                        JSONObject virathaNaatkalJSONObject = virathaNaatkal.getJSONObject(i);
                                        subaMuhurthaNatkalModel = new SubaMuhurthaNatkalModel();
                                        subaMuhurthaNatkalModel.setDate(virathaNaatkalJSONObject.getString("date"));
                                        subaMuhurthaNatkalModel.setInformation(virathaNaatkalJSONObject.getString("viratham_names"));



                                        if(virathaNaatkalJSONObject.getString("date").length()>4){
                                            virathaNatkalModelList.add(subaMuhurthaNatkalModel);
                                            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                                            Date dt= null;
                                            try {
                                                dt = df.parse(virathaNaatkalJSONObject.getString("date"));
                                            } catch (ParseException e) {
                                                e.printStackTrace();
                                            }
                                            DateFormat format2=new SimpleDateFormat("yyyy-MM-dd");
                                            String date =format2.format(dt);
                                            virathamdatesArray.add(date);
                                            virathamnamesArray.add(virathaNaatkalJSONObject.getString("viratham_names"));
                                        }

                                    }

                                    if(virathaNatkalModelList.size()>0){

                                        String s_amamvasai="",s_pournami="",s_krithigai="",s_sashti="",s_sangadahara_chathurthi="",s_eakadasi="",s_pradhosham="",s_maadha_sivarathri="",s_chathurthi="";
                                        for (int i=0;i<virathaNatkalModelList.size();i++){


                                            if(virathaNatkalModelList.get(i).getInformation().contains("அமாவாசை")){

                                                String date[]=virathaNatkalModelList.get(i).getDate().split("-");
                                                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                                                Date dt= null;
                                                try {
                                                    dt = df.parse(virathaNatkalModelList.get(i).getDate());
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                }
                                                Calendar cal = new GregorianCalendar();
                                                cal.setTime(dt);

                                                DateFormat format2=new SimpleDateFormat("EEEE");
                                                String  selectedWeek =format2.format(dt);

                                                if(selectedWeek.matches("Sunday")){
                                                    s_amamvasai=s_amamvasai+date[0]+" ஞாயிறு";
                                                    tv_amavaasai.setText(s_amamvasai);

                                                } if(selectedWeek.matches("Monday")){
                                                    s_amamvasai=s_amamvasai+date[0]+" திங்கள்";
                                                    tv_amavaasai.setText(s_amamvasai);

                                                } if(selectedWeek.matches("Tuesday")){
                                                    s_amamvasai=s_amamvasai+date[0]+" செவ்வாய்";
                                                    tv_amavaasai.setText(s_amamvasai);
                                                    // tv_day.setText("செவ்வாய்");
                                                } if(selectedWeek.matches("Wednesday")){
                                                    s_amamvasai=s_amamvasai+date[0]+" புதன்";
                                                    tv_amavaasai.setText(s_amamvasai);

                                                } if(selectedWeek.matches("Thursday")){
                                                    s_amamvasai=s_amamvasai+date[0]+" வியாழன்";
                                                    tv_amavaasai.setText(s_amamvasai);

                                                } if(selectedWeek.matches("Friday")){
                                                    s_amamvasai=s_amamvasai+date[0]+" வெள்ளி";
                                                    tv_amavaasai.setText(s_amamvasai);

                                                } if(selectedWeek.matches("Saturday")){
                                                    s_amamvasai=s_amamvasai+date[0]+" சனி";
                                                    tv_amavaasai.setText(s_amamvasai);

                                                }
                                            }
                                            if(virathaNatkalModelList.get(i).getInformation().contains("ௌர்ணமி")){
                                                String date[]=virathaNatkalModelList.get(i).getDate().split("-");
                                                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                                                Date dt= null;
                                                try {
                                                    dt = df.parse(virathaNatkalModelList.get(i).getDate());
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                }

                                                Calendar cal=Calendar.getInstance();
                                                DateFormat format=new SimpleDateFormat("dd-MM-yyyy");
                                                format.format(dt);
                                                cal=format.getCalendar();

                                                DateFormat format2=new SimpleDateFormat("EEEE");
                                                String  selectedWeek =format2.format(dt);

                                                if(selectedWeek.matches("Sunday")){
                                                    s_pournami=s_pournami+date[0]+" ஞாயிறு ";
                                                    tv_pournami.setText(s_pournami);

                                                } if(selectedWeek.matches("Monday")){
                                                    s_pournami=s_pournami+date[0]+" திங்கள் ";
                                                    tv_pournami.setText(s_pournami);

                                                } if(selectedWeek.matches("Tuesday")){
                                                    s_pournami=s_pournami+date[0]+" செவ்வாய் ";
                                                    tv_pournami.setText(s_pournami);
                                                    // tv_day.setText("செவ்வாய்");
                                                } if(selectedWeek.matches("Wednesday")){
                                                    s_pournami=s_pournami+date[0]+" புதன் ";
                                                    tv_pournami.setText(s_pournami);

                                                } if(selectedWeek.matches("Thursday")){
                                                    s_pournami=s_pournami+date[0]+" வியாழன் ";
                                                    tv_pournami.setText(s_pournami);

                                                } if(selectedWeek.matches("Friday")){
                                                    s_pournami=s_pournami+date[0]+" வெள்ளி ";
                                                    tv_pournami.setText(s_pournami);

                                                } if(selectedWeek.matches("Saturday")){
                                                    s_pournami=s_pournami+date[0]+" சனி ";
                                                    tv_pournami.setText(s_pournami);

                                                }
                                            }
                                            if(virathaNatkalModelList.get(i).getInformation().contains("சதுர்த்தி")&&(!virathaNatkalModelList.get(i).getInformation().contains("சங்கடஹர"))){
                                                String date[]=virathaNatkalModelList.get(i).getDate().split("-");
                                                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                                                Date dt= null;
                                                try {
                                                    dt = df.parse(virathaNatkalModelList.get(i).getDate());
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                }
                                               /* Calendar cal = Calendar.getInstance();
                                                cal.setTime(dt);
                                                 myEventDay = new MyEvents(cal, R.drawable.ganesha, virathaNatkalModelList.get(i).getInformation());
*/
                                                DateFormat format2=new SimpleDateFormat("EEEE");
                                                String  selectedWeek =format2.format(dt);

                                                if(selectedWeek.matches("Sunday")){
                                                    s_chathurthi=s_chathurthi+date[0]+" ஞாயிறு ";
                                                    tv_chathurthi.setText(s_chathurthi);

                                                } if(selectedWeek.matches("Monday")){
                                                    s_chathurthi=s_chathurthi+date[0]+" திங்கள் ";
                                                    tv_chathurthi.setText(s_chathurthi);

                                                } if(selectedWeek.matches("Tuesday")){
                                                    s_chathurthi=s_chathurthi+date[0]+" செவ்வாய் ";
                                                    tv_chathurthi.setText(s_chathurthi);
                                                    // tv_day.setText("செவ்வாய்");
                                                } if(selectedWeek.matches("Wednesday")){
                                                    s_chathurthi=s_chathurthi+date[0]+" புதன் ";
                                                    tv_chathurthi.setText(s_chathurthi);

                                                } if(selectedWeek.matches("Thursday")){
                                                    s_chathurthi=s_chathurthi+date[0]+" வியாழன் ";
                                                    tv_chathurthi.setText(s_chathurthi);

                                                } if(selectedWeek.matches("Friday")){
                                                    s_chathurthi=s_chathurthi+date[0]+" வெள்ளி ";
                                                    tv_chathurthi.setText(s_chathurthi);

                                                } if(selectedWeek.matches("Saturday")){
                                                    s_chathurthi=s_chathurthi+date[0]+" சனி ";
                                                    tv_chathurthi.setText(s_chathurthi);

                                                }
                                            }
                                            if(virathaNatkalModelList.get(i).getInformation().contains("சஷ்டி")){
                                                String date[]=virathaNatkalModelList.get(i).getDate().split("-");
                                                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                                                Date dt= null;
                                                try {
                                                    dt = df.parse(virathaNatkalModelList.get(i).getDate());
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                }
                                                DateFormat format2=new SimpleDateFormat("EEEE");
                                                String  selectedWeek =format2.format(dt);

                                                if(selectedWeek.matches("Sunday")){
                                                    s_sashti=s_sashti+date[0]+" ஞாயிறு ";
                                                    tv_sashti.setText(s_sashti);

                                                } if(selectedWeek.matches("Monday")){
                                                    s_sashti=s_sashti+date[0]+" திங்கள் ";
                                                    tv_sashti.setText(s_sashti);

                                                } if(selectedWeek.matches("Tuesday")){
                                                    s_sashti=s_sashti+date[0]+" செவ்வாய் ";
                                                    tv_sashti.setText(s_sashti);
                                                    // tv_day.setText("செவ்வாய்");
                                                } if(selectedWeek.matches("Wednesday")){
                                                    s_sashti=s_sashti+date[0]+" புதன் ";
                                                    tv_sashti.setText(s_sashti);

                                                } if(selectedWeek.matches("Thursday")){
                                                    s_sashti=s_sashti+date[0]+" வியாழன் ";
                                                    tv_sashti.setText(s_sashti);

                                                } if(selectedWeek.matches("Friday")){
                                                    s_sashti=s_sashti+date[0]+" வெள்ளி ";
                                                    tv_sashti.setText(s_sashti);

                                                } if(selectedWeek.matches("Saturday")){
                                                    s_sashti=s_sashti+date[0]+" சனி ";
                                                    tv_sashti.setText(s_sashti);

                                                }
                                            }
                                            if(virathaNatkalModelList.get(i).getInformation().contains("ஏகாதசி")){
                                                String date[]=virathaNatkalModelList.get(i).getDate().split("-");
                                                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                                                Date dt= null;
                                                try {
                                                    dt = df.parse(virathaNatkalModelList.get(i).getDate());
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                }
                                                DateFormat format2=new SimpleDateFormat("EEEE");
                                                String  selectedWeek =format2.format(dt);

                                                if(selectedWeek.matches("Sunday")){
                                                    s_eakadasi=s_eakadasi+date[0]+" ஞாயிறு ";
                                                    tv_eakadasi.setText(s_eakadasi);

                                                } if(selectedWeek.matches("Monday")){
                                                    s_eakadasi=s_eakadasi+date[0]+" திங்கள் ";
                                                    tv_eakadasi.setText(s_eakadasi);

                                                } if(selectedWeek.matches("Tuesday")){
                                                    s_eakadasi=s_eakadasi+date[0]+" செவ்வாய் ";
                                                    tv_eakadasi.setText(s_eakadasi);
                                                    // tv_day.setText("செவ்வாய்");
                                                } if(selectedWeek.matches("Wednesday")){
                                                    s_eakadasi=s_eakadasi+date[0]+" புதன் ";
                                                    tv_eakadasi.setText(s_eakadasi);

                                                } if(selectedWeek.matches("Thursday")){
                                                    s_eakadasi=s_eakadasi+date[0]+" வியாழன் ";
                                                    tv_eakadasi.setText(s_eakadasi);

                                                } if(selectedWeek.matches("Friday")){
                                                    s_eakadasi=s_eakadasi+date[0]+" வெள்ளி ";
                                                    tv_eakadasi.setText(s_eakadasi);

                                                } if(selectedWeek.matches("Saturday")){
                                                    s_eakadasi=s_eakadasi+date[0]+" சனி ";
                                                    tv_eakadasi.setText(s_eakadasi);

                                                }
                                            }
                                            if(virathaNatkalModelList.get(i).getInformation().contains("ிரதோஷம்")){
                                                String date[]=virathaNatkalModelList.get(i).getDate().split("-");
                                                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                                                Date dt= null;
                                                try {
                                                    dt = df.parse(virathaNatkalModelList.get(i).getDate());
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                }
                                                DateFormat format2=new SimpleDateFormat("EEEE");
                                                String  selectedWeek =format2.format(dt);

                                                if(selectedWeek.matches("Sunday")){
                                                    s_pradhosham=s_pradhosham+date[0]+" ஞாயிறு ";
                                                    tv_pradhosham.setText(s_pradhosham);

                                                } if(selectedWeek.matches("Monday")){
                                                    s_pradhosham=s_pradhosham+date[0]+" திங்கள் ";
                                                    tv_pradhosham.setText(s_pradhosham);

                                                } if(selectedWeek.matches("Tuesday")){
                                                    s_pradhosham=s_pradhosham+date[0]+" செவ்வாய் ";
                                                    tv_pradhosham.setText(s_pradhosham);
                                                    // tv_day.setText("செவ்வாய்");
                                                } if(selectedWeek.matches("Wednesday")){
                                                    s_pradhosham=s_pradhosham+date[0]+" புதன் ";
                                                    tv_pradhosham.setText(s_pradhosham);

                                                } if(selectedWeek.matches("Thursday")){
                                                    s_pournami=s_pradhosham+date[0]+" வியாழன் ";
                                                    tv_pradhosham.setText(s_pradhosham);

                                                } if(selectedWeek.matches("Friday")){
                                                    s_pradhosham=s_pradhosham+date[0]+" வெள்ளி ";
                                                    tv_pradhosham.setText(s_pradhosham);

                                                } if(selectedWeek.matches("Saturday")){
                                                    s_pradhosham=s_pradhosham+date[0]+" சனி ";
                                                    tv_pradhosham.setText(s_pradhosham);

                                                }
                                            }
                                            if(virathaNatkalModelList.get(i).getInformation().contains("சங்கடஹர")){
                                                String date[]=virathaNatkalModelList.get(i).getDate().split("-");
                                                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                                                Date dt= null;
                                                try {
                                                    dt = df.parse(virathaNatkalModelList.get(i).getDate());
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                }
                                                DateFormat format2=new SimpleDateFormat("EEEE");
                                                String  selectedWeek =format2.format(dt);

                                                if(selectedWeek.matches("Sunday")){
                                                    s_sangadahara_chathurthi=s_sangadahara_chathurthi+date[0]+" ஞாயிறு  ";
                                                    tv_sangadahara_chathurthi.setText(s_sangadahara_chathurthi);

                                                } if(selectedWeek.matches("Monday")){
                                                    s_sangadahara_chathurthi=s_sangadahara_chathurthi+date[0]+" திங்கள் ";
                                                    tv_sangadahara_chathurthi.setText(s_sangadahara_chathurthi);

                                                } if(selectedWeek.matches("Tuesday")){
                                                    s_sangadahara_chathurthi=s_sangadahara_chathurthi+date[0]+" செவ்வாய் ";
                                                    tv_sangadahara_chathurthi.setText(s_sangadahara_chathurthi);
                                                    // tv_day.setText("செவ்வாய்");
                                                } if(selectedWeek.matches("Wednesday")){
                                                    s_sangadahara_chathurthi=s_sangadahara_chathurthi+date[0]+" புதன் ";
                                                    tv_sangadahara_chathurthi.setText(s_sangadahara_chathurthi);

                                                } if(selectedWeek.matches("Thursday")){
                                                    s_sangadahara_chathurthi=s_sangadahara_chathurthi+date[0]+" வியாழன் ";
                                                    tv_sangadahara_chathurthi.setText(s_sangadahara_chathurthi);

                                                } if(selectedWeek.matches("Friday")){
                                                    s_sangadahara_chathurthi=s_sangadahara_chathurthi+date[0]+" வெள்ளி ";
                                                    tv_sangadahara_chathurthi.setText(s_sangadahara_chathurthi);

                                                } if(selectedWeek.matches("Saturday")){
                                                    s_sangadahara_chathurthi=s_sangadahara_chathurthi+date[0]+" சனி ";
                                                    tv_sangadahara_chathurthi.setText(s_sangadahara_chathurthi);

                                                }
                                            }
                                            if(virathaNatkalModelList.get(i).getInformation().contains("ிருத்திகை")){
                                                String date[]=virathaNatkalModelList.get(i).getDate().split("-");
                                                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                                                Date dt= null;
                                                try {
                                                    dt = df.parse(virathaNatkalModelList.get(i).getDate());
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                }
                                                DateFormat format2=new SimpleDateFormat("EEEE");
                                                String  selectedWeek =format2.format(dt);

                                                if(selectedWeek.matches("Sunday")){
                                                    s_krithigai=s_krithigai+date[0]+" ஞாயிறு ";
                                                    tv_krithigai.setText(s_krithigai);

                                                } if(selectedWeek.matches("Monday")){
                                                    s_krithigai=s_krithigai+date[0]+" திங்கள் ";
                                                    tv_krithigai.setText(s_krithigai);

                                                } if(selectedWeek.matches("Tuesday")){
                                                    s_krithigai=s_krithigai+date[0]+" செவ்வாய் ";
                                                    tv_krithigai.setText(s_krithigai);
                                                    // tv_day.setText("செவ்வாய்");
                                                } if(selectedWeek.matches("Wednesday")){
                                                    s_krithigai=s_krithigai+date[0]+" புதன் ";
                                                    tv_krithigai.setText(s_krithigai);

                                                } if(selectedWeek.matches("Thursday")){
                                                    s_krithigai=s_krithigai+date[0]+" வியாழன் ";
                                                    tv_krithigai.setText(s_krithigai);

                                                } if(selectedWeek.matches("Friday")){
                                                    s_krithigai=s_krithigai+date[0]+" வெள்ளி ";
                                                    tv_krithigai.setText(s_krithigai);

                                                } if(selectedWeek.matches("Saturday")){
                                                    s_krithigai=s_krithigai+date[0]+" சனி ";
                                                    tv_krithigai.setText(s_krithigai);

                                                }
                                            }
                                            if(virathaNatkalModelList.get(i).getInformation().contains("மாத சிவராத்திர")){
                                                String date[]=virathaNatkalModelList.get(i).getDate().split("-");
                                                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                                                Date dt= null;
                                                try {
                                                    dt = df.parse(virathaNatkalModelList.get(i).getDate());
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                }
                                                DateFormat format2=new SimpleDateFormat("EEEE");
                                                String  selectedWeek =format2.format(dt);

                                                if(selectedWeek.matches("Sunday")){
                                                    s_maadha_sivarathri=s_maadha_sivarathri+date[0]+" ஞாயிறு";
                                                    tv_maadha_sivarathri.setText(s_maadha_sivarathri);

                                                } if(selectedWeek.matches("Monday")){
                                                    s_maadha_sivarathri=s_maadha_sivarathri+date[0]+" திங்கள்";
                                                    tv_maadha_sivarathri.setText(s_maadha_sivarathri);

                                                } if(selectedWeek.matches("Tuesday")){
                                                    s_maadha_sivarathri=s_maadha_sivarathri+date[0]+" செவ்வாய்";
                                                    tv_maadha_sivarathri.setText(s_maadha_sivarathri);
                                                    // tv_day.setText("செவ்வாய்");
                                                } if(selectedWeek.matches("Wednesday")){
                                                    s_maadha_sivarathri=s_maadha_sivarathri+date[0]+" புதன்";
                                                    tv_maadha_sivarathri.setText(s_maadha_sivarathri);

                                                } if(selectedWeek.matches("Thursday")){
                                                    s_maadha_sivarathri=s_maadha_sivarathri+date[0]+" வியாழன்";
                                                    tv_maadha_sivarathri.setText(s_maadha_sivarathri);

                                                } if(selectedWeek.matches("Friday")){
                                                    s_maadha_sivarathri=s_maadha_sivarathri+date[0]+" வெள்ளி";
                                                    tv_maadha_sivarathri.setText(s_maadha_sivarathri);

                                                } if(selectedWeek.matches("Saturday")){
                                                    s_maadha_sivarathri=s_maadha_sivarathri+date[0]+" சனி";
                                                    tv_maadha_sivarathri.setText(s_maadha_sivarathri);

                                                }
                                            }

                                           // mCalendarView.setDate(myEventDay.getCalendar());

                                        }
                                      //  mCalendarView.setEvents(mEventDays);


                                    }
                                    if(virathaNatkalModelList.size()>0){
                                        layout_viratha_naatkal.setVisibility(View.VISIBLE);
                                    }else
                                        layout_viratha_naatkal.setVisibility(View.GONE);


                                }
                                if(dailyObject.has("Subha Muhoortham")){
                                    subhamuhurthamDates=new ArrayList<>();
                                    JSONArray subhaMuhurthamArray=dailyObject.getJSONArray("Subha Muhoortham");
                                    subaMuhurthaNatkalModelList=new ArrayList<>();
                                    for(int i=0;i<subhaMuhurthamArray.length();i++) {

                                        JSONObject subhaMuhurthamArrayJSONObject = subhaMuhurthamArray.getJSONObject(i);
                                        subaMuhurthaNatkalModel = new SubaMuhurthaNatkalModel();
                                        subaMuhurthaNatkalModel.setDate(subhaMuhurthamArrayJSONObject.getString("date"));
                                        subaMuhurthaNatkalModel.setFromTime(subhaMuhurthamArrayJSONObject.getString("from_time"));
                                        subaMuhurthaNatkalModel.setToTime(subhaMuhurthamArrayJSONObject.getString("to_time"));
                                        subaMuhurthaNatkalModel.setInformation(subhaMuhurthamArrayJSONObject.getString("information"));


                                        if(subhaMuhurthamArrayJSONObject.getString("date").length()>4){
                                            subaMuhurthaNatkalModelList.add(subaMuhurthaNatkalModel);
                                            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                                            Date dt= null;
                                            try {
                                                dt = df.parse(subhaMuhurthamArrayJSONObject.getString("date"));
                                            } catch (ParseException e) {
                                                e.printStackTrace();
                                            }
                                            DateFormat format2=new SimpleDateFormat("yyyy-MM-dd");
                                            String date =format2.format(dt);
                                            subhamuhurthamDates.add(date);
                                        }


                                    }

                                    if(subaMuhurthaNatkalModelList.size()>0){
                                        layout_subha_muhurtha_naatkal.setVisibility(View.VISIBLE);
                                        mAdapter=new SubhaMuhurthaNatkalAdapter(getContext(),subaMuhurthaNatkalModelList);
                                        LinearLayoutManager horizontalLayoutManager1 = new LinearLayoutManager(getContext());
                                        recyclerView.setLayoutManager(horizontalLayoutManager1);
                                        recyclerView.setAdapter(mAdapter);
                                    }else
                                        layout_subha_muhurtha_naatkal.setVisibility(View.GONE);


                                }
                                if(dailyObject.has("Govt Holiday")){
                                    JSONArray arasuVidumuraiNaatkalArray=dailyObject.getJSONArray("Govt Holiday");
                                    arasuVidumuraiNatkalModelList=new ArrayList<>();
                                    for(int i=0;i<arasuVidumuraiNaatkalArray.length();i++) {

                                        JSONObject arasuVidumuraiNatkalObject = arasuVidumuraiNaatkalArray.getJSONObject(i);
                                        subaMuhurthaNatkalModel = new SubaMuhurthaNatkalModel();
                                        subaMuhurthaNatkalModel.setDate(arasuVidumuraiNatkalObject.getString("date"));
                                        subaMuhurthaNatkalModel.setInformation(arasuVidumuraiNatkalObject.getString("information"));

                                        if(arasuVidumuraiNatkalObject.getString("date").length()>4)
                                        arasuVidumuraiNatkalModelList.add(subaMuhurthaNatkalModel);
                                    }
                                    if(arasuVidumuraiNatkalModelList.size()>0){
                                        layout_govt_holidays.setVisibility(View.VISIBLE);
                                        mAdapter2=new GovtHolidaysAdapter(getContext(),arasuVidumuraiNatkalModelList);
                                        LinearLayoutManager horizontalLayoutManager1 = new LinearLayoutManager(getContext());
                                        recyclerViewArasuVidumurai.setLayoutManager(horizontalLayoutManager1);
                                        recyclerViewArasuVidumurai.setAdapter(mAdapter2);
                                    }else
                                        layout_govt_holidays.setVisibility(View.GONE);

                                }
                            }



                                itemmonth = (Calendar) month1.clone();
                                items = new ArrayList<String>();
                                adapter = new CalenderAdapter(getActivity(), (GregorianCalendar) month1,virathamdatesArray,subhamuhurthamDates,virathamnamesArray);
                                gridview.setAdapter(adapter);



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
