package Aplicacao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ProgramaExercicio {
	
	public static void main(String[] args) {
		
		List<Integer> numeros = Arrays.asList(3, 4, 5, 10, 7);
		
		Stream<Integer> numerosOrdenados = numeros.stream().map(n -> n * 10);
		
		System.out.println(Arrays.toString(numerosOrdenados.toArray()));
		
		Stream<String> nomes = Stream.of("X", "Zero", "Iris", "Axl", "Alia");
		System.out.println(Arrays.toString(nomes.toArray()));
		
		Stream<Integer> pares = Stream.iterate(0, n -> n + 2);
		System.out.println(Arrays.toString(pares.limit(10).toArray()));
		
		Stream<Long> fibonacci = Stream.iterate(new Long[] {0L, 1L}, numero -> new Long[] {numero[1], numero[0]+numero[1]}).map(numero -> numero[0]);
		System.out.println(Arrays.toString(fibonacci.limit(10).toArray()));
	}

}
