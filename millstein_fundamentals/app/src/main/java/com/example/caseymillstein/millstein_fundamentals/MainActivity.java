package com.example.caseymillstein.millstein_fundamentals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private EditText zipCode;
    private Button searchButton;
    private ListView zipCodeSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zipCode = (EditText) findViewById(R.id.zipCode);
        searchButton = (Button) findViewById(R.id.searchButton);
        zipCodeSearch = (ListView) findViewById(R.id.zipCodeList);


    }



}
