package com.example.android.finalminor;

import android.app.Activity;
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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import static android.R.attr.data;


/**
 * Created by Ankur on 29/9/16.
 */
public class DefaultPage extends AppCompatActivity {

    TextView mAmazonBtn;
    Button mAmazonApplyBtn;
    Button mLinkedInApplyBtn;
    Button mSopraApplyBtn;
    Button mHclApplyBtn;
    Button mInfosysApplyBtn;
    Button mTcsApplyBtn;
    Button mWiproApplyBtn;
    Button mCognizantApplyBtn;
    Button mAccentureApplyBtn;
    Button mFacebookApplyBtn;




    boolean amazonCriteria = true;
    boolean linkedInCriteria = true;
    boolean sopraCriteria = true;
    boolean hclCriteria = false;
    boolean infosysCriteria = false;
    boolean tcsCriteria =true;
    boolean wiproCriteria = true;
    boolean cognizantCriteria = false;
    boolean accentureCriteria = false;
    boolean facebookCriteria = true;

    boolean[] criteria;

  //  int lpa;
    int amazonlpa = 12;
    int linkedInlpa = 5;
    int sopralpa = 5;
    int hcllpa = 2;
    int infosyslpa = 4;
    int tcslpa =4;
    int wiprolpa = 5;
    int cognizantlpa = 6;
    int accenturelpa = 4;
    int facebooklpa = 15;

    int lpa[];

    LinearLayout[] layout;


    LinearLayout amazonlay;
    LinearLayout linkedInlay;
    LinearLayout sopralay;
    LinearLayout hcllay;
    LinearLayout infosyslay;
    LinearLayout tcslay;
    LinearLayout wiprolay;
    LinearLayout cognizantlay;
    LinearLayout accenturelay;
    LinearLayout facebooklay;




//    private RecyclerView recyclerView;
//    private CompanyAdapter mAdapter;
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
            startActivity(new Intent(DefaultPage.this,StudentTeacher.class));
            startActivity(new Intent(this,AccountAction.class));
            finish();
            return;
        }


        setContentView(R.layout.company_list);
        Boolean merc = false;
        Boolean lpaMerc1 = false;
        Boolean lpaMerc2 = false;
        Boolean lpaMerc3 = false;
        Boolean lpaMerc4 = false;

        Intent intent = getIntent();
        merc = intent.getBooleanExtra("Merc",merc);
        lpaMerc1 = intent.getBooleanExtra("lpaMerc1",lpaMerc1);
        lpaMerc2 = intent.getBooleanExtra("lpaMerc2",lpaMerc2);
        lpaMerc3 = intent.getBooleanExtra("lpaMerc3",lpaMerc3);
        lpaMerc4 = intent.getBooleanExtra("lpaMerc4",lpaMerc4);


        criteria = new boolean[10];
        criteria[0] = amazonCriteria;
        criteria[1] = linkedInCriteria;
        criteria[2] = sopraCriteria;
        criteria[3] = hclCriteria;
        criteria[4] = infosysCriteria;
        criteria[5] = tcsCriteria;
        criteria[6] = wiproCriteria;
        criteria[7] = cognizantCriteria;
        criteria[8] = accentureCriteria;
        criteria[9] = facebookCriteria;

        lpa = new int[10];
        lpa[0] = amazonlpa;
        lpa[1] = linkedInlpa;
        lpa[2] = sopralpa;
        lpa[3] = hcllpa;
        lpa[4] = infosyslpa;
        lpa[5] = tcslpa;
        lpa[6] = wiprolpa;
        lpa[7] = cognizantlpa;
        lpa[8] = accenturelpa;
        lpa[9] = facebooklpa;

        layout = new LinearLayout[10];

        layout[0] = (LinearLayout) findViewById(R.id.amazon);
        layout[1] = (LinearLayout) findViewById(R.id.linkedIn);
        layout[2] = (LinearLayout) findViewById(R.id.sopra);
        layout[3] = (LinearLayout) findViewById(R.id.hcl);
        layout[4] = (LinearLayout) findViewById(R.id.infosys);
        layout[5] = (LinearLayout) findViewById(R.id.tcs);
        layout[6] = (LinearLayout) findViewById(R.id.wipro);
        layout[7] = (LinearLayout) findViewById(R.id.cognizant);
        layout[8] = (LinearLayout) findViewById(R.id.accenture);
        layout[9] = (LinearLayout) findViewById(R.id.facebook);


        if(merc==true){
            for(int i=0;i<9;i++){
                if(criteria[i]==false){
                    layout[i].setVisibility(View.GONE);
                }
            }

        }

        if(lpaMerc1==true){
            for(int i=0;i<9;i++){
                if(lpa[i]>3){
                    layout[i].setVisibility(View.GONE);
                }
            }
        }

        if(lpaMerc2==true){
            for(int i=0;i<9;i++){
                if(lpa[i]<=3 && lpa[i]>5){
                    layout[i].setVisibility(View.GONE);
                }
            }
        }

        if(lpaMerc3==true){
            for(int i=0;i<9;i++){
                if(lpa[i]<=5 && lpa[i]>10){
                    layout[i].setVisibility(View.GONE);
                }
            }
        }

        if(lpaMerc4==true){
            for(int i=0;i<9;i++){
                if(lpa[i]<=10){
                    layout[i].setVisibility(View.GONE);
                }
            }
        }



        mAmazonBtn = (TextView) findViewById(R.id.amazon_btn);

        mAmazonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(i);
            }
        });

        mAmazonApplyBtn = (Button) findViewById(R.id.amazon_apply_now_btn);
        mAmazonApplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(i);
            }
        });

        mLinkedInApplyBtn = (Button) findViewById(R.id.linkedin_apply_now_btn);
        mSopraApplyBtn = (Button) findViewById(R.id.sopra_apply_now_btn);
        mHclApplyBtn = (Button) findViewById(R.id.hcl_apply_now_btn);
        mInfosysApplyBtn = (Button) findViewById(R.id.infosys_apply_now_btn);
        mTcsApplyBtn = (Button) findViewById(R.id.tcs_apply_now_btn);
        mWiproApplyBtn = (Button) findViewById(R.id.wipro_apply_now_btn);
        mCognizantApplyBtn = (Button) findViewById(R.id.cognizant_apply_now_btn);
        mAccentureApplyBtn = (Button) findViewById(R.id.accenture_apply_now_btn);
        mFacebookApplyBtn = (Button) findViewById(R.id.facebook_apply_now_btn);

        mLinkedInApplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), LinkedIn.class);
                view.getContext().startActivity(i);
            }
        });

        mSopraApplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), Sopra.class);
                view.getContext().startActivity(i);
            }
        });

        mHclApplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), HCL.class);
                view.getContext().startActivity(i);
            }
        });

        mInfosysApplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), Infosys.class);
                view.getContext().startActivity(i);
            }
        });

        mTcsApplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), TCS.class);
                view.getContext().startActivity(i);
            }
        });

        mWiproApplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), Wipro.class);
                view.getContext().startActivity(i);
            }
        });

        mCognizantApplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), Cognizant.class);
                view.getContext().startActivity(i);
            }
        });

        mAccentureApplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), Accenture.class);
                view.getContext().startActivity(i);
            }
        });

        mFacebookApplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), Facebook.class);
                view.getContext().startActivity(i);
            }
        });

//        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//
//        mAdapter = new CompanyAdapter();
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mAdapter);


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
