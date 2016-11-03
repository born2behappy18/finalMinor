package com.example.android.finalminor;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


/**
 * Created by Ankur on 29/9/16.
 */
public class DefaultPage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CompanyAdapter mAdapter;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true); //for offline storing data


        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        if(mFirebaseUser == null){
            //not signed in. launch login
            startActivity(new Intent(this,AccountAction.class));
            finish();
            return;
        }

        setContentView(R.layout.company_list);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new CompanyAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.company_list_actions, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_search:
                // search action
                return true;
            case R.id.action_filter:
                // filter
                FilterAction();
                return true;

            case R.id.action_account:
                AccountAction();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void FilterAction() {
        Intent i = new Intent(DefaultPage.this, FilterAction.class);
        startActivity(i);
    }

    private void AccountAction() {
        Intent i = new Intent(DefaultPage.this, AccountMenu.class);
        startActivity(i);
    }
}
