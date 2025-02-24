module com.example.mateskids {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mateskids to javafx.fxml;
    exports com.example.mateskids;
}