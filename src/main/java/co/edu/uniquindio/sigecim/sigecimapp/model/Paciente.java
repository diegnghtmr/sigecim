package co.edu.uniquindio.sigecim.sigecimapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@SuperBuilder
@AllArgsConstructor

public class Paciente extends Persona{
    private String eps;
    private final List<Cita> listaCitas = new ArrayList<>();
}
