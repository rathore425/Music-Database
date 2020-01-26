package com.company.Model;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
 
public class Datasource {

    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/home/abhinav/Java/IdeaProjects/DataBase/Music/" + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;

    public static final String TABLE_GENRES = "genres";
    public static final String COLUMN_GENRES_ID = "_id";
    public static final String COLUMN_GENRES_SONG_TYPE = "song_type";
    public static final String COLUMN_GENRES_ARTIST_NAME = "artist_name";
    public static final int INDEX_GENRES_ID = 1;
    public static final int INDEX_GENRES_SONG_TYPE = 2;
    public static final int INDEX_GENRES_ARTIST_NAME = 3;

    public static final String TABLE_YEAR = "year";
    public static final String COLUMN_YEAR_ID = "_id";
    public static final String COLUMN_YEAR_YEAR_OF_RELEASE = "year_of_release";
    public static final int INDEX_YEAR_ID = 1;
    public static final int INDEX_YEAR_YEAR_OF_RELEASE = 2;

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;
//
//    public static final String QUERY_ALBUMS_BY_ARTIST_START =
//            "SELECT " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_NAME + " FROM " + TABLE_ALBUMS +
//                    " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + '.' + COLUMN_ARTIST_ID +
//                    " WHERE " + TABLE_ARTISTS + '.' + COLUMN_ARTIST_NAME + " = \"";
//
//    public static final String QUERY_ALBUMS_BY_ARTIST_SORT =
//            " ORDER BY " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";

    public static final String QUERY_ARTIST_BY_SONG_START =
            "SELECT " + TABLE_SONGS + '.' + COLUMN_SONG_TRACK + ',' +
                    TABLE_SONGS + '.' + COLUMN_SONG_TITLE + ',' + TABLE_ARTISTS + '.' + COLUMN_ARTIST_NAME + ','
                    + TABLE_ALBUMS + '.' + COLUMN_ALBUM_NAME + ',' + TABLE_GENRES + '.' + COLUMN_GENRES_SONG_TYPE + ','
                    + TABLE_YEAR + '.' + COLUMN_YEAR_YEAR_OF_RELEASE + " FROM " + TABLE_SONGS +
                    " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + '.' + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_ID +
                    " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + '.' + COLUMN_ARTIST_ID +
                    " INNER JOIN " + TABLE_GENRES + " ON " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_ID + " = " + TABLE_GENRES + '.' + COLUMN_GENRES_ID +
                    " INNER JOIN " + TABLE_YEAR + " ON " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_ID + " = " + TABLE_YEAR + '.' + COLUMN_YEAR_ID;

    public static final String QUERY_ARTIST_FOR_SONG_SORT =
            " ORDER BY " + TABLE_SONGS + '.' + COLUMN_SONG_TRACK + ',' + TABLE_SONGS + '.' + COLUMN_SONG_TITLE + ',' + TABLE_ARTISTS + '.' + COLUMN_ARTIST_NAME + ','
                    + TABLE_ALBUMS + '.' + COLUMN_ALBUM_NAME + ',' + TABLE_GENRES + '.' + COLUMN_GENRES_SONG_TYPE + ','
                    + TABLE_YEAR + '.' + COLUMN_YEAR_YEAR_OF_RELEASE + " COLLATE NOCASE ";

    public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";
    public static final String CREATE_ARTIST_FOR_SONG_VIEW = " CREATE VIEW IF NOT EXISTS " +
            TABLE_ARTIST_SONG_VIEW + " AS SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " AS " + COLUMN_SONG_ALBUM + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK + ", " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " FROM " + TABLE_SONGS + " INNER JOIN " +
            TABLE_ALBUMS + " ON " + TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS +
            "." + COLUMN_ALBUM_ID + " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." +
            COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID + " ORDER BY " + TABLE_ARTISTS + "." +
            COLUMN_ARTIST_NAME + ", " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME +
            ", " + TABLE_SONGS + "." + COLUMN_SONG_TRACK;

    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS +
            "(" + COLUMN_ARTIST_NAME + ") VALUES(?)";

    public static final String INSERT_ALBUMS = "INSERT INTO " + TABLE_ALBUMS +
            "(" + COLUMN_ALBUM_NAME + ", " + COLUMN_ALBUM_ARTIST + ") VALUES(?, ?)";

    public static final String INSERT_SONGS = "INSERT INTO " + TABLE_SONGS +
            "(" + COLUMN_SONG_TRACK + ", " + COLUMN_SONG_TITLE + ", " + COLUMN_SONG_ALBUM + ") VALUES(?, ?, ?)";

    public static final String INSERT_GENRES = "INSERT INTO " + TABLE_GENRES +
            "(" + COLUMN_GENRES_SONG_TYPE + ", " + COLUMN_GENRES_ARTIST_NAME + ") VALUES(?, ?)";

