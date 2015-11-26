package com.example.caseymillstein.millstein_fundamentals;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

/**
 * Created by caseymillstein on 11/25/15.
 */
public class WeatherListFragment extends ListFragment {

    public static final String TAG = "WeatherListFragment.TAG";
    public static WeatherListFragment newInstance() {
        WeatherListFragment frag = new WeatherListFragment();
        return frag;
    }

    public WeatherListFragment() {
        super();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}
