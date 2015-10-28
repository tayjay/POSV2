package com.example.rtas.posv2;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ButtonsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ButtonsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ButtonsFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //private Activity activity;
    private LinearLayout layout;
    private Button button1;
    private Button button2;
    private Activity activity;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ButtonsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ButtonsFragment newInstance(String param1, String param2) {
        ButtonsFragment fragment = new ButtonsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ButtonsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity = getActivity();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
        System.out.println();

        if(layout!=null)
        {

            Button button = (Button) layout.findViewById(R.id.apple);
            button.setOnClickListener(handleClick);
        }

        Button apple;
        Button banana;

        apple = (Button) activity.findViewById(R.id.apple);

        //System.out.println(apple);
        //apple.setOnClickListener(handleClick);
        /*
        getActivity().findViewById(R.id.apple).setOnClickListener(handleClick);
        getActivity().findViewById(R.id.banana).setOnClickListener(handleClick);
        getActivity().findViewById(R.id.battery).setOnClickListener(handleClick);
        getActivity().findViewById(R.id.cheese).setOnClickListener(handleClick);
        getActivity().findViewById(R.id.strawberry).setOnClickListener(handleClick);
        getActivity().findViewById(R.id.chicken).setOnClickListener(handleClick);
        getActivity().findViewById(R.id.milk).setOnClickListener(handleClick);
        getActivity().findViewById(R.id.beef).setOnClickListener(handleClick);
        getActivity().findViewById(R.id.dress).setOnClickListener(handleClick);
        getActivity().findViewById(R.id.shoes).setOnClickListener(handleClick);
        getActivity().findViewById(R.id.lego).setOnClickListener(handleClick);
        getActivity().findViewById(R.id.book).setOnClickListener(handleClick);
        getActivity().findViewById(R.id.lotion).setOnClickListener(handleClick);
        getActivity().findViewById(R.id.tshirt).setOnClickListener(handleClick);
        getActivity().findViewById(R.id.pants).setOnClickListener(handleClick);
        getActivity().findViewById(R.id.socks).setOnClickListener(handleClick);
        */

    }

    public View.OnClickListener handleClick = new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            Button btn = (Button)arg0;
            switch (arg0.getId()) {
                case R.id.apple:
                    mListener.onFragmentInteraction(arg0.getId());
            }

            int id = btn.getId();
            if (mListener != null) {
                mListener.onFragmentInteraction(id);

            }


        }

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_buttons,container,false);
        //Button apple = (Button) container.findViewById(R.id.apple);
        //apple.setOnClickListener(handleClick);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buttons, container, false);

    }

    /*
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(int id) {
        if (mListener != null) {
            mListener.onFragmentInteraction(id);
        }
    }
    */
    /*
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);


        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    */

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


        if(context instanceof Activity)
        {
            activity = (Activity) context;
        }
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button)v;
        switch (v.getId()) {
            case R.id.apple:
                mListener.onFragmentInteraction(v.getId());
        }

        int id = btn.getId();
        if (mListener != null) {
            mListener.onFragmentInteraction(id);

        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(int id);
    }

}
