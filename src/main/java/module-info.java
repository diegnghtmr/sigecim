module co.edu.uniquindio.sigecim.sigecimapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires org.mapstruct;
    requires org.mapstruct.processor;


    opens co.edu.uniquindio.sigecim.sigecimapp to javafx.fxml;
    exports co.edu.uniquindio.sigecim.sigecimapp;

    opens co.edu.uniquindio.sigecim.sigecimapp.viewController;
    exports co.edu.uniquindio.sigecim.sigecimapp.viewController;
    opens co.edu.uniquindio.sigecim.sigecimapp.mapping.mappers to org.mapstruct;
    exports co.edu.uniquindio.sigecim.sigecimapp.mapping.mappers;
}