import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class RootController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem currentReportMenuItem;

    @FXML
    private MenuItem removePunctuationMenuItem;

    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private MenuItem openFileMenuItem;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private MenuItem historyLogMenuItem;

    @FXML
    private MenuItem helpMenuItem;

    @FXML
    private MenuItem historyReportMenuItem;
    
    private TextParty mainApp;
    
    public void setMainApp(TextParty mainApp) {
    	this.mainApp = mainApp;
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        assert currentReportMenuItem != null : "fx:id=\"currentReportMenuItem\" was not injected: check your FXML file 'stage.fxml'.";
        assert removePunctuationMenuItem != null : "fx:id=\"removePunctuationMenuItem\" was not injected: check your FXML file 'stage.fxml'.";
        assert aboutMenuItem != null : "fx:id=\"aboutMenuItem\" was not injected: check your FXML file 'stage.fxml'.";
        assert openFileMenuItem != null : "fx:id=\"openFileMenuItem\" was not injected: check your FXML file 'stage.fxml'.";
        assert closeMenuItem != null : "fx:id=\"closeMenuItem\" was not injected: check your FXML file 'stage.fxml'.";
        assert historyLogMenuItem != null : "fx:id=\"historyLogMenuItem\" was not injected: check your FXML file 'stage.fxml'.";
        assert helpMenuItem != null : "fx:id=\"helpMenuItem\" was not injected: check your FXML file 'stage.fxml'.";
        assert historyReportMenuItem != null : "fx:id=\"historyReportMenuItem\" was not injected: check your FXML file 'stage.fxml'.";

        closeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
        	
        	@Override
        	public void handle(ActionEvent event) {
        		
        		try {
        			
        			System.err.println("STOP");
					mainApp.stop();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        	}
        });
    }
}
