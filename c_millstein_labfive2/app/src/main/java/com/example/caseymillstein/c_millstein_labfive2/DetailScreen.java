package com.example.caseymillstein.c_millstein_labfive2;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by caseymillstein on 12/15/15.
 */
public class DetailScreen extends Fragment {



    public static final String TAG = "ViewScreen.TAG";



    TextView nameReal;
    TextView ageReal;
    TextView schoolReal;
    Button deleteButton;
    Button shareButton;
    private onDeleteButtonClick deletePerson;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(activity instanceof onDeleteButtonClick){
            deletePerson = (onDeleteButtonClick)activity;
        }else{
            throw new IllegalArgumentException("Still Wrong Bro");
        }

    }

    @Override
    public View onCreateView(LayoutInflater _inflater, ViewGroup _container, Bundle _savedInstanceState){
        View view = _inflater.inflate(R.layout.viewscreen, _container, false);

        nameReal = (TextView) view.findViewById(R.id.nameReal);
        ageReal = (TextView) view.findViewById(R.id.ageReal);
        schoolReal = (TextView) view.findViewById(R.id.schoolReal);
        deleteButton = (Button) view.findViewById(R.id.deleteButton);
        //shareButton = (Button) view.findViewById(R.id.shareButton);




        //DELETE BUTTON CLICK
        deleteButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Bundle args = getArguments();
                if(args != null && args.containsKey("key")) {
                    PersonInfo personInfoAgain = (PersonInfo) args.getSerializable("key");
                    deletePerson.removePerson(personInfoAgain);

                }
            }
        });

        //SHARE BUTTON CLICK
        shareButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Bundle args = getArguments();
                if(args != null && args.containsKey("key")) {
                    PersonInfo personInfoAgain = (PersonInfo) args.getSerializable("key");
                    String objectOutput = "Name: " + personInfoAgain.getmName() + " Age: " + personInfoAgain.getmAge() + " School: " + personInfoAgain.getmSchool();
                    Intent batmanIntent = new Intent(Intent.ACTION_SEND);
                    batmanIntent.putExtra(Intent.EXTRA_TEXT, objectOutput);
                    batmanIntent.setType("text/plain");
                    startActivity(Intent.createChooser(batmanIntent, "Sharing is caring!"));


                }
            }
        });



        return  view;
    }

    public static DetailScreen newInstance(PersonInfo returnPerson) {

        DetailScreen storeList = new DetailScreen();
        Bundle args = new Bundle();
        args.putSerializable("key", returnPerson);
        storeList.setArguments(args);
        return storeList;

    }

    public interface onDeleteButtonClick{
        public void removePerson(PersonInfo personData);
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();

        //CREATE BUNDLE ARGUMENTS FOR NAME, AGE, SCHOOL

        Bundle args = getArguments();
        if(args != null && args.containsKey("key")){
            PersonInfo personInfoAgain = (PersonInfo)args.getSerializable("key");
            nameReal.setText(personInfoAgain.getmName());
            ageReal.setText(personInfoAgain.getmAge());
            schoolReal.setText(personInfoAgain.getmSchool());

        }


    }


}
