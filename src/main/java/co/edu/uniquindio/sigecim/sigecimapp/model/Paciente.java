package co.edu.uniquindio.sigecim.sigecimapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder

public class Paciente extends Persona{
    private String eps;
    private List<Cita> listaCitas;

}
