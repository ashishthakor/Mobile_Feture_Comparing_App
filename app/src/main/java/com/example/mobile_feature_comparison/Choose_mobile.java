package com.example.mobile_feature_comparison;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Choose_mobile extends AppCompatActivity {
    @BindView(R.id.mobile1)
    RecyclerView mobile1;

    @BindView(R.id.mobile2)
    RecyclerView mobile2;


    ArrayList<MobileModel> choosen_mobile1 = new ArrayList<>();
    ArrayList<MobileModel> choosen_mobile2 = new ArrayList<>();
    ArrayList<MobileModel> selection = new ArrayList<>();
    SharedPreference sharedPreference;
    MobileAdapter mobileAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mobile);
        ButterKnife.bind(this);
       sharedPreference = new SharedPreference(getApplicationContext());
       selection= sharedPreference.getselectedmobile();
       choosen_mobile1.add(selection.get(0));
       choosen_mobile2.add(selection.get(1));
        setMobile1();
        setMobile2();
    }

    public void setMobile1() {
        mobileAdapter = new MobileAdapter(getApplicationContext(), choosen_mobile1);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mobile1.setLayoutManager(mLayoutManager);
        mobile1.setAdapter(mobileAdapter);
        mobile1.setNestedScrollingEnabled(false);
    }

    public void setMobile2() {
        mobileAdapter = new MobileAdapter(getApplicationContext(), choosen_mobile2);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mobile2.setLayoutManager(mLayoutManager);
        mobile2.setAdapter(mobileAdapter);
        mobile2.setNestedScrollingEnabled(false);
    }
}