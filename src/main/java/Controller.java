import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Controller {

    @FXML
    private Button mainButton;

    public void buttonClicker() {
        System.out.println("Button clicked!!!");
    }

}
