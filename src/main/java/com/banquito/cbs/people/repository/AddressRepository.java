package com.banquito.cbs.people.repository;

import com.banquito.cbs.people.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
