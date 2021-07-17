package com.example.mobile_feature_comparison;

import  android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.io.Serializable;

public class MobileModel implements Serializable {

    String mobile_name;
    String company_name;
    String charging_type;

    int id,price, screen_W,screen_H, megapixel_back,RAM_size,battery_size,number_of_cores,megapixel_front;
    Double rating,  screen_size;
    boolean selected;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Double getScreen_size() {
        return screen_size;
    }

    public void setScreen_size(Double screen_size) {
        this.screen_size = screen_size;
    }

    public String getMobile_name() {
        return mobile_name;
    }

    public void setMobile_name(String mobile_name) {
        this.mobile_name = mobile_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCharging_type() {
        return charging_type;
    }

    public void setCharging_type(String charging_type) {
        this.charging_type = charging_type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getScreen_W() {
        return screen_W;
    }

    public void setScreen_W(int screen_W) {
        this.screen_W = screen_W;
    }

    public int getScreen_H() {
        return screen_H;
    }

    public void setScreen_H(int screen_H) {
        this.screen_H = screen_H;
    }

    public int getMegapixel_back() {
        return megapixel_back;
    }

    public void setMegapixel_back(int megapixel_back) {
        this.megapixel_back = megapixel_back;
    }

    public int getRAM_size() {
        return RAM_size;
    }

    public void setRAM_size(int RAM_size) {
        this.RAM_size = RAM_size;
    }

    public int getBattery_size() {
        return battery_size;
    }

    public void setBattery_size(int battery_size) {
        this.battery_size = battery_size;
    }

    public int getNumber_of_cores() {
        return number_of_cores;
    }

    public void setNumber_of_cores(int number_of_cores) {
        this.number_of_cores = number_of_cores;
    }

    public int getMegapixel_front() {
        return megapixel_front;
    }

    public void setMegapixel_front(int megapixel_front) {
        this.megapixel_front = megapixel_front;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }


}
