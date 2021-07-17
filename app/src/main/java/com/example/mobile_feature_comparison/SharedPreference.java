package com.example.mobile_feature_comparison;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPreference {

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private Context mContext;

    public SharedPreference(Context context) {
        mContext = context;
        mSharedPreferences = mContext.getSharedPreferences("app",0);
        mEditor = mSharedPreferences.edit();
    }

    public ArrayList<MobileModel> getselectedmobile() {
        String data = mSharedPreferences.getString("selectedmobile", "NoData");
        if(data.equals("NoData"))
        {
            return new ArrayList<MobileModel>();
        }
        else
        {
            Gson gson = new Gson();
            MobileModel[] userItems = gson.fromJson(data, MobileModel[].class);
            List<MobileModel> selected = Arrays.asList(userItems);
            selected = new ArrayList<MobileModel>(selected);
            return (ArrayList<MobileModel>) selected;
        }
    }

    public void setselectedmobile(ArrayList<MobileModel> select) {
        Gson gson = new Gson();
        String selected = gson.toJson(select);
        mEditor.putString("selectedmobile", selected);
        mEditor.commit();
    }

}
