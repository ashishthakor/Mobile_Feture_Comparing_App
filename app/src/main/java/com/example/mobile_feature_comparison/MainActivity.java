package com.example.mobile_feature_comparison;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    ArrayList<MobileModel> mobileModels = new ArrayList<>();
    SharedPreference sharedPreference;
    @BindView(R.id.selection)
    RecyclerView selection;
    @BindView(R.id.compare)
    TextView compare;
    AlertDialog.Builder alertDialog;
    SelectionAdapter selectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sharedPreference = new SharedPreference(getApplicationContext());
        alertDialog = new android.app.AlertDialog.Builder(getApplicationContext());


        MobileModel mobile1 = new MobileModel();


        mobile1.setId(1);
        mobile1.setCompany_name("OnePlus");
        mobile1.setMobile_name("8T pro");
        mobile1.setPrice(57999);
        mobile1.setScreen_size(6.7);
        mobile1.setScreen_W(1440);
        mobile1.setScreen_H(3168);
        mobile1.setMegapixel_front(16);
        mobile1.setMegapixel_back(64);
        mobile1.setRAM_size(12);
        mobile1.setBattery_size(4850);
        mobile1.setNumber_of_cores(8);
        mobile1.setRating(4.5);
        mobile1.setSelected(false);
        mobile1.setCharging_type("20W fast C-type");
        mobileModels.add(mobile1);


        MobileModel mobile2 = new MobileModel();
        mobile2.setId(2);
        mobile2.setCompany_name("Google");
        mobile2.setMobile_name("Pixel 4a");
        mobile2.setPrice(25899);
        mobile2.setScreen_size(5.81);
        mobile2.setScreen_W(1080);
        mobile2.setScreen_H(2340);
        mobile2.setMegapixel_front(8);
        mobile2.setMegapixel_back(12);
        mobile2.setRAM_size(8);
        mobile2.setBattery_size(3140);
        mobile2.setNumber_of_cores(8);
        mobile2.setSelected(false);
        mobile2.setRating(3.5);
        mobile2.setCharging_type("18W fast");
        mobileModels.add(mobile2);

        MobileModel mobile3 = new MobileModel();
        mobile3.setId(3);
        mobile3.setCompany_name("MI");
        mobile3.setMobile_name("10T pro");
        mobile3.setPrice(39999);
        mobile3.setScreen_size(6.67);
        mobile3.setScreen_W(1080);
        mobile3.setScreen_H(2400);
        mobile3.setMegapixel_front(20);
        mobile3.setMegapixel_back(108);
        mobile3.setRAM_size(6);
        mobile3.setBattery_size(5000);
        mobile3.setNumber_of_cores(8);
        mobile3.setSelected(false);
        mobile3.setRating(1.5);
        mobile3.setCharging_type("33W fast");
        mobileModels.add(mobile3);

        MobileModel mobile4 = new MobileModel();
        mobile4.setId(4);
        mobile4.setCompany_name("OnePlus");
        mobile4.setMobile_name("8T");
        mobile4.setPrice(38999);
        mobile4.setScreen_size(6.55);
        mobile4.setScreen_W(1080);
        mobile4.setScreen_H(2400);
        mobile4.setMegapixel_front(16);
        mobile4.setMegapixel_back(48);
        mobile4.setRAM_size(8);
        mobile4.setBattery_size(4500);
        mobile4.setNumber_of_cores(8);
        mobile4.setSelected(false);
        mobile4.setRating(4.3);
        mobile4.setCharging_type("65W fast C-type");
        mobileModels.add(mobile4);

        MobileModel mobile5 = new MobileModel();
        mobile5.setId(5);
        mobile5.setCompany_name("Vivo");
        mobile5.setMobile_name("V20");
        mobile5.setPrice(21799);
        mobile5.setScreen_size(6.44);
        mobile5.setScreen_W(1080);
        mobile5.setScreen_H(2400);
        mobile5.setMegapixel_front(44);
        mobile5.setMegapixel_back(64);
        mobile5.setRAM_size(6);
        mobile5.setBattery_size(4000);
        mobile5.setNumber_of_cores(8);
        mobile5.setSelected(false);
        mobile5.setRating(3.5);
        mobile5.setCharging_type("45W fast Charging");
        mobileModels.add(mobile5);


        setselection(mobileModels);
        compare.setOnClickListener(new View.OnClickListener() {
            ArrayList<MobileModel> selected_mobile = new ArrayList<>();
            int selection1, selection2;

            @Override
            public void onClick(View v) {
                for (int i = 0; i < mobileModels.size(); i++) {
                    if (mobileModels.get(i).isSelected()) {
                        mobileModels.get(i).setSelected(false);
                        selected_mobile.add(mobileModels.get(i));
                    }
                }
                if (selected_mobile.size() == 2) {
                    sharedPreference.setselectedmobile(selected_mobile);
                    selected_mobile.clear();

                    Intent i = new Intent(getApplicationContext(), Choose_mobile.class);
                    startActivity(i);

                } else if (selected_mobile.size() == 1) {
                    showToast("please select another mobile!");
                    selected_mobile.clear();
                    setselection(mobileModels);
                } else if (selected_mobile.size() == 0) {
                    showToast("please select 2 mobiles!");
                    selected_mobile.clear();
                    setselection(mobileModels);
                } else if (selected_mobile.size() > 2) {
                    showToast("Do no select more than 2 mobiles!");
                    selected_mobile.clear();
                    setselection(mobileModels);
                }
            }
        });
    }

    private void  (ArrayList<MobileModel> mobileModels) {
        selectionAdapter = new SelectionAdapter(getApplicationContext(), mobileModels);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        selection.setLayoutManager(mLayoutManager);
        selection.setAdapter(selectionAdapter);
        selection.setNestedScrollingEnabled(false);
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }

}