package com.epicodus.doddt.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by jusuzuki on 11/1/15.
 */
@Table(name = "playlist_songs", id = "_id")
public class PlaylistSong extends Model {

    @Column(name = "Playlist")
    public Playlist mPlaylist;

    @Column(name = "Song")
    public Song mSong;

    public PlaylistSong(){
        super();
    }

    public PlaylistSong(Playlist playlist, Song song){
        super();
        mPlaylist = playlist;
        mSong = song;
    }
}
