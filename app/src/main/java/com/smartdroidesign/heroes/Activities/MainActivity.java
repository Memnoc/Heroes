package com.smartdroidesign.heroes.Activities;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.smartdroidesign.heroes.Fragments.MainFragment;
import com.smartdroidesign.heroes.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Calling FragmentManager and registering fragment_container
//        import android.support.v4.app.Fragment; This is the support library for fragments
        FragmentManager manager = getSupportFragmentManager();
//        Creating the Fragment. fragment_container is the id defined in ActivityMain.xml
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

//        Building the logic to get the fragment loaded onto the screen.
//        MainFragment it's the child class of Fragment, and this is how it gets assigned fragment = new MainFragment();
        if(fragment == null){
            fragment = new MainFragment();
            manager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
//  This is the method tha has to be implemented in any activity that wants to call a fragment. Refer to MainFragment.java
//   MainFragmentInteractionListener(); it's the interface, onMainFragmentInteraction(); is the method called inside the interface, and here.
    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }
}

