package InterfaceUsuario;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Entidades.Departamento;
import InterfaceUsuario.Util.Alerts;
import InterfaceUsuario.Util.Utility;
import Servicos.ServicoDepartamento;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DepartamentoController implements Initializable{
	
	private ServicoDepartamento servicoD;
	
	@FXML
	private TableView<Departamento> tabelaDepartamentos;
	
	@FXML
	private TableColumn<Departamento, Integer> ColunaId;
	
	@FXML
	private TableColumn<Departamento, String> ColunaNome;
	
	@FXML
	private Button botaoNovo;
	
	private ObservableList <Departamento> obsLista;
	
	@FXML
	public void onBotaoNovoAction(ActionEvent abrirForm) {
		Stage faseRelacionada = Utility.faseAtual(abrirForm);
		criarFormularioDialogo("/InterfaceUsuario/FormularioDepartamento.fxml", faseRelacionada);
	}
	
	public void setServicoDepartamento(ServicoDepartamento servico) {
		servicoD = servico;//Inversão de contreole pricipio Solid
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
	
	public void atualizarTabela() {
		if(servicoD == null) {
			throw new IllegalStateException("Serviço está nulo");
		}
		List<Departamento> departamentos = servicoD.findAll();
		obsLista = FXCollections.observableArrayList(departamentos);
		tabelaDepartamentos.setItems(obsLista);
	}
	
	private void criarFormularioDialogo (String NomeJanela, Stage faseRelacionada) {
		try {
			FXMLLoader gerador = new FXMLLoader(getClass().getResource(NomeJanela));
			Pane objetoPane = gerador.load();
			
			Stage faseDialogo = new Stage();
			faseDialogo.setTitle("Digite o departamento");
			faseDialogo.setScene(new Scene(objetoPane));
			faseDialogo.setResizable(false);
			faseDialogo.initOwner(faseRelacionada);
			faseDialogo.initModality(Modality.WINDOW_MODAL);
			faseDialogo.showAndWait();
		}catch(IOException erro) {
			Alerts.showAlert("IO Exception Ocurrence", "Erro carregando tela", erro.getMessage(), AlertType.ERROR);
		}
	}

}
