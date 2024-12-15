package com.banquito.cbs.bank.service;

import com.banquito.cbs.bank.model.Bank;
import com.banquito.cbs.bank.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService
{
    @Autowired
    private BankRepository bankRepository;

    public Bank find(String bin) {
        return bankRepository.findById(bin).orElse(null);
    }

    public void update(Bank bank) {
        bankRepository.save(bank);
    }
}
