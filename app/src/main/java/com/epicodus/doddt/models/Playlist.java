package com.epicodus.doddt.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jusuzuki on 11/1/15.
 */
@Table(name = "Playlists", id = "_id")
public class Playlist extends Model {

    @Column(name = "Playlist")
    public String mPlaylist;

    public Playlist(){
        super();
    }

    public Playlist(String name){
        super();
        mPlaylist = name;
    }

    public String getName(){
        return mPlaylist;
    }

    public static List<Playlist> all(){
        return new Select()
                .from(Playlist.class)
                .execute();
    }

    public static Playlist find(String name){
        return new Select()
                .from(Playlist.class)
                .where("Playlist = ?", name)
                .executeSingle();
    }

//    public List<Song> getSongs(Playlist playlist){
//        List<PlaylistSong> joins = new Select()
//                .from(PlaylistSong.class)
//                .where("Playlist = ?", playlist);
//                .execute();
//
//        List<Song> songs = new ArrayList<>();
//
//        for(PlaylistSong join : joins){
//            songs.add(join.mSong);
//        }
//
//        return songs;
//    }

    public static Playlist newPlaylist(String name){
        Playlist playlist = find(name);

        if (playlist == null){
            playlist = new Playlist(name);
            playlist.save();
        }
        return playlist;
    }


    public static void addToPlaylist(String playlistName, Song song){
        Playlist getPlaylist = Playlist.find(playlistName);
        PlaylistSong addSongToPlaylist = new PlaylistSong(getPlaylist, song);
        addSongToPlaylist.save();
    }
}
