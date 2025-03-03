package com.example.mateskids;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioApp extends Application { //Importante el extends

    @Override
    public void start(Stage stage) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("inicio-view.fxml"));
        Scene scene = new Scene(fxmlLoader, 700, 500);

        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        stage.setTitle("MatesKids"); //Titulo principal, mas importante.
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}