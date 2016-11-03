package com.example.android.finalminor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by rajeev on 4/11/16.
 */

public class HCL extends AppCompatActivity{


    private Button mApplynow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hcl);
        mApplynow = (Button) findViewById(R.id.apply_now_btn);
        mApplynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HCL.this, "Applied , All the best",
                        Toast.LENGTH_LONG).show();
            }
        });


    }
}
