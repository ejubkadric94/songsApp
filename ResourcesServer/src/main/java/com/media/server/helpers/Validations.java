package com.media.server.helpers;

import com.media.server.models.Song;

public class Validations {
    public static boolean isSongValid(Song song) {
        return song.getTitle() != null && !song.getTitle().isEmpty() && song.getOriginatingCountry() != null
                && !song.getOriginatingCountry().isEmpty();
    }
}
