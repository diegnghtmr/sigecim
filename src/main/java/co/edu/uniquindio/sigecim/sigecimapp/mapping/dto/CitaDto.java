package co.edu.uniquindio.sigecim.sigecimapp.mapping.dto;

public record CitaDto(
        String fecha,
        String hora,
        String motivo,
        PacienteDto paciente,
        DoctorDto doctor
) {
}
