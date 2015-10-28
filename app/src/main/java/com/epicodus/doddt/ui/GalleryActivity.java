package com.epicodus.doddt.ui;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.doddt.R;
import com.epicodus.doddt.models.Gallery;
import com.epicodus.doddt.models.GalleryLib;

public class GalleryActivity extends AppCompatActivity {

    private TextView mGalleryText;
    private ImageView mGalleryView;
    private Button mNextButton;
    private Gallery mCurrentGallery;
    private GalleryLib mGalleryLib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mGalleryText = (TextView) findViewById(R.id.galleryText);
        mGalleryView = (ImageView) findViewById(R.id.galleryView);
        mNextButton = (Button) findViewById(R.id.nextButton);
        mGalleryLib = new GalleryLib();
        mCurrentGallery = mGalleryLib.getGallery().get(0);

        setLayoutContent();

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentGallery = mGalleryLib.nextGallery(mCurrentGallery);
                setLayoutContent();
            }
        });

    }

    private void setLayoutContent() {
        mGalleryText.setText(mCurrentGallery.getGalleryText());
        mGalleryView.setImageResource(mCurrentGallery.getImage());
    }


}
