package co.edu.uniquindio.sigecim.sigecimapp.viewController;

import co.edu.uniquindio.sigecim.sigecimapp.controller.DoctorController;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.CitaDto;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.DoctorDto;
import co.edu.uniquindio.sigecim.sigecimapp.viewController.services.IBaseViewController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class DoctorViewController extends BaseViewController implements IBaseViewController<DoctorDto> {
    DoctorController doctorController;
    ObservableList<DoctorDto>  listaDoctoresDto = FXCollections.observableArrayList();
    DoctorDto doctorSeleccionado;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevo;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private TableView<DoctorDto> tblDoctor;

    @FXML
    private TableColumn<DoctorDto, String> tcCorreoElectronico;

    @FXML
    private TableColumn<DoctorDto, String> tcDireccion;

    @FXML
    private TableColumn<DoctorDto, String> tcDocumento;

    @FXML
    private TableColumn<DoctorDto, String> tcEspecialidad;

    @FXML
    private TableColumn<DoctorDto, String> tcExperiencia;

    @FXML
    private TableColumn<DoctorDto, String> tcFechaNacimiento;

    @FXML
    private TableColumn<DoctorDto, String> tcNombre;

    @FXML
    private TableColumn<DoctorDto, String> tcTelefono;

    @FXML
    private TextField txtCorreoElectronico;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtDocumento;

    @FXML
    private TextField txtEspecialidad;

    @FXML
    private TextField txtExperiencia;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    public void onActualizar(ActionEvent event) {
        actualizarDoctor();
    }

    @FXML
    public void onAgregar(ActionEvent event) {
        agregarDoctor();
    }

    @FXML
    public void onEliminar(ActionEvent event) {
        eliminarDoctor();
    }

    @FXML
    public void onNuevo(ActionEvent event) {
        limpiarCampos();
        deseleccionarTabla();
    }

    @FXML
    public void initialize() {
        doctorController = new DoctorController();
        initView();
    }

    public void initView() {
        initDataBinding();
        obtenerDoctores();
        tblDoctor.getItems().clear();
        tblDoctor.setItems(listaDoctoresDto);
        listenerSelection();
    }

    public void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().nombre()));
        tcDocumento.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().documento()));
        tcFechaNacimiento.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().fechaNacimiento()));
        tcDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().direccion()));
        tcTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().telefono()));
        tcCorreoElectronico.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().correo()));
        tcEspecialidad.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().especialidad()));
        tcExperiencia.setCellValueFactory(cellData -> new SimpleStringProperty(
                String.valueOf(cellData.getValue().experiencia())));
    }

    private void obtenerDoctores() {
        listaDoctoresDto.addAll(doctorController.obtenerDoctores());
    }

    public void listenerSelection() {
        tblDoctor.getSelectionModel().selectedItemProperty().addListener((obs,
                                                                          oldSelection, newSelection) -> {
            doctorSeleccionado = newSelection;
            mostrarInformacionDoctor(doctorSeleccionado);
        });
    }

    private void mostrarInformacionDoctor(DoctorDto doctorSeleccionado) {
        if (doctorSeleccionado != null) {
            txtNombre.setText(doctorSeleccionado.nombre());
            txtDocumento.setText(doctorSeleccionado.documento());
            dpFecha.setValue(LocalDate.parse(doctorSeleccionado.fechaNacimiento()));
            txtDireccion.setText(doctorSeleccionado.direccion());
            txtTelefono.setText(doctorSeleccionado.telefono());
            txtCorreoElectronico.setText(doctorSeleccionado.correo());
            txtEspecialidad.setText(doctorSeleccionado.especialidad());
            txtExperiencia.setText(String.valueOf(doctorSeleccionado.experiencia()));
        }
    }

    public boolean validarDatos(DoctorDto doctorDto) {
        String mensaje = "";
        if (doctorDto.nombre() == null || doctorDto.nombre().isEmpty()) {
            mensaje += "El nombre es obligatorio\n";
        }
        if (doctorDto.documento() == null || doctorDto.documento().isEmpty()) {
            mensaje += "El documento es obligatorio\n";
        }
        if (doctorDto.fechaNacimiento() == null || doctorDto.fechaNacimiento().isEmpty()) {
            mensaje += "La fecha de nacimiento es obligatoria\n";
        } else {
            LocalDate fechaNacimiento = LocalDate.parse(doctorDto.fechaNacimiento());
            if (fechaNacimiento.isAfter(LocalDate.now().minusYears(18))) {
                mensaje += "El doctor debe tener al menos 18 años\n";
            }
        }
        if (doctorDto.direccion() == null || doctorDto.direccion().isEmpty()) {
            mensaje += "La dirección es obligatoria\n";
        }
        if (doctorDto.telefono() == null || doctorDto.telefono().isEmpty()) {
            mensaje += "El teléfono es obligatorio\n";
        }
        if (doctorDto.correo() == null || doctorDto.correo().isEmpty()) {
            mensaje += "El correo es obligatorio\n";
        }
        if (doctorDto.especialidad() == null || doctorDto.especialidad().isEmpty()) {
            mensaje += "La especialidad es obligatoria\n";
        }
        if (doctorDto.experiencia() < 0) {
            mensaje += "La experiencia no puede ser negativa\n";
        }
        if (mensaje.isEmpty()) {
            return true;
        } else {
            mostrarMensaje("Notificación doctor", "Datos inválidos", mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }

    public void limpiarCampos() {
        txtNombre.clear();
        txtDocumento.clear();
        dpFecha.setValue(null);
        txtDireccion.clear();
        txtTelefono.clear();
        txtCorreoElectronico.clear();
        txtEspecialidad.clear();
        txtExperiencia.clear();
    }

    public void deseleccionarTabla() {
        tblDoctor.getSelectionModel().clearSelection();
        doctorSeleccionado = null;
    }

    private void agregarDoctor() {
        DoctorDto doctorDto = construirDoctor();
        if (validarDatos(doctorDto)) {
            if (doctorController.agregar(doctorDto)) {
                listaDoctoresDto.add(doctorDto);
                mostrarMensaje("Notificación doctor", "Doctor agregado",
                        "El doctor ha sido agregado con éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            } else {
                mostrarMensaje("Error doctor", "Doctor no agregado",
                        "El doctor no pudo ser agregado", Alert.AlertType.ERROR);
            }
        }
    }

    private DoctorDto construirDoctor() {
        String fechaNacimiento = dpFecha.getValue() != null ? dpFecha.getValue().toString() : "";
        int experiencia = txtExperiencia.getText() != null && !txtExperiencia.getText().isEmpty() ? Integer.parseInt(txtExperiencia.getText()) : (-1);
        return new DoctorDto(
                txtNombre.getText(),
                txtDocumento.getText(),
                txtTelefono.getText(),
                txtCorreoElectronico.getText(),
                fechaNacimiento,
                txtDireccion.getText(),
                txtEspecialidad.getText(),
                experiencia,
                new ArrayList<CitaDto>());
    }

    private void eliminarDoctor() {
        boolean doctorEliminado = false;
        if (doctorSeleccionado != null) {
            if (mostrarMensajeConfirmacion("¿Está seguro de eliminar el doctor seleccionado?")) {
                doctorEliminado = doctorController.eliminar(doctorSeleccionado.documento());
                if (doctorEliminado) {
                    listaDoctoresDto.remove(doctorSeleccionado);
                    deseleccionarTabla();
                    limpiarCampos();
                    mostrarMensaje("Notificación doctor", "Doctor eliminado",
                            "El doctor ha sido eliminado con éxito", Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje("Error doctor", "Doctor no eliminado",
                            "El doctor no pudo ser eliminado", Alert.AlertType.ERROR);
                }
            }
        } else {
            mostrarMensaje("Error doctor", "Doctor no seleccionado",
                    "Por favor, seleccione un doctor", Alert.AlertType.ERROR);
        }
    }

    private void actualizarDoctor() {
        boolean doctorActualizado = false;
        DoctorDto doctorDto = construirDoctor();
        if (doctorSeleccionado != null) {
            if (validarDatos(doctorDto)) {
                if (!hayCambios(doctorSeleccionado, doctorDto)) {
                    mostrarMensaje("Error doctor", "Sin cambios",
                            "No se puede actualizar el doctor sin cambios", Alert.AlertType.ERROR);
                    return;
                }
                int selectedIndex = tblDoctor.getSelectionModel().getSelectedIndex();
                doctorActualizado = doctorController.actualizar(doctorSeleccionado.documento(), doctorDto);
                if (doctorActualizado) {
                    listaDoctoresDto.set(selectedIndex, doctorDto);
                    tblDoctor.refresh();
                    tblDoctor.getSelectionModel().select(selectedIndex);
                    mostrarMensaje("Notificación doctor", "Doctor actualizado",
                            "El doctor ha sido actualizado con éxito", Alert.AlertType.INFORMATION);
                    deseleccionarTabla();
                    limpiarCampos();
                } else {
                    mostrarMensaje("Error doctor", "Doctor no actualizado",
                            "El doctor no pudo ser actualizado", Alert.AlertType.ERROR);
                }
            }
        } else {
            mostrarMensaje("Error doctor", "Doctor no seleccionado",
                    "Por favor, seleccione un doctor", Alert.AlertType.ERROR);
        }
    }

    private boolean hayCambios(DoctorDto doctorSeleccionado, DoctorDto doctorDto) {
        return !doctorSeleccionado.nombre().equals(doctorDto.nombre()) ||
                !doctorSeleccionado.documento().equals(doctorDto.documento()) ||
                !doctorSeleccionado.fechaNacimiento().equals(doctorDto.fechaNacimiento()) ||
                !doctorSeleccionado.direccion().equals(doctorDto.direccion()) ||
                !doctorSeleccionado.telefono().equals(doctorDto.telefono()) ||
                !doctorSeleccionado.correo().equals(doctorDto.correo()) ||
                !doctorSeleccionado.especialidad().equals(doctorDto.especialidad()) ||
                doctorSeleccionado.experiencia() != doctorDto.experiencia();
    }
}
