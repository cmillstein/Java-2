package com.example.caseymillstein.c_millstein_multiactivity;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caseymillstein on 12/5/15.
 */
public class ListScreen extends ListFragment{




    public static final String TAG = "ListScreen.TAG";





    @Override
    public View onCreateView(LayoutInflater _inflater, ViewGroup _container, Bundle _savedInstanceState) {
        View view = _inflater.inflate(R.layout.listscreen, _container, false);



        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();


        Bundle args = getArguments();
        if(args != null && args.containsKey("key")){
            ArrayList<PersonInfo> personArray = (ArrayList<PersonInfo>)args.getSerializable("key");
            //String[] stringArray = new String[personArray.size()];
            ArrayAdapter<String> personAdapter = new ArrayAdapter<String>();



        }




    }

    public static ListScreen newInstance(ArrayList<PersonInfo> returnPerson) {

        ListScreen storeList = new ListScreen();
        Bundle args = new Bundle();
        args.putSerializable("key", returnPerson);
        storeList.setArguments(args);
        return storeList;

    }




}
