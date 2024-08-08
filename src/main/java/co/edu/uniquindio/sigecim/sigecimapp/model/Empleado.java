package co.edu.uniquindio.sigecim.sigecimapp.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder

public class Empleado extends Persona{
    private String contrasenia;

}
