package com.example.caseymillstein.c_millstein_multiactivity;

import android.app.Activity;
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
    private onClickListener buttonClickList;



    public interface onClickListener{
        public void listClick(PersonInfo listPerson);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof onClickListener){
            buttonClickList = (onClickListener)activity;
        }else{
            throw new IllegalArgumentException("It's wrong");
        }
    }



    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String name = (String) l.getItemAtPosition(position);
        PersonInfo newPersonObject = new PersonInfo();
        Bundle args = getArguments();
        if (args != null && args.containsKey("key")) {
            ArrayList<PersonInfo> personArray = (ArrayList<PersonInfo>) args.getSerializable("key");
            for(PersonInfo morePeople:personArray){
                if(morePeople.getmName().equals(name)){
                    newPersonObject = morePeople;
                    break;
                }
            }

        }

        buttonClickList.listClick(newPersonObject);
    }





    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //View view = getView();


        Bundle args = getArguments();
        if(args != null && args.containsKey("key")){
            ArrayList<PersonInfo> personArray = (ArrayList<PersonInfo>)args.getSerializable("key");
            String[] stringArray = new String[personArray.size()];
            int loop = 0;
            for(PersonInfo individual:personArray){
                stringArray[loop] = individual.getmName();
                loop++;

            }

            ArrayAdapter<String> personAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, stringArray);
            setListAdapter(personAdapter);



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
