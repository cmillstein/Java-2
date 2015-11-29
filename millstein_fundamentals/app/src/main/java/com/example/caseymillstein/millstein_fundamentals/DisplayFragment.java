package com.example.caseymillstein.millstein_fundamentals;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by caseymillstein on 11/28/15.
 */
public class DisplayFragment extends Fragment{

    public static final String TAG = "DisplayFragment.TAG";

    public static DisplayFragment newInstance(){

        DisplayFragment displayFrag = new DisplayFragment();
        return displayFrag;
    }

    @Override
    public View onCreateView(LayoutInflater _inflater, ViewGroup _container, Bundle _savedInstanceState){
        View view = _inflater.inflate(R.layout.display_fragment, _container, false);
        return  view;
    }


}
