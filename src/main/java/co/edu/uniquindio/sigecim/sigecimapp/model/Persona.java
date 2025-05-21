package co.edu.uniquindio.sigecim.sigecimapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

public abstract class Persona {
    private String nombre;
    private String documento;
    private String telefono;
    private String correo;
    private LocalDate fechaNacimiento;
    private String direccion;

}
