package com.media.server.models;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Publisher extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private Set<Song> songs;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
