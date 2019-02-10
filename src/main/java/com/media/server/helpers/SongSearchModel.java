package com.media.server.helpers;

import com.media.server.enums.Genre;

public class SongSearchModel {
    private Genre genre;
    private String country;
    private String artistName;
    private String publisherName;
    private String songTitle;

    public SongSearchModel() {
    }

    public Genre getGenre() {
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
