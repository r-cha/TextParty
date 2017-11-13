import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class HistoryReportController extends RootController implements Initializable{

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
    
    private TextParty mainApp;
    
    public void setMainApp(TextParty mainApp) {
    	this.mainApp = mainApp;
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        assert wordLengthText != null : "fx:id=\"wordLengthText\" was not injected: check your FXML file 'historyReportScene.fxml'.";
        assert numberOfLinesText != null : "fx:id=\"numberOfLinesText\" was not injected: check your FXML file 'historyReportScene.fxml'.";
        assert numberOfFilesText != null : "fx:id=\"numberOfFilesText\" was not injected: check your FXML file 'historyReportScene.fxml'.";
        assert refreshButton != null : "fx:id=\"refreshButton\" was not injected: check your FXML file 'historyReportScene.fxml'.";
        assert numberOfBlankLinesText != null : "fx:id=\"numberOfBlankLinesText\" was not injected: check your FXML file 'historyReportScene.fxml'.";
        assert charactersPerLineText != null : "fx:id=\"charactersPerLineText\" was not injected: check your FXML file 'historyReportScene.fxml'.";
        assert numberOfWordsText != null : "fx:id=\"numberOfWordsText\" was not injected: check your FXML file 'historyReportScene.fxml'.";
        assert numberOfSpacesText != null : "fx:id=\"numberOfSpacesText\" was not injected: check your FXML file 'historyReportScene.fxml'.";

    }
    
    public void update() {
    	
    	numberOfFilesText.setText(Integer.toString(mainApp.history.size()));
    	
    	// Variables to keep track of total and average statistics
    	int totalLines = 0;
    	int totalBlankLines = 0;                            
    	int totalNumWords = 0;
    	int totalNumSpaces = 0;
    	double totalAvgWordLength = 0;
    	double totalAvgCharLines = 0;
    	
    	for (RecordFile record : mainApp.history) 
    	{
    		// For each RecordFile in mainApp.history, add the statistics to the global total
    		totalLines += record.numLines;                    
    		totalBlankLines += record.blankLines;
    		totalNumWords += record.numWords;
    		totalNumSpaces += record.numSpaces;
    		totalAvgWordLength += record.avgWordLength;
    		totalAvgCharLines += record.avgCharLines;
    	}
    	
    	// Calculate the averages using the cumulative values from the history list
    	totalAvgWordLength = totalAvgWordLength / mainApp.history.size();        
    	totalAvgCharLines = totalAvgCharLines / mainApp.history.size();
    	
    	// Update the textboxes with the new values
    	numberOfLinesText.setText(Integer.toString(totalLines));                
    	numberOfBlankLinesText.setText(Integer.toString(totalBlankLines));
    	numberOfWordsText.setText(Integer.toString(totalNumWords));
    	numberOfSpacesText.setText(Integer.toString(totalNumSpaces));

    	charactersPerLineText.setText(Double.toString(totalAvgCharLines));
    	wordLengthText.setText(Double.toString(totalAvgWordLength));
    	
    }
}
