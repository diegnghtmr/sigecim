package co.edu.uniquindio.sigecim.sigecimapp.viewController;

import co.edu.uniquindio.sigecim.sigecimapp.controller.CitaController;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.CitaDto;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.DoctorDto;
import co.edu.uniquindio.sigecim.sigecimapp.mapping.dto.PacienteDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CitaViewController extends BaseViewController{
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
        tcDoctor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().doctor().nombre()));
        tcDocumentoDoctor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().doctor().documento()));
        tcPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().paciente().nombre()));
        tcDocumentoPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().paciente().documento()));
        tcFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fecha()));
        tcHora.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().hora()));
        tcMotivo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().motivo()));
    }

    private void obtenerCitas() {
        //listaCitasDto.addAll(citaController.obtenerCitas());
    }

    public void listenerSelection() {

    }

    public void validateForm(){

    }

    public void clearData(){

    }


}
