package Aplicacao;

import java.util.Locale;
import java.util.Scanner;

import Entidade.Produto;

public class Executor {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Digite os dados do produto:");
		System.out.println("Nome: ");
		String nome = sc.nextLine();
		
		System.out.println("Pre?o: ");
		double precinho = sc.nextDouble();
		
		/*System.out.println("Quantidade em estoque: ");
		int quanti = sc.nextInt();*/
		
		Produto produtoTeste = new Produto(nome, precinho);
		
		
		System.out.println("Dados do produto:" + produtoTeste.toString()); // n?o h? problemas se for digitado apenas produtoTeste, pois o toString j? retorna string
		
		System.out.println();
		System.out.println("Entre com o n?mero a ser adicionado ao estoque: ");
		int itens = sc.nextInt();
		produtoTeste.addProduto(itens);
		
		produtoTeste.setName("Computador");
		
		System.out.println("Nome atualizado: " + produtoTeste.getName());
		
		System.out.println();
		System.out.println("Atualiza??o:" + produtoTeste.toString());
		
		System.out.println();
		System.out.println("Entre com o n?mero a ser removido do estoque: ");
		itens = sc.nextInt();
		produtoTeste.removerProduto(itens);
		
		System.out.println();
		System.out.println("Atualiza??o:" + produtoTeste.toString());
		
		sc.close();
	}

}
