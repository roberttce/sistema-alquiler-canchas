package com.example.backend_alquiler_canchas.repository;

import com.example.backend_alquiler_canchas.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {
    Optional<Administrador> findByUsuario(String usuario);
}