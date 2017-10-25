import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TextParty extends Application{

	private Stage primaryStage;
	private BorderPane rootLayout;
	private AnchorPane defaultScene, currentReportScene, currentNoPunctuationScene, historyLogScene, historyReportScene, helpScene, aboutScene;
	private RootController rootController;

	public ActiveFile current;
	public ArrayList<RecordFile> history;
	
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
		
		history = new ArrayList<RecordFile>();
		
		initRootLayout();

		showDefaultScene();

	}
	
	@Override
	public void stop() throws Exception{
		
		primaryStage.close();
		
	}

	/*************************************************************
	 *                                                           *
	 *                                                           * 
	 * ALL METHODS BELOW THIS POINT ARE SCENE TRANSITION METHODS *
	 *                                                           *
	 *                                                           * 
	 *************************************************************/

	public void initRootLayout() {

		try {
			
			FXMLLoader loader = new FXMLLoader();
			
			// Load root fxml
			loader.setLocation(TextParty.class.getResource("ProjectScenes/stage.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show scene with root Layout
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);

			primaryStage.show();
			
			rootController = (RootController) loader.getController();
			rootController.setMainApp(this);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showDefaultScene() {

		try {

			// Load default scene
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TextParty.class.getResource("ProjectScenes/defaultScene.fxml"));
			defaultScene = (AnchorPane) loader.load();

			// Set Scene into center of root layout
			rootLayout.setCenter(defaultScene);

			DefaultSceneController controller = (DefaultSceneController) loader.getController();
			controller.setMainApp(this);
			controller.update();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showCurrentReportScene() {

		try {

			// Load default scene
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TextParty.class.getResource("ProjectScenes/currentReportScene.fxml"));
			currentReportScene = (AnchorPane) loader.load();

			// Set Scene into center of root layout
			rootLayout.setCenter(currentReportScene);

			CurrentReportSceneController controller = loader.getController();
			controller.setMainApp(this);
			controller.update();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showCurrentNoPunctuationScene() {

		try {

			// Load default scene
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TextParty.class.getResource("ProjectScenes/currentNoPunctuationScene.fxml"));
			currentNoPunctuationScene = (AnchorPane) loader.load();

			// Set Scene into center of root layout
			rootLayout.setCenter(currentNoPunctuationScene);

			CurrentNoPunctuationController controller = loader.getController();
			controller.setMainApp(this);
			controller.update();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showHistoryLogScene() {

		try {

			// Load default scene
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TextParty.class.getResource("ProjectScenes/historyLogScene.fxml"));
			historyLogScene = (AnchorPane) loader.load();

			// Set Scene into center of root layout
			rootLayout.setCenter(historyLogScene);

			HistoryLogController controller = loader.getController();
			controller.setMainApp(this);
			controller.update();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showHistoryReportScene() {

		try {

			// Load default scene
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TextParty.class.getResource("ProjectScenes/historyReportScene.fxml"));
			historyReportScene = (AnchorPane) loader.load();

			// Set Scene into center of root layout
			rootLayout.setCenter(historyReportScene);

			HistoryReportController controller = loader.getController();
			controller.setMainApp(this);
			controller.update();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showHelpScene() {

		try {

			// Load default scene
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TextParty.class.getResource("ProjectScenes/helpScene.fxml"));
			helpScene = (AnchorPane) loader.load();

			// Set Scene into center of root layout
			rootLayout.setCenter(helpScene);

			HelpController controller = loader.getController();
			controller.setMainApp(this);
			controller.update();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showAboutScene() {

		try {

			// Load default scene
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TextParty.class.getResource("ProjectScenes/aboutScene.fxml"));
			aboutScene = (AnchorPane) loader.load();

			// Set Scene into center of root layout
			rootLayout.setCenter(aboutScene);

			AboutController controller = loader.getController();
			controller.setMainApp(this);
			controller.update();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
