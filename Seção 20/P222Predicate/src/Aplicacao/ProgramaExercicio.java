package Aplicacao;

import java.util.ArrayList;
import java.util.List;

import Integrantes.Hunter;

public class ProgramaExercicio {
	
	public static void main(String[] args) {
		
		List<Hunter> hunters = new ArrayList<>();
		
		hunters.add(new Hunter("X", "B", 30.0));
		hunters.add(new Hunter("Zero", "A", 32.0));
		hunters.add(new Hunter("Iris", "S", 48.0));
		hunters.add(new Hunter("Axl", "B", 40.0));
		
		//hunters.removeIf(hunter -> hunter.getHP() >= 40);
		//hunters.removeIf(new HuntersPredicate());//Implementação de imtarface
		//hunters.removeIf(Hunter::PredicadoHunterStatic);
		hunters.removeIf(Hunter::PredicadoHunterNaoStatic);
		
		for(Hunter integrante : hunters) {
			System.out.println(integrante);
		}
	}
}
