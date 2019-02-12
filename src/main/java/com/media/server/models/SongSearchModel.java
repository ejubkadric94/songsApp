package com.media.server.models;

public class SongSearchModel {
    private String genre;
    private String country;
    private String artistName;
    private String publisherName;
    private String songTitle;

    public SongSearchModel() {
    }

    public String getGenre() {
        return genre;
    }

    public String getCountry() {
        return country;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public String getSongTitle() {
        return songTitle;
    }
}
