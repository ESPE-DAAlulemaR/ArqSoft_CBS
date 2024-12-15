package com.banquito.cbs.external.service;

import com.banquito.cbs.external.model.BrandSecure;
import com.banquito.cbs.external.repository.BrandSecureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandSecureService
{
    @Autowired
    private BrandSecureRepository brandSecureRepository;

    public List<BrandSecure> getAll() {
        return brandSecureRepository.findAll();
    }

    public BrandSecure find(Long id) {
        return brandSecureRepository.findById(id).orElse(null);
    }

    public void save(BrandSecure customer) {
        brandSecureRepository.save(customer);
    }

    public void destroy(BrandSecure customer) {
        brandSecureRepository.delete(customer);
    }
}
