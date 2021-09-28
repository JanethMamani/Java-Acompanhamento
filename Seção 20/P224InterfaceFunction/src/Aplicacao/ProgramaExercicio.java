package Aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import Integrantes.Hunter;
import Utilitarios.UpperCaseFunction;

public class ProgramaExercicio {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Hunter> hunters = new ArrayList<>();
		
		hunters.add(new Hunter("X", "B", 30.0));
		hunters.add(new Hunter("Zero", "A", 32.0));
		hunters.add(new Hunter("Iris", "S", 48.0));
		hunters.add(new Hunter("Axl", "B", 40.0));
		
		//List<String> nomes = hunters.stream().map(new UpperCaseFunction()).collect(Collectors.toList());
		
		List<String> nomes = hunters.stream().map(Hunter::UpperCaseStatic).collect(Collectors.toList());
		
		nomes.forEach(System.out::println);
	}
}
