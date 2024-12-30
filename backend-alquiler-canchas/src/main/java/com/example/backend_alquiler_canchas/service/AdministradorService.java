package com.example.backend_alquiler_canchas.service;

import com.example.backend_alquiler_canchas.model.Administrador;
import com.example.backend_alquiler_canchas.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.backend_alquiler_canchas.dto.AdministradorDTO;
import com.example.backend_alquiler_canchas.dto.LoginResponseDTO;


@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<Administrador> listarTodos() {
        return repository.findAll();
    }
    public Administrador buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrador no encontrado"));
    }

    public Administrador guardar(Administrador administrador) {
        administrador.setContrasena(passwordEncoder.encode(administrador.getContrasena()));
        return repository.save(administrador);
    }

    public Administrador actualizar(Integer id, Administrador administradorActualizado) {
        return repository.findById(id).map(administrador -> {
            administrador.setNombre(administradorActualizado.getNombre());
            administrador.setApellido(administradorActualizado.getApellido());
            administrador.setUsuario(administradorActualizado.getUsuario());
            administrador.setCorreoElectronico(administradorActualizado.getCorreoElectronico());
            if (administradorActualizado.getContrasena() != null && !administradorActualizado.getContrasena().isEmpty()) {
                administrador.setContrasena(passwordEncoder.encode(administradorActualizado.getContrasena()));
            }
            return repository.save(administrador);
        }).orElseThrow(() -> new RuntimeException("Administrador no encontrado"));
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public void cambiarContrasena(Integer id, String nuevaContrasena) {
        repository.findById(id).map(administrador -> {
            administrador.setContrasena(passwordEncoder.encode(nuevaContrasena));
            return repository.save(administrador);
        }).orElseThrow(() -> new RuntimeException("Administrador no encontrado"));
    }
}