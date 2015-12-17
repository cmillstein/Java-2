package com.example.caseymillstein.c_millstein_labfive2;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by caseymillstein on 12/16/15.
 */
public class DetailsActivity extends AppCompatActivity {


    String name;
    String age;
    String school;
    Cursor people;
    Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_container);




    }
}
