package com.example.mateskids;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Nivel3Controller implements Initializable {
    //Metodos que inicializan las variables despues de que se carge la interfaz
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // No es necesario inicializar nada porque, las preguntas se generan desde a clase OperacionesNivel1
    }

    //Metodos para cada boton
    @FXML
    protected void onSuma3ButtonClick(ActionEvent event) throws IOException {
        cargarOperacionesNivel3(event, "sumas");
    }

    @FXML
    protected void onResta3ButtonClick(ActionEvent event) throws IOException {
        cargarOperacionesNivel3(event, "restas");

    }
    @FXML
    protected void onMultiplicacion3ButtonClick(ActionEvent event) throws IOException {
        cargarOperacionesNivel3(event, "multiplicaciones");

    }
    @FXML
    protected void onDivisionButtonClick(ActionEvent event) throws IOException {
        cargarOperacionesNivel3(event, "divisiones");

    }

    @FXML
    protected void volverAlInicio(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mateskids/inicio-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);
            scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm()); // Asegúrate de agregar el CSS

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            System.out.println("❌ Error al cargar la vista: inicio-view.fxml");
            e.printStackTrace();
        }
    }

    private void cargarOperacionesNivel3(ActionEvent event, String tipoOperacion){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mateskids/OperacionesNivel3-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);

            // Obtener el controlador de la vista de operaciones y pasar el tipo de operación
            OperacionesNivel3 controller3 = fxmlLoader.getController();
            controller3.elegirTipoOperacion(tipoOperacion);

            // Cambiar la escena
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            System.out.println("❌ Error al cargar la vista: OperacionesNivel3-view.fxml");
            e.printStackTrace();
        }
    }

}
