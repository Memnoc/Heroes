package com.smartdroidesign.heroes.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//    Declaring variables in the global scope.

    private Button AccBtn;
    private Button geneticBtn;
    private Button bornBtn;
    private Button choosePowBtn;

    private MainFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
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
// This is a necessary passage, the view has to be saved into a variable, in order to be able to retrieve
// the other elements (buttons, etc.) by id. So, put the view into a variable "view".
        View view = inflater.inflate(R.layout.fragment_main, container, false);
//        Now you can register the views as always.
        AccBtn = (Button)view.findViewById(R.id.AccBtn);
        geneticBtn = (Button)view.findViewById(R.id.geneticBtn);
        bornBtn = (Button)view.findViewById(R.id.bornBtn);
        choosePowBtn = (Button)view.findViewById(R.id.choosePowBtn);

// The word "this" refers to "this class" and finds anything matching an onClickListener in the MainFragment.class.
        AccBtn.setOnClickListener(this);
        geneticBtn.setOnClickListener(this);
        bornBtn.setOnClickListener(this);


//      We want to disable the Choose Powers button as the screen loads for the first time, and until any checkbox is checked.
        choosePowBtn.setEnabled(false);
        choosePowBtn.getBackground().setAlpha(128);
        // Inflate the layout for this fragment
        return view;
    }
// To be able to use onClick(); an interface needed to be implemented in this class MainFragment.class
// implements View.OnClickListener allows us to use onClick as a generic function
// and set up listeners in the buttons
    @Override
    public void onClick(View v) {
        choosePowBtn.setEnabled(true);
        choosePowBtn.getBackground().setAlpha(255);

//        Capturing the button clicked in to a variable
        Button btn = (Button)v;
        int leftDrawable = 0;
        int rightDrawable = 0;

        if(btn == AccBtn){
            leftDrawable = R.drawable.lightning;
            rightDrawable = R.drawable.item_selected;
        } else if (btn == geneticBtn){
            leftDrawable = R.drawable.atomic;
        } else if (btn == bornBtn) {
            leftDrawable = R.drawable.rocket;
        }
//      Setting the check_mark on each button once selected (they are all disabled by default)
        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0,R.drawable.item_selected,0);

    }

    public void removeChecks(){

    }

    // TODO: Rename method, update argument and hook method into UI event
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
