package com.example.android.finalminor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.widget.EditText;

/**
 * Created by chandrakala on 11/1/2016.
 */

public class UserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_prof);

        EditText name,address,number,course,aggregate;

        name = (EditText)findViewById(R.id.et_name);
        address= (EditText)findViewById(R.id.et_add);
        number= (EditText)findViewById(R.id.et_phone);
        course= (EditText)findViewById(R.id.et_Branch);
        aggregate = (EditText)findViewById(R.id.et_agg);


    }
}