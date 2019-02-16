package com.media.server.controllers;

import com.media.server.helpers.MessageWrapper;
import com.media.server.helpers.Resources;
import com.media.server.models.User;
import com.media.server.models.UserPOJO;
import com.media.server.repositories.UserRepository;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/loginWithRemoteServer", method = RequestMethod.POST)
    public ResponseEntity loginUsingRemoteServer(@RequestBody UserPOJO userPOJO) {
        if (userPOJO.getAccessToken() == null || userPOJO.getBearerToken() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageWrapper(Resources.INVALID_INPUT));
        }


        userRepository.save(new User(userPOJO));
        return ResponseEntity.status(HttpStatus.OK).body(userPOJO);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/user/{accessToken}")
    public ResponseEntity getUser(@PathVariable String accessToken) {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageWrapper(Resources.SUCCESS));
    }
}
