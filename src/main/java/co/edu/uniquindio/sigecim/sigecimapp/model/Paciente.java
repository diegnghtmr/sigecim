package co.edu.uniquindio.sigecim.sigecimapp.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder

public class Paciente extends Persona{
    private String eps;
    private List<Cita> listaCitas;

}
