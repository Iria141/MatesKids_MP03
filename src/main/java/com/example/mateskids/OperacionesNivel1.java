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
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import javafx.scene.control.TextField;

public class OperacionesNivel1 implements Initializable {

    Random random = new Random();
    private int respuestaCorrecta;
    private String tipoOperacion = "sumas";
    private boolean esPreguntaTest;

    @FXML
    private Label preguntaLabel, resultadoLabel;
    @FXML
    private Button btnOpcion1, btnOpcion2, btnOpcion3, btnVerificar;
    @FXML
    private TextField respuestaUsuario;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Button> botones = Arrays.asList(btnOpcion1, btnOpcion2, btnOpcion3);
        // Asignacion del evento a cada botón (lmbda)
        botones.forEach(btn -> btn.setOnAction(event -> verificarRespuesta(event)));
        // Generar la primera pregunta
        generarPregunta();
    }

    public void elegirTipoOperacion(String tipo) {
        this.tipoOperacion = tipo;
        generarPregunta();
    }

    @FXML
    protected void generarPregunta() {

        try{
            resultadoLabel.setText(""); // Limpiar mensaje anterior
            respuestaUsuario.clear();
            esPreguntaTest = random.nextBoolean(); //  De forma aleatoria se meustra un tipo de pregunta

            if (esPreguntaTest) {
                generarPreguntaTest();
            } else {
                generarPreguntaAbierta();
            }
        } catch (Exception e) {
            resultadoLabel.setText("❌ Error al generar la pregunta.");
        }
    }

    private void generarPreguntaAbierta() {

        respuestaUsuario.setVisible(true);
        btnOpcion1.setVisible(false);
        btnOpcion2.setVisible(false);
        btnOpcion3.setVisible(false);
        btnVerificar.setVisible(true);

        int num1 = random.nextInt(20) + 1;
        int num2 = random.nextInt(10) + 1;

        if (tipoOperacion.equals("sumas")) {
            respuestaCorrecta = num1 + num2;
            preguntaLabel.setText(num1 + " + " + num2 + " = ?");
        } else {
            if (num1 < num2) { // Evitar negativos en restas
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }

            preguntaLabel.setText(num1 + " - " + num2 + " = ?");
        }
    }

    private void generarPreguntaTest() {

        respuestaUsuario.setVisible(false);
        btnOpcion1.setVisible(true);
        btnOpcion2.setVisible(true);
        btnOpcion3.setVisible(true);
        btnVerificar.setVisible(false);

        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(10) + 1;

        if (tipoOperacion.equals("sumas")) {
            respuestaCorrecta = num1 + num2;
            preguntaLabel.setText(num1 + " + " + num2 + " = ?");
        } else {
            if (num1 < num2) { // Evitar negativos en restas
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
            respuestaCorrecta = num1 - num2;
            preguntaLabel.setText(num1 + " - " + num2 + " = ?");
        }


        // Generar respuestas incorrectas
        int opcionCorrecta = random.nextInt(3);
        int[] opciones = new int[3];

        for (int i = 0; i < 3; i++) {
            if (i == opcionCorrecta) {
                opciones[i] = respuestaCorrecta;
            } else {
                opciones[i] = generarOpcionesIncorrecta(respuestaCorrecta);
            }
        }

        // Asignar respuestas a los botones
        btnOpcion1.setText(String.valueOf(opciones[0]));
        btnOpcion2.setText(String.valueOf(opciones[1]));
        btnOpcion3.setText(String.valueOf(opciones[2]));
    }


    @FXML
    protected void verificarRespuesta(ActionEvent event) {
        Button btnPresionado = (Button) event.getSource();
        int respuestaSeleccionada = Integer.parseInt(btnPresionado.getText());

        // verifica si la respuesta es correcta
        Predicate<Integer> esCorrecta = respuesta -> respuesta == respuestaCorrecta;
        // Aplicar el Predicate
        resultadoLabel.setText(esCorrecta.test(respuestaSeleccionada) ? "✅ ¡Correcto!" : "❌ Incorrecto, intenta de nuevo.");
    }

    @FXML
    protected void verificarRespuestaUsuario() {
        String entrada = respuestaUsuario.getText().trim();

        if (!entradaValida(entrada)) {
            resultadoLabel.setText("❌ Introduce numeros positivos.");
            return;
        }

        try {
            int respuestaIngresada = Integer.parseInt(entrada);

            if (respuestaIngresada == respuestaCorrecta) {
                resultadoLabel.setText("✅ ¡Correcto!");
            } else {
                resultadoLabel.setText("❌ Incorrecto, intenta de nuevo.");
            }
        } catch (NumberFormatException e) {
            resultadoLabel.setText("❌ Error: Ingresa solo números válidos.");
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    // Validación con expresión regular
    private boolean entradaValida(String input) {
        return Pattern.matches("-?\\d+", input); //Acepta números enteros
    }


    private int generarOpcionesIncorrecta(int correcta) {
        return IntStream.generate(() -> random.nextInt(20) +1)//Genera solo números positivos
                .filter(num -> num != correcta)// asegura de que la opción incorrecta no sea igual a la correcta
                .findFirst()
                .orElse(correcta); //devuelve la correcta, n el caso extremo en que no se encuentre otro número
    }

    @FXML
    protected void onSiguienteButtonClick() {
        generarPregunta();
    }

    @FXML
    protected void volver(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mateskids/nivel1-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}


/*
bound: se refiere a la vinculación de propiedades (binding), es decir, una propiedad está vinculada a otra y cambia automáticamente.
Si una propiedad está "bound", no puedes modificarla manualmente sin usar unbind() y Binding se usa para sincronizar valores entre
UI elements sin necesidad de listeners.

 */
