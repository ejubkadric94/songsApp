package com.media.server.helpers;

import com.media.server.models.ExpiryPeriod;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class ExpirySpecification {
    public static Specification<ExpiryPeriod> customerHasBirthday() {
        return (root, query, cb) -> {
            Date now = new Date();
            return cb.lessThan(root.get("expiry"), now);
        };
    }
}
