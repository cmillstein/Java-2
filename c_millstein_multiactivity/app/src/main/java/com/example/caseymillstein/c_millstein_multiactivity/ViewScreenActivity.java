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

        ViewScreen tempList = ViewScreen.newInstance();
        getFragmentManager().beginTransaction()
                .replace(R.id.viewContainer, tempList, ViewScreen.TAG)
                .commit();



    }

    @Override
    public void listClick(PersonInfo newVariable){
        Intent viewScreen = new Intent(this, ViewScreenActivity.class);
        viewScreen.putExtra("key", newVariable);
        startActivityForResult(viewScreen, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == Activity.RESULT_OK && requestCode == 1){
            //UPDATE LIST



        }
    }


    public static ViewScreen newInstance(PersonInfo returnPerson) {

        ViewScreen storeList = new ViewScreen();
        Bundle args = new Bundle();
        args.putSerializable("key", returnPerson);
        storeList.setArguments(args);
        return storeList;

    }

}
