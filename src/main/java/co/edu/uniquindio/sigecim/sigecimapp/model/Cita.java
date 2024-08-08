package co.edu.uniquindio.sigecim.sigecimapp.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder

public class Cita {
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private Paciente paciente;
    private Doctor doctor;

}
