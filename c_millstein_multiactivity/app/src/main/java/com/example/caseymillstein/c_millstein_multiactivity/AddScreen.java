package com.example.caseymillstein.c_millstein_multiactivity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caseymillstein on 12/5/15.
 */
public class AddScreen extends Fragment{

    List<PersonInfo> personInfoList = new ArrayList<>();
    ArrayAdapter<String> personAdapter;



    public static final String TAG = "AddScreen.TAG";
    private static final String SAVE_NAME = "AddScreen.SAVE_NAME";
    private static final String SAVE_AGE = "AddScreen.SAVE_AGE";
    private static final String SAVE_SCHOOL = "AddScreen.SAVE_SCHOOL";


    private onButtonClickListener buttonClick;
    EditText addName;
    EditText addAge;
    EditText addSchool;
    Button submitButton;
    Button showList;
    String userName;
    String userAge;
    String userSchool;




    public interface onButtonClickListener{
        public void savePersonData(String _name, String _age, String _school);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof onButtonClickListener){
            buttonClick = (onButtonClickListener)activity;
        }else{
            throw new IllegalArgumentException("It's wrong");
        }
    }





    @Override
    public View onCreateView(LayoutInflater _inflater, ViewGroup _container, Bundle _savedInstanceState){
        View view = _inflater.inflate(R.layout.addscreen, _container, false);

        //VARIABLES
        addName = (EditText) view.findViewById(R.id.addName);
        addAge = (EditText) view.findViewById(R.id.addAge);
        addSchool = (EditText) view.findViewById(R.id.addSchool);
        submitButton = (Button) view.findViewById(R.id.submitButton);
        showList = (Button) view.findViewById(R.id.showList);

        addName.setHint("Enter Name");
        addAge.setHint("Enter Age");
        addSchool.setHint("Enter School");


        //SUBMIT BUTTON
        submitButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String name = addName.getText().toString();
                String age = addAge.getText().toString();
                String school = addSchool.getText().toString();

                if(!name.isEmpty() && !age.isEmpty() && !school.isEmpty()){
                    buttonClick.savePersonData(name,age,school);
                    addName.setText("");
                    addAge.setText("");
                    addSchool.setText("");
                }else{
                    Toast.makeText(getActivity(), "No User Added!", Toast.LENGTH_SHORT).show();

                }

            }
        });



        //SHOWS LIST VIEW OF ENTERED ITEMS
        showList.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                Intent listActivity = new Intent(getActivity(), ListActivity.class);
                startActivity(listActivity);


            }

        });






        return  view;
    }




}
