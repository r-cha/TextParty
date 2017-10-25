import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class CurrentNoPunctuationController extends RootController implements Initializable{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextFlow textWithoutPunctuationTexftFlow;

	@FXML
	private Text fileNameText;

	@FXML
	private Button saveButton;

	private TextParty mainApp;

	public void setMainApp(TextParty mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	public void initialize(URL location, ResourceBundle resources) {
		assert textWithoutPunctuationTexftFlow != null : "fx:id=\"textWithoutPunctuationTexftFlow\" was not injected: check your FXML file 'currentNoPunctuationScene.fxml'.";
		assert fileNameText != null : "fx:id=\"fileNameText\" was not injected: check your FXML file 'currentNoPunctuationScene.fxml'.";
		assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'currentNoPunctuationScene.fxml'.";

	}

	public void update() {
		
		if (mainApp.current != null) {
			
			fileNameText.setText(mainApp.current.getFile().getName());
			Text content = new Text(mainApp.current.getNoPunctuation());
			textWithoutPunctuationTexftFlow = new TextFlow(content);
			
		}
		
	}
}
