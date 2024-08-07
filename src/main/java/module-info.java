module co.edu.uniquindio.sigecim.sigecimapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.sigecim.sigecimapp to javafx.fxml;
    exports co.edu.uniquindio.sigecim.sigecimapp;
}