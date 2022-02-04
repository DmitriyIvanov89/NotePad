package ru.divanov;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ru.divanov.controllers.Controller;

import java.io.IOException;

public class NotePadApp extends Application {
    /**
     * Refactor initRoot method
     * Application title in const
     */

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        initRoot();
    }

    private void initRoot() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/NotePad.fxml"));
            BorderPane rootLayOut = loader.load();
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/icon.png")));
            primaryStage.setTitle("NotePad");
            primaryStage.setScene(new Scene(rootLayOut));
            Controller controller = loader.getController();
            controller.setMainApp(this);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
