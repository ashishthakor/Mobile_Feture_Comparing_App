package com.example.mobile_feature_comparison;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectionAdapter extends RecyclerView.Adapter<SelectionAdapter.ViewHolder> {
    Context context;
    ArrayList<MobileModel> mobileModels;


    public SelectionAdapter(Context context, ArrayList<MobileModel> mobileModels) {
        this.context = context;
        this.mobileModels = mobileModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.selection_adapter, parent, false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.company.setText(String.valueOf(mobileModels.get(position).getCompany_name()+" "));
    holder.mobile.setText(String.valueOf(mobileModels.get(position).getMobile_name()+" "));
   holder.selectCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
       @Override
       public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
           mobileModels.get(position).setSelected(isChecked);
       }
   });
    }

    @Override
    public int getItemCount() {

        return mobileModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.company)
        TextView company;

        @BindView(R.id.mobile)
        TextView mobile;

         @BindView(R.id.select)
         CheckBox selectCB;

         public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
