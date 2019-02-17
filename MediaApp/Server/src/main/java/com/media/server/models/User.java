package com.media.server.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.media.server.models.helperModels.UserPOJO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "app_user")
public class User extends Auditable {
    @Id
    @Column(unique = true)
    @GeneratedValue
    private Long id;
    @Column(name = "access_token")
    private String accessToken;
    @Column(name = "bearer_token")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String bearerToken;
    @Column(name = "access_token_expiration_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Date accessTokenExpirationTime;

    public User() {
    }

    public User(UserPOJO userPOJO) {
        this.accessToken = userPOJO.getAccessToken().getToken();
        this.accessTokenExpirationTime = userPOJO.getAccessToken().getExpirationTime();
        this.bearerToken = userPOJO.getBearerToken().getToken();
    }

    public Long getId() {
        return id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    @JsonProperty("accessToken.token")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getBearerToken() {
        return bearerToken;
    }

    @JsonProperty("bearerToken.token")
    public void setBearerToken(String bearerToken) {
        this.bearerToken = bearerToken;
    }

    public Date getAccessTokenExpirationTime() {
        return accessTokenExpirationTime;
    }

    @JsonProperty("accessToken.expirationDate")
    public void setAccessTokenExpirationTime(Date accessTokenExpirationTime) {
        this.accessTokenExpirationTime = accessTokenExpirationTime;
    }
}
