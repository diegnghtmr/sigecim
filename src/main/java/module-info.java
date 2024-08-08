module co.edu.uniquindio.sigecim.sigecimapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens co.edu.uniquindio.sigecim.sigecimapp to javafx.fxml;
    exports co.edu.uniquindio.sigecim.sigecimapp;
    opens co.edu.uniquindio.sigecim.sigecimapp.viewController to javafx.fxml;
    exports co.edu.uniquindio.sigecim.sigecimapp.viewController;
}