    public static final String INSERT_YEAR = "INSERT INTO " + TABLE_YEAR +
            "(" + COLUMN_YEAR_YEAR_OF_RELEASE + ") VALUES(?)";

    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " +
            TABLE_ARTISTS + " WHERE " + COLUMN_ARTIST_NAME + " = ?";

    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID + " FROM " +
            TABLE_ALBUMS + " WHERE " + COLUMN_ALBUM_NAME + " = ?";
//
//    public static final String QUERY_GENRES = "SELECT " + COLUMN_GENRES_ID + " FROM " +
//            TABLE_GENRES + " WHERE " + COLUMN_GENRES_SONG_TYPE + " = ?";
//
//    public static final String QUERY_YEAR = "SELECT " + COLUMN_YEAR_ID + " FROM " +
//            TABLE_YEAR + " WHERE " + COLUMN_YEAR_YEAR_OF_RELEASE + " = ?";

    private Connection conn;

    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;
    private PreparedStatement insertIntoGenres;
    private PreparedStatement insertIntoYear;
    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;
    private PreparedStatement queryGenres;
    private PreparedStatement queryYear;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            System.out.println("connection done");
            insertIntoArtists = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = conn.prepareStatement(INSERT_ALBUMS, Statement.RETURN_GENERATED_KEYS);
            insertIntoSongs = conn.prepareStatement(INSERT_SONGS);
            insertIntoGenres = conn.prepareStatement(INSERT_GENRES);
            insertIntoYear = conn.prepareStatement(INSERT_YEAR);
            queryArtist = conn.prepareStatement(QUERY_ARTIST);
            queryAlbum = conn.prepareStatement(QUERY_ALBUM);
//            queryGenres = conn.prepareStatement(QUERY_GENRES);
//            queryYear = conn.prepareStatement(QUERY_YEAR);

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {

            if (insertIntoArtists != null)
                insertIntoArtists.close();
            if (insertIntoAlbums != null)
                insertIntoAlbums.close();
            if (insertIntoSongs != null)
                insertIntoSongs.close();
            if (insertIntoGenres != null)
                insertIntoGenres.close();
            if (insertIntoYear != null)
                insertIntoYear.close();
            if (queryArtist != null)
                queryArtist.close();
            if (queryAlbum != null)
                queryAlbum.close();
//            if (queryGenres != null)
//                queryGenres.close();
//            if (queryYear != null)
//                queryYear.close();

            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    //    public List<Artist> queryArtists(int sortOrder) {
//
//        StringBuilder sb = new StringBuilder("SELECT * FROM ");
//        sb.append(TABLE_ARTISTS);
//        if(sortOrder != ORDER_BY_NONE){
//            sb.append(" ORDER BY ");
//            sb.append(COLUMN_ARTIST_NAME);
//            sb.append(" COLLATE NOCASE ");
//            if(sortOrder == ORDER_BY_DESC){
//                sb.append("DESC");
//            }else{
//                sb.append("ASC");
//            }
//        }
//
//        Statement statement = null;
//        ResultSet results = null;
//        try {
//            statement = conn.createStatement();
//            results = statement.executeQuery(sb.toString());
//            System.out.println("statement executed");
//
//            List<Artist> artists = new ArrayList<>();
//            while (results.next()) {
//
//                Artist artist = new Artist();
//                artist.setId(results.getInt(INDEX_ARTIST_ID));
//                artist.setName(results.getString(INDEX_ARTIST_NAME));
//                artists.add(artist);
//            }
//            return artists;
//        } catch (SQLException e) {
//            System.out.println("Query failed: " + e.getMessage());
//            return null;
//        } finally {
//            try {
//                if (results != null) {
//                    results.close();
//                }
//            } catch (SQLException e) {
//                System.out.println("Error closing ResultSet: " + e.getMessage());
//            }
//            try {
//                if (statement != null)
//                    statement.close();
//            } catch (SQLException e) {
//                System.out.println("Error closing Statement: " + e.getMessage());
//            }
//        }
//    }
//    public List<String> queryAlbumsForArtist(String artistName , int sortOrder){
//
//        //SELECT albums.name FROM albums INNER JOIN artists ON albums.artist = artists._id WHERE artists.name = "Carole King" ORDER BY albums.name COLLATE NOCASE ASC
//        StringBuilder sb = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
//        sb.append(artistName);
//        sb.append("\"");
//
//        public void querySongsMetadata() {
//        String sql = "SELECT * FROM " + TABLE_SONGS;
//
//        try (Statement statement = conn.createStatement();
//             ResultSet results = statement.executeQuery(sql)) {
//
//            ResultSetMetaData meta = results.getMetaData();
//            int numColumns = meta.getColumnCount();
//            for (int i = 1; i <= numColumns; i++) {
//                System.out.format("Column %d in the songs table is names %s\n", i, meta.getColumnName(i));
//            }
//        } catch (SQLException e) {
//            System.out.println("Query failed " + e.getMessage());
//        }
//    }
//
//        if(sortOrder != ORDER_BY_NONE){
//            sb.append(QUERY_ALBUMS_BY_ARTIST_SORT);
////
//            if(sortOrder == ORDER_BY_DESC){
//                sb.append("DESC");
//            }else{
//                sb.append("ASC");
//            }
//        }
//        System.out.println("SQL statement = " + sb.toString());
//
//        try{
//            Statement statement = conn.createStatement();
//            ResultSet results = statement.executeQuery(sb.toString());
//            List<String> albums = new ArrayList<>();
//            while(results.next()){
//                albums.add(results.getString(1));
//            }
//            return albums;
//
//        }catch (SQLException e){
//            System.out.println("Query failed: " + e.getMessage());
//            return null;
//        }
//    }
//
    public List<SongArtist> queryArtistForSong() {
        StringBuilder sb = new StringBuilder(QUERY_ARTIST_BY_SONG_START);
        System.out.println("SQL statement: " + sb.toString());

        try {

            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sb.toString());
            List<SongArtist> songArtists = new ArrayList<>();

            while (results.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setSongTrack(results.getInt(1));
                songArtist.setSongTitle(results.getString(2));
                songArtist.setArtistName(results.getString(3));
                songArtist.setAlbumName(results.getString(4));
                songArtist.setGenresSongType(results.getString(5));
                songArtist.setYearYearOfRelease(results.getInt(6));
                songArtists.add(songArtist);                                //Adding Object to our list
            }

            return songArtists;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public boolean createViewForSongArtists() {

        try (Statement statement = conn.createStatement()) {

            statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
            return true;
        } catch (SQLException e) {
            System.out.println("Create View failed " + e.getMessage());
            return false;
        }
    }

    private int insertArtist(String name) throws SQLException {
        queryArtist.setString(1, name);
        ResultSet results = queryArtist.executeQuery();
        if (results.next()) {
            return results.getInt(1);
        } else {
            insertIntoArtists.setString(1, name);
            int affectedRows = insertIntoArtists.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Coundn't insert artist!");
            }
            ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for artist");
            }
        }
    }

