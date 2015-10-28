package com.epicodus.doddt.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.doddt.R;
import com.epicodus.doddt.models.Quote;
import com.epicodus.doddt.models.QuoteLib;

import org.w3c.dom.Text;

public class QuoteActivity extends AppCompatActivity {

    private TextView mQuoteText;
    private TextView mQuoteAuthor;
    private Button mNextQuote;
    private QuoteLib mQuoteLib;
    private Quote mCurrentQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        mQuoteText = (TextView) findViewById(R.id.quoteText);
        mQuoteAuthor = (TextView) findViewById(R.id.quoteAuthor);
        mNextQuote = (Button) findViewById(R.id.nextQuote);
        mQuoteLib = new QuoteLib();
        mCurrentQuote = mQuoteLib.getQuotes().get(0);

        setLayoutContent();

        mNextQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentQuote = mQuoteLib.nextQuote(mCurrentQuote);
                setLayoutContent();
            }
        });

    }

    private void setLayoutContent() {
        mQuoteText.setText(mCurrentQuote.getText());
        mQuoteAuthor.setText(mCurrentQuote.getAuthor());
    }


}
