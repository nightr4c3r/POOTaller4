package com.example.taller3.Controllers;

import com.example.taller3.HelloApplication;
import com.example.taller3.Models.Moto;
import com.example.taller3.Repositories.MotoRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label motoCountLabel;
    @FXML
    private Button addMotoButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateCount();
    }

    private void updateCount() {
        if (motoCountLabel != null) {
            motoCountLabel.setText("Total motos: " + MotoRepository.size());
        }
    }

    @FXML
    protected void onAddMotoClick() throws IOException {
        HelloApplication.setRoot("add-moto.fxml", 500, 350);
    }

    @FXML
    protected void onRefreshClick() {
        updateCount();
    }

    @FXML
    protected void onShowAllClick() {
        var motos = MotoRepository.getAll();
        if (motos.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Listado de Motos");
            alert.setHeaderText(null);
            alert.setContentText("No hay motos registradas.");
            alert.showAndWait();
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Moto m : motos) {
            sb.append(i++)
              .append(". Placa: ").append(m.getPlaca() == null ? "" : m.getPlaca())
              .append(", Marca: ").append(m.getMarca() == null ? "" : m.getMarca())
              .append(", Modelo: ").append(m.getModelo() == null ? "" : m.getModelo())
              .append("\n");
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Listado de Motos");
        alert.setHeaderText("Motos almacenadas (" + motos.size() + ")");
        alert.setContentText(sb.toString());
        alert.showAndWait();
    }
}
