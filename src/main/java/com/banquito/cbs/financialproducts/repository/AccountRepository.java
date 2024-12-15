package com.banquito.cbs.financialproducts.repository;

import com.banquito.cbs.financialproducts.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
