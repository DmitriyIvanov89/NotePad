import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;


public class NotePadApp extends Application {
    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("NotePad");
        primaryStage.setWidth(500);
        primaryStage.setHeight(700);

        try (InputStream iconStream = getClass().getResourceAsStream("/icon.png")) {
            Image image = new Image(iconStream);
            primaryStage.getIcons().add(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        primaryStage.show();
    }
}
