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


//    public static List<Song> getSongs(String playlistTitle){
//        Playlist playlist = Playlist.find(playlistTitle);
//        return new Select("Song")
//            .from(PlaylistSong.class)
//            .where("Playlist = ?", playlist.getId())
//            .execute();
//    }

    public static List<Song> getSongs(String playlistTitle){
        Playlist playlist = Playlist.find(playlistTitle);
        List<PlaylistSong> listOfPlaylistSongs = new Select()
                .from(PlaylistSong.class)
                .where("Playlist = ?", playlist.getId())
                .execute();

        List<Song> listOfSongs = new ArrayList<>();
        for (PlaylistSong playlistSong : listOfPlaylistSongs){
            Song song = playlistSong.mSong;
            listOfSongs.add(song);
        }

        return listOfSongs;
    }

}
