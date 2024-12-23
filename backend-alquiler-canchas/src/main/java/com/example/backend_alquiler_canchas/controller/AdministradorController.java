package com.example.backend_alquiler_canchas.controller;

import com.example.backend_alquiler_canchas.model.Administrador;
import com.example.backend_alquiler_canchas.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.backend_alquiler_canchas.dto.LoginRequestDTO;
import com.example.backend_alquiler_canchas.dto.AdministradorDTO;
import com.example.backend_alquiler_canchas.dto.LoginResponseDTO;


import java.util.List;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService service;

    @GetMapping
    public List<Administrador> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Administrador crear(@Validated @RequestBody Administrador administrador) {
        return service.guardar(administrador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrador> actualizar(@PathVariable Integer id, @Validated @RequestBody Administrador administrador) {
        Administrador actualizado = service.actualizar(id, administrador);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/cambiar-contrasena")
    public ResponseEntity<Void> cambiarContrasena(@PathVariable Integer id, @RequestParam String nuevaContrasena) {
        service.cambiarContrasena(id, nuevaContrasena);
        return ResponseEntity.noContent().build();
    }
     
    @GetMapping("/{id}")
    public ResponseEntity<Administrador> buscarPorId(@PathVariable Integer id) {
        Administrador administrador = service.buscarPorId(id);  
        return ResponseEntity.ok(administrador);  
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> iniciarSesion(@RequestBody LoginRequestDTO loginRequest) {
        LoginResponseDTO response = service.autenticar(loginRequest.getUsuario(), loginRequest.getContrasena());
        return ResponseEntity.ok(response);
    }
}
    

