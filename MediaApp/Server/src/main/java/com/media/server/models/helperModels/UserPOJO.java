package com.media.server.models.helperModels;

import com.media.server.models.helperModels.AccessTokenPOJO;
import com.media.server.models.helperModels.BearerTokenPOJO;

public class UserPOJO {
    private AccessTokenPOJO accessToken;
    private BearerTokenPOJO bearerToken;

    public UserPOJO () {
    }

    public AccessTokenPOJO getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessTokenPOJO accessToken) {
        this.accessToken = accessToken;
    }

    public BearerTokenPOJO getBearerToken() {
        return bearerToken;
    }

    public void setBearerToken(BearerTokenPOJO bearerToken) {
        this.bearerToken = bearerToken;
    }
}
