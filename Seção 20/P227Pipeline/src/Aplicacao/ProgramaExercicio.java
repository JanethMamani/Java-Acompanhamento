package Aplicacao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProgramaExercicio {
	
	public static void main(String[] args) {
		
		List<Integer> numeros = Arrays.asList(8, 10, 11, 12, 14, 16, 17, 13);
		Stream<Integer> numerosStream = numeros.stream().map(n -> n * 10);
		System.out.println(Arrays.toString(numerosStream.toArray()));
		
		int produto = numeros.stream().reduce(1, (x,y) -> x*y);
		System.out.println("Produto: "+ produto);
		
		int soma = numeros.stream().reduce(0, (x,y) -> x+y);
		System.out.println("Soma: "+ soma);
		
		List<Integer> maisProcessos = numeros.stream()
				.filter(n -> n % 2 == 0)
				.map(n -> n * 10)
				.collect(Collectors.toList());
		System.out.println(Arrays.toString(maisProcessos.toArray()));
	}

}
