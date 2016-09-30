package com.example.android.finalminor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by rajeev on 30/9/16.
 */
public class FlashScreen1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);

        Thread logoTimer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    Intent intent = new Intent(FlashScreen1.this,DefaultPage.class);
                    startActivity(intent);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    finish();
                }
            };
        };
        logoTimer.start();
    }
}
