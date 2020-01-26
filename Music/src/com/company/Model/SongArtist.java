package com.company.Model;

public class SongArtist {
//
//    private String artistName;
//    private String albumName;
//    private int track;
//
//    public String getArtistName() {
//        return artistName;
//    }
//
//    public void setArtistName(String artistName) {
//        this.artistName = artistName;
//    }
//
//    public String getAlbumName() {
//        return albumName;
//    }
//
//    public void setAlbumName(String albumName) {
//        this.albumName = albumName;
//    }
//
//    public int getTrack() {
//        return track;
//    }
//
//    public void setTrack(int track) {
//        this.track = track;
//    }

    private int songTrack;
    private String SongTitle;
    private String artistName;
    private String albumName;
    private String genresSongType;
    private int yearYearOfRelease;

    public int getSongTrack() {
        return songTrack;
    }

    public void setSongTrack(int songTrack) {
        this.songTrack = songTrack;
    }

    public String getSongTitle() {
        return SongTitle;
    }

    public void setSongTitle(String songTitle) {
        SongTitle = songTitle;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getGenresSongType() {
        return genresSongType;
    }

    public void setGenresSongType(String genresSongType) {
        this.genresSongType = genresSongType;
    }

    public int getYearYearOfRelease() {
        return yearYearOfRelease;
    }

    public void setYearYearOfRelease(int yearYearOfRelease) {
        this.yearYearOfRelease = yearYearOfRelease;
    }
}
