package com.example.caseymillstein.millstein_fundamentals;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by caseymillstein on 11/25/15.
 */
public class WeatherListFragment extends Fragment {

    public static final String TAG = "WeatherListFragment.TAG";

   public static WeatherListFragment newInstance(){

       WeatherListFragment weatherFrag = new WeatherListFragment();
       return weatherFrag;
   }

 @Override
    public View onCreateView(LayoutInflater _inflater, ViewGroup _container, Bundle _savedInstanceState){
     View view = _inflater.inflate(R.layout.weather_list, _container, false);
     return  view;
 }
}
