package com.epicodus.doddt.models;

/**
 * Created by Guest on 10/27/15.
 */
public class Gallery {

    private String mGalleryText;
    private int mImage;

    public Gallery(String galleryText, int image) {
        mGalleryText = galleryText;
        mImage = image;
    }

    public String getGalleryText() {
        return mGalleryText;
    }

    public void setGalleryText(String galleryText) {
        mGalleryText = galleryText;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }
}
