import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class HelpController extends RootController implements Initializable{
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text helpText;

    private TextParty mainApp;
    
    public void setMainApp(TextParty mainApp) {
    	this.mainApp = mainApp;
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        assert helpText != null : "fx:id=\"helpText\" was not injected: check your FXML file 'helpScene.fxml'.";
        
        helpText.setWrappingWidth(450);
        helpText.setText("Welcome to TextParty!\n\n"
        		+ "Use the 'File' menu to choose a .txt file to open, or to close the application.\n"
        		+ "After choosing a file, click the 'Analyze' button to proceed to the Current Report view. This view shows the statistics associated with the file.\n\n"
        		+ "The 'View' menu provides access to the historical data of files imported, as well as the ability to view the current file with punctuation removed.\n\n"
        		+ "The 'Help' menu provides access to this page, and the About page. Right click the developer's names for a good time.");
    }
    
    public void update() {
    	
    }
	
}
