package com.authorization.authorization.models;

import javax.persistence.*;

public class Token {
    @Id
    @Column(unique = true)
    @GeneratedValue
    private Long id;
    private String token;

    @OneToOne
    @JoinColumn(name = "user.id")
    private User user;
}
