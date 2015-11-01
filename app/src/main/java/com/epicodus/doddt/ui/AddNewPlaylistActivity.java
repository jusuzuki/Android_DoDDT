package com.epicodus.doddt.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.doddt.R;
import com.epicodus.doddt.models.Playlist;

public class AddNewPlaylistActivity extends AppCompatActivity {

    private Button mCreateNewPlaylistButton;
    private EditText mNewPlaylistName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_playlist);

        mCreateNewPlaylistButton = (Button) findViewById(R.id.createNewPlaylistButton);
        mNewPlaylistName = (EditText) findViewById(R.id.newPlaylistName);

        mCreateNewPlaylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mNewPlaylistName.getText().toString();
                Playlist playlist = Playlist.newPlaylist(name);
                playlist.save();
                Intent intent = new Intent(AddNewPlaylistActivity.this, AllPlaylistsActivity.class);
                startActivity(intent);
            }
        });
    }

}
