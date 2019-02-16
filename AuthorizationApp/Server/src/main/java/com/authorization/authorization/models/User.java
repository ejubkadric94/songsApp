package com.authorization.authorization.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @Column(unique = true)
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "user")
    @JoinColumn(unique = true)
    private BearerToken bearerToken;
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "user")
    @JoinColumn(unique = true)
    private AccessToken accessToken;

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BearerToken getBearerToken() {
        return bearerToken;
    }

    public void setBearerToken(BearerToken bearerToken) {
        this.bearerToken = bearerToken;
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }
}
