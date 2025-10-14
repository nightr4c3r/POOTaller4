package com.example.taller3.Controllers;

import com.example.taller3.Models.Moto;
import com.example.taller3.Repositories.MotoRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MotosTableController implements Initializable {
    @FXML
    private TableView<Moto> motosTable;
    @FXML
    private TableColumn<Moto, String> placaCol;
    @FXML
    private TableColumn<Moto, String> marcaCol;
    @FXML
    private TableColumn<Moto, String> modeloCol;
    @FXML
    private Label emptyLabel;

    private final ObservableList<Moto> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (placaCol != null) placaCol.setCellValueFactory(new PropertyValueFactory<>("placa"));
        if (marcaCol != null) marcaCol.setCellValueFactory(new PropertyValueFactory<>("marca"));
        if (modeloCol != null) modeloCol.setCellValueFactory(new PropertyValueFactory<>("modelo"));


        data.setAll(MotoRepository.getAll());
        if (motosTable != null) {
            motosTable.setItems(data);
        }
        updateEmptyState();
    }

    private void updateEmptyState() {
        boolean isEmpty = data.isEmpty();
        if (emptyLabel != null) emptyLabel.setVisible(isEmpty);
        if (motosTable != null) motosTable.setVisible(!isEmpty);
    }

    @FXML
    protected void onBackClick() throws IOException {
        Window w = (motosTable != null ? motosTable.getScene().getWindow() : (emptyLabel != null ? emptyLabel.getScene().getWindow() : null));
        if (w != null) w.hide();
    }
}
