package com.example.android.finalminor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by rajeev on 3/11/16.
 */
public class TeacherStudent extends AppCompatActivity {

    private Button mTeacher;
    private Button mStudent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_teacher);

        mTeacher = (Button) findViewById(R.id.teacher_btn);
        mStudent = (Button) findViewById(R.id.student_btn);
    }
}
