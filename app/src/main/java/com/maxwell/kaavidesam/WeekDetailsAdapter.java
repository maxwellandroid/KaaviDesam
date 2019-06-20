package com.maxwell.kaavidesam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WeekDetailsAdapter extends BaseAdapter {

    private Context context;
    private List<TableDetails> tableDetails;

public WeekDetailsAdapter(Context context,List<TableDetails> tableDetailsList){
    this.context=context;
    this.tableDetails=tableDetailsList;

}
    @Override
    public int getCount() {
        return tableDetails.size();
    }

    @Override
    public Object getItem(int position) {
        return tableDetails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.layout_entire_week_row, parent, false);
        }

        TextView tv_day=(TextView)convertView.findViewById(R.id.textview_week_day);
        TextView tv_rahu=(TextView)convertView.findViewById(R.id.textview_rahu_time);
        TextView tv_kuligai=(TextView)convertView.findViewById(R.id.textview_kuligai_time);
        TextView tv_yamakanta=(TextView)convertView.findViewById(R.id.textview_yamakanta_time);
        TextView tv_soolam=(TextView)convertView.findViewById(R.id.textview_vaarasoolai_content);
        TextView tv_parigaram=(TextView)convertView.findViewById(R.id.textview_parigaram_content);
        TextView tv_nallaneram=(TextView)convertView.findViewById(R.id.textview_nalla_neram);


        if(tableDetails.get(position).getWeek().matches("Sunday")){
            tv_day.setText("ஞாயிறு");
        } if(tableDetails.get(position).getWeek().matches("Monday")){
            tv_day.setText("திங்கள்");
        } if(tableDetails.get(position).getWeek().matches("Tuesday")){
            tv_day.setText("செவ்வாய்");
        } if(tableDetails.get(position).getWeek().matches("Wednesday")){
            tv_day.setText("புதன்");
        } if(tableDetails.get(position).getWeek().matches("Thursday")){
            tv_day.setText("வியாழன்");
        } if(tableDetails.get(position).getWeek().matches("Friday")){
            tv_day.setText("வெள்ளி");
        } if(tableDetails.get(position).getWeek().matches("Saturday")){
            tv_day.setText("சனிக்கிழமை");
        }

        tv_rahu.setText(tableDetails.get(position).getRahukalam());
        tv_nallaneram.setText(tableDetails.get(position).getNallaneram());
        tv_kuligai.setText(tableDetails.get(position).getKuligai());
        tv_yamakanta.setText(tableDetails.get(position).getYamakantam());
        tv_soolam.setText(tableDetails.get(position).getSoolai());
        tv_parigaram.setText(tableDetails.get(position).getParigaram());




        return convertView;
    }
}
