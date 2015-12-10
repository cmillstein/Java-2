package com.example.caseymillstein.c_millstein_multiactivity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.IllegalFormatCodePointException;

/**
 * Created by caseymillstein on 12/5/15.
 */
public class ViewScreen extends Fragment{


    public static final String TAG = "ViewScreen.TAG";



    TextView nameReal;
    TextView ageReal;
    TextView schoolReal;
    Button deleteButton;
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



        return  view;
    }

    public static ViewScreen newInstance(PersonInfo returnPerson) {

        ViewScreen storeList = new ViewScreen();
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

        Bundle args = getArguments();
        if(args != null && args.containsKey("key")){
            PersonInfo personInfoAgain = (PersonInfo)args.getSerializable("key");
            nameReal.setText(personInfoAgain.getmName());
            ageReal.setText(personInfoAgain.getmAge());
            schoolReal.setText(personInfoAgain.getmSchool());

        }


    }
}
