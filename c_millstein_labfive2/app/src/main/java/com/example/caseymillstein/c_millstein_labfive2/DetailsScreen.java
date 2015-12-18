package com.example.caseymillstein.c_millstein_labfive2;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by caseymillstein on 12/16/15.
 */
public class DetailsScreen extends Fragment {

    public static final String TAG = "DetailsScreen.TAG";
    public static final String NAME_TAG = "DetailsScreen.NAME";
    public static final String AGE_TAG = "DetailsScreen.AGE";
    public static final String SCHOOL_TAG = "DetailsScreen.SCHOOL";





    private actionBarClick mListener;

    EditText nameReal;
    EditText ageReal;
    EditText schoolReal;
    String name;
    String age;
    String school;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle args = getArguments();
        if(args != null && args.containsKey(NAME_TAG) && args.containsKey(AGE_TAG) && args.containsKey(SCHOOL_TAG)){
            passInfo(args.getString(NAME_TAG), args.getString(AGE_TAG), args.getString(SCHOOL_TAG));
        }



    }

    public static DetailsScreen newInstance(String name, String age, String school){
        DetailsScreen fragment = new DetailsScreen();

        Bundle args = new Bundle();
        args.putString(NAME_TAG, name);
        args.putString(AGE_TAG, age);
        args.putString(SCHOOL_TAG, school);
        fragment.setArguments(args);



        return fragment;
    }

    public interface actionBarClick{
        void update(String name, String age, String school);
        void delete();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mListener = (actionBarClick) getActivity();
        switch (item.getItemId()){

            case R.id.updateButton:
                name = nameReal.getText().toString();
                age = ageReal.getText().toString();
                school = schoolReal.getText().toString();

                if(name.isEmpty() || age.isEmpty() || school.isEmpty()){
                    Toast.makeText(getActivity(), "Correct Information Not Entered", Toast.LENGTH_SHORT).show();
                }else{
                    mListener.update(name, age, school);
                }
                break;

            case R.id.deleteButton:
                mListener.delete();
                default:
                    break;


        }
        return true;
    }

    @Override
    public View onCreateView(LayoutInflater _inflater, ViewGroup _container, Bundle _savedInstanceState){

        return _inflater.inflate(R.layout.detailscreen, _container, false);


    }



    public void passInfo(String name, String age, String school){
        nameReal = (EditText) getView().findViewById(R.id.nameReal);
        ageReal = (EditText) getView().findViewById(R.id.ageReal);
        schoolReal = (EditText) getView().findViewById(R.id.schoolReal);

        nameReal.setText(name);
        ageReal.setText(age);
        schoolReal.setText(school);


    }


}
