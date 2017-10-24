import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class AboutController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem playSnakeMenuItem;

    @FXML
    void initialize() {
        assert playSnakeMenuItem != null : "fx:id=\"playSnakeMenuItem\" was not injected: check your FXML file 'aboutScene.fxml'.";

    }
}
