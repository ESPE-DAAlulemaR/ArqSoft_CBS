package com.banquito.cbs.people.repository;

import com.banquito.cbs.people.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
}
