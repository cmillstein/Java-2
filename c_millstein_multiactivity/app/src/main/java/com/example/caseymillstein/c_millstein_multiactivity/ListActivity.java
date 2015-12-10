package com.example.caseymillstein.c_millstein_multiactivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

/**
 * Created by caseymillstein on 12/7/15.
 */
public class ListActivity  extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listscreen);





//        if(savedInstanceState == null){
//
//            FragmentManager mgr = getFragmentManager();
//            FragmentTransaction transaction  = mgr.beginTransaction();
//            ListScreen fragment = ListScreen.newInstance();
//            transaction.replace(R.id.listContainer, fragment, ListScreen.TAG);
//            transaction.commit();
//        }




    }

}
