package Aplicacao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Entidades.Produto;

public class Principal {
	
	public static void main(String[] args) {
		
		List<Produto> produtos = new ArrayList<>();
		
		produtos.add(new Produto("TV", 900.00));
		produtos.add(new Produto("Notebook", 1200.00));
		produtos.add(new Produto("Tablet", 450.00));
		
		//Comparator<Produto> paraComparar =
		
		produtos.sort((produto1, produto2) -> produto1.getNome().toUpperCase().compareTo(produto2.getNome().toUpperCase()));
		
		for(Produto product : produtos) {
			System.out.println(product);
		}
	}
}
