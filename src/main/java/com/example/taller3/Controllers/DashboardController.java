package com.example.taller3.Controllers;

import com.example.taller3.HelloApplication;
import com.example.taller3.Repositories.MotoRepository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private Label motoCountLabel;
    @FXML
    private Button addMotoButton;
    @FXML
    private Button viewMotosButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateCount();
    }

    private void updateCount() {
        if (motoCountLabel != null) {
            motoCountLabel.setText("Total motos: " + MotoRepository.size());
        }
    }

    private Window getWindow() {
        return motoCountLabel != null ? motoCountLabel.getScene().getWindow() : null;
    }

    @FXML
    protected void onAddMotoClick() throws IOException {
        // Open Add Moto in a new window (keep dashboard)
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("add-moto.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Agregar Moto");
        stage.setScene(new Scene(root, 600, 420));
        Window owner = getWindow();
        if (owner != null) {
            stage.initOwner(owner);
        }
        // When the window closes, refresh the dashboard count
        stage.setOnHidden(e -> updateCount());
        stage.show();
    }

    @FXML
    protected void onShowAllClick() throws IOException {
        // Open motos table in a new window (keep dashboard)
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("motos-table.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Lista de Motos");
        stage.setScene(new Scene(root, 700, 480));
        Window owner = getWindow();
        if (owner != null) {
            stage.initOwner(owner);
        }
        stage.show();
    }
}
