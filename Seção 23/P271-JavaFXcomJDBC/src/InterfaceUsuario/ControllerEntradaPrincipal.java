package InterfaceUsuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import InterfaceUsuario.Util.Alerts;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class ControllerEntradaPrincipal implements Initializable {
	
	@FXML
	private MenuItem menuItemVendedor;
	
	@FXML
	private MenuItem menuItemDepartamento;
	
	@FXML 
	private MenuItem menuItemSobre;
	
	@FXML
	public void onMenuItemVendedorAction() {
		System.out.println("Vendedor.");
	}
	
	@FXML
	public void onMenuItemDepartamentoAction() {
		loadView("/InterfaceUsuario/ListaDepartamentos.fxml");
	}
	
	@FXML
	public void onMenuItemSobreAction() {
		loadView("/InterfaceUsuario/Sobre.fxml");
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	
	private synchronized void loadView(String absoluteName) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
		try {
			VBox novaVBox = loader.load();
			Scene scenePrincipal = Main.getScenePrincipal();
			VBox VBoxPrincipal = (VBox) ((ScrollPane) scenePrincipal.getRoot()).getContent();
			
			Node menuPrincipal = VBoxPrincipal.getChildren().get(0);
			VBoxPrincipal.getChildren().clear();
			VBoxPrincipal.getChildren().add(menuPrincipal);
			VBoxPrincipal.getChildren().addAll(novaVBox.getChildren());
		} catch (IOException excep) {
			Alerts.showAlert("IOException", "Erro carregando página", excep.getMessage(), AlertType.ERROR);
		}
		
	}

}
