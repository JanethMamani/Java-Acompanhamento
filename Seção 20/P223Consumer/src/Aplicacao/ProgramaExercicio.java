package Aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import Integrantes.Hunter;

public class ProgramaExercicio {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Hunter> hunters = new ArrayList<>();
		
		hunters.add(new Hunter("X", "B", 30.0));
		hunters.add(new Hunter("Zero", "A", 32.0));
		hunters.add(new Hunter("Iris", "S", 48.0));
		hunters.add(new Hunter("Axl", "B", 40.0));
		
		//hunters.forEach(new HPUpdate()); //Olhe a classe HPUpdate
		
		//hunters.forEach(Hunter::HPUpdateStatic); //Olhe o metodo estatico
		
		//hunters.forEach(Hunter::HPUpdateNaoStatico);//Olhe o metodo nao estatico
		
		double fator = 1.1;
		
		/*Consumer<Hunter> energizador = hunter -> {
			hunter.setHP(hunter.getHP() * fator);
		};
		
		hunters.forEach(energizador);
		*/
		
		//Lambda inline
		hunters.forEach(hunter -> hunter.setHP(hunter.getHP() * fator));
		
		hunters.forEach(System.out::println);
	}
}
