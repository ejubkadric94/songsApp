package com.media.server.controllers.resources;

import com.media.server.helpers.*;
import com.media.server.models.SongAssignModel;
import com.media.server.models.ExpiryPeriod;
import com.media.server.repositories.ExpiryPeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MediaPublishingController {
    @Autowired
    private ExpiryPeriodRepository expiryPeriodRepository;

    @RequestMapping(value = "/publishing/assign", method = RequestMethod.POST)
    public ResponseEntity assignSongToUser(@RequestBody SongAssignModel songAssignModel) {
        List<ExpiryPeriod> expiryPeriodList = MediaPublishingHelper.prepareExpiryPeriods(songAssignModel);
        if (expiryPeriodList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageWrapper(Resources.INVALID_INPUT));
        }

        expiryPeriodList.forEach(expiryPeriod -> expiryPeriodRepository.save(expiryPeriod));
        return ResponseEntity.status(HttpStatus.OK).body(new MessageWrapper(Resources.SUCCESS));
    }

    @RequestMapping("/publishing/expired")
    public ResponseEntity getExpiredConnections() {
        List<ExpiryPeriod> expiryPeriods = expiryPeriodRepository.findAll(ExpirySpecification.customerHasBirthday());
        return ResponseEntity.status(HttpStatus.OK).body(expiryPeriods);
    }
}