package ru.divanov;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ru.divanov.controllers.Controller;

import java.io.IOException;
import java.util.Objects;

public class NotePadApp extends Application {

    private Stage primaryStage;
    private final String title = "NotePad";

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/NotePad.fxml"));
            BorderPane rootLayOut = loader.load();
            primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/icon.png"))));
            primaryStage.setTitle(title);
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

    public String getTitle() {
        return title;
    }
}
