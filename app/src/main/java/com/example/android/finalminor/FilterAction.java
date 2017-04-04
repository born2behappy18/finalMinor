package com.example.android.finalminor;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

/**
 * Created by rajeev on 30/9/16.
 */
public class FilterAction extends AppCompatActivity {


    Button done;

    CheckBox criteriaBox;
    CheckBox lpaBox1;
    CheckBox lpaBox2;
    CheckBox lpaBox3;
    CheckBox lpaBox4;

    boolean merc = false;
    boolean lpaMerc1 = false;
    boolean lpaMerc2 = false;
    boolean lpaMerc3 = false;
    boolean lpaMerc4 = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_filter);

        // get action bar
        ActionBar actionBar = getActionBar();

        // Enabling Up / Back navigation
        //actionBar.setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        criteriaBox = (CheckBox) findViewById(R.id.checkBox);
        lpaBox1 = (CheckBox) findViewById(R.id.lpaCheckBox1);
        lpaBox2 = (CheckBox) findViewById(R.id.lpaCheckBox2);
        lpaBox3 = (CheckBox) findViewById(R.id.lpaCheckBox3);
        lpaBox4 = (CheckBox) findViewById(R.id.lpaCheckBox4);


        criteriaBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(criteriaBox.isChecked()){
                    merc = true;
                }
            }
        });

        lpaBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lpaBox1.isChecked()){
                    lpaMerc1 = true;
                }
            }
        });

        lpaBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lpaBox2.isChecked()){
                    lpaMerc2 = true;
                }
            }
        });

        lpaBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lpaBox3.isChecked()){
                    lpaMerc3 = true;
                }
            }
        });

        lpaBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lpaBox4.isChecked()){
                    lpaMerc4 = true;
                }
            }
        });

        done = (Button) findViewById(R.id.done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(FilterAction.this, DefaultPage.class)
                        .putExtra("Merc",merc);
                myintent.putExtra("lpaMerc1",lpaMerc1);
                myintent.putExtra("lpaMerc2",lpaMerc2);
                myintent.putExtra("lpaMerc3",lpaMerc3);
                myintent.putExtra("lpaMerc4",lpaMerc4);

                startActivity(myintent);
            }
        });
    }
}
