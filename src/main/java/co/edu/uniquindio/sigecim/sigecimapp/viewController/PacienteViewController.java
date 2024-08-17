package co.edu.uniquindio.sigecim.sigecimapp.viewController;

import co.edu.uniquindio.sigecim.sigecimapp.controller.PacienteController;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.CitaDto;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.PacienteDto;
import co.edu.uniquindio.sigecim.sigecimapp.viewController.services.IBaseViewController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class PacienteViewController extends BaseViewController implements IBaseViewController<PacienteDto> {
    PacienteController pacienteController;
    ObservableList<PacienteDto> listaPacientesDto = FXCollections.observableArrayList();
    PacienteDto pacienteSeleccionado;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevo;

    @FXML
    private DatePicker dpFechaNacimiento;

    @FXML
    private TableView<PacienteDto> tblPaciente;

    @FXML
    private TableColumn<PacienteDto, String> tcCorreoElectronico;

    @FXML
    private TableColumn<PacienteDto, String> tcDireccion;

    @FXML
    private TableColumn<PacienteDto, String> tcDocumento;

    @FXML
    private TableColumn<PacienteDto, String> tcEps;

    @FXML
    private TableColumn<PacienteDto, String> tcFechaNacimiento;

    @FXML
    private TableColumn<PacienteDto, String> tcNombre;

    @FXML
    private TableColumn<PacienteDto, String> tcTelefono;

    @FXML
    private TextField txtCorreoElectronico;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtDocumento;

    @FXML
    private TextField txtEps;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    public void onActualizar(ActionEvent event) {
        actualizarPaciente();
    }

    @FXML
    public void onAgregar(ActionEvent event) {
        agregarPaciente();
    }

    @FXML
    public void onEliminar(ActionEvent event) {
        eliminarPaciente();
    }

    @FXML
    public void onNuevo(ActionEvent event) {
        limpiarCampos();
        deseleccionarTabla();
    }

    @FXML
    public void initialize() {
        pacienteController = new PacienteController();
        initView();
    }

    public void initView() {
        initDataBinding();
        obtenerPacientes();
        tblPaciente.getItems().clear();
        tblPaciente.setItems(listaPacientesDto);
        listenerSelection();
    }

    public void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcDocumento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().documento()));
        tcFechaNacimiento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fechaNacimiento()));
        tcDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().direccion()));
        tcTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().telefono()));
        tcCorreoElectronico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().correo()));
        tcEps.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().eps()));
    }

    private void obtenerPacientes() {
        listaPacientesDto.addAll(pacienteController.obtenerPacientes());
    }

    public void listenerSelection() {
        tblPaciente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            pacienteSeleccionado = newSelection;
            mostrarInformacionPaciente(pacienteSeleccionado);
        });
    }

    private void mostrarInformacionPaciente(PacienteDto pacienteSeleccionado) {
        if (pacienteSeleccionado != null) {
            txtNombre.setText(pacienteSeleccionado.nombre());
            txtDocumento.setText(pacienteSeleccionado.documento());
            dpFechaNacimiento.setValue(LocalDate.parse(pacienteSeleccionado.fechaNacimiento()));
            txtDireccion.setText(pacienteSeleccionado.direccion());
            txtTelefono.setText(pacienteSeleccionado.telefono());
            txtCorreoElectronico.setText(pacienteSeleccionado.correo());
            txtEps.setText(pacienteSeleccionado.eps());
            }
    }

    public boolean validarDatos(PacienteDto pacienteDto) {
        String mensaje = "";
        if (pacienteDto.nombre() == null || pacienteDto.nombre().isEmpty()) {
            mensaje += "El nombre es obligatorio\n";
        }
        if (pacienteDto.documento() == null || pacienteDto.documento().isEmpty()) {
            mensaje += "El documento es obligatorio\n";
        }
        if (pacienteDto.fechaNacimiento() == null || pacienteDto.fechaNacimiento().isEmpty()) {
            mensaje += "La fecha de nacimiento es obligatoria\n";
        }
        if (pacienteDto.direccion() == null || pacienteDto.direccion().isEmpty()) {
            mensaje += "La dirección es obligatoria\n";
        }
        if (pacienteDto.telefono() == null || pacienteDto.telefono().isEmpty()) {
            mensaje += "El teléfono es obligatorio\n";
        }
        if (pacienteDto.correo() == null || pacienteDto.correo().isEmpty()) {
            mensaje += "El correo electrónico es obligatorio\n";
        }
        if (pacienteDto.eps() == null || pacienteDto.eps().isEmpty()) {
            mensaje += "La EPS es obligatoria\n";
        }
        if (mensaje.isEmpty()) {
            return true;
        } else {
            mostrarMensaje("Notificación paciente",
                    "Datos inválidos", mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }

    public void limpiarCampos() {
        txtNombre.clear();
        txtDocumento.clear();
        dpFechaNacimiento.setValue(null);
        txtDireccion.clear();
        txtTelefono.clear();
        txtCorreoElectronico.clear();
        txtEps.clear();
    }

    public void deseleccionarTabla() {
        tblPaciente.getSelectionModel().clearSelection();
        pacienteSeleccionado = null;
    }

    private void agregarPaciente() {
        PacienteDto pacienteDto = construirPaciente();
        if (validarDatos(pacienteDto)) {
            if (pacienteController.agregar(pacienteDto)) {
                listaPacientesDto.add(pacienteDto);
                mostrarMensaje("Notificación paciente", "Paciente agregado",
                        "El paciente ha sido agregado con éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            } else {
                mostrarMensaje("Error paciente", "Paciente no agregado",
                        "El paciente no pudo ser agregado", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Error paciente", "Datos inválidos",
                    "Por favor, ingrese datos válidos", Alert.AlertType.ERROR);
        }
    }

    private PacienteDto construirPaciente() {
        return new PacienteDto(
                txtNombre.getText(),
                txtDocumento.getText(),
                txtTelefono.getText(),
                txtCorreoElectronico.getText(),
                dpFechaNacimiento.getValue().toString(),
                txtDireccion.getText(),
                txtEps.getText(),
                new ArrayList<CitaDto>());
    }

    private void eliminarPaciente() {
        boolean pacienteEliminado = false;
        if (pacienteSeleccionado != null) {
            if (mostrarMensajeConfirmacion("¿Está seguro de eliminar el paciente seleccionado?")) {
                pacienteEliminado = pacienteController.eliminar(pacienteSeleccionado.documento());
                if (pacienteEliminado) {
                    listaPacientesDto.remove(pacienteSeleccionado);
                    deseleccionarTabla();
                    limpiarCampos();
                    mostrarMensaje("Notificación paciente", "Paciente eliminado",
                            "El paciente ha sido eliminado con éxito", Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje("Error paciente", "Paciente no eliminado",
                            "El paciente no pudo ser eliminado", Alert.AlertType.ERROR);
                }
            }
        } else {
            mostrarMensaje("Error paciente", "Paciente no seleccionado",
                    "Por favor, seleccione un paciente", Alert.AlertType.ERROR);
        }
    }

    private void actualizarPaciente() {
        boolean pacienteActualizado = false;
        PacienteDto pacienteDto = construirPaciente();
        if (pacienteSeleccionado != null) {
            if (validarDatos(pacienteDto)) {
                int selectedIndex = tblPaciente.getSelectionModel().getSelectedIndex();
                pacienteActualizado = pacienteController.actualizar(pacienteSeleccionado.documento(), pacienteDto);
                if (pacienteActualizado) {
                    listaPacientesDto.set(selectedIndex, pacienteDto);
                    tblPaciente.refresh();
                    tblPaciente.getSelectionModel().select(selectedIndex);
                    mostrarMensaje("Notificación paciente", "Paciente actualizado",
                            "El paciente ha sido actualizado con éxito", Alert.AlertType.INFORMATION);
                    deseleccionarTabla();
                    limpiarCampos();
                } else {
                    mostrarMensaje("Error paciente", "Paciente no actualizado",
                            "El paciente no pudo ser actualizado", Alert.AlertType.ERROR);
                }
            } else {
                mostrarMensaje("Error paciente", "Datos inválidos",
                        "Por favor, ingrese datos válidos", Alert.AlertType.ERROR);
            }
        }
    }
}
