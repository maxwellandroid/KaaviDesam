package com.maxwell.kaavidesam;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class GovtHolidaysAdapter extends RecyclerView.Adapter<GovtHolidaysAdapter.ViewHolder>{

    List<SubaMuhurthaNatkalModel> subaMuhurthaNatkalModelList;
    Context context;

    public GovtHolidaysAdapter(Context mcontext, List<SubaMuhurthaNatkalModel> subaMuhurthaNatkalModelList){
        this.context=mcontext;
        this.subaMuhurthaNatkalModelList =subaMuhurthaNatkalModelList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View listItem= layoutInflater.inflate(R.layout.layout_govt_holidays_row, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final SubaMuhurthaNatkalModel teamModel= subaMuhurthaNatkalModelList.get(i);

      /*  if(!teamModel.getFromTime().isEmpty()&&teamModel.getFromTime()!=null&&!teamModel.getToTime().isEmpty()&&teamModel.getToTime()!=null){*/
            viewHolder.tv_date.setText(teamModel.getDate());
       // }
         /*else {
            viewHolder.tv_date.setText(teamModel.getDate());
        }*/
        viewHolder.tv_information.setText(teamModel.getInformation());
/*
        Glide.with(context)
                .load(teamModel.getTeamImage()) // image url
                // .placeholder(R.drawable.placeholder) // any placeholder to load at start
                //.error(R.drawable.imagenotfound)  // any image in case of error
                // .override(200, 200); // resizing
                // .apply(new RequestOptions().placeholder(R.drawable.loading))
                .into(viewHolder.iv_player);
*/
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        Date dt= null;
        try {
            dt = df.parse(teamModel.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat format2=new SimpleDateFormat("EEEE");
        String  selectedWeek =format2.format(dt);

        if(selectedWeek.matches("Sunday")){
            viewHolder.tv_day.setText("ஞாயிறு");

        } if(selectedWeek.matches("Monday")){
            viewHolder.tv_day.setText("திங்கள்");

        } if(selectedWeek.matches("Tuesday")){
            viewHolder.tv_day.setText("செவ்வாய்");
            // tv_day.setText("செவ்வாய்");
        } if(selectedWeek.matches("Wednesday")){
            viewHolder.tv_day.setText("புதன்");

        } if(selectedWeek.matches("Thursday")){
            viewHolder.tv_day.setText("வியாழன்");

        } if(selectedWeek.matches("Friday")){
            viewHolder.tv_day.setText("வெள்ளி");

        } if(selectedWeek.matches("Saturday")){
            viewHolder.tv_day.setText("சனிக்கிழமை");

        }


    }

    @Override
    public int getItemCount() {
        return subaMuhurthaNatkalModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView tv_month, tv_date, tv_tamil_month, tv_tamil_date, tv_day,tv_information;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.linearLayout=(LinearLayout)itemView.findViewById(R.id.layout_contained_view);
            this.tv_date = (TextView) itemView.findViewById(R.id.text_date);
            this.tv_day = (TextView) itemView.findViewById(R.id.text_week_day);
            this.tv_information = (TextView) itemView.findViewById(R.id.text_information);

        }
    }

}
