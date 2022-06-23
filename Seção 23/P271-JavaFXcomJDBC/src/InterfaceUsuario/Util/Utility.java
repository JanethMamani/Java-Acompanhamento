package InterfaceUsuario.Util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Utility {
	
	public static Stage faseAtual (ActionEvent evento) {
		return (Stage) ((Node) evento.getSource()).getScene().getWindow();
	}

}
