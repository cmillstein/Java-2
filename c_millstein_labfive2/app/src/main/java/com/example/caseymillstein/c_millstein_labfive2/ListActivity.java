package com.example.caseymillstein.c_millstein_labfive2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.jar.Attributes;

public class ListActivity extends AppCompatActivity implements ListScreen.onListItemSelection{

    public static final int NEW_PEOPLE = 1;
    public static final int UPDATED_PEOPLE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        if(savedInstanceState == null){
            FragmentManager mgr = getFragmentManager();
            FragmentTransaction trs = mgr.beginTransaction();
            ListScreen fragment = ListScreen.newInstance();
            trs.replace(R.id.list_container, fragment, ListScreen.TAG);
            trs.commit();
        }



    }

    //Action Bar


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()){
            case R.id.addButton:
                //Put add stuff
                Intent formActivity = new Intent(this,FormActivity.class);
                startActivityForResult(formActivity, NEW_PEOPLE);
        }


        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == NEW_PEOPLE){
            Bundle args = data.getExtras();
            ContentValues values = new ContentValues();
            values.put(DatabaseHelper.NAME, args.get("Name").toString());
            values.put(DatabaseHelper.AGE, args.getInt("Age"));
            values.put(DatabaseHelper.SCHOOL, args.get("School").toString());
            getContentResolver().insert(NameProvider.CONTENT_URI, values);
        }else if(resultCode == RESULT_OK && requestCode == UPDATED_PEOPLE){
            //FILL IN
        }

    }

    @Override
    public void passURI(Uri uri){
        Intent detailScreen = new Intent(this, DetailsActivity.class);
        detailScreen.putExtra("URI", uri);
        startActivityForResult(detailScreen, UPDATED_PEOPLE);

    }



}
