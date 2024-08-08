package co.edu.uniquindio.sigecim.sigecimapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data

public class Doctor extends Persona{
    private String especialidad;
    private int experiencia;

}
