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
import com.epicodus.doddt.models.Playlist;
import com.epicodus.doddt.ui.PlaylistActivity;

import java.util.ArrayList;

/**
 * Created by jusuzuki on 11/1/15.
 */
public class PlaylistAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Playlist> mPlaylists;

    public PlaylistAdapter(Context context, ArrayList<Playlist> playlists){
        mPlaylists = playlists;
        mContext = context;
    }

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
            holder.playlistViewButton = (Button) convertView.findViewById(R.id.playlistViewButton);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Playlist playlist = mPlaylists.get(position);

        holder.playlistNameLabel.setText(playlist.getName().toString());
        holder.playlistViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (mContext, PlaylistActivity.class);
                intent.putExtra("playlistTitle", playlist.getName());
                mContext.startActivity(intent);
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        TextView playlistNameLabel;
        Button playlistViewButton;
    }
}
