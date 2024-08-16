package co.edu.uniquindio.sigecim.sigecimapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Setter
@Getter
@SuperBuilder

public class Paciente extends Persona{
    private String eps;
    private List<Cita> listaCitas;

}
