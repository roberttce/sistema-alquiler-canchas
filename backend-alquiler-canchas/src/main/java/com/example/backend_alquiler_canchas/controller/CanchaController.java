package com.example.backend_alquiler_canchas.controller;

import com.example.backend_alquiler_canchas.dto.CanchaDTO;
import com.example.backend_alquiler_canchas.service.CanchaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/canchas")
public class CanchaController {

    private final CanchaService canchaService;

    @Autowired
    public CanchaController(CanchaService canchaService) {
        this.canchaService = canchaService;
    }

    @PostMapping
    public ResponseEntity<CanchaDTO> crearCancha(@Valid @RequestBody CanchaDTO canchaDTO) {
        return ResponseEntity.ok(canchaService.crearCancha(canchaDTO));
    }

    @GetMapping("/{idCancha}")
    public ResponseEntity<CanchaDTO> obtenerCanchaPorId(@PathVariable Integer idCancha) {
        return ResponseEntity.ok(canchaService.obtenerCanchaPorId(idCancha));
    }

    @GetMapping
    public ResponseEntity<List<CanchaDTO>> listarCanchas() {
        return ResponseEntity.ok(canchaService.listarCanchas());
    }

    @PutMapping("/{idCancha}")
    public ResponseEntity<CanchaDTO> actualizarCancha(@PathVariable Integer idCancha, @Valid @RequestBody CanchaDTO canchaDTO) {
        return ResponseEntity.ok(canchaService.actualizarCancha(idCancha, canchaDTO));
    }

    @DeleteMapping("/{idCancha}")
    public ResponseEntity<Void> eliminarCancha(@PathVariable Integer idCancha) {
        canchaService.eliminarCancha(idCancha);
        return ResponseEntity.noContent().build();
    }
}