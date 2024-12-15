package com.banquito.cbs.financialproducts.repository;

import com.banquito.cbs.financialproducts.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
