package com.github.dzmiv;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

/**
 * JavaFX Application
 * Algorithm-Visualizer
 */

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/SortView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/default.css").toExternalForm());
			primaryStage.setResizable(false);
			primaryStage.setTitle("Algorithm SpeedTest"); 
			Image icon = new Image(getClass().getResourceAsStream("/appIcon.png"));
			primaryStage.getIcons().add(icon);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
		
	}
}