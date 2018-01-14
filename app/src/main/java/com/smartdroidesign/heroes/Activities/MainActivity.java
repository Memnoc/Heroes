package com.smartdroidesign.heroes.Activities;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.smartdroidesign.heroes.Fragments.MainFragment;
import com.smartdroidesign.heroes.Fragments.PickPowerFragment;
import com.smartdroidesign.heroes.Fragments.StoryFragment;
import com.smartdroidesign.heroes.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener, PickPowerFragment.PickPowerInteractionListener, StoryFragment.StoryFragmentInteractionListener {

    public String HERO_NAME;
    public String HERO_BIO;
    public int HERO_LOGO;
    public int PRIM_ICON;
    public int SECON_ICON;
    public String PRIMARY_POWER;
    public String SECONDARY_POWER;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        if(fragment == null){
            fragment = new MainFragment();
            manager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
    public void loadPickPowerScreen(){
        PickPowerFragment pickPowerFragment = new PickPowerFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickPowerFragment).addToBackStack(null).commit();
        //getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, pickPowerFragment).commit();

    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void PickPowerInteraction(Uri uri) {

    }



    public void loadStoryFragmentScreen() {

        StoryFragment storyFragment = new StoryFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, storyFragment).addToBackStack(null).commit();
    }

    @Override
    public void StoryFragmentInteraction(Uri uri) {

    }

    public void loadMainScreen() {
        MainFragment mainFragment = new MainFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mainFragment).addToBackStack(null).commit();
    }

}

