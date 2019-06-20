package com.maxwell.kaavidesam;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.maxwell.kaavidesam.DataBaseHelper.MyDataBaseHelper;

import java.util.ArrayList;
import java.util.List;

public class EntireWeekFragment extends Fragment {

    List<TableDetails> tableDetails=new ArrayList<>();

    TableDetails entryTableDetails;
    TableLayout tableLayout;

    private MyDataBaseHelper myDataBaseHelper;
    View view;
    TextView tv_view_today;

    ListView list_week_details;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.layout_entire_week_content,container,false);
        Toolbar toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
       TextView tv_screen_name=toolbar.findViewById(R.id.text_screen_name);
        tv_screen_name.setText("காவி தேசம் - வார காட்டி");
        myDataBaseHelper = new MyDataBaseHelper(getActivity());

        initializeViews();

        return view;
    }

    public void initializeViews(){

        tableLayout=(TableLayout)view.findViewById(R.id.table_entries);
        tv_view_today=(TextView)view.findViewById(R.id.textview_view_today);
        list_week_details=(ListView)view.findViewById(R.id.list_weeks);

        tableDetails=myDataBaseHelper.getAllEntries();

        WeekDetailsAdapter adapter=new WeekDetailsAdapter(getActivity(),tableDetails);
        list_week_details.setAdapter(adapter);


        tv_view_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                swapFragment();
            }
        });
    }

    private void swapFragment(){
        HomeFragment newGamefragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, newGamefragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
