package com.banquito.cbs.aplicacion.autenticacion.repository;

import com.banquito.cbs.aplicacion.autenticacion.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>
{
    Optional<Usuario> findByUsuario(String usuario);
}
