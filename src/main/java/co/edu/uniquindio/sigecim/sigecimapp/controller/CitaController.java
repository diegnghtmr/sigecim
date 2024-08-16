package co.edu.uniquindio.sigecim.sigecimapp.controller;

import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.CitaDto;

import java.util.List;

public class CitaController extends BaseController {
    public CitaController() {
        super();
    }

    public List<CitaDto> obtenerCitas() {
        return modelFactory.obtenerCitas();
    }

    public boolean agregar(CitaDto citaDto) {
        return modelFactory.agregarCita(citaDto);
    }

    public boolean eliminar(CitaDto citaDto) {
        return modelFactory.eliminarCita(citaDto);
    }

    public boolean actualizar(CitaDto citaDtoActual, CitaDto citaDtoNueva) {
        return modelFactory.actualizarCita(citaDtoActual, citaDtoNueva);
    }

}
