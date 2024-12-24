package com.example.backend_alquiler_canchas.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeporteDTO {
    private String nombreDeporte;
    private String descripcion;
    private Double costoPorHora;
}
