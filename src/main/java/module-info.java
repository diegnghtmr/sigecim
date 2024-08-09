module co.edu.uniquindio.sigecim.sigecimapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires org.mapstruct;


    opens co.edu.uniquindio.sigecim.sigecimapp to javafx.fxml;
    exports co.edu.uniquindio.sigecim.sigecimapp;
    opens co.edu.uniquindio.sigecim.sigecimapp.viewController to javafx.fxml;
    exports co.edu.uniquindio.sigecim.sigecimapp.viewController;
    opens co.edu.uniquindio.sigecim.sigecimapp.controller to javafx.fxml;
    exports co.edu.uniquindio.sigecim.sigecimapp.controller;
    opens co.edu.uniquindio.sigecim.sigecimapp.model to javafx.fxml;
    exports co.edu.uniquindio.sigecim.sigecimapp.model;
}