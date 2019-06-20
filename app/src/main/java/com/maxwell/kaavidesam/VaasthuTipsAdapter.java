package com.maxwell.kaavidesam;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class VaasthuTipsAdapter extends RecyclerView.Adapter<VaasthuTipsAdapter.ViewHolder>{

    List<String> vasthuTips;
    Context context;

    public VaasthuTipsAdapter(Context mcontext, List<String> vaasthuTips){
        this.context=mcontext;
        this.vasthuTips =vaasthuTips;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View listItem= layoutInflater.inflate(R.layout.layout_vaasthu_tips_row, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.tv_vasthu_content.setText("• "+vasthuTips.get(i));


    }

    @Override
    public int getItemCount() {
        return vasthuTips.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_vasthu_content;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tv_vasthu_content = (TextView) itemView.findViewById(R.id.text_vasthu_tip);
        }
    }

}
