package com.banquito.cbs.aplicacion.autenticacion.service;

import com.banquito.cbs.aplicacion.autenticacion.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionServicio
{
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    private void login(String username, String password)
    {
        //
    }

    private void logout(String sessionToken)
    {
        //
    }
}
