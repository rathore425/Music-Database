package com.company;

import com.company.Model.Artist;
import com.company.Model.Datasource;
import com.company.Model.SongArtist;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if(!datasource.open())
        {
            System.out.println("Can't open datasource");
            return;
        }

//        List<Artist> artists = datasource.queryArtists(Datasource.ORDER_BY_ASC );
//        if(artists == null){
//            System.out.println("No artist");
//            return;
//        }
//        for(Artist artist : artists){
//            System.out.println("ID - " + artist.getId() + " , Name - " + artist.getName());
//        }

//        List<String> albumsForArtist =
//                datasource.queryAlbumsForArtist("ZZ Top" , Datasource.ORDER_BY_ASC);
//
//        for(String album : albumsForArtist){
//            System.out.println(album);
//        }

//        List<SongArtist> songArtists = datasource.queryArtistForSong("Heartless" , Datasource.ORDER_BY_ASC);
        //List<SongArtist> songArtists = datasource.
        List<SongArtist> songArtists = datasource.queryArtistForSong();
        if(songArtists == null){
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for(SongArtist main : songArtists){
            System.out.println("Song track = " + main.getSongTrack() + "," +
                    " Song title = " + main.getSongTitle() + "," +
                    " Artist name = " + main.getArtistName() + "," +
                    " Album name = " + main.getAlbumName() + "," +
                    " Song_type = " + main.getGenresSongType() + "," +
                    " Year_of_release = " + main.getYearYearOfRelease()
                    );
        }

        //datasource.querySongsMetadata();

        datasource.createViewForSongArtists();

        datasource.insertSong("Touch of Grey", "Grateful Dead", "In The Dark", 1);
        datasource.insertYear(2000);
        datasource.insertGenres("Classic Rock", "Grateful Dead");

        datasource.close();
    }

}
