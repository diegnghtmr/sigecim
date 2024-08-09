package co.edu.uniquindio.sigecim.sigecimapp.mapping.dto;

import java.util.List;

public record DoctorDto(
        String nombre,
        String documento,
        String telefono,
        String correo,
        String fechaNacimiento,
        String direccion,
        String especialidad,
        int experiencia,
        List<CitaDto> listaCitasDto
) {
}
