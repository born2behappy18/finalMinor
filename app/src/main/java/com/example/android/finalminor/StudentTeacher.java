package com.example.android.finalminor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by chandrakala on 11/4/2016.
 */

public class StudentTeacher extends AppCompatActivity {

    int profile = -1; //1 for teacher & 0 for student

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_teacher);
        Button mTeacher = (Button) findViewById(R.id.teacher_btn);
        Button mStudent = (Button) findViewById(R.id.student_btn);

        mTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile=1;
            }
        });
        mStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile=0;
            }
        });

    }
}