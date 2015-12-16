package com.example.caseymillstein.c_millstein_labfive2;

import java.io.Serializable;

/**
 * Created by caseymillstein on 12/15/15.
 */
public class PersonInfo implements Serializable{


    public static final String TAG = "PersonInfo.TAG";



    private static long serialVersionUID = 1;

    private String mName;
    private String mAge;
    private String mSchool;

    public PersonInfo() { mName = mAge = mSchool = "";}

    public PersonInfo(String _name, String _age, String _school){

        mName = _name;
        mAge = _age;
        mSchool = _school;

    }

    //SETTERS
    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmAge(String mAge) {
        this.mAge = mAge;
    }

    public void setmSchool(String mSchool) {
        this.mSchool = mSchool;
    }

    //GETTERS
    public String getmName() {
        return mName;
    }

    public String getmAge() {
        return mAge;
    }

    public String getmSchool() {
        return mSchool;
    }
}
