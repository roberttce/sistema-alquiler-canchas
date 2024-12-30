package com.example.backend_alquiler_canchas.controller;

import com.example.backend_alquiler_canchas.dto.DeporteDTO;
import com.example.backend_alquiler_canchas.service.DeporteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deportes")
public class DeporteController {

    private final DeporteService deporteService;

    @Autowired
    public DeporteController(DeporteService deporteService) {
        this.deporteService = deporteService;
    }

    @PostMapping
    public ResponseEntity<DeporteDTO> crearDeporte(@Valid @RequestBody DeporteDTO deporteDTO) {
        return ResponseEntity.ok(deporteService.crearDeporte(deporteDTO));
    }

    @GetMapping("/{idDeporte}")
    public ResponseEntity<DeporteDTO> obtenerDeportePorId(@PathVariable Integer idDeporte) {
        return ResponseEntity.ok(deporteService.obtenerDeportePorId(idDeporte));
    }

    @GetMapping
    public ResponseEntity<List<DeporteDTO>> listarDeportes() {
        return ResponseEntity.ok(deporteService.listarDeportes());
    }

    @PutMapping("/{idDeporte}")
    public ResponseEntity<DeporteDTO> actualizarDeporte(@PathVariable Integer idDeporte, @Valid @RequestBody DeporteDTO deporteDTO) {
        return ResponseEntity.ok(deporteService.actualizarDeporte(idDeporte, deporteDTO));
    }

    @DeleteMapping("/{idDeporte}")
    public ResponseEntity<Void> eliminarDeporte(@PathVariable Integer idDeporte) {
        deporteService.eliminarDeporte(idDeporte);
        return ResponseEntity.noContent().build();
    }
}
