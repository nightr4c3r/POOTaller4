module com.example.taller3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.taller3 to javafx.fxml;
    exports com.example.taller3;
}