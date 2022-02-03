package ru.divanov;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class NotePadApp extends Application {
    private final String TITLE = "NotePad";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/NotePad.fxml"));
            BorderPane rootLayOut = loader.load();
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/icon.png")));
            primaryStage.setTitle(TITLE);
            primaryStage.setScene(new Scene(rootLayOut));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
