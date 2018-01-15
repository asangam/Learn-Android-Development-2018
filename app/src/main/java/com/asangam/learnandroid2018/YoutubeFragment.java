package com.asangam.learnandroid2018;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class YoutubeFragment extends Fragment {


    public YoutubeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_youtube, container, false);
        //declaring variables for all the ImageButtons
        ImageButton btnImgPrabeesh=view.findViewById(R.id.btnImgPrabeesh);
        ImageButton btnImgSaokosal=view.findViewById(R.id.btnImgSaokosal);
        ImageButton btnImgTvac=view.findViewById(R.id.btnImgTvac);
        ImageButton btnImgAppeteria=view.findViewById(R.id.appeteria);
        ImageButton btnImgBoston=view.findViewById(R.id.thenewboston);
        final ImageButton btnImgDelaroy=view.findViewById(R.id.delaroy);
        ImageButton btnImgAws=view.findViewById(R.id.aws);
        ImageButton btnImgEdmt=view.findViewById(R.id.edmt);
        ImageButton btnImgTonikamiTv=view.findViewById(R.id.tonikami);
        ImageButton btnImgGoogleDev=view.findViewById(R.id.google_dev);
        ImageButton btnImgTelusko=view.findViewById(R.id.telesko);
        ImageButton btnImgAndroidDev=view.findViewById(R.id.android_dev);
        ImageButton btnImgProgrammingGuru=view.findViewById(R.id.btnImgProgrammingGuru);

        //Handling the Image Button Click for Prabeesh
        btnImgPrabeesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/TICOONTECHNOLOGIES")));
            }
        });

        //Handling the Image Button click for Saokosal
        btnImgSaokosal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/user/oumsaokosal")));
            }
        });

        //Handling the Image Button click for Tvac
        btnImgTvac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/user/akshayejh")));
            }
        });

        //Handling the Image Button click for Appeteria Technologies
        btnImgAppeteria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/channel/UCDIqyt5j8HOq8pGCkmkJGgw?&ab_channel=AppeteriaTechnologies")));
            }
        });

        //Handling the Image Button click for TheNewBoston
        btnImgBoston.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/user/thenewboston")));
            }
        });

        //Handling the Image Button Click for Delaroy Studio
        btnImgDelaroy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/channel/UCZ00VgbuL3218mXA0_drptg")));
            }
        });

        //Handling the Image Button click for Aws
        btnImgAws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/channel/UCoQp_Duwqh0JWEZrg4DT2Ug")));
            }
        });

        //Handling Image Button click for Edmt Dev
        btnImgEdmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/user/eddydn71")));
            }
        });

        //Handling the Image Button click for Tonikami Tv
        btnImgTonikamiTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/channel/UCh1B37nnAfZuj9IWH-T5KUw?&ab_channel=TonikamiTV")));
            }
        });

        //Handling the Image Button click for Google Developer
        btnImgGoogleDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/user/GoogleDevelopers")));
            }
        });

        //Handling the Image Button click for Telusko Learning
        btnImgTelusko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/user/javaboynavin")));
            }
        });

        //Handling the Image Button click for Android Developers
        btnImgAndroidDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/user/androiddevelopers")));
            }
        });

        //Handling the Image Button click for  Programming Guru
        btnImgProgrammingGuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/channel/UCuLZgngZF5HlAr4B_Ud_Vew")));
            }
        });


        return view;
    }

    public void onResume()
    {
        super.onResume();
        ((NavActivity) getActivity())
                .setActionBarTitle("YouTube Channels");
        //helps to set the action bar title in different fragments dynamically
    }

}
