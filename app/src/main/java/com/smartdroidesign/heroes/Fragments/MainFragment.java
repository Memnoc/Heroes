package com.smartdroidesign.heroes.Fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
 * {@link MainFragment.MainFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private Button AccBtn;
    private Button geneticBtn;
    private Button bornBtn;
    private Button choosePowBtn;

    private MainFragmentInteractionListener mListener;

    public MainFragment() {
    }

    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        AccBtn = (Button)view.findViewById(R.id.AccBtn);
        geneticBtn = (Button)view.findViewById(R.id.geneticBtn);
        bornBtn = (Button)view.findViewById(R.id.bornBtn);
        choosePowBtn = (Button)view.findViewById(R.id.showStoryBtn);

        AccBtn.setOnClickListener(this);
        geneticBtn.setOnClickListener(this);
        bornBtn.setOnClickListener(this);
        choosePowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadPickPowerScreen();
            }
        });


        choosePowBtn.setEnabled(false);
        choosePowBtn.getBackground().setAlpha(128);


        MainActivity mainActivity = (MainActivity)getActivity();


        return view;
    }
    @Override
    public void onClick(View v) {
        choosePowBtn.setEnabled(true);
        choosePowBtn.getBackground().setAlpha(255);

        Button btn = (Button)v;
        int leftDrawable = 0;
        AccBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning,0,R.drawable.item_selected_empty,0);
        geneticBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atomic,0,R.drawable.item_selected_empty,0);
        bornBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket,0,R.drawable.item_selected_empty,0);

        if(btn == AccBtn){
            leftDrawable = R.drawable.lightning;
        } else if (btn == geneticBtn){
            leftDrawable = R.drawable.atomic;
        } else if (btn == bornBtn) {
            leftDrawable = R.drawable.rocket;
        }
        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0,R.drawable.item_selected,0);


    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onMainFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainFragmentInteractionListener) {
            mListener = (MainFragmentInteractionListener) context;
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
    public interface MainFragmentInteractionListener {
        // TODO: Update argument type and name
        void onMainFragmentInteraction(Uri uri);
    }
}
