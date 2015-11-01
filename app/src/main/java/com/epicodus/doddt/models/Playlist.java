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

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public Song getSong() {
        return mSong;
    }

    public void setSong(Song mSong) {
        this.mSong = mSong;
    }

    public static List<Playlist> all(){
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
