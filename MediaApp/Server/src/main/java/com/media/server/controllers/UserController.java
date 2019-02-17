package com.media.server.controllers;

import com.media.server.helpers.MessageWrapper;
import com.media.server.helpers.Resources;
import com.media.server.models.User;
import com.media.server.models.helperModels.UserPOJO;
import com.media.server.persistance.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * OAuth2 login endpoint
     * This endpoint will be called from a remote server, once the remote server authenticates the user.
     * Remote server should provide access and bearer tokens which will then be saved.
     *
     * @param userPOJO JSON object which contains tokens, in form of:
     *                 ```
     *                      {
     *                           "bearerToken": {
     *                              "token": "bf70caf4-f72b-491d-a04e-d58b4c1941e0"
     *                          },
     *                          "accessToken": {
     *                              "token": "605b9828-8392-49f4-a7a2-c928e2499a0a",
     *                              "expirationTime": "2019-02-17T12:50:51.568+0000"
     *                          }
     *                      }
     *                 ```
     * @method POST
     * @return The created user ID
     */
    @RequestMapping(value = "/loginWithRemoteServer", method = RequestMethod.POST)
    public ResponseEntity loginUsingRemoteServer(@RequestBody UserPOJO userPOJO) {
        if (userPOJO.getAccessToken() == null || userPOJO.getBearerToken() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageWrapper(Resources.INVALID_INPUT));
        }

        User user = new User(userPOJO);
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(user.getId());
    }
}
