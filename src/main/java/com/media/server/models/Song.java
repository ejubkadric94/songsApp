package com.media.server.models;

import com.media.server.enums.Genre;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="song")
public class Song {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "uuid", columnDefinition = "VARCHAR(255)", updatable = false, nullable = false)
    private UUID uuid;
    private String title;
    @ManyToOne
    @JoinColumn(name = "artist.uuid", nullable = false)
    private Artist artist;
    @ManyToOne
    @JoinColumn(name = "publisher.uuid", nullable = false)
    private Publisher publisher;
    @Column(name = "originating_country")
    private String originatingCountry;
    private Genre genre;

    @Column(name = "publishing_date")
    private LocalDate publishingDate;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    public Song(String title, String country, Genre genre) {
        this.title = title;
        this.originatingCountry = country;
        this.genre = genre;
    }
}
