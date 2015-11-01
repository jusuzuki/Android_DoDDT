package com.epicodus.doddt.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by jusuzuki on 11/1/15.
 */
@Table(name = "Song", id = "_id")
public class Song extends Model{

    @Column(name="Artist")
    private String mArtist;

    @Column(name="Title")
    private String mTitle;

    @Column(name="User")
    private String mUser;

    public Song(){
        super();
    }

    public Song(String artist, String title, String user){
        super();
        mArtist = artist;
        mTitle = title;
        mUser = user;
    }

    public String getmArtist() {
        return mArtist;
    }

    public void setmArtist(String mArtist) {
        this.mArtist = mArtist;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmUser() {
        return mUser;
    }

    public void setmUser(String mUser) {
        this.mUser = mUser;
    }

    public static List<Song> all(){
        return new Select()
                .from(Song.class)
                .execute();
    }
}
