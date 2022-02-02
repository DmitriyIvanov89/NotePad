import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class NotePadApp extends Application {
    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        primaryStage.setTitle("NotePad");
//        primaryStage.setWidth(500);
//        primaryStage.setHeight(700);
//
//        try (InputStream iconStream = getClass().getResourceAsStream("/icon.png")) {
//            Image image = new Image(iconStream);
//            primaryStage.getIcons().add(image);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        FXMLLoader loader = new FXMLLoader();
//        URL xmlUrl = getClass().getResource("/properties.fxml");
//        loader.setLocation(xmlUrl);
//        Parent root = loader.load();
//
//        primaryStage.setScene(new Scene(root));

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/properties.fxml"));
        Controller controller = loader.getController();

        primaryStage.show();
    }
}
