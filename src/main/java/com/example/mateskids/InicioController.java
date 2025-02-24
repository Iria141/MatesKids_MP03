package com.example.mateskids;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


//Gestion de calculos
public class InicioController implements Initializable {

    @FXML
    private Label boton;
    private Label titulo = new Label("!Bienvenido a MatesKids!");
    private Label descripcion = new Label("Elige tu nivel");
    @FXML
    private Button botonFacil;
    @FXML
    private Button botonMedio;
    @FXML
    private Button botonDificil;

//Metodos para cada boton
    @FXML
    protected void onFacilButtonClick() throws IOException {

        boton.setText("Nivel 1, 6-8 años");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mateskids/nivel1-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);

        // Obtener el Stage actual y cambiar de escena con el boton que activo el evento.
        Stage stage = (Stage) ((javafx.scene.Node)botonFacil).getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    protected void onMedioButtonClick() throws IOException {

        boton.setText("Nivel 2, 8-10 años");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mateskids/nivel2-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);

        // Obtener el Stage actual y cambiar de escena con el boton que activo el evento.
        Stage stage = (Stage) ((javafx.scene.Node)botonMedio).getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    protected void onDificilButtonClick() throws IOException {

        boton.setText("Nivel 3, 10-12 años");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mateskids/nivel3-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);

        // Obtener el Stage actual y cambiar de escena con el boton que activo el evento.
        Stage stage = (Stage) ((javafx.scene.Node)botonDificil).getScene().getWindow();
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