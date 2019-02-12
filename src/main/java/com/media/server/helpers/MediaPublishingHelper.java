package com.media.server.helpers;

import com.media.server.models.ExpiryPeriod;
import com.media.server.models.SongAssignModel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MediaPublishingHelper {

    public static List<ExpiryPeriod> prepareExpiryPeriods(SongAssignModel songAssignModel) {
        List<ExpiryPeriod> resultList = new ArrayList<>();

        Timestamp ts = new Timestamp(songAssignModel.getExpiryPeriod());
        Date expiry = new Date(ts.getTime());
        songAssignModel.getUsersIds().forEach(userId ->
            songAssignModel.getSongsIds().forEach(songId -> resultList.add(new ExpiryPeriod(userId, songId, expiry)))
        );

        return resultList;
    }
}
