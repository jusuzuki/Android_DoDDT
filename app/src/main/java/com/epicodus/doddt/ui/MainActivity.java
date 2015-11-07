package com.epicodus.doddt.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.epicodus.doddt.R;
import com.epicodus.doddt.admin.AdminActivity;
import com.parse.ParseObject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.timezoneButton) Button mTimezoneButton;
    @Bind(R.id.quotesButton) Button mQuotesButton;
    @Bind(R.id.galleryButton) Button mGalleryButton;
    @Bind(R.id.playlistButton) Button mPlaylistButton;
    @Bind(R.id.doddtButton) Button mAdminButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

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

        mAdminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                startActivity(intent);
            }
        });



    }


}
