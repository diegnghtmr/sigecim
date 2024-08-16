package co.edu.uniquindio.sigecim.sigecimapp.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Cita {
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private Paciente paciente;
    private Doctor doctor;

}
