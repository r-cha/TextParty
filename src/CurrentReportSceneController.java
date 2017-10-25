import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

public class CurrentReportSceneController extends RootController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text wordLengthText;

    @FXML
    private ListView<String> mostCommonWordsList;

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
    
    private TextParty mainApp;
    
    public void setMainApp(TextParty mainApp) {
    	this.mainApp = mainApp;
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        assert wordLengthText != null : "fx:id=\"wordLengthText\" was not injected: check your FXML file 'currentReportScene.fxml'.";
        assert mostCommonWordsList != null : "fx:id=\"mostCommonWordsList\" was not injected: check your FXML file 'currentReportScene.fxml'.";
        assert numberOfLinesText != null : "fx:id=\"numberOfLinesText\" was not injected: check your FXML file 'currentReportScene.fxml'.";
        assert reanalyzeButton != null : "fx:id=\"reanalyzeButton\" was not injected: check your FXML file 'currentReportScene.fxml'.";
        assert fileNameText != null : "fx:id=\"fileNameText\" was not injected: check your FXML file 'currentReportScene.fxml'.";
        assert numberOfBlankLinesText != null : "fx:id=\"numberOfBlankLinesText\" was not injected: check your FXML file 'currentReportScene.fxml'.";
        assert charactersPerLineText != null : "fx:id=\"charactersPerLineText\" was not injected: check your FXML file 'currentReportScene.fxml'.";
        assert numberOfWordsText != null : "fx:id=\"numberOfWordsText\" was not injected: check your FXML file 'currentReportScene.fxml'.";
        assert numberOfSpacesText != null : "fx:id=\"numberOfSpacesText\" was not injected: check your FXML file 'currentReportScene.fxml'.";
        
        reanalyzeButton.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		
        		try {
        			
        			System.err.println("REFRESH");
					update();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        	}
        });
    }
    
    public void update() {
        if (mainApp.current != null) {
        	wordLengthText.setText(Double.toString(mainApp.current.getWordLength()));
        	mostCommonWordsList.setItems(FXCollections.observableArrayList(mainApp.current.getCommonWords()));
        	numberOfLinesText.setText(Integer.toString(mainApp.current.getNumLines()));
        	fileNameText.setText(mainApp.current.getFile().getName());
        	numberOfBlankLinesText.setText(Integer.toString(mainApp.current.getBlankLines()));
        	charactersPerLineText.setText(Double.toString(mainApp.current.getCharLines()));
        	numberOfWordsText.setText(Integer.toString(mainApp.current.getNumWords()));
        	numberOfSpacesText.setText(Integer.toString(mainApp.current.getNumSpaces()));
        }
    }
}
