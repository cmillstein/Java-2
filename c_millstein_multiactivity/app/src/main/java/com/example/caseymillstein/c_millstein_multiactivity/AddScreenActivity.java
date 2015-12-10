package com.example.caseymillstein.c_millstein_multiactivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by caseymillstein on 12/7/15.
 */
public class AddScreenActivity extends AppCompatActivity{

    public static final int ADD_PERSON = 1026;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addscreen);


//        if (savedInstanceState == null) {
//
//            FragmentManager mgr = getFragmentManager();
//            FragmentTransaction transaction = mgr.beginTransaction();
//            AddScreen fragment = AddScreen.newInstance();
//            transaction.replace(R.id.fragment_container_one, fragment, ListActivity.TAG);
//            transaction.commit();
//        }


    }


}



