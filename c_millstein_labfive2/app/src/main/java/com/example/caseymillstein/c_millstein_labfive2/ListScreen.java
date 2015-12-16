package com.example.caseymillstein.c_millstein_labfive2;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by caseymillstein on 12/15/15.
 */
public class ListScreen extends Fragment {




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



//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
//
//        String name = (String) l.getItemAtPosition(position);
//        PersonInfo newPersonObject = new PersonInfo();
//        Bundle args = getArguments();
//        if (args != null && args.containsKey("key")) {
//            ArrayList<PersonInfo> personArray = (ArrayList<PersonInfo>) args.getSerializable("key");
//            for(PersonInfo morePeople:personArray){
//                if(morePeople.getmName().equals(name)){
//                    newPersonObject = morePeople;
//                    break;
//                }
//            }
//
//        }
//
//        buttonClickList.listClick(newPersonObject);
//    }


    //UPDATING LIST
    public void updateDisplayList(ArrayList<PersonInfo> returnPersonInfo){


        String[] stringArray = new String[returnPersonInfo.size()];
        int loop = 0;
        for(PersonInfo individual:returnPersonInfo){
            stringArray[loop] = individual.getmName();
            loop++;

        }

        ArrayAdapter<String> personAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, stringArray);
        //setListAdapter(personAdapter);
    }




    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //View view = getView();


        Bundle args = getArguments();
        if(args != null && args.containsKey("key")){
            updateDisplayList((ArrayList<PersonInfo>)args.getSerializable("key"));



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
