package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage appStage) {
		try {
			Parent gerado = FXMLLoader.load(getClass().getResource("/InterfaceGrafica/Visual.fxml"));
			Scene scene = new Scene(gerado);
			appStage.setScene(scene);
			appStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
