package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Scene scenePrincipal;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader carregador = new FXMLLoader(getClass().getResource("/InterfaceUsuario/EntradaPrincipal.fxml"));
			ScrollPane container = carregador.load();
			
			//Ajustar janela
			container.setFitToHeight(true);
			container.setFitToWidth(true);
			
			scenePrincipal = new Scene(container);
			primaryStage.setScene(scenePrincipal);
			primaryStage.setTitle("Exemplo aplicação Java FX");
			primaryStage.show();
		} catch(IOException excep) {
			excep.printStackTrace();
		}
	}
	
	public static Scene getScenePrincipal() {
		return scenePrincipal;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
