package com.banquito.cbs.aplicacion.transaccion.repositorio;

import com.banquito.cbs.aplicacion.transaccion.modelo.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepositorio extends JpaRepository<Transaccion, Integer> {
}
