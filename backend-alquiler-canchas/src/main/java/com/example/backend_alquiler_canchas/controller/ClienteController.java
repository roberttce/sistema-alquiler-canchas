 package com.example.backend_alquiler_canchas.controller;

import com.example.backend_alquiler_canchas.dto.ClienteDTO;
import com.example.backend_alquiler_canchas.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> crearCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok(clienteService.crearCliente(clienteDTO));
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<ClienteDTO> obtenerClientePorId(@PathVariable Integer idCliente) {
        return ResponseEntity.ok(clienteService.obtenerClientePorId(idCliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<ClienteDTO> actualizarCliente(@PathVariable Integer idCliente, @Valid @RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok(clienteService.actualizarCliente(idCliente, clienteDTO));
    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Integer idCliente) {
        clienteService.eliminarCliente(idCliente);
        return ResponseEntity.noContent().build();
    }
}
