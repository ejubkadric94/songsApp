package com.media.server.persistance.specifications;

import com.media.server.models.User;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class UserSpecification {
    public static Specification<User> isUserAuthenticated(String accessToken) {
        return (root, query, cb) -> {
            Date now = new Date();
            return cb.and(cb.greaterThan(root.get("accessTokenExpirationTime"), now), cb.equal(root.get("accessToken"), accessToken));
        };
    }
}
