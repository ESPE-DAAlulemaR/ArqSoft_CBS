package com.banquito.cbs.aplicacion.autenticacion.service;

import com.banquito.cbs.aplicacion.autenticacion.modelo.Usuario;
import com.banquito.cbs.aplicacion.autenticacion.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio
{
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> getAll() {
        return usuarioRepositorio.findAll();
    }

    public Usuario find(Integer id) {
        return usuarioRepositorio.findById(id).orElse(null);
    }

    public void save(Usuario user) {
        usuarioRepositorio.save(user);
    }

    public void destroy(Usuario customer) {
        usuarioRepositorio.delete(customer);
    }
}
