package com.company.Model;

public class Genres {

    private int id;
    private String song_type;
    private String artist_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSong_type() {
        return song_type;
    }

    public void setSong_type(String song_type) {
        this.song_type = song_type;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }
}
