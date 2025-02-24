package com.example.mateskids;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioApp extends Application { //Importante el extends

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InicioApp.class.getResource("inicio-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        InicioController inicio = new InicioController();

        stage.setTitle("MatesKids"); //Titulo principal, mas importante.
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}