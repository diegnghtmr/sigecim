module co.edu.uniquindio.sigecim.sigecimapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires org.mapstruct;
    requires org.mapstruct.processor;


    opens co.edu.uniquindio.sigecim.sigecimapp to javafx.fxml;
    exports co.edu.uniquindio.sigecim.sigecimapp;

    exports co.edu.uniquindio.sigecim.sigecimapp.viewController;
    opens co.edu.uniquindio.sigecim.sigecimapp.viewController to javafx.fxml;
    exports co.edu.uniquindio.sigecim.sigecimapp.controller;
    exports co.edu.uniquindio.sigecim.sigecimapp.mapping.dto;
    exports co.edu.uniquindio.sigecim.sigecimapp.mapping.mappers;
    exports co.edu.uniquindio.sigecim.sigecimapp.model;
    exports co.edu.uniquindio.sigecim.sigecimapp.controller.services;
    opens co.edu.uniquindio.sigecim.sigecimapp.controller to javafx.fxml;
}