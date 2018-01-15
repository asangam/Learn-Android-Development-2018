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
public class BeginnersFragment extends Fragment {





    public BeginnersFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Helps to create onclick event for the button in the fragments
        View view= inflater.inflate(R.layout.fragment_beginners, container, false);
        Button btnInterface=(Button) view.findViewById(R.id.btnInterface);
        Button btnInput=(Button) view.findViewById(R.id.btnInput);
        Button btnScreen=(Button) view.findViewById(R.id.btnScreen);
        Button btnNetworking=(Button) view.findViewById(R.id.btnNetworking);
        Button btnStorage=(Button) view.findViewById(R.id.btnStorage);
        Button btnDesigner=(Button) view.findViewById(R.id.btnDesigner);

        //Handlling the click event for Interface Button
        btnInterface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.udacity.com/course/android-basics-user-interface--ud834")));

            }

        });
        //Handling the click event for Input button
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.udacity.com/course/android-basics-user-input--ud836")));

            }
        });
        //Handling the click event for Screen button
        btnScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(("https://www.udacity.com/course/android-basics-multiscreen-apps--ud839"))));
            }
        });
        //Handling the click event for Networking button
        btnNetworking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.udacity.com/course/android-basics-networking--ud843")));
            }
        });
        //Handling the click event for Storage button
        btnStorage.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.udacity.com/course/android-basics-data-storage--ud845")));
        }
    });

        //Handling the click event for Designer button
    btnDesigner.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.udacity.com/course/ux-design-for-mobile-developers--ud849")));
        }
    });

        return view;
    }


    public void onResume()
    {
        super.onResume();
        ((NavActivity) getActivity())
                .setActionBarTitle("Beginners");
        //helps to set the action bar title in different fragments dynamically
    }

}
