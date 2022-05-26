package advancedProjectComputer;

import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;





public class Main extends Application {
	private static Stage mainStage;
	@Override
	public void start(Stage primaryStage) throws Exception{
		mainStage = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(root,688,488));
		primaryStage.setTitle("Ticket Reservation");
		primaryStage.show();
	}
	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		mainStage.getScene().setRoot(pane);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
