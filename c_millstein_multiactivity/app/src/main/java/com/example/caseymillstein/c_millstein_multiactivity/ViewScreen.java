package com.example.caseymillstein.c_millstein_multiactivity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by caseymillstein on 12/5/15.
 */
public class ViewScreen extends Fragment{


    public static final String TAG = "ViewScreen.TAG";



    @Override
    public View onCreateView(LayoutInflater _inflater, ViewGroup _container, Bundle _savedInstanceState){
        View view = _inflater.inflate(R.layout.viewscreen, _container, false);




        return  view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();


    }
}
