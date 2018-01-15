package com.asangam.learnandroid2018;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SouceCodeFragment extends Fragment {


    public SouceCodeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_souce_code, container, false);
    }
    public void onResume()
    {
        super.onResume();
        ((NavActivity) getActivity())
                .setActionBarTitle("Source Code");
        //helps to set the action bar title in different fragments dynamically
    }
}
