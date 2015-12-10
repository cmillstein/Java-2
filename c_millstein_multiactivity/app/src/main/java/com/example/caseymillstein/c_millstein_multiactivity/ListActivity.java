package com.example.caseymillstein.c_millstein_multiactivity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by caseymillstein on 12/7/15.
 */
public class ListActivity extends AppCompatActivity implements ListScreen.onClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listscreen);


        ArrayList<PersonInfo> personArray = new ArrayList<>();
        try{
            FileInputStream fis = openFileInput("File.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            personArray = (ArrayList<PersonInfo>)ois.readObject();
            ois.close();


        }catch(Exception e){


        }

        ListScreen tempList = ListScreen.newInstance(personArray);
        getFragmentManager().beginTransaction()
                .replace(R.id.listContainer2, tempList, ListScreen.TAG)
                .commit();



    }

    @Override
    public void listClick(PersonInfo newVariable){
        Intent viewScreen = new Intent(this, ViewScreenActivity.class);
        viewScreen.putExtra("key", newVariable);
        startActivityForResult(viewScreen, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == Activity.RESULT_OK && requestCode == 1){
            //UPDATE LIST
            ListScreen tempList = (ListScreen)getFragmentManager().findFragmentByTag(ListScreen.TAG);
            PersonInfo personData = (PersonInfo) data.getSerializableExtra("key");
            ArrayList<PersonInfo> personArray = new ArrayList<>();
            try{
                FileInputStream fis = openFileInput("File.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                personArray = (ArrayList<PersonInfo>)ois.readObject();
                ois.close();


            }catch(Exception e){


            }
            for(PersonInfo morePeople:personArray){
                if(morePeople.getmName().equals(personData.getmName())){
                    personArray.remove(morePeople);
                    break;

                }
            }

//            personArray.remove(data.getSerializableExtra("key"));
            try{
                FileOutputStream fos = openFileOutput("File.txt", Context.MODE_PRIVATE);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(personArray);
                oos.close();

            }catch(Exception e){


            }


            tempList.updateDisplayList(personArray);


        }
    }

}
