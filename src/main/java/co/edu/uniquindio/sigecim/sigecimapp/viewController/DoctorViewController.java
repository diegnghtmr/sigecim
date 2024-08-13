package co.edu.uniquindio.sigecim.sigecimapp.viewController;

import co.edu.uniquindio.sigecim.sigecimapp.controller.DoctorController;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.DoctorDto;
import co.edu.uniquindio.sigecim.sigecimapp.viewController.services.IBaseViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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

    }

    @FXML
    public void onAgregar(ActionEvent event) {

    }

    @FXML
    public void onEliminar(ActionEvent event) {

    }

    @FXML
    public void onNuevo(ActionEvent event) {

    }

    @FXML
    public void initialize() {

    }

    public void initView() {

    }

    public void initDataBinding() {

    }

    public void listenerSelection() {

    }

    public boolean validarDatos(DoctorDto object) {
        return false;
    }

    public void limpiarCampos() {

    }

    public void deseleccionarTabla() {

    }
}
