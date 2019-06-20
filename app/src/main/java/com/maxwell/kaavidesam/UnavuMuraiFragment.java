package com.maxwell.kaavidesam;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UnavuMuraiFragment extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    List<String> unavuMuraiList=new ArrayList<>();
    String currentDate;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.layout_vaasthu_tips, container, false);
        Toolbar toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        TextView tv_screen_name=toolbar.findViewById(R.id.text_screen_name);
        tv_screen_name.setText("உணவு முறை");
        recyclerView =(RecyclerView)view.findViewById(R.id.recyclerViewVaasthuKuripugal);
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c);
        currentDate=formattedDate;
        dailyDetails();
        return view;
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
                                    if(dailyObject.has("Unavu Murai")){
                                        JSONArray unavuMurai=dailyObject.getJSONArray("Unavu Murai");
                                        unavuMuraiList =new ArrayList<>();
                                        for(int i=0;i<unavuMurai.length();i++){
                                            JSONObject unavuMuraiJSONObject=unavuMurai.getJSONObject(i);
                                            unavuMuraiList.add(unavuMuraiJSONObject.getString("days")+" days - "+unavuMuraiJSONObject.getString("information"));

                                        }
                                        mAdapter=new VaasthuTipsAdapter(getContext(), unavuMuraiList);
                                        LinearLayoutManager horizontalLayoutManager1 = new LinearLayoutManager(getContext());
                                        recyclerView.setLayoutManager(horizontalLayoutManager1);
                                        recyclerView.setAdapter(mAdapter);
                                    }

                                }catch (JSONException e) {
                                    e.printStackTrace();

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
