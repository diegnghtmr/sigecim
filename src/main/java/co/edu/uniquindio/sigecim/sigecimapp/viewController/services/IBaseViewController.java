package co.edu.uniquindio.sigecim.sigecimapp.viewController.services;

import javafx.event.ActionEvent;

public interface IBaseViewController <T>{

    void onNuevo(ActionEvent event);

    void onAgregar(ActionEvent event);

    void onEliminar(ActionEvent event);

    void onActualizar(ActionEvent event);

    void initialize();

    void initView();

    void initDataBinding();

    void listenerSelection();

    boolean validarDatos(T object);

    void limpiarCampos();

    void deseleccionarTabla();

}
