package co.edu.uniquindio.sigecim.sigecimapp.controller;

import co.edu.uniquindio.sigecim.sigecimapp.controller.services.IBaseController;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.PacienteDto;

import java.util.List;

public class PacienteController extends BaseController implements IBaseController<PacienteDto> {
    public PacienteController() {
        super();
    }

    public List<PacienteDto> obtenerPacientes() {
        return modelFactory.obtenerPacientes();
    }

    public boolean agregar(PacienteDto pacienteDto) {
        return modelFactory.agregarPaciente(pacienteDto);
    }

    public boolean eliminar(String documento) {
        return modelFactory.eliminarPaciente(documento);
    }

    public boolean actualizar(String documento, PacienteDto pacienteDto) {
        return modelFactory.actualizarPaciente(documento, pacienteDto);
    }
}