// CitaViewController.java

package co.edu.uniquindio.sigecim.sigecimapp.viewController;

import co.edu.uniquindio.sigecim.sigecimapp.controller.CitaController;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.CitaDto;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.DoctorDto;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.PacienteDto;
import co.edu.uniquindio.sigecim.sigecimapp.viewController.services.IBaseViewController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.Function;

public class CitaViewController extends BaseViewController implements IBaseViewController<CitaDto> {
    CitaController citaController;
    ObservableList<CitaDto> listaCitasDto = FXCollections.observableArrayList();
    CitaDto citaSeleccionada;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevo;

    @FXML
    private ComboBox<DoctorDto> cbDoctor;

    @FXML
    private ComboBox<String> cbHora;

    @FXML
    private ComboBox<PacienteDto> cbPaciente;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private TableView<CitaDto> tblCita;

    @FXML
    private TableColumn<CitaDto, String> tcDoctor;

    @FXML
    private TableColumn<CitaDto, String> tcDocumentoDoctor;

    @FXML
    private TableColumn<CitaDto, String> tcDocumentoPaciente;

    @FXML
    private TableColumn<CitaDto, String> tcFecha;

    @FXML
    private TableColumn<CitaDto, String> tcHora;

    @FXML
    private TableColumn<CitaDto, String> tcMotivo;

    @FXML
    private TableColumn<CitaDto, String> tcPaciente;

    @FXML
    private TextArea txtaMotivo;

    @FXML
    public void onActualizar(ActionEvent event) {
        actualizarCita();
    }

    @FXML
    public void onAgregar(ActionEvent event) {
        agregarCita();
    }

    @FXML
    public void onEliminar(ActionEvent event) {
        eliminarCita();
    }

    @FXML
    public void onNuevo(ActionEvent event) {
        limpiarCampos();
        deseleccionarTabla();
    }

    @FXML
    public void initialize() {
        citaController = new CitaController();
        initView();
    }

    public void initView() {
        initDataBinding();
        obtenerCitas();
        cargarDatosComboBox();
        tblCita.getItems().clear();
        tblCita.setItems(listaCitasDto);
        listenerSelection();
    }

    public void initDataBinding() {
        tcDoctor.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().doctor() != null ? cellData.getValue().doctor().nombre() : ""));
        tcDocumentoDoctor.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().doctor() != null ? cellData.getValue().doctor().documento() : ""));
        tcPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().paciente() != null ? cellData.getValue().paciente().nombre() : ""));
        tcDocumentoPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().paciente() != null ? cellData.getValue().paciente().documento() : ""));
        tcFecha.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().fecha()));
        tcHora.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().hora()));
        tcMotivo.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().motivo()));
    }

    private void obtenerCitas() {
        listaCitasDto.addAll(citaController.obtenerCitas());
    }

    private void cargarDatosComboBox() {
        ObservableList<DoctorDto> listaDoctores = FXCollections.observableArrayList(
                citaController.obtenerDoctores());
        ObservableList<PacienteDto> listaPacientes = FXCollections.observableArrayList(
                citaController.obtenerPacientes());
        ObservableList<String> listaHorarios = FXCollections.observableArrayList(
                citaController.obtenerHorariosDisponibles());

        initializeComboBox(cbDoctor, listaDoctores,
                doctor -> doctor.nombre() + " " + doctor.documento());
        initializeComboBox(cbPaciente, listaPacientes,
                paciente -> paciente.nombre() + " " + paciente.documento());
        initializeComboBox(cbHora, listaHorarios,
                Function.identity());
    }

    private <T> void initializeComboBox(ComboBox<T> comboBox,
                                        ObservableList<T> items,
                                        Function<T, String> displayFunction) {
        comboBox.setItems(items);
        comboBox.setCellFactory(lv -> new ListCell<T>() {
            @Override
            protected void updateItem(T item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : displayFunction.apply(item));
            }
        });
        comboBox.setButtonCell(new ListCell<T>() {
            @Override
            protected void updateItem(T item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : displayFunction.apply(item));
            }
        });
    }

    public void listenerSelection() {
        tblCita.getSelectionModel().selectedItemProperty().addListener((obs,
                                                                        oldSelection, newSelection) -> {
            citaSeleccionada = newSelection;
            mostrarInformacionCita(citaSeleccionada);
        });
    }

    private void mostrarInformacionCita(CitaDto citaSeleccionada) {
        if (citaSeleccionada != null) {
            dpFecha.setValue(LocalDate.parse(citaSeleccionada.fecha()));
            cbHora.setValue(citaSeleccionada.hora());
            cbDoctor.setValue(citaSeleccionada.doctor());
            cbPaciente.setValue(citaSeleccionada.paciente());
            txtaMotivo.setText(citaSeleccionada.motivo());
        }
    }

