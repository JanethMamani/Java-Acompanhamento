package Servicos;

import java.util.List;
import java.util.function.Predicate;

import Entidade.Reploid;

public class ServicoHunter {
	
	public double somaFiltrada(List<Reploid> reploids, Predicate<Reploid> separador) {
		double soma = 0.0;
		for (Reploid reploid : reploids) {
			if(separador.test(reploid)) {
				soma += reploid.getHp();
			}
		}
		return soma;
	}

}
