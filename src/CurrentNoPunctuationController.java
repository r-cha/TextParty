import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class CurrentNoPunctuationController extends RootController implements Initializable{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Text withoutPunctuationText;

	@FXML
	private Text fileNameText;

	private TextParty mainApp;

	public void setMainApp(TextParty mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	public void initialize(URL location, ResourceBundle resources) {
		assert withoutPunctuationText != null : "fx:id=\"withoutPunctuationText\" was not injected: check your FXML file 'currentNoPunctuationScene.fxml'.";
		assert fileNameText != null : "fx:id=\"fileNameText\" was not injected: check your FXML file 'currentNoPunctuationScene.fxml'.";
		
		withoutPunctuationText.setWrappingWidth(450);

	}

	public void update() {
		
		// TODO: Fix this
		
		if (mainApp.current != null) {
			
			fileNameText.setText(mainApp.current.getFile().getName());
			withoutPunctuationText.setText(mainApp.current.getNoPunctuation());
			
		}
		
	}
}
