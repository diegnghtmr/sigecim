package co.edu.uniquindio.sigecim.sigecimapp.mapping.dto;

import java.util.List;

public record PacienteDto(
        String nombre,
        String documento,
        String telefono,
        String correo,
        String fechaNacimiento,
        String direccion,
        String eps,
        List<CitaDto> listaCitasDto
) {
}
