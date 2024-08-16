package co.edu.uniquindio.sigecim.sigecimapp.model;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder

public class Empleado extends Persona{
    private String contrasenia;

}
