package co.edu.uniquindio.sigecim.sigecimapp.viewController;

import co.edu.uniquindio.sigecim.sigecimapp.controller.PacienteController;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.PacienteDto;
import co.edu.uniquindio.sigecim.sigecimapp.viewController.services.IBaseViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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

    public boolean validarDatos(PacienteDto object) {
        return false;
    }

    public void limpiarCampos() {

    }

    public void deseleccionarTabla() {

    }


}
