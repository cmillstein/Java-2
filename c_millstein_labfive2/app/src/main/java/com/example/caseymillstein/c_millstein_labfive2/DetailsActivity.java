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
import java.util.List;

/**
 * Created by caseymillstein on 12/16/15.
 */
public class DetailsActivity extends AppCompatActivity implements DetailsScreen.actionBarClick {


    private static final String TAG = "DetailsActivity.TAG";
    String nameReal;
    String ageReal;
    String schoolReal;
    String id;
    Cursor people;
    Uri uri;
    private static DetailsScreen detailScreen;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailscreen);

        Intent retrieveIntent = getIntent();
        uri = retrieveIntent.getParcelableExtra("URI");
        id = DatabaseHelper.STUDENT_ID + "=" + uri.getLastPathSegment();
        people = getContentResolver().query(uri, DatabaseHelper.ALL_COLUMNS, id, null, null);

        if(people != null){
            people.moveToFirst();
        }


        //Setting Info To Text Views

        nameReal = people.getString(people.getColumnIndex(DatabaseHelper.NAME));
        ageReal = people.getString(people.getColumnIndex(DatabaseHelper.AGE));
        schoolReal = people.getString(people.getColumnIndex(DatabaseHelper.SCHOOL));
        infoRecieve(nameReal, ageReal, schoolReal);



//        nameReal = (EditText) findViewById(R.id.nameReal);
//        ageReal = (EditText) findViewById(R.id.ageReal);
//        schoolReal = (EditText) findViewById(R.id.schoolReal);
//
//        Intent newIntent = getIntent();
//        Uri newUri = newIntent.getParcelableExtra("URI");
//        Cursor c = getContentResolver().query(newUri, DatabaseHelper.ALL_COLUMNS, null, null, null);
//        c.moveToNext();
//
//        nameReal.setText(c.getString(c.getColumnIndex(DatabaseHelper.NAME)));
//        Log.e(TAG, "Name: " + c.getString(c.getColumnIndex(DatabaseHelper.NAME)));
//        ageReal.setText(String.format("%d", c.getInt(c.getColumnIndex(DatabaseHelper.AGE))));
//        Log.e(TAG, "Age: " + c.getInt(c.getColumnIndex(DatabaseHelper.AGE)));
//        schoolReal.setText(c.getString(c.getColumnIndex(DatabaseHelper.SCHOOL)));




    }

    //Action Bar Detail Info
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.details, menu);

        return true;
    }


    //Update Method Intent
    @Override
    public void update(String name, String age, String school) {

        int ageInt = Integer.parseInt(age);

        Intent newActivity = new Intent(this, ListActivity.class);
        newActivity.putExtra("SWITCH", "update");
        newActivity.putExtra("name", name);
        newActivity.putExtra("age", ageInt);
        newActivity.putExtra("school", school);
        newActivity.putExtra("ID", id);
        setResult(RESULT_OK, newActivity);
        finish();



    }

    //Delete Method INtent
    @Override
    public void delete() {

        Intent deleteIntent = new Intent(this, ListActivity.class);
        deleteIntent.putExtra("SWITCH", "delete");
        deleteIntent.putExtra("ID", id);
        setResult(RESULT_OK, deleteIntent);
        finish();
    }


    //Receiving info from detailscreen
    void infoRecieve(String name, String age, String school){
        detailScreen = DetailsScreen.newInstance(name, age, school);
        getFragmentManager().beginTransaction().replace(R.id.detail_container, detailScreen, DetailsScreen.TAG).commit();

    }


}
