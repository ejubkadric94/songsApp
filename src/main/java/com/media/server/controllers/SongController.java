package com.media.server.controllers;

import com.media.server.enums.Genre;
import com.media.server.models.Song;
import com.media.server.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {
    @Autowired
    private SongRepository songRepository;

    @RequestMapping("/create")
    String createUser() {
        Song song = new Song("tt", "BIH", Genre.EURO_DANCE);
        songRepository.save(song);
        return "success";
    }
}
