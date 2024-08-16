package co.edu.uniquindio.sigecim.sigecimapp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@Builder

public class Cita {
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private Paciente paciente;
    private Doctor doctor;

}
