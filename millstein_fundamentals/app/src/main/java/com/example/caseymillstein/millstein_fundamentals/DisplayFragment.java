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
import java.io.Serializable;

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

    public static DisplayFragment newInstance(Weather weatherinfo){

        DisplayFragment displayFrag = new DisplayFragment();
        Bundle args = new Bundle();
        args.putString("Temp", weatherinfo.getmWeatherMain());
        args.putString("City", weatherinfo.getCity());
        args.putString("Humidity", weatherinfo.getmHumidity());
        args.putString("Description", weatherinfo.getmWeatherDescription());



        displayFrag.setArguments(args);

        return displayFrag;
    }

    @Override
    public View onCreateView(LayoutInflater _inflater, ViewGroup _container, Bundle _savedInstanceState){
        View view = _inflater.inflate(R.layout.display_fragment, _container, false);




        return  view;
    }

    public void setDetails(String _Temp, String _City, String _Humidity, String _Description){
        displayTemp.setText(_Temp);
        city.setText(_City);
        humidity.setText("Humidity: " + _Humidity);
        description.setText(_Description);



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

        Bundle args = getArguments();
        if(args != null && args.containsKey("Temp")){
//            displayTemp.setText(args.getString("Temp"));
//            city.setText(args.getString("City"));
//            humidity.setText(args.getString("Humidity"));
//            description.setText(args.getString("Description"));

            setDetails(args.getString("Temp"), args.getString("City"), args.getString("Humidity"), args.getString("Description"));


        }





    }
}
