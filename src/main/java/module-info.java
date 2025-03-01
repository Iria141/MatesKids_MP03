module com.example.mateskids {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.mateskids to javafx.fxml;
    exports com.example.mateskids;
}