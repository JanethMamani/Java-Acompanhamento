package Servicos;

import java.util.List;

public class ServicoCalculo {
	
	public static <TipoQualquer extends Comparable<TipoQualquer>> TipoQualquer max(List<TipoQualquer> lista) {
		if(lista.isEmpty()) {
			throw new IllegalStateException("Lista não pode estar vazia");
		}
		TipoQualquer maximo = lista.get(0);
		for (TipoQualquer item : lista) {
			if (item.compareTo(maximo)>0) {
				maximo = item;
			}
		}
		return maximo;
	}

}
