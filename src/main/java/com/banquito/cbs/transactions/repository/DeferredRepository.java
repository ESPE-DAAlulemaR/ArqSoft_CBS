package com.banquito.cbs.transactions.repository;

import com.banquito.cbs.transactions.model.Deferred;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeferredRepository extends JpaRepository<Deferred, Long> {
}
