package com.epicodus.doddt.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by jusuzuki on 11/1/15.
 */
@Table(name = "Playlist", id = "_id")
public class Playlist extends Model {

    @Column(name = "Name")
    public String mName;

    @Column(name = "Song")
    public Song mSong;

    public Playlist(){
        super();
    }

    public Playlist(String name, Song song){
        super();
        mName = name;
        mSong = song;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Song getmSong() {
        return mSong;
    }

    public void setmSong(Song mSong) {
        this.mSong = mSong;
    }

    public List<Playlist> all(){
        return new Select()
                .from(Playlist.class)
                .execute();
    }

    public List<Playlist> getPlaylist(String name){
        return new Select()
                .from(Playlist.class)
                .where("Name = ?", name)
                .execute();
    }
}
