// Ubicación: src/main/java/com/example/backend_alquiler_canchas/dto/LoginResponseDTO.java

package com.example.backend_alquiler_canchas.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {
    private String mensaje;
    private Integer idAdministrador;
}
