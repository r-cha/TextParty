import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class HistoryReportController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text wordLengthText;

    @FXML
    private Text numberOfLinesText;

    @FXML
    private Text numberOfFilesText;

    @FXML
    private Button refreshButton;

    @FXML
    private Text numberOfBlankLinesText;

    @FXML
    private Text charactersPerLineText;

    @FXML
    private Text numberOfWordsText;

    @FXML
    private Text numberOfSpacesText;

    @FXML
    void initialize() {
        assert wordLengthText != null : "fx:id=\"wordLengthText\" was not injected: check your FXML file 'historyReportScene.fxml'.";
        assert numberOfLinesText != null : "fx:id=\"numberOfLinesText\" was not injected: check your FXML file 'historyReportScene.fxml'.";
        assert numberOfFilesText != null : "fx:id=\"numberOfFilesText\" was not injected: check your FXML file 'historyReportScene.fxml'.";
        assert refreshButton != null : "fx:id=\"refreshButton\" was not injected: check your FXML file 'historyReportScene.fxml'.";
        assert numberOfBlankLinesText != null : "fx:id=\"numberOfBlankLinesText\" was not injected: check your FXML file 'historyReportScene.fxml'.";
        assert charactersPerLineText != null : "fx:id=\"charactersPerLineText\" was not injected: check your FXML file 'historyReportScene.fxml'.";
        assert numberOfWordsText != null : "fx:id=\"numberOfWordsText\" was not injected: check your FXML file 'historyReportScene.fxml'.";
        assert numberOfSpacesText != null : "fx:id=\"numberOfSpacesText\" was not injected: check your FXML file 'historyReportScene.fxml'.";

    }
}