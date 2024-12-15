package com.banquito.cbs.disputes.service;

import com.banquito.cbs.disputes.model.Quarrel;
import com.banquito.cbs.disputes.repository.QuarrelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuarrelService {
    @Autowired
    private QuarrelRepository quarrelRepository;

    public List<Quarrel> getAll() {
        return quarrelRepository.findAll();
    }

    public Quarrel find(Long id) {
        return quarrelRepository.findById(id).orElse(null);
    }

    public void save(Quarrel quarrel) {
        quarrelRepository.save(quarrel);
    }

    public void destroy(Quarrel quarrel) {
        quarrelRepository.delete(quarrel);
    }
}
