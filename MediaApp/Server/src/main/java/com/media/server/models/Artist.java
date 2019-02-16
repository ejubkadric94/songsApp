package com.media.server.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Artist extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "artist")
    private Set<Song> songs;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
