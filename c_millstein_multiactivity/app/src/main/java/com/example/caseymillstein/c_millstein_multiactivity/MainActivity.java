package com.example.caseymillstein.c_millstein_multiactivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AddScreen.onButtonClickListener {

    ArrayList<PersonInfo> personInfoList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public void savePersonData(String _name, String _age, String _school) {
        //PASS USER DATA TO LISTSCREEN
        PersonInfo tempBundle = new PersonInfo(_name, _age, _school);


        //LOAD CURRENT LIST
        try{
            FileInputStream fis = openFileInput("File.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            personInfoList = (ArrayList<PersonInfo>)ois.readObject();
            ois.close();

        }catch(Exception e){


        }

        personInfoList.add(tempBundle);


        //SAVE UPDATED LIST
        try{
            FileOutputStream fos = openFileOutput("File.txt", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(personInfoList);
            oos.close();

        }catch(Exception e){


        }




        //CREATE TOAST TO TELL USER THAT DATA PASSED
        Toast.makeText(this, "User Added!", Toast.LENGTH_SHORT).show();


    }
}
