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

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String mArtist) {
        this.mArtist = mArtist;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getUser() {
        return mUser;
    }

    public void setUser(String mUser) {
        this.mUser = mUser;
    }

    public static List<Song> all(){
        return new Select()
                .from(Song.class)
                .execute();
    }

    public static Song find(String title){
        return new Select()
                .from(Song.class)
                .where("Title = ?", title)
                .executeSingle();
    }
}
