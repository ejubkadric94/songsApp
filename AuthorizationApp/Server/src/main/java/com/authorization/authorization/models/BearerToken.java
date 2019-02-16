package com.authorization.authorization.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "bearer_token")
public class BearerToken {
    @Id
    @Column(unique = true)
    @GeneratedValue
    private Long id;
    private String token;

    @OneToOne
    @JoinColumn(name = "user.id")
    private User user;

    public BearerToken() {
    }

    public BearerToken(User user) {
        this.user = user;
        this.token = UUID.randomUUID().toString();
    }

    public String getToken() {
        return token;
    }
}
