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
public class DocumentationFragment extends Fragment {


    public DocumentationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_documentation, container, false);
        Button btnDocumentation=view.findViewById(R.id.btnDocumentation);

        //Handling the Documentation button click
        btnDocumentation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/guide/index.html")));
            }
        });
        return view;
    }

    public void onResume()
    {
        super.onResume();
        ((NavActivity) getActivity())
                .setActionBarTitle("Official Documentation");
        //helps to set the action bar title in different fragments dynamically
    }

}
