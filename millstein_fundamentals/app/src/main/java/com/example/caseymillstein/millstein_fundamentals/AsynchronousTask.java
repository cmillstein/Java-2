package com.example.caseymillstein.millstein_fundamentals;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caseymillstein on 11/30/15.
 */
public class AsynchronousTask extends AsyncTask<URL, Integer, Weather> {

    private TextView displayTemp;
    private TextView city;
    private TextView description;
    private TextView humidity;

    ArrayList<Weather> weatherArrayList = new ArrayList<>();
    Adapter mAdapter;
    ListView zipCodeList;



    Activity mActivity;


    //CREATE ASYNC TASK

        String jsonString = "";

    public AsynchronousTask(Activity activity) {

        this.mActivity = activity;
    }


    protected void onPreExecute() {
            //progressBar.setVisibility(View.VISIBLE);

        }

        @Override
        protected Weather doInBackground(URL... _url) {

            for (URL queryURL : _url) {
                try {
                    URLConnection conn = queryURL.openConnection();
                    jsonString = IOUtils.toString(conn.getInputStream());
                    break;
                } catch (IOException e) {
                    Log.e("millstein_fundamentals", "Could not establish connection");
                }
            }
            JSONObject apiData;
            Weather store = new Weather();



            try {
                apiData = new JSONObject(jsonString);
            } catch (Exception e) {
                Log.e("millstein_fundamentals", "Cannot convert to API");
                apiData = null;
            }

            try {
                if (apiData != null) {
                    store.setmCity(apiData.getString("name"));
                    store.setmWeatherMain(apiData.getJSONObject("main").getString("temp"));
                    store.setmHumidity(apiData.getJSONObject("main").getString("humidity"));
                    store.setmWeatherDescription(apiData.getJSONArray("weather").getJSONObject(0).getString("description"));


                }


            } catch (Exception e) {
                Log.e("millstein_fundamentals", "Cannot convert to API 2");
                apiData = null;
            }


            return store;
        }
            protected void onPostExecute(Weather _weatherInfo){




//
//        city.setText(_weatherInfo.getCity());
//        displayTemp.setText(_weatherInfo.getmWeatherMain());
//        humidity.setText(_weatherInfo.getmHumidity());
//        description.setText(_weatherInfo.getmWeatherDescription());
//

        //progressBar.setVisibility(View.GONE);

    }



    }


