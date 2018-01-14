package com.smartdroidesign.heroes.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.smartdroidesign.heroes.Activities.MainActivity;
import com.smartdroidesign.heroes.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowerFragment.PickPowerInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickPowerFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private Button turtleBtn;
    private Button lightBtn;
    private Button flightBtn;
    private Button webBtn;
    private Button laserBtn;
    private Button strenghtBtn;
    private Button showStoryBtn;


    private PickPowerInteractionListener mListener;

    public PickPowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickPowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickPowerFragment newInstance(String param1, String param2) {
        PickPowerFragment fragment = new PickPowerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pick_power, container, false);
        turtleBtn = view.findViewById(R.id.turtleBtn);
        lightBtn = view.findViewById(R.id.lightBtn);
        flightBtn = view.findViewById(R.id.flightBtn);
        webBtn = view.findViewById(R.id.webButton);
        laserBtn = view.findViewById(R.id.primPowerBtn);
        strenghtBtn = view.findViewById(R.id.secondPowerBtn);
        showStoryBtn = view.findViewById(R.id.showStoryBtn);



        turtleBtn.setOnClickListener(this);
        lightBtn.setOnClickListener(this);
        flightBtn.setOnClickListener(this);
        webBtn.setOnClickListener(this);
        laserBtn.setOnClickListener(this);
        strenghtBtn.setOnClickListener(this);
        showStoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadStoryFragmentScreen();
            }
        });


        showStoryBtn.setEnabled(false);
        showStoryBtn.getBackground().setAlpha(128);
        return view;
    }

    @Override
    public void onClick(View v) {
        showStoryBtn.setEnabled(true);
        showStoryBtn.getBackground().setAlpha(255);



        int leftDrawable = 0;
        turtleBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtle_power,0,R.drawable.item_selected_empty,0);
        lightBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.thors_hammer,0,R.drawable.item_selected_empty,0);
        flightBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_man_crest,0,R.drawable.item_selected_empty,0);
        webBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spider_web,0,R.drawable.item_selected_empty,0);
        laserBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laser_vision,0,R.drawable.item_selected_empty,0);
        strenghtBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_strength,0,R.drawable.item_selected_empty,0);

        Button btn = (Button)v;
        MainActivity mainActivity = (MainActivity)getActivity();
        String turtleBio = getResources().getString(R.string.turtle_bio_src);
        String thorBio = getResources().getString(R.string.thor_bio_src);
        String supermanBio = getResources().getString(R.string.superman_bio_src);
        String spidermanBio = getResources().getString(R.string.spiderman_bio_src);
        String cyclopeBio = getResources().getString(R.string.cyclope_bio_src);
        String wolverineBio = getResources().getString(R.string.wolverine_bio_src);


        if(btn == turtleBtn){
            leftDrawable = R.drawable.turtle_power;
            mainActivity.HERO_NAME = "Ninja Turtles";
            mainActivity.HERO_BIO = turtleBio;
            mainActivity.HERO_LOGO = R.drawable.turtle_power;
            mainActivity.PRIMARY_POWER = "Turtle Power";
            mainActivity.PRIM_ICON = R.drawable.turtle_power;
            mainActivity.SECON_ICON = R.drawable.super_strength;
            mainActivity.SECONDARY_POWER = "Super Strength";
        } else if (btn == lightBtn){
            leftDrawable = R.drawable.thors_hammer;
            mainActivity.HERO_NAME = "Thor";
            mainActivity.HERO_BIO = thorBio;
            mainActivity.HERO_LOGO = R.drawable.thors_hammer;
            mainActivity.PRIMARY_POWER = "Big Hammer";
            mainActivity.SECONDARY_POWER = "Super Strength";
            mainActivity.PRIM_ICON = R.drawable.thors_hammer;
            mainActivity.SECON_ICON = R.drawable.super_strength;
        } else if (btn == flightBtn) {
            leftDrawable = R.drawable.super_man_crest;
            mainActivity.HERO_NAME = "Superman";
            mainActivity.HERO_BIO = supermanBio;
            mainActivity.HERO_LOGO = R.drawable.super_man_crest;
            mainActivity.PRIMARY_POWER = "Flight";
            mainActivity.SECONDARY_POWER = "Super Strength";
            mainActivity.PRIM_ICON = R.drawable.super_man_crest;
            mainActivity.SECON_ICON = R.drawable.super_strength;
        } else if (btn == webBtn) {
            leftDrawable = R.drawable.spider_web;
            mainActivity.HERO_LOGO = R.drawable.spider_web;
            mainActivity.HERO_NAME = "Spiderman";
            mainActivity.HERO_BIO = spidermanBio;
            mainActivity.PRIMARY_POWER = "Web slinging";
            mainActivity.SECONDARY_POWER = "Super agility";
            mainActivity.PRIM_ICON = R.drawable.spider_web;
            mainActivity.SECON_ICON = R.drawable.super_strength;
        } else if (btn == laserBtn) {
            leftDrawable = R.drawable.laser_vision;
            mainActivity.HERO_LOGO = R.drawable.laser_vision;
            mainActivity.HERO_NAME = "Cyclope";
            mainActivity.HERO_BIO = cyclopeBio;
            mainActivity.PRIMARY_POWER = "Laser vision";
            mainActivity.SECONDARY_POWER = "Super Smart";
            mainActivity.PRIM_ICON = R.drawable.laser_vision;
            mainActivity.SECON_ICON = R.drawable.super_strength;
        } else if (btn == strenghtBtn){
            leftDrawable = R.drawable.super_strength;
            mainActivity.HERO_LOGO = R.drawable.super_strength;
            mainActivity.HERO_NAME = "Wolverine";
            mainActivity.HERO_BIO = wolverineBio;
            mainActivity.PRIMARY_POWER = "Adamantium skeleton";
            mainActivity.SECONDARY_POWER = "Super Strength";
            mainActivity.PRIM_ICON = R.drawable.super_strength;
            mainActivity.SECON_ICON = R.drawable.super_strength;
        }
        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0,R.drawable.item_selected,0);

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.PickPowerInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickPowerInteractionListener) {
            mListener = (PickPowerInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface PickPowerInteractionListener {
        // TODO: Update argument type and name
        void PickPowerInteraction(Uri uri);
    }


}
