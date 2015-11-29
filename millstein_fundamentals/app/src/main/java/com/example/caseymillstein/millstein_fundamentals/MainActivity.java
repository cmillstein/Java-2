package com.example.caseymillstein.millstein_fundamentals;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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
}
