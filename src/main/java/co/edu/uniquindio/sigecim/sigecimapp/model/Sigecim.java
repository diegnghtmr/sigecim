package co.edu.uniquindio.sigecim.sigecimapp.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class Sigecim {
    private final String nombre;
    private List<Empleado> listaEmpleados;
    private List<Doctor> listaDoctores;
    private List<Paciente> listaPacientes;
    private List<Cita> listaCitas;

}
