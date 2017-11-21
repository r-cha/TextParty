import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;

public class SnakeController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Canvas snakeCanvas;
    
    private Scene scene;
    
    public void setMainScene(Scene scene) {
    	this.scene = scene;
    }
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        assert snakeCanvas != null : "fx:id=\"snakeCanvas\" was not injected: check your FXML file 'snakeScene.fxml'.";
        
    }
    
    public void update() {
    	
    	
    }
}
