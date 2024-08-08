package co.edu.uniquindio.sigecim.sigecimapp.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder

public class Doctor extends Persona{
    private String especialidad;
    private int experiencia;
    private List<Cita> listaCitas;

}
