package co.edu.uniquindio.sigecim.sigecimapp.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder

public abstract class Persona {
    private String nombre;
    private String documento;
    private String telefono;
    private String correo;
    private LocalDate fechaNacimiento;
    private String direccion;

}
