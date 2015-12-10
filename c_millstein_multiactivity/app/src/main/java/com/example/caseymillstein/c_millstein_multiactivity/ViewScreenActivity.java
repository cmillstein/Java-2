package com.example.caseymillstein.c_millstein_multiactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Created by caseymillstein on 12/8/15.
 */
public class ViewScreenActivity extends AppCompatActivity {

    public static final String TAG = "ViewScreen.TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_container);

        Intent newIntent = getIntent();
        PersonInfo anotherOne = (PersonInfo)newIntent.getSerializableExtra("key");
        ViewScreen tempList = ViewScreen.newInstance(anotherOne);
        getFragmentManager().beginTransaction()
                .replace(R.id.viewContainer, tempList, ViewScreen.TAG)
                .commit();



    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == Activity.RESULT_OK && requestCode == 1){
            //UPDATE LIST



        }
    }




}
