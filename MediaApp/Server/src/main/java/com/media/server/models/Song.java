package com.media.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="song")
public class Song extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "artist.id", nullable = false)
    @JsonIgnore
    private Artist artist;
    @ManyToOne
    @JoinColumn(name = "publisher.id", nullable = false)
    @JsonIgnore
    private Publisher publisher;
    @Column(name = "originating_country")
    private String originatingCountry;
    @Column(nullable = false)
    private String genre;
    @Column(name = "publishing_date")
    private LocalDate publishingDate;

    public Song() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginatingCountry() {
        return originatingCountry;
    }

    public void setOriginatingCountry(String originatingCountry) {
        this.originatingCountry = originatingCountry;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
