package com.banquito.cbs.bank.repository;

import com.banquito.cbs.bank.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, String>
{
}
