package com.example.mateskids;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Nivel3Controller implements Initializable {
    @FXML
    private Label descripcion = new Label("Bienvenido a Nivel 3, repasaremos operaciones de mas de un digito con llevandos y asprendemos a  dividir por uno");
    @FXML
    private Button inicioVolver;
    //Metodos para cada boton
    @FXML
    protected void onSuma3ButtonClick() {
    }

    @FXML
    protected void onResta3ButtonClick() {
    }
    @FXML
    protected void onMultiplicacion3ButtonClick() {
    }
    @FXML
    protected void onDivisionButtonClick() {
    }

    @FXML
    protected void volverAlInicio() throws IOException {
        // Cargar la pantalla de inicio
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mateskids/inicio-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);

        // Obtener el Stage actual y cambiar la escena
        Stage stage = (Stage) ((javafx.scene.Node)inicioVolver).getScene().getWindow();
        stage.setScene(scene);
    }


    //Metodos que inicializan las variables despues de que se carge la interfaz
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
