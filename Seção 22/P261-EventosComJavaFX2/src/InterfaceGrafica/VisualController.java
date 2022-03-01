package InterfaceGrafica;

import Utilidades.Alertas;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class VisualController {
	
	@FXML
	private Button botaoTeste;

	@FXML
	public void onBotaoTesteAction() {
		System.out.println("Clicado!");
		Alertas.mostrarAlerta("Titulo do alerta", "Alert! OuO", "Hi", AlertType.INFORMATION);
	}
}
