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

/**
 * Created by caseymillstein on 12/16/15.
 */
public class DetailsScreen extends Fragment {

    public static final String TAG = "DetailsScreen.TAG";





    public interface onDetailItemSelection{
        void passURI(Uri uri);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static DetailsScreen newInstance(){
        DetailsScreen fragment = new DetailsScreen();
        return fragment;
    }




}
