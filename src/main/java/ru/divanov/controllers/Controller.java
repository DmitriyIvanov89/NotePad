package ru.divanov.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import ru.divanov.NotePadApp;

import java.io.*;

public class Controller {

    private NotePadApp mainApp;
    private TextArea textArea;

    public void setMainApp(NotePadApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }

    @FXML
    private void openFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text files(*.txt)", "*.txt"),
                new FileChooser.ExtensionFilter("Config files(*.ini)", "*.ini"));
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File selectedFile = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
        if (selectedFile != null) {
            textArea.setText(loadFromFile(selectedFile));
            mainApp.getPrimaryStage().setTitle("NotePad" + selectedFile.getName());
        }
    }

    @FXML
    private void saveToFile() {

    }

    private String loadFromFile(File file) {
        String line;
        StringBuilder totalLines = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                totalLines.append(line);
                totalLines.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalLines.toString();
    }
}
