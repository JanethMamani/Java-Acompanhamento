package Aplicacao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Programa {
	
	public static void main(String[] args) {
		
		Set<String> recursoSet = new HashSet<>();
		//new TreeSet
		//new LinkedHashSet
		
		recursoSet.add("TV");
		recursoSet.add("Notebook");
		recursoSet.add("Tablet");
		
		System.out.println(recursoSet.contains("Notebook"));
		
		recursoSet.removeIf(objeto -> objeto.charAt(0) == 'T');//Isso é um predicado
		
		for (String item :recursoSet) {
			System.out.println(item);
		}
		
		//Algumas operações
		
		Set<Integer> unidade17 = new TreeSet<>(Arrays.asList(0,2,4,6,8,10));
		Set<Integer> unidadeSpecial = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9,10));
		
		//Uniao de treeset
		Set<Integer> unidadeXZ = new TreeSet<>(unidade17);
		unidadeXZ.addAll(unidadeSpecial);
		System.out.println(unidadeXZ);
		
		//Intersecção
		Set<Integer> unidade8 = new TreeSet<>(unidade17);
		unidade8.retainAll(unidadeSpecial);
		System.out.println(unidade8);
		
		//Diferença
		Set<Integer> externos = new TreeSet<>(unidade17);
		externos.removeAll(unidadeSpecial);
		System.out.println(externos);
	}

}
