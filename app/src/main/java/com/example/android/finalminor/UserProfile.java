package com.example.android.finalminor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;

import static android.R.attr.name;
import static com.example.android.finalminor.R.id.email;

/**
 * Created by chandrakala on 11/1/2016.
 */

public class UserProfile extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private String mUserId;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_prof);

        final EditText name, address, number, course, aggregate;

        name = (EditText) findViewById(R.id.et_name);
        address = (EditText) findViewById(R.id.et_add);
        number = (EditText) findViewById(R.id.et_phone);
        course = (EditText) findViewById(R.id.et_Branch);
        aggregate = (EditText) findViewById(R.id.et_agg);

        Button submit = (Button) findViewById(R.id.b_submit);
        // Initialize Firebase Auth and Database Reference
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mUserId = mFirebaseUser.getUid();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabase.child("users").child(mUserId).child("address").push().setValue(address.getText().toString());
                address.setText(address.getText().toString());
                mDatabase.child("users").child(mUserId).child("name").push().setValue(name.getText().toString());
                name.setText(name.getText().toString());

            }
        });
    }


}
