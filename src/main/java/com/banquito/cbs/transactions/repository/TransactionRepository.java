package com.banquito.cbs.transactions.repository;

import com.banquito.cbs.transactions.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
