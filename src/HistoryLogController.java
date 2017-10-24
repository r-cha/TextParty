import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class HistoryLogController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<?> historyLogList;

    @FXML
    void initialize() {
        assert historyLogList != null : "fx:id=\"historyLogList\" was not injected: check your FXML file 'historyLogScene.fxml'.";

    }
}
