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

import Entidade.Funcionario;

public class ProgramaPrincipal {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Entre com o caminho do arquivo: ");
		String caminho = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			List<Funcionario> funcionarios = new ArrayList<>();
			
			String linha = br.readLine();
			while(linha != null) {
				String[] dados = linha.split(",");
				funcionarios.add(new Funcionario(dados[0],dados[1],Double.parseDouble(dados[2])));
				linha = br.readLine();
			}
			System.out.print("Digite o saário para filtro: ");
			Double salario = sc.nextDouble();
			
			Comparator<String> alfabetico = (a, b) -> a.toUpperCase().compareTo(b.toUpperCase());
			List<String> salarioMaior = funcionarios.stream()
					.filter(f -> f.getSalario() > salario)
					.map(f -> f.getEmail())
					.sorted(alfabetico)
					.collect(Collectors.toList());
					
			salarioMaior.forEach(System.out::println);
			
			Double soma = funcionarios.stream()
					.filter(f -> f.getNome().charAt(0) == 'M')
					.map(f -> f.getSalario())
					.reduce(0.0, (x,z) -> x + z);
			
			System.out.println("A soma dos salarios dos funcionários que começam com a letra 'M' é: " + soma);
			
		}catch (IOException excep) {
			System.out.println("Erro: " + excep.getMessage());
		}
		sc.close();
	}

}
