package com.epicodus.doddt.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.epicodus.doddt.R;
import com.epicodus.doddt.models.Playlist;

import java.util.ArrayList;

/**
 * Created by jusuzuki on 11/1/15.
 */
public class PlaylistAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Playlist> mPlaylists;

    @Override
    public int getCount() {
        return mPlaylists.size();
    }

    @Override
    public Object getItem(int position) {
        return mPlaylists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.playlist_list_item, null);
            holder = new ViewHolder();
            holder.playlistNameLabel = (TextView) convertView.findViewById(R.id.playlistNameLabel);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Playlist playlist = mPlaylists.get(position);

        holder.playlistNameLabel.setText(playlist.getName().toString());

        return convertView;
    }

    private static class ViewHolder {
        TextView playlistNameLabel;
    }
}
