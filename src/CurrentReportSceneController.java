import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

public class CurrentReportSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text wordLengthText;

    @FXML
    private ListView<?> mostCommonWordsList;

    @FXML
    private Text numberOfLinesText;

    @FXML
    private Button reanalyzeButton;

    @FXML
    private Text fileNameText;

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
        assert wordLengthText != null : "fx:id=\"wordLengthText\" was not injected: check your FXML file 'currentReportScene.fxml'.";
        assert mostCommonWordsList != null : "fx:id=\"mostCommonWordsList\" was not injected: check your FXML file 'currentReportScene.fxml'.";
        assert numberOfLinesText != null : "fx:id=\"numberOfLinesText\" was not injected: check your FXML file 'currentReportScene.fxml'.";
        assert reanalyzeButton != null : "fx:id=\"reanalyzeButton\" was not injected: check your FXML file 'currentReportScene.fxml'.";
        assert fileNameText != null : "fx:id=\"fileNameText\" was not injected: check your FXML file 'currentReportScene.fxml'.";
        assert numberOfBlankLinesText != null : "fx:id=\"numberOfBlankLinesText\" was not injected: check your FXML file 'currentReportScene.fxml'.";
        assert charactersPerLineText != null : "fx:id=\"charactersPerLineText\" was not injected: check your FXML file 'currentReportScene.fxml'.";
        assert numberOfWordsText != null : "fx:id=\"numberOfWordsText\" was not injected: check your FXML file 'currentReportScene.fxml'.";
        assert numberOfSpacesText != null : "fx:id=\"numberOfSpacesText\" was not injected: check your FXML file 'currentReportScene.fxml'.";

    }
}
