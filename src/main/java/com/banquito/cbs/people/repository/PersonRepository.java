package com.banquito.cbs.people.repository;

import com.banquito.cbs.people.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
