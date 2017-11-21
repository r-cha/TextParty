import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

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

        /************* 
         * FILE Menu *
         *************/
        
        /**
         * Open File button opens a system dialog to choose a file to load.
         */
        openFileMenuItem.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		
        		try {
        			
        			FileChooser fileChooser = new FileChooser();
        			fileChooser.setTitle("Open Resource File");
        			fileChooser.getExtensionFilters().addAll(
        			         new ExtensionFilter("Text Files", "*.txt"),
        			         new ExtensionFilter("All Files", "*.*"));
        			
        			mainApp.current = new ActiveFile(fileChooser.showOpenDialog(mainApp.getPrimaryStage()));
        			
        			mainApp.sceneTransition("defaultScene");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        	}
        });
        
        /**
         * Close button stops the application, serializing the history if one has been initiated.
         */
        closeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		
        		try {
        			
					mainApp.stop();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        	}
        });
        
        /*************
         * VIEW menu *
         *************/
        
        /**
         * Current Report button opens a view of the statistics of the currently-loaded file. 
         * This button simply shows the scene of statistics, but loading the scene analyzes the current file.        
         */
        currentReportMenuItem.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		
        		try {
        			
					mainApp.sceneTransition("currentReportScene");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        	}
        });
        
        /**
         * Remove Punctuation button shows a view that displays the text of the current active file with punctuation removed.
         */
        removePunctuationMenuItem.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		
        		try {
        			
					mainApp.sceneTransition("currentNoPunctuationScene");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        	}
        });
        
        
        /**
         * History Log button shows a list of past loaded files, including filename and date.
         */
        historyLogMenuItem.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		
        		try {
        			
					mainApp.sceneTransition("historyLogScene");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        	}
        });
        
        /**
         * History Report button shows cumulative calculations of the given statistics for all files included in the history. 
         * The historical files are not reloaded and reanalyzed, because historical item statistics are recorded when they are transferred from the ActiveFile to RecordFile type.
         */
        historyReportMenuItem.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		
        		try {
        			
					mainApp.sceneTransition("historyReportScene");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        	}
        });
        
        
        /*************
         * HELP Menu *
         *************/
        
        /**
         * Help button displays a scene that contains the Help information.
         */
        helpMenuItem.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		
        		try {
        			
					mainApp.sceneTransition("helpScene");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        	}
        });
        
        /**
         * About button shows the About scene
         */
        aboutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		
        		try {

					mainApp.sceneTransition("aboutScene");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        	}
        });
    }
    
    public void update() {
    	
    }
}
