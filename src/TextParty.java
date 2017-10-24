import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TextParty extends Application{
	
	private Stage primaryStage;
	private BorderPane rootLayout;

	public static void main(String[] args) {
		Application.launch(args);
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("TextParty");
		
		initRootLayout();
		
		showStartupScene();
		
	}
	
	public void initRootLayout() {
		
		try {
			// Load root fxml
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TextParty.class.getResource("ProjectScenes/stage.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			// Show scene with root Layout
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showStartupScene() {
		
		try {
			
			// Load default scene
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TextParty.class.getResource("ProjectScenes/defaultScene.fxml"));
			AnchorPane defaultScene = (AnchorPane) loader.load();
			
			// Set Scene into center of root layout
			rootLayout.setCenter(defaultScene);
			
			DefaultSceneController controller = loader.getController();
			controller.setMainApp(this);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showCurrentReportScene() {
		
		try {
			
			// Load default scene
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TextParty.class.getResource("ProjectScenes/currentReportScene.fxml"));
			AnchorPane currentReportScene = (AnchorPane) loader.load();
			
			// Set Scene into center of root layout
			rootLayout.setCenter(currentReportScene);
			
			CurrentReportSceneController controller = loader.getController();
			controller.setMainApp(this);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showCurrentNoPunctuationScene() {
		
		try {
			
			// Load default scene
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TextParty.class.getResource("ProjectScenes/currentNoPunctuationScene.fxml"));
			AnchorPane currentNoPunctuationScene = (AnchorPane) loader.load();
			
			// Set Scene into center of root layout
			rootLayout.setCenter(currentNoPunctuationScene);
			
			CurrentNoPunctuationController controller = loader.getController();
			controller.setMainApp(this);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showHistoryLogScene() {
		
		try {
			
			// Load default scene
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TextParty.class.getResource("ProjectScenes/historyLogScene.fxml"));
			AnchorPane historyLogScene = (AnchorPane) loader.load();
			
			// Set Scene into center of root layout
			rootLayout.setCenter(historyLogScene);
			
			HistoryLogController controller = loader.getController();
			controller.setMainApp(this);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showHistoryReportScene() {
		
		try {
			
			// Load default scene
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TextParty.class.getResource("ProjectScenes/historyReportScene.fxml"));
			AnchorPane historyReportScene = (AnchorPane) loader.load();
			
			// Set Scene into center of root layout
			rootLayout.setCenter(historyReportScene);
			
			HistoryReportController controller = loader.getController();
			controller.setMainApp(this);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showHelpScene() {
		
		try {
			
			// Load default scene
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TextParty.class.getResource("ProjectScenes/helpScene.fxml"));
			AnchorPane helpScene = (AnchorPane) loader.load();
			
			// Set Scene into center of root layout
			rootLayout.setCenter(helpScene);
			
			HelpController controller = loader.getController();
			controller.setMainApp(this);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showAboutScene() {
		
		try {
			
			// Load default scene
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TextParty.class.getResource("ProjectScenes/aboutScene.fxml"));
			AnchorPane aboutScene = (AnchorPane) loader.load();
			
			// Set Scene into center of root layout
			rootLayout.setCenter(aboutScene);
			
			AboutController controller = loader.getController();
			controller.setMainApp(this);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
