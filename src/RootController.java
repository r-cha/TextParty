import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;

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

        /*
         * FILE Menu
         */
        
        openFileMenuItem.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		
        		try {
        			
        			System.err.println("OPEN");        			
        			FileChooser fileChooser = new FileChooser();
        			fileChooser.setTitle("Open Resource File");
        			mainApp.current = new ActiveFile(fileChooser.showOpenDialog(mainApp.getPrimaryStage()));
        			
        			if (mainApp.current != null)
        				mainApp.history.add(new RecordFile(mainApp.current));
        			
        			mainApp.showDefaultScene();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        	}
        });
        
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
        
        /*
         * VIEW menu
         */
        
        currentReportMenuItem.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		
        		try {
        			
        			System.err.println("CURRENT REPORT");
					mainApp.showCurrentReportScene();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        	}
        });
        
        removePunctuationMenuItem.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		
        		try {
        			
        			System.err.println("CURRENT W//O PUNCTUATION");
        			
        			if (mainApp.current != null)
        				mainApp.current.removePunctuation();
        			
					mainApp.showCurrentNoPunctuationScene();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        	}
        });
        
        historyLogMenuItem.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		
        		try {
        			
        			System.err.println("HISTORY");
					mainApp.showHistoryLogScene();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        	}
        });
        
        historyReportMenuItem.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		
        		try {
        			
        			System.err.println("HISTORY REPORT");
					mainApp.showHistoryReportScene();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        	}
        });
        
        
        /*
         * HELP Menu
         */
        
        helpMenuItem.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		
        		try {
        			
        			System.err.println("HELP");
					mainApp.showHelpScene();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        	}
        });
        
        aboutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		
        		try {
        			
        			System.err.println("ABOUT");
					mainApp.showAboutScene();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        	}
        });
    }
}
