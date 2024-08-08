package co.edu.uniquindio.sigecim.sigecimapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data

public class Paciente extends Persona{
    private String eps;

}
