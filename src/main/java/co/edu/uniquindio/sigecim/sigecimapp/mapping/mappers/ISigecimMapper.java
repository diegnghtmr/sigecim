package co.edu.uniquindio.sigecim.sigecimapp.mapping.mappers;

import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.*;
import co.edu.uniquindio.sigecim.sigecimapp.model.*;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ISigecimMapper {
    ISigecimMapper INSTANCE = Mappers.getMapper(ISigecimMapper.class);

    // Cita mapping methods
    @Named("citaToCitaDto")
    CitaDto citaToCitaDto(Cita cita);

    @Named("citaDtoToCita")
    Cita citaDtoToCita(CitaDto citaDto);

    @IterableMapping(qualifiedByName = "citaToCitaDto")
    List<CitaDto> getCitasDto(List<Cita> listaCitas);

    // Paciente mapping methods
    @Named("pacienteToPacienteDto")
    PacienteDto pacienteToPacienteDto(Paciente paciente);

    @Named("pacienteDtoToPaciente")
    Paciente pacienteDtoToPaciente(PacienteDto pacienteDto);

    @IterableMapping(qualifiedByName = "pacienteToPacienteDto")
    List<PacienteDto> getPacientesDto(List<Paciente> listaPacientes);

    // Doctor mapping methods
    @Named("doctorToDoctorDto")
    DoctorDto doctorToDoctorDto(Doctor doctor);

    @Named("doctorDtoToDoctor")
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
