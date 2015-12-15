package com.example.caseymillstein.c_millstein_labfive;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by caseymillstein on 12/13/15.
 */
public class DetailsScreen extends Fragment{

    TextView nameReal;
    TextView ageReal;
    TextView schoolReal;
    Button deleteButton;
    Button shareButton;
    //private onDeleteButtonClick deletePerson;


    @Override
    public View onCreateView(LayoutInflater _inflater, ViewGroup _container, Bundle _savedInstanceState) {
        View view = _inflater.inflate(R.layout.detailscreen, _container, false);

        nameReal = (TextView) view.findViewById(R.id.nameReal);
        ageReal = (TextView) view.findViewById(R.id.ageReal);
        schoolReal = (TextView) view.findViewById(R.id.schoolReal);
        deleteButton = (Button) view.findViewById(R.id.deleteButton);


        return view;
    }

    }
