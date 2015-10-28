package com.epicodus.doddt.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Guest on 10/27/15.
 */


public class Quote extends Model {

    private String mText;
    private String mAuthor;

    public Quote(String text, String author){
        mText = text;
        mAuthor = author;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }
}
