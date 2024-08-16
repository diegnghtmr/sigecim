package co.edu.uniquindio.sigecim.sigecimapp.model;

import co.edu.uniquindio.sigecim.sigecimapp.exceptions.CitaException;
import co.edu.uniquindio.sigecim.sigecimapp.exceptions.DoctorException;
import co.edu.uniquindio.sigecim.sigecimapp.exceptions.PacienteException;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Builder

public class Sigecim {
    private final String nombre;
    private List<Empleado> listaEmpleados;
    private List<Doctor> listaDoctores;
    private List<Paciente> listaPacientes;
    private List<Cita> listaCitas;

    public boolean verificarCitaExistente(String fecha, String hora) throws CitaException {
        LocalDate fechaLocalDate = LocalDate.parse(fecha, DateTimeFormatter.ISO_DATE);
        LocalTime horaLocalTime = LocalTime.parse(hora, DateTimeFormatter.ISO_TIME);
        boolean citaExiste = listaCitas.stream().anyMatch(cita -> cita.getFecha().equals(fechaLocalDate) && cita.getHora().equals(horaLocalTime));

        if (citaExiste) {
            throw new CitaException("La cita con fecha: " + fecha + " y hora: " + hora + " ya existe");
        } else {
            return false;
        }
    }

    public void agregarCita(Cita cita) throws CitaException {
        getListaCitas().add(cita);
    }

    public boolean eliminarCita(String fecha, String hora) throws CitaException {
        Cita cita = null;
        boolean flagExiste = false;
        cita = obtenerCita(fecha, hora);
        if (cita == null) {
            throw new CitaException("La cita a eliminar no existe");
        } else {
            getListaCitas().remove(cita);
            flagExiste = true;
        }
        return flagExiste;
    }

    private Cita obtenerCita(String fecha, String hora) {
        LocalDate fechaLocalDate = LocalDate.parse(fecha, DateTimeFormatter.ISO_DATE);
        LocalTime horaLocalTime = LocalTime.parse(hora, DateTimeFormatter.ISO_TIME);
        return listaCitas.stream()
                .filter(cita -> cita.getFecha().equals(fechaLocalDate) && cita.getHora().equals(horaLocalTime))
                .findFirst()
                .orElse(null);
    }

    public boolean actualizarCita(String fecha, String hora, Cita cita) throws CitaException {
        Cita citaActual = obtenerCita(fecha, hora);
        if(citaActual == null){
            throw new CitaException("La cita a actualizar no existe");
        }else{
            citaActual.setFecha(cita.getFecha());
            citaActual.setHora(cita.getHora());
            citaActual.setDoctor(cita.getDoctor());
            citaActual.setPaciente(cita.getPaciente());
            citaActual.setMotivo(cita.getMotivo());
            return true;
        }
    }





    public boolean verificarDoctorExistente(String documento) throws DoctorException {
        boolean doctorExiste = listaDoctores.stream().anyMatch(doctor -> doctor.getDocumento().equals(documento));
        if (doctorExiste) {
            throw new DoctorException("El doctor con documento: " + documento + " ya existe");
        } else {
            return false;
        }
    }

    public void agregarDoctor(Doctor doctor) throws DoctorException {
        getListaDoctores().add(doctor);
    }

    public boolean eliminarDoctor(String documento) throws DoctorException {
        Doctor doctor = null;
        boolean flagExiste = false;
        doctor = obtenerDoctor(documento);
        if (doctor == null) {
            throw new DoctorException("El doctor a eliminar no existe");
        } else {
            getListaDoctores().remove(doctor);
            flagExiste = true;
        }
        return flagExiste;
    }

    private Doctor obtenerDoctor(String documento) {
        return listaDoctores.stream()
                .filter(doctor -> doctor.getDocumento().equals(documento))
                .findFirst()
                .orElse(null);
    }


    public boolean actualizarDoctor(String documento, Doctor doctor) throws DoctorException {
        Doctor doctorActual = obtenerDoctor(documento);
        if(doctorActual == null){
            throw new DoctorException("El doctor a actualizar no existe");
        }else{
            doctorActual.setNombre(doctor.getNombre());
            doctorActual.setDocumento(doctor.getDocumento());
            doctorActual.setTelefono(doctor.getTelefono());
            doctorActual.setCorreo(doctor.getCorreo());
            doctorActual.setFechaNacimiento(doctor.getFechaNacimiento());
            doctorActual.setDireccion(doctor.getDireccion());
            doctorActual.setEspecialidad(doctor.getEspecialidad());
            doctorActual.setExperiencia(doctor.getExperiencia());
            return true;
        }
    }





    public boolean verificarPacienteExistente(String documento) throws PacienteException {
        boolean pacienteExiste = listaPacientes.stream().anyMatch(paciente -> paciente.getDocumento().equals(documento));
        if (pacienteExiste) {
            throw new PacienteException("El paciente con documento: " + documento + " ya existe");
        } else {
            return false;
        }
    }


    public void agregarPaciente(Paciente paciente) throws PacienteException {
        getListaPacientes().add(paciente);
    }

    public boolean eliminarPaciente(String documento) throws PacienteException{
        Paciente paciente = null;
        boolean flagExiste = false;
        paciente = obtenerPaciente(documento);
        if(paciente == null){
            throw new PacienteException("El paciente a eliminar no existe");
        }else{
            getListaPacientes().remove(paciente);
            flagExiste = true;
        }
        return flagExiste;
    }

    private Paciente obtenerPaciente(String documento) {
        return listaPacientes.stream()
                .filter(paciente -> paciente.getDocumento().equals(documento))
                .findFirst()
                .orElse(null);
    }

    public boolean actualizarPaciente(String documento, Paciente paciente) throws PacienteException {
        Paciente pacienteActual = obtenerPaciente(documento);
        if(pacienteActual == null){
            throw new PacienteException("El paciente a actualizar no existe");
        }else{
            pacienteActual.setNombre(paciente.getNombre());
            pacienteActual.setDocumento(paciente.getDocumento());
            pacienteActual.setTelefono(paciente.getTelefono());
            pacienteActual.setCorreo(paciente.getCorreo());
            pacienteActual.setFechaNacimiento(paciente.getFechaNacimiento());
            pacienteActual.setDireccion(paciente.getDireccion());
            pacienteActual.setEps(paciente.getEps());
            return true;
        }
    }
}
