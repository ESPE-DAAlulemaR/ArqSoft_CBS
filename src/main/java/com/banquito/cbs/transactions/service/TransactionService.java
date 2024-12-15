package com.banquito.cbs.transactions.service;

import com.banquito.cbs.transactions.model.Transaction;
import com.banquito.cbs.transactions.repository.TransactionDetailRepository;
import com.banquito.cbs.transactions.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionDetailRepository transactionDetailRepository;


    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    public Transaction find(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void destroy(Transaction transaction) {
        transactionRepository.delete(transaction);
    }
}
