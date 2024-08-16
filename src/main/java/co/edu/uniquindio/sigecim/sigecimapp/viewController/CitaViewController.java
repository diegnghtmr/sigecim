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
        tblCita.getItems().clear();
        tblCita.setItems(listaCitasDto);
        listenerSelection();
    }

    public void initDataBinding() {
        tcDoctor.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().doctor().nombre()));
        tcDocumentoDoctor.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().doctor().documento()));
        tcPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().paciente().nombre()));
        tcDocumentoPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().paciente().documento()));
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
        if (mensaje.isEmpty()) {
            return true;
        } else {
            mostrarMensaje("Notificación cita",
                    "Datos inválidos", mensaje, Alert.AlertType.WARNING);
            return false;
        }
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
        } else {
            mostrarMensaje("Error cita", "Datos inválidos",
                    "Por favor, ingrese datos válidos", Alert.AlertType.ERROR);
        }
    }

    private CitaDto construirCitaDto() {
        return new CitaDto(
                dpFecha.getValue().toString(),
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
                citaActualizada = citaController.actualizar(citaSeleccionada, citaDto);
                if (citaActualizada) {
                    listaCitasDto.remove(citaSeleccionada);
                    listaCitasDto.add(citaDto);
                    tblCita.refresh();
                    mostrarMensaje("Notificación cita", "Cita actualizada",
                            "La cita ha sido actualizada con éxito", Alert.AlertType.INFORMATION);
                    deseleccionarTabla();
                    limpiarCampos();
                } else {
                    mostrarMensaje("Error cita", "Cita no actualizada",
                            "La cita no pudo ser actualizada", Alert.AlertType.ERROR);
                }
            } else {
                mostrarMensaje("Error cita", "Datos inválidos",
                        "Por favor, ingrese datos válidos", Alert.AlertType.ERROR);
            }
        }
    }

}
