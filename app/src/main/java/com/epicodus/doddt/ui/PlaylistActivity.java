package com.epicodus.doddt.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.doddt.R;
import com.epicodus.doddt.adapters.SongAdapter;
import com.epicodus.doddt.models.Playlist;
import com.epicodus.doddt.models.Song;

import java.util.ArrayList;

public class PlaylistActivity extends ListActivity {

    private Button mAddNewPlaylistButton;
    private Button mAddNewSongButton;
    private SongAdapter mAdapter;
    private ArrayList<Song> mSongs;
    private TextView mDisplaySomething;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        mAddNewPlaylistButton = (Button) findViewById(R.id.addNewPlaylistButton);
        mAddNewSongButton = (Button) findViewById(R.id.addNewSongButton);

        mSongs = (ArrayList) Song.all();
        mAdapter = new SongAdapter(this, mSongs);
        setListAdapter(mAdapter);

        mDisplaySomething = (TextView) findViewById(R.id.displaySomething);
        mDisplaySomething.setText(mSongs.get(0).getmArtist().toString());

        mAddNewSongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlaylistActivity.this, NewSongActivity.class);
                startActivity(intent);
            }
        });
    }

}
