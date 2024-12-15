package com.banquito.cbs.transactions.service;

import com.banquito.cbs.transactions.model.Deferred;
import com.banquito.cbs.transactions.repository.DeferredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeferredService {
    @Autowired
    private DeferredRepository deferredRepository;

    public List<Deferred> getAll() {
        return deferredRepository.findAll();
    }

    public Deferred find(Long id) {
        return deferredRepository.findById(id).orElse(null);
    }

    public void save(Deferred deferred) {
        deferredRepository.save(deferred);
    }

    public void destroy(Deferred deferred) {
        deferredRepository.delete(deferred);
    }
}
