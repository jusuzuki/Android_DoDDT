package com.epicodus.doddt.admin;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.epicodus.doddt.R;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AdminActivity extends AppCompatActivity {

    @Bind(R.id.addPhotoButton) Button mAddPhotoButton;
    @Bind(R.id.goToAddQuoteButton) Button mGoToAddQuoteButton;


    public static final int PICK_PHOTO_REQUEST = 2;

    protected Uri mMediaUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ButterKnife.bind(this);

        mAddPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent choosePhotoIntent = new Intent(Intent.ACTION_GET_CONTENT);
                choosePhotoIntent.setType("image/*");
                startActivityForResult(choosePhotoIntent, PICK_PHOTO_REQUEST);
            }
        });
    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == PICK_PHOTO_REQUEST){
                if (data == null){
                    Toast.makeText(getApplicationContext(), "PROBLEM DATA NULL", Toast.LENGTH_SHORT).show();
                }
                else {
                    mMediaUri = data.getData();
                    try {
                        Bitmap bitmapImage = MediaStore.Images.Media.getBitmap(this.getContentResolver(), mMediaUri);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        bitmapImage.compress(Bitmap.CompressFormat.PNG, 10, stream);
                        byte[] byteArray = stream.toByteArray();
                        ParseFile file = new ParseFile("image.png", byteArray);
                        ParseObject object = new ParseObject("Image");
                        object.put("image", file);
                        ParseACL parseACL = new ParseACL();
                        parseACL.setPublicReadAccess(true);
                        object.setACL(parseACL);
                        object.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                if( e == null) {
                                    Toast.makeText(getApplication().getBaseContext(), "Your image has been posted", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getApplication().getBaseContext(), "There was an error - please try again", Toast.LENGTH_LONG).show();
                                }
                            }
                        });

                    } catch (IOException e) {
                        Toast.makeText(getApplication().getBaseContext(), "There was an error - please try again", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }

                }
            }
        }
        else if (resultCode != RESULT_CANCELED){
            Toast.makeText(getApplicationContext(),"PROBLEM",Toast.LENGTH_SHORT).show();
        }
    }

}
