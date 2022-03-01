package Utilidades;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alertas {
	
	public static void mostrarAlerta(String titulo, String header, String content, AlertType type) {
		Alert alerta = new Alert(type);
		alerta.setTitle(titulo);
		alerta.setHeaderText(header);
		alerta.setContentText(content);
		alerta.show();
	}

}
