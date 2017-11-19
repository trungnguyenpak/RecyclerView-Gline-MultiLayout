package com.trungnguyeen.exerciseweek89_recyclerview_internetimage_multilayout.model;

import java.io.Serializable;

/**
 * Created by trungnguyeen on 11/19/17.
 */

public class Food implements Serializable{

    private String mName;
    private String mImageUrl;
    private String mPrice;

    public Food() {
    }


    public Food(String mName, String mPrice, String mImageUrl) {
        this.mName = mName;
        this.mPrice = mPrice;
        this.mImageUrl = mImageUrl;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }
}
