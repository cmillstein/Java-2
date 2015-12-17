package com.example.caseymillstein.c_millstein_labfive2;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.net.URI;

/**
 * Created by caseymillstein on 12/16/15.
 */
public class NameProvider extends ContentProvider {

    private static final String AUTHORITY = "com.example.caseymillstein.c_millstein_labfive2.NameProvider";
    private static final String DATA_SOURCE = "student";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + DATA_SOURCE);
    public static final int PERSON = 1;
    public static final int PERSON_ID = 2;
    private DatabaseHelper myDatabase;

    private static final UriMatcher URIMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static{
        URIMatcher.addURI(AUTHORITY, DATA_SOURCE, PERSON);
        URIMatcher.addURI(AUTHORITY, DATA_SOURCE + "/#", PERSON_ID);
    }


    //CREATE -- READ -- UPDATE -- DELETE




    //CREATE
    @Override
    public boolean onCreate() {

        myDatabase = new DatabaseHelper(getContext());

        return true;
    }


    //CREATING CURSOR INFO
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder qBuilder = new SQLiteQueryBuilder();
        qBuilder.setTables(DatabaseHelper.TABLE_NAME);

        int uriType = URIMatcher.match(uri);
        switch(uriType){
            case PERSON_ID:
                qBuilder.appendWhere(DatabaseHelper.STUDENT_ID + "=" + uri.getLastPathSegment());
                break;

            case PERSON:
                break;

            default:
                throw new IllegalArgumentException("URI Not Valid");

        }

        Cursor newCursor = qBuilder.query(myDatabase.getReadableDatabase(), projection, selection, selectionArgs, null, null, sortOrder);
        newCursor.setNotificationUri(getContext().getContentResolver(), uri);


        return newCursor;
    }


    @Override
    public String getType(Uri uri) {
        return null;
    }


    //INSERTING URI
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int type = URIMatcher.match(uri);
        SQLiteDatabase sqdb = myDatabase.getWritableDatabase();

        long id;
        switch(type){
            case PERSON:
                id = sqdb.insert(DatabaseHelper.TABLE_NAME, null, values);
                break;

            default:
                throw new IllegalArgumentException("URI Not Valid: " + uri);

        }

        getContext().getContentResolver().notifyChange(uri, null);



        return Uri.parse(DATA_SOURCE + "/" + id);
    }


    //DELETE INFO
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        int type = URIMatcher.match(uri);
        SQLiteDatabase sqdb = myDatabase.getWritableDatabase();
        int deleteRows;

        switch(type){
            case PERSON_ID:
                String id = uri.getLastPathSegment();
                if(TextUtils.isEmpty(selection)){
                    deleteRows = sqdb.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.STUDENT_ID + "=" + id, null);
                }else{
                    deleteRows = sqdb.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.STUDENT_ID + "=" + id + "and" + selection, selectionArgs);
                }
                break;

            default:
                throw new IllegalArgumentException("URI Not Valid: " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);



        return deleteRows;
    }


    //UPDATE INFO
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int type = URIMatcher.match(uri);
        SQLiteDatabase sqdb = myDatabase.getWritableDatabase();
        int updateRows;

        switch(type){
            case PERSON:
                updateRows = sqdb.update(DatabaseHelper.TABLE_NAME, values, selection, selectionArgs);
                break;

            case PERSON_ID:
                String id = uri.getLastPathSegment();
                if(TextUtils.isEmpty(selection)){
                    updateRows = sqdb.update(DatabaseHelper.TABLE_NAME, values, DatabaseHelper.STUDENT_ID + "=" + id, null);

                }else{
                    updateRows = sqdb.update(DatabaseHelper.TABLE_NAME, values, DatabaseHelper.STUDENT_ID + "=" + id + "and" + selection, selectionArgs);

                }
                break;

            default:
                throw new IllegalArgumentException("URI Not Valid: " + uri);


        }

        getContext().getContentResolver().notifyChange(uri, null);






        return updateRows;

    }
}
