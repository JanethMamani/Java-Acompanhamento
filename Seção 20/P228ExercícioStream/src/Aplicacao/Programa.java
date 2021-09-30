package Aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import Entidades.Produto;

public class Programa {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Entrar com o caminho completo: ");
		String caminho = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			List<Produto> produtos = new ArrayList<>();
			
			String linha = br.readLine();
			while(linha != null) {
				String[] campos = linha.split(",");
				produtos.add(new Produto(campos[0], Double.parseDouble(campos[1])));
				linha = br.readLine();
			}
			
			double media = produtos.stream()
					.map(p -> p.getPreco())
					.reduce(0.0, (x,y) -> x+y )/ produtos.size();
			
			System.out.println("Preço médio: " + String.format("%.2f", media));
			
			Comparator<String> comparadorPreco = (prod1, prod2) -> prod1.toUpperCase().compareTo(prod2.toUpperCase());
			
			List<String> nomes = produtos.stream()
					.filter(p -> p.getPreco() < media)
					.map(p -> p.getNome())
					.sorted(comparadorPreco.reversed())
					.collect(Collectors.toList());
			
			nomes.forEach(System.out::println);
			
		} catch (IOException excep) {
			System.out.println("Erro: " + excep.getMessage());
		}
		sc.close();
	}

}
