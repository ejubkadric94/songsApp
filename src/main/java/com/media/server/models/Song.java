package com.media.server.models;

import com.media.server.enums.Genre;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="song")
public class Song {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String title;
//    private Artist artist;
//    private Publisher publisher;
    @Column(name = "originating_country")
    private String originatingCountry;
    private Genre genre;

    @Column(name = "publishing_date")
    private LocalDate publishingDate;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;
}
