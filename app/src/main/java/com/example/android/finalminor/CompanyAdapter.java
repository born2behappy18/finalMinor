package com.example.android.finalminor;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by rajeev on 30/9/16.
 */
public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.MyViewHolder> {

    private TextView mCompanyNameBtn;
    private Button mApplyNowbtn;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View view) {

            super(view);
            mCompanyNameBtn = (TextView) view.findViewById(R.id.company_name_btn);
            mApplyNowbtn = (Button) view.findViewById(R.id.apply_now_btn);
        }
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.company_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        mCompanyNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(i);
            }
        });

        mApplyNowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), CompanyApply.class);
                view.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
