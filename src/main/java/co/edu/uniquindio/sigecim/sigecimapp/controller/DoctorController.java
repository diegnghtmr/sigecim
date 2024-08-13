package co.edu.uniquindio.sigecim.sigecimapp.controller;

import co.edu.uniquindio.sigecim.sigecimapp.controller.services.IBaseController;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.DoctorDto;

import java.util.List;

public class DoctorController extends BaseController implements IBaseController<DoctorDto> {
    public DoctorController() {
        super();
    }

    public List<DoctorDto> obtenerDoctores() {
        return modelFactory.obtenerDoctores();
    }

    public boolean agregar(DoctorDto doctorDto) {
        return modelFactory.agregarDoctor(doctorDto);
    }

    public boolean eliminar(String documento) {
        return modelFactory.eliminarDoctor(documento);
    }

    public boolean actualizar(String documento, DoctorDto doctorDto) {
        return modelFactory.actualizarDoctor(documento, doctorDto);
    }
}