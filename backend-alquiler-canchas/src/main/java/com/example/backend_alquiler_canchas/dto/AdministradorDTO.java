package com.example.backend_alquiler_canchas.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorDTO {
    private String nombre;
    private String apellido;
    private String usuario;
    private String correoElectronico;
}