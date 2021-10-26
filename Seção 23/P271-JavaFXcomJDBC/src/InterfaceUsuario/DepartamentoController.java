package InterfaceUsuario;

import java.net.URL;
import java.util.ResourceBundle;

import Entidades.Departamento;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DepartamentoController implements Initializable{
	
	@FXML
	private TableView<Departamento> tabelaDepartamentos;
	
	@FXML
	private TableColumn<Departamento, Integer> ColunaId;
	
	@FXML
	private TableColumn<Departamento, String> ColunaNome;
	
	@FXML
	private Button botaoNovo;
	
	@FXML
	public void onBotaoNovoAction() {
		System.out.println("Botão Novo");
	}
 
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		initializeNodes();
		
	}

	private void initializeNodes() {
		ColunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
		ColunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		Stage stage = (Stage) Main.getScenePrincipal().getWindow();
		tabelaDepartamentos.prefHeightProperty().bind(stage.heightProperty());
		
	}

}
