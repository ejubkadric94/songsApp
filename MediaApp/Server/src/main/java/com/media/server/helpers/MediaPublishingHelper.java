package com.media.server.helpers;

import com.media.server.models.ExpiryPeriod;
import com.media.server.models.helperModels.SongPOJO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MediaPublishingHelper {

    public static List<ExpiryPeriod> prepareExpiryPeriods(SongPOJO songPOJO) {
        List<ExpiryPeriod> resultList = new ArrayList<>();

        Timestamp ts = new Timestamp(songPOJO.getExpiryPeriod());
        Date expiry = new Date(ts.getTime());
        songPOJO.getUsersIds().forEach(userId ->
            songPOJO.getSongsIds().forEach(songId -> resultList.add(new ExpiryPeriod(userId, songId, expiry)))
        );

        return resultList;
    }
}
