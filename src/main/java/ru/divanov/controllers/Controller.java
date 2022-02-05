package ru.divanov.controllers;

import com.sun.javafx.binding.StringFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import ru.divanov.NotePadApp;
import ru.divanov.model.FileType;
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
            mainApp.getPrimaryStage().setTitle(String.format("%s - %s", selectedFile.getAbsolutePath(), mainApp.getTitle()));
        }
    }

    @FXML
    private void saveToFile(ActionEvent event) {
        FileChooser fileChooser = initChooser("Save to file");
        File savedFile = fileChooser.showSaveDialog(mainApp.getPrimaryStage());
        if (savedFile != null) {
            new DataSaver().saveToFile(savedFile, textAreaId.getText());
            mainApp.getPrimaryStage().setTitle(String.format("%s - %s", savedFile.getAbsolutePath(), mainApp.getTitle()));
        }

    }

    private FileChooser initChooser(String title) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(String.format("Text files(%s)", FileType.TXT.getFileType()), FileType.TXT.getFileType()),
                new FileChooser.ExtensionFilter(String.format("Config files(%s)", FileType.INI.getFileType()), FileType.INI.getFileType())
        );
        return fileChooser;
    }
}
