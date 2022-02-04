package ru.divanov.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import ru.divanov.NotePadApp;
import ru.divanov.service.DataLoader;
import ru.divanov.service.DataSaver;

import java.io.*;

public class Controller {

    private NotePadApp mainApp;
    @FXML
    private TextArea textAreaId = new TextArea();

    public void setMainApp(NotePadApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void openFile(ActionEvent event) {
        FileChooser fileChooser = initChooser("Open file");
        File selectedFile = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
        if (selectedFile != null) {
            textAreaId.setText(new DataLoader().loadFromFile(selectedFile));
            mainApp.getPrimaryStage().setTitle(String.format("%s - NotePad", selectedFile.getAbsolutePath()));
        }
    }

    @FXML
    private void saveToFile(ActionEvent event) {
        FileChooser fileChooser = initChooser("Save to file");
        File savedFile = fileChooser.showSaveDialog(mainApp.getPrimaryStage());
        if (savedFile != null) {
            new DataSaver().saveToFile(savedFile, textAreaId.getText());
            mainApp.getPrimaryStage().setTitle(String.format("%s - NotePad", savedFile.getAbsolutePath()));
        }

    }

    private FileChooser initChooser(String title) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text files(*.txt)", "*.txt"),
                new FileChooser.ExtensionFilter("Config files(*.ini)", "*.ini")
        );
        return fileChooser;
    }
}
