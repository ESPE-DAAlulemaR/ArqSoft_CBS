package com.banquito.cbs.auth.service;

import com.banquito.cbs.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService
{
    @Autowired
    private UserRepository userRepository;

    private void login(String username, String password)
    {
        //
    }

    private void logout(String sessionToken)
    {
        //
    }
}
