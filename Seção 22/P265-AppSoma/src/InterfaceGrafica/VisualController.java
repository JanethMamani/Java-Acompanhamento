package InterfaceGrafica;

import Utilidades.Alertas;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VisualController {

	@FXML
	private TextField txtNumero1;

	@FXML
	private TextField txtNumero2;

	@FXML
	private Label labelResultado;

	@FXML
	private Button btSoma;

	@FXML
	public void onBotaoSumAction() {
		try {
			double numero1 = Double.parseDouble(txtNumero1.getText());
			double numero2 = Double.parseDouble(txtNumero2.getText());
			double soma = numero1 + numero2;
			labelResultado.setText(String.format("%.2f", soma));
		} catch (NumberFormatException exp) {
			Alertas.mostrarAlerta("Erro ao calcular", null, "Insira um número válido!\n" + exp.getMessage(), AlertType.ERROR);
		}
	}
}
