package com.media.server.controllers;

import com.media.server.helpers.*;
import com.media.server.models.helperModels.SongPOJO;
import com.media.server.models.ExpiryPeriod;
import com.media.server.persistance.repositories.ExpiryPeriodRepository;
import com.media.server.persistance.specifications.ExpirySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This controller makes is responsible of assigning media to users for a certain period of time.
 * To use any of its endpoint, user has to provide a request header "Access-Token" with valid and non expired value,
 * along with every request. To obtain an access token, please refer to UserController.
 *
 */
@RestController
@RequestMapping("/publishing")
public class MediaPublishingController {
    @Autowired
    private ExpiryPeriodRepository expiryPeriodRepository;

    /**
     * Assign a group of songs to group of users.
     *
     * @method POST
     * @param songPOJO JSON string containing array of users ids, and array of of songs ids
     * @return 400 in case of empty arrays, or 200 otherwise
     */
    @RequestMapping(value = "/assign", method = RequestMethod.POST)
    public ResponseEntity assignSongToUser(@RequestBody SongPOJO songPOJO) {
        List<ExpiryPeriod> expiryPeriodList = MediaPublishingHelper.prepareExpiryPeriods(songPOJO);
        if (expiryPeriodList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageWrapper(Resources.INVALID_INPUT));
        }

        expiryPeriodList.forEach(expiryPeriod -> expiryPeriodRepository.save(expiryPeriod));
        return ResponseEntity.status(HttpStatus.OK).body(new MessageWrapper(Resources.SUCCESS));
    }

    /**
     * Returns all assigned media which expired.
     * @return
     */
    @RequestMapping("/expired")
    public ResponseEntity getExpiredConnections() {
        List<ExpiryPeriod> expiryPeriods = expiryPeriodRepository.findAll(ExpirySpecification.customerHasBirthday());
        return ResponseEntity.status(HttpStatus.OK).body(expiryPeriods);
    }
}
