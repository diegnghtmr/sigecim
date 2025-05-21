package co.edu.uniquindio.sigecim.sigecimapp.controller;

import co.edu.uniquindio.sigecim.sigecimapp.exceptions.CitaException;
import co.edu.uniquindio.sigecim.sigecimapp.exceptions.DoctorException;
import co.edu.uniquindio.sigecim.sigecimapp.exceptions.PacienteException;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.CitaDto;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.DoctorDto;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.PacienteDto;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.mappers.ISigecimMapper;
import co.edu.uniquindio.sigecim.sigecimapp.model.*;
import co.edu.uniquindio.sigecim.sigecimapp.utils.SigecimUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class ModelFactory {
    Sigecim sigecim;
    ISigecimMapper sigecimMapper = ISigecimMapper.INSTANCE;

    private static class SingletonHolder {

        private static final ModelFactory eINSTANCE = new ModelFactory();


    }
    public static ModelFactory getInstance(){
        return SingletonHolder.eINSTANCE;
    }
    public ModelFactory() {
        cargarDatosBase();
    }
    private void cargarDatosBase() {
        sigecim = SigecimUtils.inicializarDatos();
    }
    public List<String> obtenerHorariosDisponibles() {
        return SigecimUtils.obtenerHorariosDisponibles();
    }

    public List<CitaDto> obtenerCitas() {
        return sigecimMapper.getCitasDto(sigecim.getListaCitas());
    }

    public boolean agregarCita(CitaDto citaDto) {
        try {
            if (!sigecim.verificarCitaExistente(citaDto.fecha(), citaDto.hora())) {
                Cita cita = sigecimMapper.citaDtoToCita(citaDto);
                getSigecim().agregarCita(cita);
            }
            return true;
        } catch (CitaException e) {
            e.getMessage();
            return false;
        }
    }

    public boolean eliminarCita(CitaDto citaDto) {
        boolean flagExiste = false;
        try {
            flagExiste = getSigecim().eliminarCita(citaDto.fecha(), citaDto.hora());
        } catch (CitaException e) {
            e.printStackTrace();
        }
        return flagExiste;
    }

    public boolean actualizarCita(CitaDto citaDtoActual, CitaDto citaDtoNueva) {
        try {
            Cita cita = sigecimMapper.citaDtoToCita(citaDtoNueva);
            getSigecim().actualizarCita(citaDtoActual.fecha(), citaDtoActual.hora(), cita);
            return true;
        } catch (CitaException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<DoctorDto> obtenerDoctores() {
        return sigecimMapper.getDoctoresDto(sigecim.getListaDoctores());
    }

    public boolean agregarDoctor(DoctorDto doctorDto) {
        try {
            if (!sigecim.verificarDoctorExistente(doctorDto.documento())) {
                Doctor doctor = sigecimMapper.doctorDtoToDoctor(doctorDto);
                getSigecim().agregarDoctor(doctor);
            }
            return true;
        } catch (DoctorException e) {
            e.getMessage();
            return false;
        }
    }

    public boolean eliminarDoctor(String documento) {
        boolean flagExiste = false;
        try {
            flagExiste = getSigecim().eliminarDoctor(documento);
        } catch (DoctorException e) {
            e.printStackTrace();
        }
        return flagExiste;
    }

    public boolean actualizarDoctor(String documento, DoctorDto doctorDto) {
        try {
            Doctor doctor = sigecimMapper.doctorDtoToDoctor(doctorDto);
            getSigecim().actualizarDoctor(documento, doctor);
            return true;
        } catch (DoctorException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<PacienteDto> obtenerPacientes() {
        return sigecimMapper.getPacientesDto(sigecim.getListaPacientes());
    }

    public boolean agregarPaciente(PacienteDto pacienteDto) {
        try {
            if (!sigecim.verificarPacienteExistente(pacienteDto.documento())) {
                Paciente paciente = sigecimMapper.pacienteDtoToPaciente(pacienteDto);
                getSigecim().agregarPaciente(paciente);
            }
            return true;
        } catch (PacienteException e) {
            e.getMessage();
            return false;
        }
    }

    public boolean eliminarPaciente(String documento) {
        boolean flagExiste = false;
        try {
            flagExiste = getSigecim().eliminarPaciente(documento);
        } catch (PacienteException e) {
            e.printStackTrace();
        }
        return flagExiste;
    }

    public boolean actualizarPaciente(String documento, PacienteDto pacienteDto) {
        try {
            Paciente paciente = sigecimMapper.pacienteDtoToPaciente(pacienteDto);
            getSigecim().actualizarPaciente(documento, paciente);
            return true;
        } catch (PacienteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
