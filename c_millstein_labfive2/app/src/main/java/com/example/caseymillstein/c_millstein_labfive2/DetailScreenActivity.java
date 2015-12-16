package com.example.caseymillstein.c_millstein_labfive2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by caseymillstein on 12/15/15.
 */
public class DetailScreenActivity extends AppCompatActivity implements DetailScreen.onDeleteButtonClick {

    public static final String TAG = "ViewScreen.TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_container);

        Intent newIntent = getIntent();
        PersonInfo anotherOne = (PersonInfo)newIntent.getSerializableExtra("key");
        DetailScreen tempList = DetailScreen.newInstance(anotherOne);
        getFragmentManager().beginTransaction()
                .replace(R.id.viewContainer, tempList, DetailScreen.TAG)
                .commit();



    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == Activity.RESULT_OK && requestCode == 1){


        }
    }


    //SENDING DATA BACKWARDS ----- RETURNING INTENT FROM REQUEST
    @Override
    public void removePerson(PersonInfo personData) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("key", personData);
        setResult(RESULT_OK, returnIntent);
        finish();

    }






}
