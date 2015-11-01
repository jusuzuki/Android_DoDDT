package com.epicodus.doddt.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.epicodus.doddt.R;
import com.epicodus.doddt.models.Song;

import java.util.ArrayList;

/**
 * Created by jusuzuki on 11/1/15.
 */
public class SongAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Song> mSongs;

    public SongAdapter (Context context, ArrayList<Song> songs){
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.song_list_item, null);
            holder = new ViewHolder();
            holder.artistLabel = (TextView) convertView.findViewById(R.id.artistLabel);
            holder.titleLabel = (TextView) convertView.findViewById(R.id.titleLabel);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Song song = mSongs.get(position);

        holder.artistLabel.setText(song.getmArtist());
        holder.titleLabel.setText(song.getmTitle());

        return convertView;
    }

    private static class ViewHolder {
        TextView artistLabel;
        TextView titleLabel;
    }
}
