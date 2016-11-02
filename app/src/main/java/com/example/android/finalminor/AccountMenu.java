package com.example.android.finalminor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Ankur on 11/1/2016.
 */

public class AccountMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_menu);

        Button userProf = (Button)findViewById(R.id.b_userProfile);
        Button userSett = (Button)findViewById(R.id.b_userSetting);

        userProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountMenu.this, UserProfile.class));
            }
        });

        userSett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountMenu.this,AccountAction.class));
            }
        });
    }
}