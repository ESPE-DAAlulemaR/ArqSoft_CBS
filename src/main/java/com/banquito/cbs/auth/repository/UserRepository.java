package com.banquito.cbs.auth.repository;

import com.banquito.cbs.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
}
