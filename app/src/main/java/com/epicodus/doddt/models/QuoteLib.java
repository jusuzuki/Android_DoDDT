package com.epicodus.doddt.models;

import java.util.ArrayList;

/**
 * Created by Guest on 10/27/15.
 */
public class QuoteLib {

    public ArrayList<Quote> getQuotes(){
        return mQuotes;
    }

    private ArrayList<Quote> mQuotes;

    public QuoteLib(){
        setQuotes();
    }

    private void setQuotes() {
        mQuotes = new ArrayList<>();

        mQuotes.add(new Quote (
                "I think...that I would rather recollect a life mis-spent on fragile things than spent avoiding moral debt.",
                "Neil Gaiman"
        ));

        mQuotes.add(new Quote (
                "There are so many fragile things, after all. People break so easily, and so do dreams and hearts.",
                "Neil Gaiman"
        ));
    }

    public Quote nextQuote(Quote currentQuote){
        int index = mQuotes.indexOf(currentQuote);
        if(index == mQuotes.size() - 1){
            return mQuotes.get(0);
        } else {
            return mQuotes.get(index + 1);
        }
    }

}