// CitaViewController.java

    public boolean validarDatos(CitaDto citaDto) {
        String mensaje = "";
        if (citaDto.fecha() == null || citaDto.fecha().isEmpty()) {
            mensaje += "La fecha es obligatoria\n";
        }
        if (citaDto.hora() == null || citaDto.hora().isEmpty()) {
            mensaje += "La hora es obligatoria\n";
        }
        if (citaDto.doctor() == null) {
            mensaje += "El doctor es obligatorio\n";
        }
        if (citaDto.paciente() == null) {
            mensaje += "El paciente es obligatorio\n";
        }
        if (citaDto.motivo() == null || citaDto.motivo().isEmpty()) {
            mensaje += "El motivo es obligatorio\n";
        }
        if (!mensaje.isEmpty()) {
            mostrarMensaje("Notificación cita", "Datos inválidos", mensaje, Alert.AlertType.WARNING);
            return false;
        }
        return esCitaValida(citaDto);
    }

    private boolean esCitaValida(CitaDto citaDto) {
        LocalDate fechaCita = LocalDate.parse(citaDto.fecha());
        LocalTime horaCita = LocalTime.parse(citaDto.hora());
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();

        if (fechaCita.isBefore(fechaActual) || (fechaCita.isEqual(fechaActual) && horaCita.isBefore(horaActual))) {
            mostrarMensaje("Notificación cita", "Fecha y hora inválidas", "La cita debe ser hoy o en una fecha y hora futura", Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }

    public void limpiarCampos(){
        dpFecha.setValue(null);
        cbHora.setValue(null);
        cbDoctor.setValue(null);
        cbPaciente.setValue(null);
        txtaMotivo.setText("");
    }

    public void deseleccionarTabla() {
        tblCita.getSelectionModel().clearSelection();
        citaSeleccionada = null;
    }

    private void agregarCita() {
        CitaDto citaDto = construirCitaDto();
        if (validarDatos(citaDto)) {
            if (citaController.agregar(citaDto)) {
                listaCitasDto.add(citaDto);
                mostrarMensaje("Notificación cita", "Cita agregada",
                        "La cita ha sido agregada con éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            } else {
                mostrarMensaje("Error cita", "Cita no agregada",
                        "La cita no pudo ser agregada", Alert.AlertType.ERROR);
            }
        }
    }

    private CitaDto construirCitaDto() {
        String fecha = dpFecha.getValue() != null ? dpFecha.getValue().toString() : "";
        return new CitaDto(
                fecha,
                cbHora.getValue(),
                txtaMotivo.getText(),
                cbPaciente.getValue(),
                cbDoctor.getValue());
    }

    private void eliminarCita() {
        boolean citaEliminada = false;
        if (citaSeleccionada != null) {
            if (mostrarMensajeConfirmacion("¿Está seguro de eliminar la cita seleccionada?")) {
                citaEliminada = citaController.eliminar(citaSeleccionada);
                if (citaEliminada) {
                    listaCitasDto.remove(citaSeleccionada);
                    deseleccionarTabla();
                    limpiarCampos();
                    mostrarMensaje("Notificación cita", "Cita eliminada",
                            "La cita ha sido eliminada con éxito", Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje("Error cita", "Cita no eliminada",
                            "La cita no pudo ser eliminada", Alert.AlertType.ERROR);
                }
            }
        } else {
            mostrarMensaje("Error cita", "Cita no seleccionada",
                    "Por favor, seleccione una cita para eliminar", Alert.AlertType.ERROR);
        }
    }

    private void actualizarCita() {
        boolean citaActualizada = false;
        CitaDto citaDto = construirCitaDto();
        if (citaSeleccionada != null) {
            if (validarDatos(citaDto)) {
                if (!hayCambios(citaSeleccionada, citaDto)) {
                    mostrarMensaje("Error cita", "Sin cambios",
                            "No se puede actualizar la cita sin cambios", Alert.AlertType.ERROR);
                    return;
                }
                int selectedIndex = tblCita.getSelectionModel().getSelectedIndex();
                citaActualizada = citaController.actualizar(citaSeleccionada, citaDto);
                if (citaActualizada) {
                    listaCitasDto.set(selectedIndex, citaDto);
                    tblCita.refresh();
                    tblCita.getSelectionModel().select(selectedIndex);
                    mostrarMensaje("Notificación cita", "Cita actualizada",
                            "La cita ha sido actualizada con éxito", Alert.AlertType.INFORMATION);
                    deseleccionarTabla();
                    limpiarCampos();
                } else {
                    mostrarMensaje("Error cita", "Cita no actualizada",
                            "La cita no pudo ser actualizada", Alert.AlertType.ERROR);
                }
            }
        } else {
            mostrarMensaje("Error cita", "Cita no seleccionada",
                    "Por favor, seleccione una cita para actualizar", Alert.AlertType.ERROR);
        }
    }

    private boolean hayCambios(CitaDto citaSeleccionada, CitaDto citaDto) {
        return !citaSeleccionada.fecha().equals(citaDto.fecha()) ||
                !citaSeleccionada.hora().equals(citaDto.hora()) ||
                !citaSeleccionada.doctor().equals(citaDto.doctor()) ||
                !citaSeleccionada.paciente().equals(citaDto.paciente()) ||
                !citaSeleccionada.motivo().equals(citaDto.motivo());
    }
}