package com.example.android.finalminor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by rajeev on 30/9/16.
 */
public class CompanyApply extends AppCompatActivity {

    private Button mApplyBtn;
    private Button mPreparationBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mApplyBtn = (Button) findViewById(R.id.apply_btn);
        mApplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CompanyApply.this, ApplyForm.class);
                startActivity(i);
            }
        });

        mPreparationBtn = (Button) findViewById(R.id.prepration_btn);
        mPreparationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CompanyApply.this, PreparationTest.class);
                startActivity(i);
            }
        });
    }
}
