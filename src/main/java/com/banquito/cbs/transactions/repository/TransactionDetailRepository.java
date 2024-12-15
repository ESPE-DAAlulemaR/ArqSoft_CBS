package com.banquito.cbs.transactions.repository;

import com.banquito.cbs.transactions.model.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Long> {
}
