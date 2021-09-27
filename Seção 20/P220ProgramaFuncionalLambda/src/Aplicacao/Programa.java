package Aplicacao;

import java.util.ArrayList;
import java.util.List;

import Entidade.Produto;

public class Programa {
	
	public static int compararProdutos(Produto produto1, Produto produto2) {
		return produto1.getPreco().compareTo(produto2.getPreco());
	}
	
	public static void main(String[] args) {
		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto("TV", 900.00));
		produtos.add(new Produto("Notebook", 1200.00));
		produtos.add(new Produto("Tablet", 450.00));
		
		produtos.sort(Programa :: compararProdutos);
		
		produtos.forEach(System.out::println);
	}
}
