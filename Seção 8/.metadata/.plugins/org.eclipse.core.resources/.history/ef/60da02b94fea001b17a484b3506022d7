package Aplicacao;

import java.util.Locale;
import java.util.Scanner;

import Entidade.Produto;

public class Executor {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Produto produtoTeste = new Produto();
		
		System.out.println("Digite os dados do produto:");
		System.out.println("Nome: ");
		produtoTeste.name = sc.nextLine();
		
		System.out.println("Preço: ");
		produtoTeste.preco = sc.nextDouble();
		
		System.out.println("Quantidade em estoque: ");
		produtoTeste.quantidade = sc.nextInt();
		
		
		System.out.println("Dados do produto:" + produtoTeste.toString()); // não há problemas se for digitado apenas produtoTeste, pois o toString já retorna string
		
		System.out.println();
		System.out.println("Entre com o número a ser adicionado ao estoque: ");
		int itens = sc.nextInt();
		produtoTeste.addProduto(itens);
		
		System.out.println();
		System.out.println("Atualização:" + produtoTeste.toString());
		
		System.out.println();
		System.out.println("Entre com o número a ser removido do estoque: ");
		itens = sc.nextInt();
		produtoTeste.removerProduto(itens);
		
		System.out.println();
		System.out.println("Atualização:" + produtoTeste.toString());
		
		sc.close();
	}

}
