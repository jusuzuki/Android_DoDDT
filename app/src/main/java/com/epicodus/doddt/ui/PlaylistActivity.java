package com.epicodus.doddt.ui;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.doddt.R;
import com.epicodus.doddt.adapters.SongsInPlaylistAdapter;
import com.epicodus.doddt.models.Playlist;
import com.epicodus.doddt.models.Song;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PlaylistActivity extends ListActivity {

    private TextView mPlaylistNameText;
    private Button mAddSongsToPlaylistButton;
    private SongsInPlaylistAdapter mAdapter;
    private ArrayList<Song> mSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        mPlaylistNameText = (TextView) findViewById(R.id.playlistNameText);
        mAddSongsToPlaylistButton = (Button) findViewById(R.id.addSongsToPlaylistButton);

        String playlistTitle = getIntent().getStringExtra("playlistTitle");
        mPlaylistNameText.setText(playlistTitle);

        mSongs = (ArrayList) Song.all();
        mAdapter = new SongsInPlaylistAdapter(this, mSongs);
        setListAdapter(mAdapter);


    }


}
