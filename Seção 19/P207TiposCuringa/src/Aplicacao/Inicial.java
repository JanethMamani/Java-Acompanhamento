package Aplicacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inicial {
	
	public static void main(String[] args) {
		
		//Tipos coringas podem ser supertipos de qualquer outro tipo de lista
		List<?> algunsObjetos = new ArrayList<Object>();
		List<Integer> unsInteiros = new ArrayList<Integer>();
		algunsObjetos = unsInteiros;
		
		Object item;
		Integer num = 15;
		item = num;
		
		//
		List<Integer> outrosNumeros = Arrays.asList(5, 2, 10);
		imprimirLista(outrosNumeros);
		
		List<String> meusNomes = Arrays.asList("X", "Zero", "Axl");
		imprimirLista(meusNomes);
	}
	
	public static void imprimirLista(List<?> listinha) {
		for (Object item : listinha) {
			System.out.println(item);
		}
	}

}
