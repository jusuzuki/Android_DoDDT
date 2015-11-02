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
import com.epicodus.doddt.adapters.SongsInPlaylistAdapter;
import com.epicodus.doddt.models.Playlist;
import com.epicodus.doddt.models.PlaylistSong;
import com.epicodus.doddt.models.Song;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PlaylistActivity extends ListActivity {

    private TextView mPlaylistNameText;
    private Button mAddSongsToPlaylistButton;
    private SongsInPlaylistAdapter mAdapter;
    private ArrayList<Song> mSongs;
    public String mPlaylistTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        mPlaylistNameText = (TextView) findViewById(R.id.playlistNameText);
        mAddSongsToPlaylistButton = (Button) findViewById(R.id.addSongsToPlaylistButton);

        final String playlistTitle = getIntent().getStringExtra("playlistTitle");
        mPlaylistTitle = playlistTitle;
        mPlaylistNameText.setText(playlistTitle);
        //Playlist playlist = Playlist.find(playlistTitle);

        mSongs = (ArrayList) PlaylistSong.getSongs(playlistTitle);
        mAdapter = new SongsInPlaylistAdapter(this, mSongs);
        setListAdapter(mAdapter);

        mAddSongsToPlaylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlaylistActivity.this, AddSongsToPlaylistActivity.class);
                intent.putExtra("playlistTitle", playlistTitle);
                startActivity(intent);
            }
        });


    }


}
