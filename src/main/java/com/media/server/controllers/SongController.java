package com.media.server.controllers;

import com.media.server.helpers.MessageWrapper;
import com.media.server.helpers.Resources;
import com.media.server.helpers.SongSearchModel;
import com.media.server.helpers.Validations;
import com.media.server.models.Artist;
import com.media.server.models.Genre;
import com.media.server.models.Publisher;
import com.media.server.models.Song;
import com.media.server.repositories.ArtistRepository;
import com.media.server.repositories.GenreRepository;
import com.media.server.repositories.PublisherRepository;
import com.media.server.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SongController {
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private GenreRepository genreRepository;

    @RequestMapping("/song/{id}")
    public ResponseEntity getSong(@PathVariable Long id) {
       Optional<Song> song = songRepository.findById(id);

       if (!song.isPresent()) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageWrapper(Resources.SONG_DOES_NOT_EXIST));
       }
       return ResponseEntity.status(HttpStatus.OK).body(song.get());
    }

    @RequestMapping(value = "/song/{artistId}/{publisherId}", method = RequestMethod.POST)
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

    @RequestMapping(value = "/song/{songId}", method = RequestMethod.PUT)
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

    @RequestMapping(value = "/song/{songId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteSong(@PathVariable Long songId) {
        Optional<Song> song = songRepository.findById(songId);
        if (!song.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageWrapper(Resources.INVALID_INPUT));
        }

        songRepository.delete(song.get());
        return ResponseEntity.status(HttpStatus.OK).body(new MessageWrapper(Resources.SUCCESS));
    }

    @RequestMapping(value = "/song/search", method = RequestMethod.POST)
    public ResponseEntity searchSongs(@RequestBody SongSearchModel songSearchModel) {
        Song song = new Song();
        if (songSearchModel.getCountry() != null && !songSearchModel.getCountry().isEmpty()) {
            song.setOriginatingCountry(songSearchModel.getCountry());
        }
        if (songSearchModel.getSongTitle() != null && !songSearchModel.getSongTitle().isEmpty()) {
            song.setTitle(songSearchModel.getSongTitle());
        }

        Optional<Publisher> publisher = publisherRepository.findByName(songSearchModel.getPublisherName());
        if (publisher.isPresent()) {
            song.setPublisher(publisher.get());
        }
        Optional<Artist> artist = artistRepository.findByName(songSearchModel.getArtistName());
        if (artist.isPresent()) {
            song.setArtist(artist.get());
        }
        Optional<Genre> genre = genreRepository.findByName(songSearchModel.getGenreName());
        if (genre.isPresent()) {
            song.setGenre(genre.get());
        }

        Example<Song> example = Example.of(song);
        List<Song> songs = songRepository.findAll(example);
        return ResponseEntity.status(HttpStatus.OK).body(songs);
    }
}
