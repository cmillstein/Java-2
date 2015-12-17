package com.example.caseymillstein.c_millstein_labfive2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URI;

/**
 * Created by caseymillstein on 12/16/15.
 */
public class DetailsActivity extends AppCompatActivity {


    private static final String TAG = "DetailsActivity.TAG";
    EditText nameReal;
    EditText ageReal;
    EditText schoolReal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailscreen);

        if(savedInstanceState == null){
            FragmentManager mgr = getFragmentManager();
            FragmentTransaction trs = mgr.beginTransaction();
            DetailsScreen fragment = DetailsScreen.newInstance();
            trs.replace(R.id.detail_container, fragment, DetailsScreen.TAG);
            trs.commit();
        }


        nameReal = (EditText) findViewById(R.id.nameReal);
        ageReal = (EditText) findViewById(R.id.ageReal);
        schoolReal = (EditText) findViewById(R.id.schoolReal);

        Intent newIntent = getIntent();
        Uri newUri = newIntent.getParcelableExtra("URI");
        Cursor c = getContentResolver().query(newUri, DatabaseHelper.ALL_COLUMNS, null, null, null);
        c.moveToNext();

        nameReal.setText(c.getString(c.getColumnIndex(DatabaseHelper.NAME)));
        Log.e(TAG, "Name: " + c.getString(c.getColumnIndex(DatabaseHelper.NAME)));
        ageReal.setText(String.format("%d", c.getInt(c.getColumnIndex(DatabaseHelper.AGE))));
        Log.e(TAG, "Age: " + c.getInt(c.getColumnIndex(DatabaseHelper.AGE)));
        schoolReal.setText(c.getString(c.getColumnIndex(DatabaseHelper.SCHOOL)));




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.details, menu);

        return true;
    }


}
