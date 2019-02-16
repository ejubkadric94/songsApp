package com.authorization.authorization.models;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "access_token")
public class AccessToken {
    @Id
    @Column(unique = true)
    @GeneratedValue
    private Long id;
    private String token;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;

    @OneToOne
    @JoinColumn(name = "user.id")
    private User user;

    public AccessToken() {
    }

    public AccessToken(User user) {
        this.user = user;
        this.token = UUID.randomUUID().toString();
        expirationDate = new Date(System.currentTimeMillis() + 5*60*1000);
    }

    public String getToken() {
        return token;
    }

    public Date getExpirationTime() {
        return expirationDate;
    }
}
