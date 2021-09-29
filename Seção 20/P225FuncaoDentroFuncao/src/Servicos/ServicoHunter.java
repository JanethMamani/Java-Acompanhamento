package Servicos;

import java.util.List;

import Entidade.Reploid;

public class ServicoHunter {
	
	public double somaFiltrada(List<Reploid> reploids) {
		double soma = 0.0;
		for (Reploid reploid : reploids) {
			if(reploid.getNome().charAt(0) == 'A') {
				soma += reploid.getHp();
			}
		}
		return soma;
	}

}
