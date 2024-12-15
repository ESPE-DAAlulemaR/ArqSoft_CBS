package com.banquito.cbs.financialproducts.service;

import com.banquito.cbs.financialproducts.model.Account;
import com.banquito.cbs.financialproducts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public Account find(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    public void save(Account customer) {
        accountRepository.save(customer);
    }

    public void destroy(Account customer) {
        accountRepository.delete(customer);
    }
}
