package com.maxwell.kaavidesam;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class KaaviDesamContentFragment extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.layout_kaavi_desam_content,container,false);
        Toolbar toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        TextView tv_screen_name=toolbar.findViewById(R.id.text_screen_name);
        tv_screen_name.setText("காவி தேசம்");
        return view;
    }
}
