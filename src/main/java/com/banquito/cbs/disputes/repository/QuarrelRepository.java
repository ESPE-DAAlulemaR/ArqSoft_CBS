package com.banquito.cbs.disputes.repository;

import com.banquito.cbs.disputes.model.Quarrel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuarrelRepository extends JpaRepository<Quarrel, Long> {
}
