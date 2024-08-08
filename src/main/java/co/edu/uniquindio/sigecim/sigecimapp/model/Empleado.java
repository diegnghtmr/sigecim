package co.edu.uniquindio.sigecim.sigecimapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data

public class Empleado extends Persona{
    private String contrasenia;

}
