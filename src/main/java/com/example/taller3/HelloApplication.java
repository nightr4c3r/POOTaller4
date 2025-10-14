package com.example.taller3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        primaryStage.setTitle("Motos App");
        setRoot("dashboard.fxml", 700, 480);
        primaryStage.show();
    }

    public static void setRoot(String fxml, double width, double height) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        Parent root = loader.load();
        Scene scene = new Scene(root, width, height);
        primaryStage.setScene(scene);
    }
}
