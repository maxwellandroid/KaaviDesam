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

import java.util.List;


public class KarinaalAdapter extends RecyclerView.Adapter<KarinaalAdapter.ViewHolder>{

    List<String> karinaalDates;
    Context context;

    public KarinaalAdapter(Context mcontext, List<String> karinaalDates){
        this.context=mcontext;
        this.karinaalDates =karinaalDates;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View listItem= layoutInflater.inflate(R.layout.layout_karinall_row, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.tv_date.setText(karinaalDates.get(i));


    }

    @Override
    public int getItemCount() {
        return karinaalDates.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView  tv_date;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tv_date = (TextView) itemView.findViewById(R.id.text_date);
        }
    }

}
