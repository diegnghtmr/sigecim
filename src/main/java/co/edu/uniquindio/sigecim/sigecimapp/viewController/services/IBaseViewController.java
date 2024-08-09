package co.edu.uniquindio.sigecim.sigecimapp.viewController.services;

import javafx.event.ActionEvent;

public interface IBaseViewController {

    void onNuevo(ActionEvent event);

    void onAgregar(ActionEvent event);

    void onEliminar(ActionEvent event);

    void onActualizar(ActionEvent event);

    void initialize();

    void initView();

    void initDataBinding();

    void listenerSelection();

    void validateForm();

    void clearData();

}
