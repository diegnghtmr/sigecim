package co.edu.uniquindio.sigecim.sigecimapp.utils;

import co.edu.uniquindio.sigecim.sigecimapp.model.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class SigecimUtils {
    public static Sigecim inicializarDatos() {
        Sigecim sigecim = Sigecim.builder().build();

        Doctor doctor1 = Doctor.builder()
                .nombre("Jhon Oscar").documento("1048385436").telefono("3136843754")
                .correo("jhonoscar777@example.com")
                .fechaNacimiento(LocalDate.of(1980, 2, 10))
                .direccion("calle 777").especialidad("Medicina General").experiencia(10).build();

        Doctor doctor2 = Doctor.builder()
                .nombre("Maria Teresa").documento("2048385437").telefono("3201234567")
                .correo("mariateresaforever@example.com")
                .fechaNacimiento(LocalDate.of(1975, 4, 12))
                .direccion("avenida 45").especialidad("Pediatría").experiencia(15).build();

        Doctor doctor3 = Doctor.builder()
                .nombre("Carlos Alberto").documento("3048385438").telefono("3109876543")
                .correo("carlosalberto65@example.com")
                .fechaNacimiento(LocalDate.of(1982, 6, 23))
                .direccion("carrera 7").especialidad("Cardiología").experiencia(12).build();

        Doctor doctor4 = Doctor.builder()
                .nombre("Laura Beatriz").documento("4048385439").telefono("3001122334")
                .correo("laurabeatrizdc@example.com")
                .fechaNacimiento(LocalDate.of(1988, 9, 30))
                .direccion("calle 9").especialidad("Dermatología").experiencia(8).build();

        Doctor doctor5 = Doctor.builder()
                .nombre("Juan Carlos").documento("5048385440").telefono("3112233445")
                .correo("juancarlos001@example.com")
                .fechaNacimiento(LocalDate.of(1979, 11, 11))
                .direccion("avenida 10").especialidad("Neurología").experiencia(14).build();

        Doctor doctor6 = Doctor.builder()
                .nombre("Ana Lucia").documento("6048385441").telefono("3123344556")
                .correo("analuciamedica@example.com")
                .fechaNacimiento(LocalDate.of(1985, 2, 5))
                .direccion("carrera 15").especialidad("Ginecología").experiencia(10).build();

        Doctor doctor7 = Doctor.builder()
                .nombre("Miguel Angel").documento("7048385442").telefono("3134455667")
                .correo("miguelangel23@example.com")
                .fechaNacimiento(LocalDate.of(1983, 8, 19))
                .direccion("calle 20").especialidad("Ortopedia").experiencia(11).build();

        Doctor doctor8 = Doctor.builder()
                .nombre("Daniela Patricia").documento("8048385443").telefono("3145566778")
                .correo("danielapatriciaes@example.com")
                .fechaNacimiento(LocalDate.of(1991, 4, 25))
                .direccion("avenida 33").especialidad("Oftalmología").experiencia(7).build();

        Doctor doctor9 = Doctor.builder()
                .nombre("Santiago Jose").documento("9048385444").telefono("3156677889")
                .correo("santiagojosefr@example.com")
                .fechaNacimiento(LocalDate.of(1986, 6, 14))
                .direccion("carrera 21").especialidad("Psiquiatría").experiencia(9).build();

        Doctor doctor10 = Doctor.builder()
                .nombre("Valentina Isabel").documento("10048385445").telefono("3167788990")
                .correo("valentinaisabeluk@example.com")
                .fechaNacimiento(LocalDate.of(1993, 12, 3))
                .direccion("calle 25").especialidad("Endocrinología").experiencia(5).build();

        Paciente paciente1 = Paciente.builder()
                .nombre("Jhon Alejandro").documento("1048385436").telefono("3136843754")
                .correo("jhonalejo123@example.com")
                .fechaNacimiento(LocalDate.of(1990, 1, 1))
                .direccion("calle 13").eps("SURA").build();

        Paciente paciente2 = Paciente.builder()
                .nombre("Maria Fernanda").documento("1667385437").telefono("3201234567")
                .correo("mariafernandauwu@example.com")
                .fechaNacimiento(LocalDate.of(1985, 5, 15))
                .direccion("avenida 45").eps("SANITAS").build();

        Paciente paciente3 = Paciente.builder()
                .nombre("Carlos Andres").documento("1961385438").telefono("3109876543")
                .correo("carlosandresaa@example.com")
                .fechaNacimiento(LocalDate.of(1978, 3, 22))
                .direccion("carrera 7").eps("COOMEVA").build();

        Paciente paciente4 = Paciente.builder()
                .nombre("Laura Camila").documento("1000385439").telefono("3001122334")
                .correo("lauracamilita@example.com")
                .fechaNacimiento(LocalDate.of(1992, 7, 30))
                .direccion("calle 9").eps("NUEVA EPS").build();

        Paciente paciente5 = Paciente.builder()
                .nombre("Juan David").documento("1128385440").telefono("3112233445")
                .correo("juandd@example.com")
                .fechaNacimiento(LocalDate.of(1988, 11, 11))
                .direccion("avenida 10").eps("CAFESALUD").build();

        Paciente paciente6 = Paciente.builder()
                .nombre("Ana Sofia").documento("1448385441").telefono("3123344556")
                .correo("anasofiaaa@example.com")
                .fechaNacimiento(LocalDate.of(1995, 2, 5))
                .direccion("carrera 15").eps("FAMISANAR").build();

        Paciente paciente7 = Paciente.builder()
                .nombre("Miguel Angel").documento("1554385442").telefono("3134455667")
                .correo("miguelangelreal@example.com")
                .fechaNacimiento(LocalDate.of(1983, 8, 19))
                .direccion("calle 20").eps("SALUD TOTAL").build();

        Paciente paciente8 = Paciente.builder()
                .nombre("Daniela Patricia").documento("1221385443").telefono("3145566778")
                .correo("danielapatriciaofficial@example.com")
                .fechaNacimiento(LocalDate.of(1991, 4, 25))
                .direccion("avenida 33").eps("COMPENSAR").build();

        Paciente paciente9 = Paciente.builder()
                .nombre("Santiago Jose").documento("1467385444").telefono("3156677889")
                .correo("santiagojosekkkk@example.com")
                .fechaNacimiento(LocalDate.of(1986, 6, 14))
                .direccion("carrera 21").eps("COLSUBSIDIO").build();

        Paciente paciente10 = Paciente.builder()
                .nombre("Valentina Isabel").documento("1210385445").telefono("3167788990")
                .correo("valentinaisabel01@example.com")
                .fechaNacimiento(LocalDate.of(1993, 12, 3))
                .direccion("calle 25").eps("CRUZ BLANCA").build();

        Cita cita1 = Cita.builder().fecha(LocalDate.now().minusMonths(5))
                .hora(LocalTime.of(8, 0)).motivo("Consulta general")
                .paciente(paciente3).doctor(doctor1).build();

        Cita cita2 = Cita.builder().fecha(LocalDate.now().minusMonths(8))
                .hora(LocalTime.of(9, 0)).motivo("Revisión pediátrica")
                .paciente(paciente1).doctor(doctor2).build();

        Cita cita3 = Cita.builder().fecha(LocalDate.now().minusMonths(10))
                .hora(LocalTime.of(10, 0)).motivo("Chequeo cardiológico")
                .paciente(paciente2).doctor(doctor3).build();

        Cita cita4 = Cita.builder().fecha(LocalDate.now().minusMonths(3))
                .hora(LocalTime.of(11, 0)).motivo("Consulta dermatológica")
                .paciente(paciente4).doctor(doctor4).build();

        Cita cita5 = Cita.builder().fecha(LocalDate.now().minusMonths(2))
                .hora(LocalTime.of(12, 0)).motivo("Evaluación neurológica")
                .paciente(paciente5).doctor(doctor5).build();

        Cita cita6 = Cita.builder().fecha(LocalDate.now().minusMonths(6))
                .hora(LocalTime.of(13, 0)).motivo("Consulta ginecológica")
                .paciente(paciente6).doctor(doctor6).build();

        Cita cita7 = Cita.builder().fecha(LocalDate.now().minusMonths(12))
                .hora(LocalTime.of(14, 0)).motivo("Revisión ortopédica")
                .paciente(paciente7).doctor(doctor7).build();

        Cita cita8 = Cita.builder().fecha(LocalDate.now().minusMonths(2))
                .hora(LocalTime.of(15, 0)).motivo("Chequeo oftalmológico")
                .paciente(paciente8).doctor(doctor8).build();

        Cita cita9 = Cita.builder().fecha(LocalDate.now().minusMonths(8))
                .hora(LocalTime.of(16, 0)).motivo("Consulta psiquiátrica")
                .paciente(paciente9).doctor(doctor9).build();

        Cita cita10 = Cita.builder().fecha(LocalDate.now().minusMonths(10))
                .hora(LocalTime.of(17, 0)).motivo("Evaluación endocrinológica")
                .paciente(paciente10).doctor(doctor10).build();

        Empleado empleado1 = Empleado.builder()
                .nombre("Juan Esteban").documento("1048385436")
                .telefono("3136877754").correo("juan.esteban@gmail.com")
                .fechaNacimiento(LocalDate.of(1999, 7, 5))
                .direccion("calle 1").contrasenia("password0").build();

        Empleado empleado2 = Empleado.builder()
                .nombre("Sofia Martinez").documento("2048385437")
                .telefono("3201234567").correo("sofia.martinez@example.com")
                .fechaNacimiento(LocalDate.of(1990, 3, 12))
                .direccion("avenida 2").contrasenia("password1").build();

        Empleado empleado3 = Empleado.builder()
                .nombre("Andres Felipe").documento("3048385438")
                .telefono("3109876543").correo("andres.felipe@example.com")
                .fechaNacimiento(LocalDate.of(1988, 6, 23))
                .direccion("carrera 3").contrasenia("password2").build();

        Empleado empleado4 = Empleado.builder()
                .nombre("Beatriz Gomez").documento("4048385439")
                .telefono("3001122334").correo("beatriz.gomez@example.com")
                .fechaNacimiento(LocalDate.of(1992, 9, 30))
                .direccion("calle 4").contrasenia("password3").build();

        Empleado empleado5 = Empleado.builder()
                .nombre("Carlos Perez").documento("5048385440")
                .telefono("3112233445").correo("carlos.perez@example.com")
                .fechaNacimiento(LocalDate.of(1985, 11, 11))
                .direccion("avenida 5").contrasenia("password4").build();

        doctor1.getListaCitas().add(cita1);
        doctor2.getListaCitas().add(cita2);
        doctor3.getListaCitas().add(cita3);
        doctor4.getListaCitas().add(cita4);
        doctor5.getListaCitas().add(cita5);
        doctor6.getListaCitas().add(cita6);
        doctor7.getListaCitas().add(cita7);
        doctor8.getListaCitas().add(cita8);
        doctor9.getListaCitas().add(cita9);
        doctor10.getListaCitas().add(cita10);

        paciente1.getListaCitas().add(cita2);
        paciente2.getListaCitas().add(cita3);
        paciente3.getListaCitas().add(cita1);
        paciente4.getListaCitas().add(cita4);
        paciente5.getListaCitas().add(cita5);
        paciente6.getListaCitas().add(cita6);
        paciente7.getListaCitas().add(cita7);
        paciente8.getListaCitas().add(cita8);
        paciente9.getListaCitas().add(cita9);
        paciente10.getListaCitas().add(cita10);

        sigecim.getListaDoctores().add(doctor1);
        sigecim.getListaDoctores().add(doctor2);
        sigecim.getListaDoctores().add(doctor3);
        sigecim.getListaDoctores().add(doctor4);
        sigecim.getListaDoctores().add(doctor5);
        sigecim.getListaDoctores().add(doctor6);
        sigecim.getListaDoctores().add(doctor7);
        sigecim.getListaDoctores().add(doctor8);
        sigecim.getListaDoctores().add(doctor9);
        sigecim.getListaDoctores().add(doctor10);

        sigecim.getListaPacientes().add(paciente1);
        sigecim.getListaPacientes().add(paciente2);
        sigecim.getListaPacientes().add(paciente3);
        sigecim.getListaPacientes().add(paciente4);
        sigecim.getListaPacientes().add(paciente5);
        sigecim.getListaPacientes().add(paciente6);
        sigecim.getListaPacientes().add(paciente7);
        sigecim.getListaPacientes().add(paciente8);
        sigecim.getListaPacientes().add(paciente9);
        sigecim.getListaPacientes().add(paciente10);

        sigecim.getListaCitas().add(cita1);
        sigecim.getListaCitas().add(cita2);
        sigecim.getListaCitas().add(cita3);
        sigecim.getListaCitas().add(cita4);
        sigecim.getListaCitas().add(cita5);
        sigecim.getListaCitas().add(cita6);
        sigecim.getListaCitas().add(cita7);
        sigecim.getListaCitas().add(cita8);
        sigecim.getListaCitas().add(cita9);
        sigecim.getListaCitas().add(cita10);

        sigecim.getListaEmpleados().add(empleado1);
        sigecim.getListaEmpleados().add(empleado2);
        sigecim.getListaEmpleados().add(empleado3);
        sigecim.getListaEmpleados().add(empleado4);
        sigecim.getListaEmpleados().add(empleado5);

        return sigecim;
    }

}
