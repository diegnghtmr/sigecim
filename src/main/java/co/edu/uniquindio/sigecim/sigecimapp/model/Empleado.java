package co.edu.uniquindio.sigecim.sigecimapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder

public class Empleado extends Persona{
    private String contrasenia;

}
