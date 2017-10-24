import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class DefaultSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text currentFileNameText;

    @FXML
    private Button analyzeButton;

    @FXML
    void initialize() {
        assert currentFileNameText != null : "fx:id=\"currentFileNameText\" was not injected: check your FXML file 'defaultScene.fxml'.";
        assert analyzeButton != null : "fx:id=\"analyzeButton\" was not injected: check your FXML file 'defaultScene.fxml'.";

    }
}
