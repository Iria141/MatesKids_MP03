package com.example.mateskids;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Nivel1Controller implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // No es necesario inicializar nada porque, las preguntas se generan desde a clase OperacionesNivel1
    }

    @FXML
    protected void onSumasButtonClick(ActionEvent event) throws IOException {
        cargarOperacionesNivel1(event, "sumas");
    }
    @FXML
    protected void onRestasButtonClick(ActionEvent event) throws IOException {
        cargarOperacionesNivel1(event, "restas");
    }

    @FXML
    protected void volverAlInicio(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mateskids/inicio-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            System.out.println("❌ Error al cargar la vista: inicio-view.fxml");
            e.printStackTrace();
        }
    }

    private void cargarOperacionesNivel1(ActionEvent event, String tipoOperacion) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mateskids/OperacionesNivel1-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);

            // Obtener el controlador de la vista de operaciones y pasar el tipo de operación
            OperacionesNivel1 controller1 = fxmlLoader.getController();
            controller1.elegirTipoOperacion(tipoOperacion);

            // Cambiar la escena
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            System.out.println("❌ Error al cargar la vista: OperacionesNivel1-view.fxml");
            e.printStackTrace();
        }
    }
}
