import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

	/**
	 * initializes the application by initializing the stage and scene, and deserializing history from a file if present.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws IOException {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("TextParty");
		
		// Deserialize history file if available
        try {
        	System.err.println("LOAD HISTORY");
            FileInputStream fi = new FileInputStream("history.tpy");
            ObjectInputStream si = new ObjectInputStream(fi);
            history = (ArrayList<RecordFile>) si.readObject();
            si.close();
            System.err.println("LOADED");
        } catch (Exception e) {
        	history = new ArrayList<RecordFile>();
            System.err.println("NO HISTORY");
        }
		
		primaryStage.setResizable(false);
		
		initRootLayout();

		showDefaultScene();

	}
	
	/**
	 * Serializes history to file, then closes the main stage and ends the program.
	 */
	@Override
	public void stop() throws Exception{
		
		// Serialize history to file
        try {
            FileOutputStream fo = new FileOutputStream("history.tpy");
            ObjectOutputStream so = new ObjectOutputStream(fo);
            so.writeObject(history);
            so.flush();
            so.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		System.err.println("STOP");
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
