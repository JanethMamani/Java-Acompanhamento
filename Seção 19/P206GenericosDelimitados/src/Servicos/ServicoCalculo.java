package Servicos;

import java.util.List;

public class ServicoCalculo {
	
	public static Integer max(List<Integer> lista) {
		if(lista.isEmpty()) {
			throw new IllegalStateException("Lista não pode estar vazia");
		}
		Integer maximo = lista.get(0);
		for (Integer item : lista) {
			if (item.compareTo(maximo)>0) {
				maximo = item;
			}
		}
		return maximo;
	}

}
