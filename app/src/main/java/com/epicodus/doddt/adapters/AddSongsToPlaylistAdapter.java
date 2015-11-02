package com.epicodus.doddt.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.doddt.R;
import com.epicodus.doddt.models.PlaylistSong;
import com.epicodus.doddt.models.Song;
import com.epicodus.doddt.models.Playlist;

import com.epicodus.doddt.ui.PlaylistActivity;

import java.util.ArrayList;

/**
 * Created by jusuzuki on 11/1/15.
 */
public class AddSongsToPlaylistAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Song> mSongs;

    public AddSongsToPlaylistAdapter (Context context, ArrayList<Song> songs){
        mSongs = songs;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mSongs.size();
    }

    @Override
    public Object getItem(int position) {
        return mSongs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.add_song_list_item, null);
            holder = new ViewHolder();
            holder.artistLabel = (TextView) convertView.findViewById(R.id.artistLabel);
            holder.titleLabel = (TextView) convertView.findViewById(R.id.titleLabel);
            holder.addToPlaylistButton = (Button) convertView.findViewById(R.id.addToPlaylistButton);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Song song = mSongs.get(position);

        holder.artistLabel.setText(song.getArtist());
        holder.titleLabel.setText(song.getTitle());
        holder.addToPlaylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, PlaylistActivity.class);

                //PROBLEM CAPTURING THE PLAYLIST NAME FROM THE CONTEXT ABOVE THE ADAPTER!!!
                String playlistTitle = intent.getStringExtra("playlistTitle");
                //HAD TO HARDCODE THE PLAYLIST NAME
                Playlist playlist = Playlist.find("another");

                PlaylistSong addToPlaylist = new PlaylistSong(playlist, song);
                addToPlaylist.save();

                intent.putExtra("playlistTitle", playlistTitle);

                mContext.startActivity(intent);
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        TextView artistLabel;
        TextView titleLabel;
        Button addToPlaylistButton;
    }
}
