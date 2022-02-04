package ru.divanov.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import ru.divanov.NotePadApp;

import java.io.*;

public class Controller {

    /**
     * Создать отдкльный класс по работе с файлами(read / write)
     * Вынести инициализацию filechooser в отдельный метод
     */

    private NotePadApp mainApp;
    @FXML
    private TextArea textAreaId = new TextArea();

    public void setMainApp(NotePadApp mainApp) {
        this.mainApp = mainApp;
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
            textAreaId.setText(loadFromFile(selectedFile));
            mainApp.getPrimaryStage().setTitle("NotePad - " + selectedFile.getName());
        }
    }

    @FXML
    private void saveToFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save to file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text files(*.txt)", "*.txt"),
                new FileChooser.ExtensionFilter("Config files(*.ini)", "*.ini")
        );
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());
        if (file != null) {
            saveTextToFile(file, textAreaId.getText());
            mainApp.getPrimaryStage().setTitle("NodePad - " + file.getName());
        }

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

    private void saveTextToFile(File file, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(text);
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
