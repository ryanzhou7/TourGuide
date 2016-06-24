package com.ryanzhou.company.tourguide.model;

/**
 * Created by ryanzhou on 6/23/16.
 */
public class Startup {
    private String mName;
    private int mImageResource;

    public Startup(String name, int drawableResource) {
        this.setName(name);
        this.setImageResource(drawableResource);
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public void setImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

}
