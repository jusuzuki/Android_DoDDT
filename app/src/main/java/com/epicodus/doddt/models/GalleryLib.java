package com.epicodus.doddt.models;

import com.epicodus.doddt.R;

import java.util.ArrayList;

/**
 * Created by Guest on 10/27/15.
 */
public class GalleryLib {

    public ArrayList<Gallery> getGallery(){
        return mGallery;
    }

    private ArrayList<Gallery> mGallery;

    public GalleryLib(){
        setGallery();
    }

    private void setGallery(){
        mGallery = new ArrayList<>();

        mGallery.add(new Gallery (
                "First image",
                R.drawable.photo_01
        ));

        mGallery.add(new Gallery (
                "Second image",
                R.drawable.photo_02
        ));

        mGallery.add(new Gallery (
                "Third image",
                R.drawable.photo_03
        ));

        mGallery.add(new Gallery (
                "Fourth image",
                R.drawable.photo_04
        ));

        mGallery.add(new Gallery (
                "Fifth image",
                R.drawable.photo_05
        ));
    }

    public Gallery nextGallery(Gallery currentGallery) {
        int index = mGallery.indexOf(currentGallery);
        if(index == mGallery.size() - 1){
            return mGallery.get(0);
        } else {
            return mGallery.get(index + 1);
        }
    }
}
