import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
                
                StackPane secondaryLayout = new StackPane();
                 
                Scene secondScene = new Scene(secondaryLayout, 400, 400, Color.FORESTGREEN);
 
                Stage secondStage = new Stage();
                secondStage.setTitle("Snake");
                secondStage.setScene(secondScene);
                
                
                 
                //Set position of second window, related to primary window.
                secondStage.setX(mainApp.getPrimaryStage().getX() + 250);
                secondStage.setY(mainApp.getPrimaryStage().getY() + 100);
                secondStage.show();
                
                SnakeController controller = new SnakeController();
                controller.setMainScene(secondScene);
        	}
        });
    }
    
    public void update() {
    	
    }
}
