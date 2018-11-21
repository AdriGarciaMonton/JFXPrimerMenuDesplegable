package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	private AnchorPane mypane;

	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("menuDesplegable.fxml"));

		mypane = (AnchorPane) loader.load();

		primaryStage.setTitle("menuDesplegable.fxml");
		primaryStage.setScene(new Scene(mypane));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
