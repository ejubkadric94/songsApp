package com.media.server.helpers;

import com.media.server.models.Genre;

public class SongSearchModel {
    private String genreName;
    private String country;
    private String artistName;
    private String publisherName;
    private String songTitle;

    public SongSearchModel() {
    }

    public String getGenreName() {
        return genreName;
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
