package com.epicodus.doddt.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.doddt.R;
import com.epicodus.doddt.models.Song;

public class NewSongActivity extends AppCompatActivity {

    private Button mNewSongButton;
    private EditText mNewTitleInput;
    private EditText mNewArtistInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_song);

        mNewSongButton = (Button) findViewById(R.id.addSongButton);
        mNewTitleInput = (EditText) findViewById(R.id.newTitleInput);
        mNewArtistInput = (EditText) findViewById(R.id.newArtistInput);

        mNewSongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSong();
                Intent intent = new Intent(NewSongActivity.this, AllPlaylistsActivity.class);
                startActivity(intent);
            }
        });

    }

    private void addSong(){
        String artist = mNewArtistInput.getText().toString();
        String title = mNewTitleInput.getText().toString();
        String user = "Ju";
        Song song = new Song(artist, title, user);
        song.save();
    }
}
