package co.edu.uniquindio.sigecim.sigecimapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Setter
@Getter
@SuperBuilder

public class Doctor extends Persona{
    private String especialidad;
    private int experiencia;
    private List<Cita> listaCitas;

}
