module com.example.taller3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.taller3 to javafx.fxml;
    exports com.example.taller3;
    exports com.example.taller3.Controllers;
    opens com.example.taller3.Controllers to javafx.fxml;
    exports com.example.taller3.Models;
    opens com.example.taller3.Models to javafx.fxml;
    exports com.example.taller3.Repositories;
    opens com.example.taller3.Repositories to javafx.fxml;
}