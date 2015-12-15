package com.example.caseymillstein.c_millstein_labfive;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by caseymillstein on 12/13/15.
 */
public class FormScreen extends AppCompatActivity{


    private onButtonClickListener buttonClick;
   EditText nameHolder;
   EditText ageHolder;
   EditText schoolHolder;
   Button saveButton;

    public interface onButtonClickListener{
        public void savePersonData(String _name, String _age, String _school);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_screen);


        nameHolder = (EditText) findViewById(R.id.nameHolder);
        ageHolder = (EditText) findViewById(R.id.ageHolder);
        schoolHolder = (EditText) findViewById(R.id.schoolHolder);
        saveButton = (Button) findViewById(R.id.saveButton);

        nameHolder.setHint("Enter Name");
        ageHolder.setHint("Enter Age");
        schoolHolder.setHint("Enter School");


        saveButton.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {



            }
        });




    }










}
