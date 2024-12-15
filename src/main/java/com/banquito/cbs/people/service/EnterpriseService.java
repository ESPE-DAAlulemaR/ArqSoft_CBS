package com.banquito.cbs.people.service;

import com.banquito.cbs.people.model.Enterprise;
import com.banquito.cbs.people.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {
    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public List<Enterprise> getAll() {
        return enterpriseRepository.findAll();
    }

    public Enterprise find(Long id) {
        return enterpriseRepository.findById(id).orElse(null);
    }

    public void save(Enterprise enterprise) {
        enterpriseRepository.save(enterprise);
    }

    public void destroy(Enterprise enterprise) {
        enterpriseRepository.delete(enterprise);
    }
}
