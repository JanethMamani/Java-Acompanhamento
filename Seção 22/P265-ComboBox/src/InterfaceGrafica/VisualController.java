package InterfaceGrafica;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Entidades.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class VisualController implements Initializable{

	@FXML
	private ComboBox<Pessoa> pessoasCombo;
	
	private ObservableList<Pessoa> contatos;
	
	@FXML
	private Button botaoAll;
	
	@FXML
	public void onBotaoAllAction() {
		for (Pessoa pessoa : pessoasCombo.getItems()) {
			System.out.println(pessoa);
		}
	}
	
	@FXML
	public void onComboBoxPessoasAction() {
		Pessoa pessoa = pessoasCombo.getSelectionModel().getSelectedItem();
		System.out.println(pessoa);
	}

	@Override
	public void initialize(URL urlParaInserirNaoesta, ResourceBundle rb) {
		List<Pessoa> pessoasLista = new ArrayList<>();
		pessoasLista.add(new Pessoa(1, "Maria", "maria@gmail.com"));
		pessoasLista.add(new Pessoa(2, "Alex", "alex@gmail.com"));
		pessoasLista.add(new Pessoa(3, "Bob", "bob@gmail.com"));
		
		contatos = FXCollections.observableArrayList(pessoasLista);
		pessoasCombo.setItems(contatos);
		
		Callback<ListView<Pessoa>, ListCell<Pessoa>> produz = lv -> new ListCell<Pessoa>() {
			@Override
			protected void updateItem(Pessoa item, boolean vazio) {
				super.updateItem(item, vazio);
				setText(vazio ? "" : item.getNome());
			}
		};
		
		pessoasCombo.setCellFactory(produz);
		pessoasCombo.setButtonCell(produz.call(null));
	}
}	

