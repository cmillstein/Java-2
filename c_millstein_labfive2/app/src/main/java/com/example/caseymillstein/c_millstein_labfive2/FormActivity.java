package com.example.caseymillstein.c_millstein_labfive2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.text.Normalizer;
import java.util.List;

/**
 * Created by caseymillstein on 12/16/15.
 */
public class FormActivity extends AppCompatActivity implements FormScreen.onActionClick{




    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formscreen);

        if(savedInstanceState == null){
            FragmentManager mgr = getFragmentManager();
            FragmentTransaction trs = mgr.beginTransaction();
            FormScreen fragment = FormScreen.newInstance();
            trs.replace(R.id.form_container, fragment, FormScreen.TAG);
            trs.commit();
        }




    }

    @Override
    public void saveInfo(String name, int age, String school) {
        Intent listActivity = new Intent(this, ListActivity.class);
        listActivity.putExtra("name", name);
        listActivity.putExtra("age", age);
        listActivity.putExtra("school", school);
        setResult(RESULT_OK, listActivity);
        Toast.makeText(FormActivity.this, "Person Added", Toast.LENGTH_SHORT).show();
        finish();
    }
}
