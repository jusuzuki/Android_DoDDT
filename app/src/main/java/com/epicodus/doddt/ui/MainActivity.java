package com.epicodus.doddt.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.epicodus.doddt.R;

public class MainActivity extends AppCompatActivity {

    private Button mTimezoneButton;
    private Button mSpinchatButton;
    private Button mQuotesButton;
    private Button mGalleryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimezoneButton = (Button) findViewById(R.id.timezoneButton);
        mSpinchatButton = (Button) findViewById(R.id.spinchatButton);
        mQuotesButton = (Button) findViewById(R.id.quotesButton);
        mGalleryButton = (Button) findViewById(R.id.galleryButton);

        mTimezoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TimezoneActivity.class);
                startActivity(intent);
            }
        });


    }


}