    private int insertAlbum(String name, int artistId) throws SQLException {
        queryAlbum.setString(1, name);
        ResultSet results = queryAlbum.executeQuery();
        if (results.next()) {
            return results.getInt(1);
        } else {
            insertIntoAlbums.setString(1, name);
            insertIntoAlbums.setInt(2, artistId);
            int affectedRows = insertIntoAlbums.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Coundn't insert album");
            }
            ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for album");
            }
        }
    }

    public void insertSong(String title, String artist, String album, int track) {
        try{
            conn.setAutoCommit(false);

            int artistId = insertArtist(artist);
            int albumId = insertAlbum(album, artistId);
            insertIntoSongs.setInt(1, track);
            insertIntoSongs.setString(2, title);
//            insertIntoSongs.setInt(3,albumId);

            insertIntoSongs.setString(3, album);
            int affectedRows = insertIntoSongs.executeUpdate();

            if (affectedRows == 1) {
                conn.commit();
            }else{
                throw new SQLException("Song insertion failed");
            }

        }catch (SQLException e){
            System.out.println("Insert songs exception: " + e.getMessage());
            try{
                System.out.println("using rollback");
                conn.rollback();
            }catch(SQLException e2){
                System.out.println(e.getMessage());
            }
        }finally {
            try{
                System.out.println("Set auto-commit");
                conn.setAutoCommit(true);
            }catch (SQLException e3){
                System.out.println(e3.getMessage());
            }
        }

    }
    public void insertYear(int year_of_release) {
        try{
            conn.setAutoCommit(false);
            insertIntoYear.setInt(1,year_of_release);

            int affectedRows = insertIntoYear.executeUpdate();

            if (affectedRows == 1) {
                conn.commit();
            }else{
                throw new SQLException("Year insertion failed");
            }

        }catch (SQLException e){
            System.out.println("Insert year exception: " + e.getMessage());
            try{
                System.out.println("using rollback");
                conn.rollback();
            }catch(SQLException e2){
                System.out.println(e.getMessage());
            }
        }finally {
            try{
                System.out.println("Set auto-commit");
                conn.setAutoCommit(true);
            }catch (SQLException e3){
                System.out.println(e3.getMessage());
            }
        }

    }
    public void insertGenres(String song_type, String artist_name) {
        try{
            conn.setAutoCommit(false);
            insertIntoGenres.setString(1, song_type);
            insertIntoGenres.setString(2, artist_name);

            int affectedRows = insertIntoGenres.executeUpdate();

            if (affectedRows == 1) {
                conn.commit();
            }else{
                throw new SQLException("Song insertion failed");
            }

        }catch (SQLException e){
            System.out.println("Insert songs exception: " + e.getMessage());
            try{
                System.out.println("using rollback");
                conn.rollback();
            }catch(SQLException e2){
                System.out.println(e.getMessage());
            }
        }finally {
            try{
                System.out.println("Set auto-commit");
                conn.setAutoCommit(true);
            }catch (SQLException e3){
                System.out.println(e3.getMessage());
            }
        }
    }
}
