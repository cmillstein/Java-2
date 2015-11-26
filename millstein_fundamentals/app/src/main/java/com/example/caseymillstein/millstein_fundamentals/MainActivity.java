package com.example.caseymillstein.millstein_fundamentals;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.app.Fragment;

public class MainActivity extends AppCompatActivity {


    private EditText zipCode;
    private Button searchButton;
    private ListView zipCodeSearch;


    public static final String TAG = "MainActivity.TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zipCode = (EditText) findViewById(R.id.zipCode);
        searchButton = (Button) findViewById(R.id.searchButton);
        zipCodeSearch = (ListView) findViewById(R.id.zipCodeList);

        if(savedInstanceState == null){
            WeatherListFragment frag = WeatherListFragment.newInstance();

            getFragmentManager().beginTransaction().replace(R.id.fragment_container, frag, WeatherListFragment.TAG).commit();

        }



    }



}
