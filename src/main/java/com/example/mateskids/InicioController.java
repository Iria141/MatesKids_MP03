package com.example.mateskids;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InicioController implements Initializable {
    @FXML
    private Label titulo;
    @FXML
    private Label descripcion;
    @FXML
    private Button botonFacil;
    @FXML
    private Button botonMedio;
    @FXML
    private Button botonDificil;


    //Metodos para cada boton
    @FXML
    protected void onFacilButtonClick() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mateskids/nivel1-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);

        // Obtener el Stage actual y cambiar de escena con el boton que activo el evento.
        Stage stage = (Stage) ((Node) botonFacil).getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    protected void onMedioButtonClick() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mateskids/nivel2-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);

        // Obtener el Stage actual y cambiar de escena con el boton que activo el evento.
        Stage stage = (Stage) ((Node) botonMedio).getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    protected void onDificilButtonClick() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mateskids/nivel3-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);

        // Obtener el Stage actual y cambiar de escena con el boton que activo el evento.
        Stage stage = (Stage) ((Node) botonDificil).getScene().getWindow();
        stage.setScene(scene);
    }


    //Metodos que inicializan las variables despues de que se carge la interfaz
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Diseño titulo
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 35));

        //diseño descripcion
        descripcion.setFont(Font.font("Arial", 18));
    }
}
