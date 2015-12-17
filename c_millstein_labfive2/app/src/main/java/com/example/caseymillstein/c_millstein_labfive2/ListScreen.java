package com.example.caseymillstein.c_millstein_labfive2;

import android.app.ListFragment;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.List;
import java.util.jar.Attributes;

/**
 * Created by caseymillstein on 12/16/15.
 */
public class ListScreen extends ListFragment {

    public static final String TAG = "ListScreen.TAG";

    CursorAdapter cAdapter;
    Cursor person;
    private onListItemSelection mListener;



    public static ListScreen newInstance(){
        ListScreen fragment = new ListScreen();
        return fragment;
    }

    public interface onListItemSelection{
        void passURI(Uri uri);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] projection = {DatabaseHelper.STUDENT_ID, DatabaseHelper.NAME};
        String[] bindFrom = {DatabaseHelper.NAME};
        int[] bindto = {android.R.id.text1};

        person = getActivity().getContentResolver().query(NameProvider.CONTENT_URI, projection, null, null, null);
        cAdapter = new SimpleCursorAdapter(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, person, bindFrom, bindto, 1);
        setListAdapter(cAdapter);


    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        mListener = (onListItemSelection) getActivity();
        Uri info = Uri.parse(NameProvider.CONTENT_URI + "/" + id);
        Log.e(TAG, "uri: " + info);
        mListener.passURI(info);



    }




}
