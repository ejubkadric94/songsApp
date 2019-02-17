package com.authorization.authorization.specifications;

import com.authorization.authorization.models.BearerToken;
import com.authorization.authorization.models.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

public class UserSpecification {
    public static Specification<User> findUserByBearerToken(String bearerToken) {
        return (root, query, cb) -> {
            final Join<User, BearerToken> join = root.join("bearerToken", JoinType.LEFT);
            return cb.equal(join.get("token"), bearerToken);
        };
    }
}
