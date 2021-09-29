package Aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import Entidade.Reploid;
import Servicos.ServicoHunter;

public class ProgramaExercicio {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Reploid> reploids = new ArrayList<>();
		
		reploids.add(new Reploid("X", "B", 50.0, 14));
		reploids.add(new Reploid("Zero", "A", 32.0, 16));
		reploids.add(new Reploid("Iris", "S", 48.0, 14));
		reploids.add(new Reploid("Axl", "B", 45.0, 11));
		reploids.add(new Reploid("Alia", "A", 28.0, 13));
		
		ServicoHunter sh = new ServicoHunter();
		double soma = sh.somaFiltrada(reploids, reploid -> reploid.getNome().charAt(0) == 'I');
		
		System.out.println("Soma: " + String.format("%.2f", soma));
	}

}
