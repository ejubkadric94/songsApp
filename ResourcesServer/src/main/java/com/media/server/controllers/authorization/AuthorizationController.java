package com.media.server.controllers.authorization;

import com.media.server.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationController {

    /**
     * Create the bearer (refresh) token and the access token.
     * Bearer token will not expire until it is replaced. However, access token will expire in 5 minutes.
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/authorization/authenticate", method = RequestMethod.POST)
    public ResponseEntity authenticate(@RequestBody User user) {
        return null;
    }


    public ResponseEntity getAccessToken() {
        return null;
    }


}
