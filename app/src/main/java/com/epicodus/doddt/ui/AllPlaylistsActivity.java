package com.epicodus.doddt.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.doddt.R;
import com.epicodus.doddt.adapters.PlaylistAdapter;
import com.epicodus.doddt.models.Playlist;

import java.util.ArrayList;

public class AllPlaylistsActivity extends ListActivity {

    private Button mAddNewPlaylistButton;
    private Button mAddNewSongButton;
    private Button mViewAllSongsButton;
    private PlaylistAdapter mAdapter;
    private ArrayList<Playlist> mPlaylists;
    private TextView mDisplaySomething;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_playlists);

        mAddNewPlaylistButton = (Button) findViewById(R.id.addNewPlaylistButton);
        mAddNewSongButton = (Button) findViewById(R.id.addNewSongButton);
        mViewAllSongsButton = (Button) findViewById(R.id.viewAllSongsButton);

        mPlaylists = (ArrayList) Playlist.all();
        mAdapter = new PlaylistAdapter(this, mPlaylists);

        setListAdapter(mAdapter);

        mDisplaySomething = (TextView) findViewById(R.id.displaySomething);
        mDisplaySomething.setText("PLAYLISTS");

        mAddNewSongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllPlaylistsActivity.this, NewSongActivity.class);
                startActivity(intent);
            }
        });

        mViewAllSongsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllPlaylistsActivity.this, ViewAllSongsActivity.class);
                startActivity(intent);
            }
        });

        mAddNewPlaylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllPlaylistsActivity.this, AddNewPlaylistActivity.class);
                startActivity(intent);
            }
        });
    }

}
