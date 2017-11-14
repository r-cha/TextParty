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
	private AnchorPane scene;
	private RootController rootController;
	private RootController controller;

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
            FileInputStream fi = new FileInputStream("history.tpy");
            ObjectInputStream si = new ObjectInputStream(fi);
            history = (ArrayList<RecordFile>) si.readObject();
            si.close();
        } catch (Exception e) {
        	history = new ArrayList<RecordFile>();
        }
		
		primaryStage.setResizable(false);
		
		initRootLayout();

		sceneTransition("defaultScene");

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
        
		primaryStage.close();
		
	}

	/*************************************************************
	 *                                                           *
	 *                                                           * 
	 * ALL METHODS BELOW THIS POINT ARE SCENE TRANSITION METHODS *
	 *                                                           *
	 *                                                           * 
	 *************************************************************/
	
	/**
	 * Transitions to a scene from any other scene. 
	 * Allows addition of scenes without adding a new "showScene" function, just pass in valid FXML document name.
	 * @param sceneName - a String that is the filename of the scene you wish to load, excluding any prefix or suffix.
	 * @author Robert Chandler
	 */
	public void sceneTransition(String sceneName) {
		
		try {

			// Load default scene
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TextParty.class.getResource("ProjectScenes/" + sceneName + ".fxml"));
			scene = (AnchorPane) loader.load();

			// Set Scene into center of root layout
			rootLayout.setCenter(scene);

			controller = loader.getController();
			controller.setMainApp(this);
			controller.update();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

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

	

}
