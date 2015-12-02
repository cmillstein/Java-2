package com.example.caseymillstein.millstein_fundamentals;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity.TAG";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager weatherManager = getFragmentManager();
        FragmentTransaction weatherTrans = weatherManager.beginTransaction();

        WeatherListFragment weatherFrag = WeatherListFragment.newInstance();
        weatherTrans.replace(R.id.fragment_container_one, weatherFrag, WeatherListFragment.TAG);
        weatherTrans.commit();


        FragmentManager displayManager = getFragmentManager();
        FragmentTransaction displayTrans = displayManager.beginTransaction();

        DisplayFragment displayFrag = DisplayFragment.newInstance();
        displayTrans.replace(R.id.fragment_container_two, displayFrag, DisplayFragment.TAG);
        displayTrans.commit();


    }

    //CONNECTION
    protected boolean isOnline() {

        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = manager.getActiveNetworkInfo();
        if(network != null && network.isConnectedOrConnecting()){
            return true;
        } else {
            return false;
        }

    }

}