package com.media.server.models.helperModels;

import java.util.ArrayList;
import java.util.List;

public class SongPOJO {
    private ArrayList<Long> usersIds;
    private List<Long> songsIds;
    private Long expiryPeriod;

    public SongPOJO() {
    }

    public List<Long> getUsersIds() {
        return usersIds;
    }

    public List<Long> getSongsIds() {
        return songsIds;
    }

    public Long getExpiryPeriod() {
        return expiryPeriod;
    }

    public void setUsersIds(ArrayList<Long> usersIds) {
        this.usersIds = usersIds;
    }

    public void setSongsIds(List<Long> songsIds) {
        this.songsIds = songsIds;
    }

    public void setExpiryPeriod(Long expiryPeriod) {
        this.expiryPeriod = expiryPeriod;
    }
}
