package com.epicodus.doddt.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.epicodus.doddt.R;

public class MainActivity extends AppCompatActivity {

    private Button mTimezoneButton;
    private Button mQuotesButton;
    private Button mGalleryButton;
    private Button mPlaylistButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimezoneButton = (Button) findViewById(R.id.timezoneButton);
        mQuotesButton = (Button) findViewById(R.id.quotesButton);
        mGalleryButton = (Button) findViewById(R.id.galleryButton);
        mPlaylistButton = (Button) findViewById(R.id.playlistButton);


        mTimezoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TimezoneActivity.class);
                startActivity(intent);
            }
        });

        mGalleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
                startActivity(intent);
            }
        });

        mQuotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuoteActivity.class);
                startActivity(intent);
            }
        });

        mPlaylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllPlaylistsActivity.class);
                startActivity(intent);
            }
        });


    }


}
