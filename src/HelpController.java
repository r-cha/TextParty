import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.TextFlow;

public class HelpController extends RootController implements Initializable{
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextFlow helpTextFlow;

    private TextParty mainApp;
    
    public void setMainApp(TextParty mainApp) {
    	this.mainApp = mainApp;
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        assert helpTextFlow != null : "fx:id=\"helpTextFlow\" was not injected: check your FXML file 'helpScene.fxml'.";

    }
    
    public void update() {
    	
    }
	
}
