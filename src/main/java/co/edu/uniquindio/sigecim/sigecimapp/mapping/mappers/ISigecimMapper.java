package co.edu.uniquindio.sigecim.sigecimapp.mapping.mappers;

import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.*;
import co.edu.uniquindio.sigecim.sigecimapp.model.*;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ISigecimMapper {
    ISigecimMapper INSTANCE = Mappers.getMapper(ISigecimMapper.class);

    // Cita mapping methods
    @Named("citaToCitaDto")
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "hora", target = "hora")
    @Mapping(source = "motivo", target = "motivo")
    @Mapping(source = "paciente", target = "paciente")
    @Mapping(source = "doctor", target = "doctor")
    CitaDto citaToCitaDto(Cita cita);

    @Named("citaDtoToCita")
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "hora", target = "hora")
    @Mapping(source = "motivo", target = "motivo")
    @Mapping(source = "paciente", target = "paciente")
    @Mapping(source = "doctor", target = "doctor")
    Cita citaDtoToCita(CitaDto citaDto);

    @IterableMapping(qualifiedByName = "citaToCitaDto")
    List<CitaDto> getCitasDto(List<Cita> listaCitas);

    // Paciente mapping methods
    @Named("pacienteToPacienteDto")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "documento", target = "documento")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "fechaNacimiento", target = "fechaNacimiento")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "eps", target = "eps")
    PacienteDto pacienteToPacienteDto(Paciente paciente);

    @Named("pacienteDtoToPaciente")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "documento", target = "documento")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "fechaNacimiento", target = "fechaNacimiento")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "eps", target = "eps")
    Paciente pacienteDtoToPaciente(PacienteDto pacienteDto);

    @IterableMapping(qualifiedByName = "pacienteToPacienteDto")
    List<PacienteDto> getPacientesDto(List<Paciente> listaPacientes);

    // Doctor mapping methods
    @Named("doctorToDoctorDto")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "documento", target = "documento")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "fechaNacimiento", target = "fechaNacimiento")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "especialidad", target = "especialidad")
    @Mapping(source = "experiencia", target = "experiencia")
    DoctorDto doctorToDoctorDto(Doctor doctor);

    @Named("doctorDtoToDoctor")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "documento", target = "documento")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "fechaNacimiento", target = "fechaNacimiento")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "especialidad", target = "especialidad")
    @Mapping(source = "experiencia", target = "experiencia")
    Doctor doctorDtoToDoctor(DoctorDto doctorDto);

    @IterableMapping(qualifiedByName = "doctorToDoctorDto")
    List<DoctorDto> getDoctoresDto(List<Doctor> listaDoctores);

    // Additional mapping methods for lists (if needed)
    @IterableMapping(qualifiedByName = "citaDtoToCita")
    List<Cita> getCitasFromDtos(List<CitaDto> listaCitasDto);

    @IterableMapping(qualifiedByName = "pacienteDtoToPaciente")
    List<Paciente> getPacientesFromDtos(List<PacienteDto> listaPacientesDto);

    @IterableMapping(qualifiedByName = "doctorDtoToDoctor")
    List<Doctor> getDoctoresFromDtos(List<DoctorDto> listaDoctoresDto);
}
