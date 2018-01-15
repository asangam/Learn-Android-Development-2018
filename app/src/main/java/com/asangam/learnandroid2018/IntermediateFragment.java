package com.asangam.learnandroid2018;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntermediateFragment extends Fragment {


    public IntermediateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_intermediate, container, false);
        Button btnDevelopingAndroid=view.findViewById(R.id.btnDevelopingAndroid);
        Button btnFirebase=view.findViewById(R.id.btnFirebase);
        Button btnLocation=view.findViewById(R.id.btnLocation);
        Button btnAnalytics=view.findViewById(R.id.btnAnalytics);
        Button btnMonetize=view.findViewById(R.id.btnMonetize);
        Button btnMaps=view.findViewById(R.id.btnMaps);

        //Handling the click event for Developing Android Apps Button
        btnDevelopingAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.udacity.com/course/new-android-fundamentals--ud851")));
            }
        });

        //Handling Firebase button click event
        btnFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.udacity.com/course/firebase-in-a-weekend-by-google-android--ud0352")));
            }
        });

        //Handling Google Location Services button click event
        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.udacity.com/course/google-location-services-on-android--ud876-1")));
            }
        });

        //Handling Google Analytics  button click event
        btnAnalytics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.udacity.com/course/google-analytics-for-android--ud876-2")));
            }
        });

        //Handling the Android App monetization button click event
        btnMonetize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.udacity.com/course/monetize-your-android-app-with-ads--ud876-3")));

            }
        });

        //Handling the Google Maps Integration button clicks
        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.udacity.com/course/add-google-maps-to-your-android-app--ud876-4")));
            }
        });

        return view;
    }

    public void onResume()
    {
        super.onResume();
        ((NavActivity) getActivity())
                .setActionBarTitle("Intermediate");
        //helps to set the action bar title in different fragments dynamically
    }


}
