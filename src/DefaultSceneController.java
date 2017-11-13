import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class DefaultSceneController extends RootController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text currentFileNameText;

    @FXML
    private Button analyzeButton;
    
    private TextParty mainApp;
    
    public void setMainApp(TextParty mainApp) {
    	this.mainApp = mainApp;
    }

    @FXML
	public void initialize(URL location, ResourceBundle resources) {
        assert currentFileNameText != null : "fx:id=\"currentFileNameText\" was not injected: check your FXML file 'defaultScene.fxml'.";
        assert analyzeButton != null : "fx:id=\"analyzeButton\" was not injected: check your FXML file 'defaultScene.fxml'.";
        
        
        analyzeButton.setOnAction(new EventHandler<ActionEvent>() {
        	
        	@Override
        	public void handle(ActionEvent event) {
        		System.err.println("ANALYZE");
        		if (mainApp.current != null) {
        			
        			mainApp.current.openFile();
        			mainApp.current.analyze();
        			mainApp.history.add(new RecordFile(mainApp.current));
        			
        		}
        		mainApp.showCurrentReportScene();
        	}
        });
        
    }
    
    public void update() {
    	
    	if (mainApp.current != null)
    		currentFileNameText.setText(mainApp.current.getFile().getName());
    	
    }
    
}
