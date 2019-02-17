package com.media.server.controllers;

import com.media.server.helpers.MessageWrapper;
import com.media.server.helpers.Resources;
import com.media.server.models.helperModels.SongSearchPOJO;
import com.media.server.helpers.Validations;
import com.media.server.models.Artist;
import com.media.server.models.Publisher;
import com.media.server.models.Song;
import com.media.server.persistance.repositories.ArtistRepository;
import com.media.server.persistance.repositories.PublisherRepository;
import com.media.server.persistance.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * This controller provides CRUD operations for Song objects.
 * To use any of its endpoint, user has to provide a request header "Access-Token" with valid and non expired value,
 * along with every request. To obtain an access token, please refer to UserController.
 */
@RestController
@RequestMapping("/song")
@EnableAutoConfiguration
public class SongController {

    @Autowired
    private SongRepository songRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    /**
     * Returns a song with specified id.
     *
     * @param id the specified id
     * @return song serialized in JSON form. Return 400 in case of non-existant song
     */
    @RequestMapping("/{id}")
    public ResponseEntity getSong(@PathVariable Long id) {
       Optional<Song> song = songRepository.findById(id);

       if (!song.isPresent()) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageWrapper(Resources.SONG_DOES_NOT_EXIST));
       }
       return ResponseEntity.status(HttpStatus.OK).body(song.get());
    }

    /**
     * Creates a song with required specification of artist and publisher.
     *
     * @param artistId Long
     * @param publisherId Long
     * @param newSong song JSON object
     * @return the id of created song. Returns 400 in cases of invalid song JSON, or if publisher or artist are not specified.
     */
    @RequestMapping(value = "/{artistId}/{publisherId}", method = RequestMethod.POST)
    public ResponseEntity createSong(@PathVariable Long artistId, @PathVariable Long publisherId, @RequestBody Song newSong) {
        Optional<Artist> artist = artistRepository.findById(artistId);
        Optional<Publisher> publisher = publisherRepository.findById(publisherId);

        if (!artist.isPresent() || !publisher.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageWrapper(Resources.INVALID_INPUT));
        }
        if (!Validations.isSongValid(newSong)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageWrapper(Resources.INVALID_INPUT));
        }

        newSong.setArtist(artist.get());
        newSong.setPublisher(publisher.get());

        songRepository.save(newSong);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageWrapper(newSong.getId()));
    }

    /**
     * Updates the existing song.
     *
     * @param songId
     * @param newSong JSON of new song
     * @return the id of created song. Returns 400 in cases of invalid song JSON, or if publisher or artist are not specified.
     */
    @RequestMapping(value = "/{songId}", method = RequestMethod.PUT)
    public ResponseEntity updateSong(@PathVariable Long songId, @RequestBody Song newSong) {
        Optional<Song> songToUpdateWrapper = songRepository.findById(songId);
        if (!songToUpdateWrapper.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageWrapper(Resources.INVALID_INPUT));
        }

        Song songToUpdate = songToUpdateWrapper.get();
        songToUpdate.setTitle(newSong.getTitle());
        songToUpdate.setOriginatingCountry(newSong.getOriginatingCountry());
        songRepository.save(songToUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageWrapper(Resources.SUCCESS));
    }

    /**
     * Deletes an existing song.
     *
     * @param songId
     * @return 400 in case of non existant song
     */
    @RequestMapping(value = "/{songId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteSong(@PathVariable Long songId) {
        Optional<Song> song = songRepository.findById(songId);
        if (!song.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageWrapper(Resources.INVALID_INPUT));
        }

        songRepository.delete(song.get());
        return ResponseEntity.status(HttpStatus.OK).body(new MessageWrapper(Resources.SUCCESS));
    }

    /**
     * Search all songs.
     *
     * @param songSearchPOJO JSON object in form of:
     *                       ```
     *                          {
     *                              "country": "USA",
     *                              "artistName": "Akon",
     *                              "publisherName": "Kobalt",
     *                              "songTitle": "Beautiful",
     *                              "genre": "POP"
     *                          }
     *                       ```
     *                      where each property is optional
     * @return The JSON serialized array of matched songs
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ResponseEntity searchSongs(@RequestBody SongSearchPOJO songSearchPOJO) {
        Song song = new Song();
        if (songSearchPOJO.getCountry() != null && !songSearchPOJO.getCountry().isEmpty()) {
            song.setOriginatingCountry(songSearchPOJO.getCountry());
        }
        if (songSearchPOJO.getSongTitle() != null && !songSearchPOJO.getSongTitle().isEmpty()) {
            song.setTitle(songSearchPOJO.getSongTitle());
        }
        if (songSearchPOJO.getGenre() != null && !songSearchPOJO.getGenre().isEmpty()) {
            song.setGenre(songSearchPOJO.getGenre());
        }

        Optional<Publisher> publisher = publisherRepository.findByName(songSearchPOJO.getPublisherName());
        if (publisher.isPresent()) {
            song.setPublisher(publisher.get());
        }
        Optional<Artist> artist = artistRepository.findByName(songSearchPOJO.getArtistName());
        if (artist.isPresent()) {
            song.setArtist(artist.get());
        }

        Example<Song> example = Example.of(song);
        List<Song> songs = songRepository.findAll(example);
        return ResponseEntity.status(HttpStatus.OK).body(songs);
    }
}
