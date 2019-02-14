package com.media.server.repositories;

import com.media.server.models.ExpiryPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ExpiryPeriodRepository extends JpaRepository<ExpiryPeriod, Long>, JpaSpecificationExecutor<ExpiryPeriod> {
}
