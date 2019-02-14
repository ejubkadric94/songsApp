package com.media.server.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ExpiryPeriod extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private Long userId;
    private Long songId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiry;

    public ExpiryPeriod() {
    }

    public ExpiryPeriod(Long userId, Long songId, Date expiry) {
        this.userId = userId;
        this.songId = songId;
        this.expiry = expiry;
    }

    public Date getExpiry() {
        return expiry;
    }
}
