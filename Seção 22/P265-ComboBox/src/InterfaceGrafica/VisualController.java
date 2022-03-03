package InterfaceGrafica;

import java.net.URL;
import java.util.ResourceBundle;

import Utilidades.Alertas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VisualController implements Initializable{

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

	@Override
	public void initialize(URL urlParaInserirNaoesta, ResourceBundle rb) {
		ConstraintsLimitacao.apenasDouble(txtNumero1);
		ConstraintsLimitacao.apenasDouble(txtNumero2);
		ConstraintsLimitacao.limitarQuantidade(txtNumero1, 12);
		ConstraintsLimitacao.limitarQuantidade(txtNumero2, 12);
	}
}
