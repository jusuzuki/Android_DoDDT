package com.epicodus.doddt.ui;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.epicodus.doddt.R;
import com.epicodus.doddt.adapters.SongAdapter;
import com.epicodus.doddt.models.Song;

import java.util.ArrayList;

public class ViewAllSongsActivity extends ListActivity {

    private SongAdapter mAdapter;
    private ArrayList<Song> mSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_songs);

        mSongs = (ArrayList) Song.all();
        mAdapter = new SongAdapter(this, mSongs);

        setListAdapter(mAdapter);
    }


}
