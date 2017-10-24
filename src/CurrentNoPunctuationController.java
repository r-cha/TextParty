import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class CurrentNoPunctuationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextFlow textWithoutPunctuationTexftFlow;

    @FXML
    private Text fileNameText;

    @FXML
    private Button saveButton;

    @FXML
    void initialize() {
        assert textWithoutPunctuationTexftFlow != null : "fx:id=\"textWithoutPunctuationTexftFlow\" was not injected: check your FXML file 'currentNoPunctuationScene.fxml'.";
        assert fileNameText != null : "fx:id=\"fileNameText\" was not injected: check your FXML file 'currentNoPunctuationScene.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'currentNoPunctuationScene.fxml'.";

    }
}
