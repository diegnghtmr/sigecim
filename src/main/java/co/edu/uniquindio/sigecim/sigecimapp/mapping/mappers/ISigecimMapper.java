package co.edu.uniquindio.sigecim.sigecimapp.mapping.mappers;

import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.CitaDto;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.DoctorDto;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.PacienteDto;
import co.edu.uniquindio.sigecim.sigecimapp.model.Cita;
import co.edu.uniquindio.sigecim.sigecimapp.model.Doctor;
import co.edu.uniquindio.sigecim.sigecimapp.model.Paciente;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ISigecimMapper {
    ISigecimMapper INSTANCE = Mappers.getMapper(ISigecimMapper.class);

    // Cita mapping methods
    @Named("CitaToCitaDto")
    CitaDto citaToCitaDto(Cita cita);

    Cita citaDtoToCita(CitaDto citaDto);

    @IterableMapping(qualifiedByName = "CitaToCitaDto")
    List<CitaDto> getCitasDto(List<Cita> listaCitas);

    // Paciente mapping methods
    @Named("PacienteToPacienteDto")
    PacienteDto pacienteToPacienteDto(Paciente paciente);

    Paciente pacienteDtoToPaciente(PacienteDto pacienteDto);

    @IterableMapping(qualifiedByName = "PacienteToPacienteDto")
    List<PacienteDto> getPacientesDto(List<Paciente> listaPacientes);

    // Doctor mapping methods
    @Named("DoctorToDoctorDto")
    DoctorDto doctorToDoctorDto(Doctor doctor);

    Doctor doctorDtoToDoctor(DoctorDto doctorDto);

    @IterableMapping(qualifiedByName = "DoctorToDoctorDto")
    List<DoctorDto> getDoctoresDto(List<Doctor> listaDoctores);
}
