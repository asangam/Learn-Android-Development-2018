package com.asangam.learnandroid2018;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.List;

public class NavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FloatingActionButton add,rating,twitter,git;
    Animation fabOpen,fabClose,rotateForward,rotateBackward;
    boolean isOpen=false;
    int i=0;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        //Implementing ads in the NavActivity
        MobileAds.initialize(NavActivity.this,
                "ca-app-pub-3940256099942544~3347511713");
        //Banner Ads
        AdView adView=findViewById(R.id.bannerAdView);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        //Interstitial Ads
        interstitialAd=new InterstitialAd(NavActivity.this);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.loadAd(new AdRequest.Builder().build());


        interstitialAd.setAdListener(new AdListener()
        {
            @Override
            public void onAdClosed()
            {
                //Helps to load the interstitial ad after it has been first launched and closed
                //the ad won't load next time if this code is not written
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



            // Loading the introduction fragment as the default fragment after the app
        //has been opened
        if(savedInstanceState==null)
        {
            IntroductionFragment introductionFragment=new IntroductionFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.navLayout,introductionFragment,introductionFragment.getTag())
                    .commit();
        }




        add = (FloatingActionButton) findViewById(R.id.add);
        rating = (FloatingActionButton) findViewById(R.id.rating);
        twitter= (FloatingActionButton) findViewById(R.id.twitter);
        git=(FloatingActionButton) findViewById(R.id.git);

        fabOpen= AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fabClose= AnimationUtils.loadAnimation(this,R.anim.fab_close);

        rotateForward=AnimationUtils.loadAnimation(this,R.anim.rotate_forward);
        rotateBackward=AnimationUtils.loadAnimation(this,R.anim.rotate_backward);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();

            }
        });

        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                Toast.makeText(NavActivity.this,"Please leave your honest review and rating.",Toast.LENGTH_LONG).show();

               //final String appPackageName=getPackageName();
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id="+getPackageName())));

            }
           });
        git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Source Code Hack for the hackers
               i++;
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1)
                        {
                            Toast.makeText(NavActivity.this, "Try harder, remember the hint", Toast.LENGTH_LONG).show();
                        }
                        else if (i==7)
                        {
                            Toast.makeText(NavActivity.this, "Source Code Unlocked", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://github.com/asangam/SanBrowserV1")));
                            animateFab();
                        }
                        else if(i>=7)
                        {
                            Toast.makeText(NavActivity.this, "Source Code Unlocked", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://github.com/asangam/SanBrowserV1")));
                            animateFab();
                        }
                    }
                },200);
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://twitter.com/the_asangam")));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void animateFab()
    {
        if(isOpen)
        {
            add.startAnimation(rotateBackward);

            twitter.startAnimation(fabClose);
            rating.startAnimation(fabClose);
            git.startAnimation(fabClose);
            twitter.setClickable(false);
            rating.setClickable(false);
            git.setClickable(false);
            isOpen=false;
        }

        else
        {
            add.startAnimation(rotateForward);

            twitter.startAnimation(fabOpen);
            rating.startAnimation(fabOpen);
            git.startAnimation(fabOpen);
            twitter.setClickable(true);
            rating.setClickable(true);
            git.setClickable(true);
            isOpen=true;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    //helps to set the action bar title in different fragments dynamically
    public void setActionBarTitle(String title)
    {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_intro) {
            // Handle the camera action
            IntroductionFragment introductionFragment=new IntroductionFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.navLayout,introductionFragment,introductionFragment.getTag())
                    .commit();

        } else if (id == R.id.nav_beginners) {
            BeginnersFragment beginnersFragment=new BeginnersFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.navLayout,beginnersFragment,beginnersFragment.getTag())
                    .commit();

        } else if (id == R.id.nav_intermediate) {
            IntermediateFragment intermediateFragment=new IntermediateFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.navLayout,intermediateFragment,intermediateFragment.getTag())
                    .commit();

        } else if (id == R.id.nav_youtube) {
            YoutubeFragment youtubeFragment=new YoutubeFragment();
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.navLayout,youtubeFragment,youtubeFragment.getTag())
                    .commit();

        } else if (id == R.id.nav_officialDocs) {
            DocumentationFragment documentationFragment=new DocumentationFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.navLayout,documentationFragment,documentationFragment.getTag())
                    .commit();

        } else if(id==R.id.nav_sourceCode){

            if(interstitialAd.isLoaded())
            {
                interstitialAd.show();
                SouceCodeFragment sourceCodeFragment=new SouceCodeFragment();
                FragmentManager manager=getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.navLayout,sourceCodeFragment,sourceCodeFragment.getTag())
                        .commit();
            }
            else
            {
                Toast.makeText(NavActivity.this, "Unable to load ad", Toast.LENGTH_SHORT).show();
                interstitialAd.show();
                SouceCodeFragment sourceCodeFragment=new SouceCodeFragment();
                FragmentManager manager=getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.navLayout,sourceCodeFragment,sourceCodeFragment.getTag())
                        .commit();
            }

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
