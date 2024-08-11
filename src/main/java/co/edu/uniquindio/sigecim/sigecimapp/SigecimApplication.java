package co.edu.uniquindio.sigecim.sigecimapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SigecimApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SigecimApplication.class.getResource("empleado-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hospital San Oscar de Dios! \uD83C\uDFE5");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}