package com.example.caseymillstein.c_millstein_labfive2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by caseymillstein on 12/16/15.
 */
public class FormScreen extends Fragment {

    public static final String TAG = "FormScreen.TAG";

    EditText name;
    EditText age;
    EditText school;

    String addName;
    int addAge;
    String addSchool;

    private onActionClick mListener;

    public interface onActionClick{
        void saveInfo(String name, int age, String school);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

    }

    public static FormScreen newInstance(){
        FormScreen fragment = new FormScreen();
        return fragment;
    }


    //SETTING UP ACTION BAR


    @Override
    public View onCreateView(LayoutInflater _inflater, ViewGroup _container, Bundle _savedInstanceState){
        return _inflater.inflate(R.layout.formscreen, _container, false);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.form, menu);

    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();

        name = (EditText) view.findViewById(R.id.nameHolder);
        age = (EditText) view.findViewById(R.id.ageHolder);
        school = (EditText) view.findViewById(R.id.schoolHolder);

//        name.setHint("Add Name");
//        age.setHint("Add Age");
//        school.setHint("Add School");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.addButton:

                addName = name.getText().toString();
                addAge = Integer.parseInt(age.getText().toString());
                addSchool = school.getText().toString();

                mListener = (onActionClick) getActivity();
                mListener.saveInfo(addName, addAge, addSchool);
                break;

            default:
                break;


        }
        return true;
    }
}
