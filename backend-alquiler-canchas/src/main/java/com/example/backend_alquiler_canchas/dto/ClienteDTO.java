package com.example.backend_alquiler_canchas.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String telefono;
    private String dni;
}
