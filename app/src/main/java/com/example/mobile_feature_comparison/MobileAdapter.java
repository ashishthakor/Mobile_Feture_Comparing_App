package com.example.mobile_feature_comparison;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.mobile_feature_comparison.R.drawable.*;

public class MobileAdapter extends RecyclerView.Adapter<MobileAdapter.ViewHolder> {
    Context context;
    ArrayList<MobileModel> mobileModels;

    public MobileAdapter(Context context, ArrayList<MobileModel> mobileModels) {
        this.context = context;
        this.mobileModels = mobileModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.mobile_adapter, parent, false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.company_name.setText(String.valueOf(mobileModels.get(position).getCompany_name()));
        holder.mobile_name.setText(String.valueOf(mobileModels.get(position).getMobile_name()));
        holder.price.setText(String.valueOf(mobileModels.get(position).getPrice()));
        holder.screeninch.setText(String.valueOf(mobileModels.get(position).getScreen_size()));
        holder.handw.setText(String.valueOf(mobileModels.get(position).getScreen_H() + " x " + String.valueOf(mobileModels.get(position).getScreen_W()) + " pixels"));
        holder.megapixel.setText(String.valueOf(mobileModels.get(position).getMegapixel_front()));
        holder.megapixelback.setText(String.valueOf(mobileModels.get(position).getMegapixel_back()));
        holder.Ram.setText(String.valueOf(mobileModels.get(position).getRAM_size()));
        holder.core.setText(String.valueOf(mobileModels.get(position).getNumber_of_cores()));
        holder.battery.setText(String.valueOf(mobileModels.get(position).getBattery_size()));
        holder.charging_type.setText(String.valueOf(mobileModels.get(position).getCharging_type()));
        holder.ratting.setText(String.valueOf(mobileModels.get(position).getRating()));
        holder.price1.setText(String.valueOf(mobileModels.get(position).getPrice()));
        if (mobileModels.get(position).getId() == 1)
            holder.mobile_image.setImageDrawable(context.getDrawable(one));
        else if (mobileModels.get(position).getId() == 2)
            holder.mobile_image.setImageDrawable(context.getDrawable(two));
        else if (mobileModels.get(position).getId() == 3)
            holder.mobile_image.setImageDrawable(context.getDrawable(three));
        else if (mobileModels.get(position).getId() == 4)
            holder.mobile_image.setImageDrawable(context.getDrawable(four));
        else if (mobileModels.get(position).getId() == 5)
            holder.mobile_image.setImageDrawable(context.getDrawable(five));

    }

    @Override
    public int getItemCount() {

        return mobileModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.company_name)
        TextView company_name;

        @BindView(R.id.mobile_name)
        TextView mobile_name;

        @BindView(R.id.price)
        TextView price;

        @BindView(R.id.screeninch)
        TextView screeninch;

        @BindView(R.id.handw)
        TextView handw;

        @BindView(R.id.megapixel)
        TextView megapixel;

        @BindView(R.id.megapixelback)
        TextView megapixelback;

        @BindView(R.id.Ram)
        TextView Ram;

        @BindView(R.id.core)
        TextView core;

        @BindView(R.id.battery)
        TextView battery;

        @BindView(R.id.charging_type)
        TextView charging_type;

        @BindView(R.id.ratting)
        TextView ratting;

        @BindView(R.id.price1)
        TextView price1;

        @BindView(R.id.buy)
        TextView buy;

        @BindView(R.id.mobile_image)
        ImageView mobile_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
    }
}
