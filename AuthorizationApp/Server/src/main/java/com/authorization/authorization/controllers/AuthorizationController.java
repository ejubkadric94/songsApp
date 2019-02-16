package com.authorization.authorization.controllers;


import com.authorization.authorization.models.AccessToken;
import com.authorization.authorization.models.BearerToken;
import com.authorization.authorization.models.User;
import com.authorization.authorization.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
public class AuthorizationController {
    @Autowired
    private UserRepository userRepository;

    /**
     * Create the bearer (refresh) token and the access token.
     * Bearer token does not expire. However, access token will expire in 5 minutes.
     *
     * @param requestBodyUser
     * @return
     */
    @CrossOrigin(origins = "http://localhost:3001")
    @RequestMapping(value = "/authorization/authenticate", method = RequestMethod.POST)
    public ResponseEntity authenticate(@RequestBody User requestBodyUser) {
        Optional<User> existingUser = userRepository.findByEmailAndPassword(requestBodyUser.getEmail(), requestBodyUser.getPassword());
        if (!existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials");
        }
        if (existingUser.get().getBearerToken() == null) {
            BearerToken bearerToken = new BearerToken(existingUser.get());
            existingUser.get().setBearerToken(bearerToken);
        }

        AccessToken accessToken = new AccessToken(existingUser.get());
        existingUser.get().setAccessToken(accessToken);
        userRepository.save(existingUser.get());


        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestJson = null;
        String url = "http://localhost:8080/loginWithRemoteServer";
        try {
            requestJson = ow.writeValueAsString(existingUser.get());
            RestTemplate returnAuthenticatedUserTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> body = new HttpEntity<String>(requestJson, headers);
            ResponseEntity<String> response = returnAuthenticatedUserTemplate.exchange(url, HttpMethod.POST, body, String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                return ResponseEntity.status(HttpStatus.OK).body(existingUser.get().getAccessToken().getToken());
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("something went wrong");
            }


        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not map existing user to json");
        }
    }

    @RequestMapping(value = "/authorization/revokeBearerToken", method = RequestMethod.POST)
    public ResponseEntity revokeBearerToken(@RequestBody User requestBodyUser) {
        Optional<User> existingUser = userRepository.findByEmailAndPassword(requestBodyUser.getEmail(), requestBodyUser.getPassword());
        if (!existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist");
        }
        if (existingUser.get().getBearerToken() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bearer token does not exist. This user never authenticated");
        }

        existingUser.get().setBearerToken(null);
        existingUser.get().setAccessToken(null);
        userRepository.save(existingUser.get());
        return ResponseEntity.status(HttpStatus.OK).body("Bearer token revoked. Please authenticate again.");
    }

    @RequestMapping(value = "/authorization/refreshAccessToken", method = RequestMethod.POST)
    public ResponseEntity refreshAccessToken(@RequestBody User requestBodyUser) {
        Optional<User> existingUser = userRepository.findByEmailAndPassword(requestBodyUser.getEmail(), requestBodyUser.getPassword());
        if (!existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist");
        }
        User user = existingUser.get();
        if (!user.getBearerToken().getToken().equals(requestBodyUser.getBearerToken().getToken())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong refresh token");
        }


        AccessToken newAccessToken = new AccessToken(user);
        user.setAccessToken(newAccessToken);
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }


}
