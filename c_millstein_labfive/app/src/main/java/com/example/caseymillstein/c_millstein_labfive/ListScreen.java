package com.example.caseymillstein.c_millstein_labfive;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.text.Normalizer;
import java.util.List;

public class ListScreen extends AppCompatActivity{

    ListView list;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_screen);

//        DatabaseHelper helper = new DatabaseHelper(this);
//        SQLiteDatabase database = helper.getWritableDatabase();


        list = (ListView)findViewById(R.id.listItems);
        addButton = (Button)findViewById(R.id.addButton);



        addButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent formScreen = new Intent(ListScreen.this, FormScreen.class);
                startActivity(formScreen);
            }


        });


    }





}
