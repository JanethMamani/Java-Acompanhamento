package Servicos;

import java.util.ArrayList;
import java.util.List;

public class ServicoImpressao<Qualquer>{
	
	private List<Qualquer> aleatorio = new ArrayList<>();
	
	public void adicionarValor(Qualquer valor) {
		aleatorio.add(valor);
	}
	
	public Qualquer primeiro() {
		if (aleatorio.isEmpty()) {
			throw new IllegalStateException("Lista esta vazia");
		}
		return aleatorio.get(0);
	}
	
	public void imprimir() {
		System.out.print("[");
		if(!aleatorio.isEmpty()) {
			System.out.print(aleatorio.get(0));
		}
		for (int i=1; i<aleatorio.size();i++) {
			System.out.print(", " + aleatorio.get(i));
		}
		System.out.println("]");
	}
}
