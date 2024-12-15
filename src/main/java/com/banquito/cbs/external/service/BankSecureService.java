package com.banquito.cbs.external.service;

import com.banquito.cbs.external.model.BankSecure;
import com.banquito.cbs.external.repository.BankSecureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankSecureService
{
    @Autowired
    private BankSecureRepository bankSecureRepository;

    public List<BankSecure> getAll() {
        return bankSecureRepository.findAll();
    }

    public BankSecure find(Long id) {
        return bankSecureRepository.findById(id).orElse(null);
    }

    public void save(BankSecure customer) {
        bankSecureRepository.save(customer);
    }

    public void destroy(BankSecure customer) {
        bankSecureRepository.delete(customer);
    }
}
