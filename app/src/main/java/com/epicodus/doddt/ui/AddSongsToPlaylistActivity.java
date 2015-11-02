package com.epicodus.doddt.ui;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.epicodus.doddt.R;
import com.epicodus.doddt.adapters.AddSongsToPlaylistAdapter;
import com.epicodus.doddt.adapters.SongsInPlaylistAdapter;
import com.epicodus.doddt.models.Playlist;
import com.epicodus.doddt.models.Song;

import java.util.ArrayList;
import java.util.List;

public class AddSongsToPlaylistActivity extends ListActivity {

    private TextView mPlaylistTitle;
    private AddSongsToPlaylistAdapter mAdapter;
    private ArrayList<Song> mSongs;
    private Playlist mPlaylist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_songs_to_playlist);

        mPlaylistTitle = (TextView) findViewById(R.id.playlistTitle);
        final String playlistTitle = getIntent().getStringExtra("playlistTitle");
        mPlaylistTitle.setText(playlistTitle);

        mSongs = (ArrayList) Song.all();
        mAdapter = new AddSongsToPlaylistAdapter(this, mSongs);
        setListAdapter(mAdapter);

    }


}
