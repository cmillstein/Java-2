package com.example.caseymillstein.c_millstein_labfive2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by caseymillstein on 12/16/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {




    //CONSTANTS
    private static final String DATABASE_NAME = "Student.db";
    private static final int DATABASE_VERSION = 1;


    public static final String TABLE_NAME = "student";
    public static final String STUDENT_ID = "_id";
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String SCHOOL = "school";
    public static final String[] ALL_COLUMNS = {STUDENT_ID, NAME, AGE, SCHOOL};

    //creating SQL table
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NAME + " TEXT, " +
                    AGE + " INTEGER, " +
                    SCHOOL + " TEXT)";



    public DatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //CREATING DATABASE
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);

    }

    //CHANGE DATABASE VERSION
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }



}
