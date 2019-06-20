package com.maxwell.kaavidesam;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by Admin on 4/7/2017.
 */
public class CalenderAdapter extends BaseAdapter {


    private Context mContext;

    private java.util.Calendar month;
    public GregorianCalendar pmonth; // calendar instance for previous month
    /**
     * calendar instance for previous month for getting complete view
     */
    public GregorianCalendar pmonthmaxset;
    private GregorianCalendar selectedDate;
    int firstDay;
    int maxWeeknumber;
    int maxP;
    int calMaxP;
    int lastWeekDay;
    int leftDays;
    int mnthlength;
    String itemvalue, curentDateString,currentDate;
    DateFormat df;

    ArrayList<String> cal_leave=new ArrayList<>();
    private ArrayList<String> items;
    public static List<String> dayString;
    public static List<String> holiday_list;
    public static List<String> absent_list;
    public static List<String> virathamNamesList;
    private View previousView;
    Calendar calendar;

    public CalenderAdapter(Context c, GregorianCalendar monthCalendar, ArrayList<String> holiday, ArrayList<String> absent,ArrayList<String> virathamNames) {
        CalenderAdapter.dayString = new ArrayList<String>();
        month = monthCalendar;
        CalenderAdapter.holiday_list=holiday;
        CalenderAdapter.absent_list=absent;
        CalenderAdapter.virathamNamesList=virathamNames;
        selectedDate = (GregorianCalendar) monthCalendar.clone();
        mContext = c;
        month.set(GregorianCalendar.DAY_OF_MONTH, 1);
        this.items = new ArrayList<String>();
        calendar=Calendar.getInstance();
        df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        curentDateString = df.format(selectedDate.getTime());
        Date d = Calendar.getInstance().getTime();
        System.out.println("Current time => " + d);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(d);
        String formattedDate1 = df1.format(d);
        currentDate=formattedDate1;
        refreshDays();
    }

    public void setItems(ArrayList<String> items) {
        for (int i = 0; i != items.size(); i++) {
            if (items.get(i).length() == 1) {
                items.set(i, "0" + items.get(i));
            }
        }
        this.items = items;
    }

    public int getCount() {
        return dayString.size();
    }

    public Object getItem(int position) {
        return dayString.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new view for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        TextView dayView;
        ImageView iv_event;
        ImageView iv_muhurtha_naatkal;
        if (convertView == null) { // if it's not recycled, initialize some
            // attributes
            LayoutInflater vi = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.calendar_item, null);

        }
        dayView = (TextView) v.findViewById(R.id.date);
        iv_event=(ImageView)v.findViewById(R.id.image_event);
        iv_muhurtha_naatkal=(ImageView)v.findViewById(R.id.image_muhurtha_naatkal);
        // separates daystring into parts.
        String[] separatedTime = dayString.get(position).split("-");
        // taking last part of date. ie; 2 from 2012-12-02
        String gridvalue = separatedTime[2].replaceFirst("^0*", "");
        // checking whether the day is in current month or not.
        if ((Integer.parseInt(gridvalue) > 1) && (position < firstDay)) {
            // setting offdays to white color.
            dayView.setTextColor(Color.GRAY);
            dayView.setClickable(false);
            dayView.setFocusable(false);
        } else if ((Integer.parseInt(gridvalue) < 7) && (position > 28)) {
            dayView.setTextColor(Color.GRAY);
            dayView.setClickable(false);
            dayView.setFocusable(false);
        } else {
            // setting curent month's days in blue color.
            dayView.setTextColor(Color.BLACK);
        }



        if(curentDateString.equals(currentDate)){
            v.setBackgroundColor(ContextCompat.getColor(mContext, R.color.darkred));
        } else {
            v.setBackgroundResource(R.drawable.rounded_edittext_kaavi_new);
        }
        if (dayString.get(position).equals(curentDateString)) {
            //setSelected(v);
           // v.setBackgroundColor(ContextCompat.getColor(mContext, R.color.darkred));
            previousView = v;
        }
         else {
            v.setBackgroundResource(R.drawable.rounded_edittext_kaavi_new);
        }
        dayView.setText(gridvalue);

        // create date string for comparison
        String date = dayString.get(position);

        if (date.length() == 1) {
            date = "0" + date;
        }
        String monthStr = "" + (month.get(GregorianCalendar.MONTH) + 1);
        if (monthStr.length() == 1) {
            monthStr = "0" + monthStr;
        }

        // show icon if date is not empty and it exists in the items array
        ImageView iw = (ImageView) v.findViewById(R.id.date_icon);
        if (date.length() > 0 && items != null && items.contains(date)) {
            iw.setVisibility(View.VISIBLE);
        } else {
            iw.setVisibility(View.INVISIBLE);
        }



