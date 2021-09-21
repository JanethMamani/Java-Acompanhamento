package Aplicacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Principal {
	
	public static void main(String[] args) {
		
		List<Integer> Inteiros = Arrays.asList(1, 2, 3, 4);
		List<Double> meusDoubles = Arrays.asList(3.14, 6.28);
		List<Object> objetos = new ArrayList<Object>();
		
		copiar(Inteiros, objetos);
		imprimirLista(Inteiros);
		
		copiar(meusDoubles, objetos);
		imprimirLista(objetos);
	}
	
	public static void copiar(List<? extends Number> origem, List<? super Number> destino) {
		for (Number numero : origem) {
			destino.add(numero);
		}
	}
	
	public static void imprimirLista(List<?> listinha) {
		for (Object item : listinha) {
			System.out.print(item + " ");
		}
		System.out.println();
	}
}
