package InterfaceGrafica;

import javafx.scene.control.TextField;

public class ConstraintsLimitacao {
	
	public static void apenasInteiros(TextField txt) {
		txt.textProperty().addListener((obs, antigo, novo) -> {
			if (novo != null && !novo.matches("\\d*")) {
				txt.setText(antigo);
			}
		});
	}
	
	public static void limitarQuantidade(TextField texto, int max) {
		texto.textProperty().addListener((obs, antigo, novo) -> {
			if (novo != null && novo.length() > max) {
				texto.setText(antigo);
			}
		});
	}
	
	public static void apenasDouble(TextField txt) {
		txt.textProperty().addListener((obs, antigo, novo) -> {
			if (novo != null && !novo.matches("\\d*([\\.]\\d*)?")) {
				txt.setText(antigo);
			}
		});
	}

}
