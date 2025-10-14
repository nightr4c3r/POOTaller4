package com.example.taller3.Controllers;

import com.example.taller3.Models.Moto;
import com.example.taller3.Repositories.MotoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.io.IOException;

public class AddMotoController {
    @FXML
    private TextField placaField;
    @FXML
    private TextField marcaField;
    @FXML
    private TextField modeloField;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;

    private void closeWindow() {
        Window w = placaField != null ? placaField.getScene().getWindow() : null;
        if (w != null) w.hide();
    }

    @FXML
    protected void onSaveClick() throws IOException {
        String placa = placaField.getText() != null ? placaField.getText().trim() : "";
        String marca = marcaField.getText() != null ? marcaField.getText().trim() : "";
        String modelo = modeloField.getText() != null ? modeloField.getText().trim() : "";

        if (placa.isEmpty() || marca.isEmpty() || modelo.isEmpty()) {
            showAlert("Datos incompletos", "Por favor, complete todos los campos: placa, marca y modelo.");
            return;
        }

        Moto moto = new Moto();
        moto.setPlaca(placa);
        moto.setMarca(marca);
        moto.setModelo(modelo);
        MotoRepository.add(moto);

        closeWindow();
    }

    @FXML
    protected void onCancelClick() throws IOException {
        // Close only this window
        closeWindow();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
