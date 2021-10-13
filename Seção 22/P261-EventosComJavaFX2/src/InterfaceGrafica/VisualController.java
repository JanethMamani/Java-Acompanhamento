package InterfaceGrafica;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class VisualController {
	
	@FXML
	private Button botaoTeste;

	
	public void onBotaoTesteAction() {
		System.out.println("Clicado!");
	}
}
