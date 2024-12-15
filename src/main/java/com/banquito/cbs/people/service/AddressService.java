package com.banquito.cbs.people.service;

import com.banquito.cbs.people.model.Address;
import com.banquito.cbs.people.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Address find(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public void save(Address address) {
        addressRepository.save(address);
    }

    public void destroy(Address address) {
        addressRepository.delete(address);
    }
}
