package com.media.server.models.helperModels;

import java.util.Date;

public class AccessTokenPOJO {
    private String token;
    private Date expirationTime;

    public AccessTokenPOJO() {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }
}
