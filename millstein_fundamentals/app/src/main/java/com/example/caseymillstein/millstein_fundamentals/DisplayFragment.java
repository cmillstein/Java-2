package com.example.caseymillstein.millstein_fundamentals;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by caseymillstein on 11/28/15.
 */
public class DisplayFragment extends Fragment{


    TextView displayTemp;
    TextView city;
    TextView humidity;
    TextView description;
    ListView zipCodeList;

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

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();

        displayTemp = (TextView) view.findViewById(R.id.displayTemp);
        city = (TextView) view.findViewById(R.id.city);
        humidity = (TextView) view.findViewById(R.id.humidity);
        description = (TextView) view.findViewById(R.id.description);
        zipCodeList = (ListView) view.findViewById(R.id.zipCodeList);




    }
}