        for (int i=0;i<holiday_list.size();i++)
        {


            String s_holi= holiday_list.get(i);
            String virathamName=virathamNamesList.get(i);


            if(dayString.get(position).equals(s_holi))
            {
                dayView.setTextColor(Color.BLACK);


              iv_event.setVisibility(View.VISIBLE);
              if(virathamName.contains("அமாவாசை")) {
                  iv_event.setImageResource(R.drawable.black_circle);
              }
              if(virathamName.contains("ௌர்ணமி")){
                  iv_event.setImageResource(R.drawable.circle);
              }
              if(virathamName.contains("சதுர்த்தி")){
                  iv_event.setImageResource(R.drawable.ganapathi);
              }
              if(virathamName.contains("சஷ்டி")){
                  iv_event.setImageResource(R.drawable.vel);
              }
              if(virathamName.contains("ஏகாதசி")){
                  iv_event.setImageResource(R.drawable.namamshadow);
              }
              if(virathamName.contains("ிரதோஷம்")){
                  iv_event.setImageResource(R.drawable.nandhi);
              }
              if(virathamName.contains("ிருத்திகை")){
                  iv_event.setImageResource(R.drawable.star);
              }
              if(virathamName.contains("மாத சிவராத்திர")){
                  iv_event.setImageResource(R.drawable.sivalingam);
              }


          //v.setBackgroundResource(R.drawable.blue);
            }
            else {
                dayView.setTextColor(Color.BLACK);
              //  iv_event.setVisibility(View.INVISIBLE);
            }

            if ((Integer.parseInt(gridvalue) > 1) && (position < firstDay)) {
                // setting offdays to white color.
                dayView.setTextColor(Color.GRAY);
                dayView.setClickable(false);
                dayView.setFocusable(false);
            } else if ((Integer.parseInt(gridvalue) < 7) && (position > 28)) {
                dayView.setTextColor(Color.GRAY);
                dayView.setClickable(false);
                dayView.setFocusable(false);
            } else {
                // setting curent month's days in blue color.
                dayView.setTextColor(Color.BLACK);
            }

        }
        for (int i=0;i<absent_list.size();i++)
        {


            String s_subha_muhurtham= holiday_list.get(i);



            if(dayString.get(position).equals(s_subha_muhurtham))
            {
                dayView.setTextColor(Color.BLACK);


              iv_muhurtha_naatkal.setVisibility(View.VISIBLE);



          //v.setBackgroundResource(R.drawable.blue);
            }
            else {
                dayView.setTextColor(Color.BLACK);
              //  iv_event.setVisibility(View.INVISIBLE);
            }

            if ((Integer.parseInt(gridvalue) > 1) && (position < firstDay)) {
                // setting offdays to white color.
                dayView.setTextColor(Color.GRAY);
                dayView.setClickable(false);
                dayView.setFocusable(false);
            } else if ((Integer.parseInt(gridvalue) < 7) && (position > 28)) {
                dayView.setTextColor(Color.GRAY);
                dayView.setClickable(false);
                dayView.setFocusable(false);
            } else {
                // setting curent month's days in blue color.
                dayView.setTextColor(Color.BLACK);
            }

        }




        dayView.setText(gridvalue);

        return v;
    }

    public View setSelected(View view) {
       if (previousView != null) {
           previousView.setBackgroundResource(R.drawable.rounded_edittext_kaavi_new);
        }
        previousView = view;

        view.setBackgroundColor(ContextCompat.getColor(mContext, R.color.nallaneramColor));
        return view;
    }


    public void refreshDays() {
        // clear items
        items.clear();
        dayString.clear();
        pmonth = (GregorianCalendar) month.clone();
        // month start day. ie; sun, mon, etc
        firstDay = month.get(GregorianCalendar.DAY_OF_WEEK);
        // finding number of weeks in current month.
        maxWeeknumber = month.getActualMaximum(GregorianCalendar.WEEK_OF_MONTH);
        // allocating maximum row number for the gridview.
        mnthlength = maxWeeknumber * 7;
        maxP = getMaxP(); // previous month maximum day 31,30....
        calMaxP = maxP - (firstDay - 1);// calendar offday starting 24,25 ...
        /**
         * Calendar instance for getting a complete gridview including the three
         * month's (previous,current,next) dates.
         */
        pmonthmaxset = (GregorianCalendar) pmonth.clone();
        /**
         * setting the start date as previous month's required date.
         */
        pmonthmaxset.set(GregorianCalendar.DAY_OF_MONTH, calMaxP + 1);

        /**
         * filling calendar gridview.
         */
        for (int n = 0; n < mnthlength; n++) {

            itemvalue = df.format(pmonthmaxset.getTime());
            pmonthmaxset.add(GregorianCalendar.DATE, 1);
            dayString.add(itemvalue);

        }
    }

    private int getMaxP() {
        int maxP;
        if (month.get(GregorianCalendar.MONTH) == month.getActualMinimum(GregorianCalendar.MONTH)) {
            pmonth.set((month.get(GregorianCalendar.YEAR) - 1),
                    month.getActualMaximum(GregorianCalendar.MONTH), 1);
        } else {
            pmonth.set(GregorianCalendar.MONTH,
                    month.get(GregorianCalendar.MONTH) - 1);
        }
        maxP = pmonth.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);

        return maxP;
    }

}
