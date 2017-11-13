import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class AboutController extends RootController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem playSnakeMenuItem;
    
    private TextParty mainApp;
    
    public void setMainApp(TextParty mainApp) {
    	this.mainApp = mainApp;
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        assert playSnakeMenuItem != null : "fx:id=\"playSnakeMenuItem\" was not injected: check your FXML file 'aboutScene.fxml'.";
        
        playSnakeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
        	
        	@Override
        	public void handle(ActionEvent event) {
        		System.err.println("SNAKE");
        		mainApp.showSnakeScene();
        	}
        });
    }
    
    public void update() {
    	
    }
}
