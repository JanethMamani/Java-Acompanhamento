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
		
		//produtos.sort(new Comparador());
		
		//Outra forma de implementação
		Comparator<Produto> paraComparar = new Comparator<Produto>() {
			@Override
			public int compare(Produto produto1, Produto produto2) {
				return produto1.getNome().toUpperCase().compareTo(produto2.getNome().toUpperCase());
			}
		};
		
		produtos.sort(paraComparar);
		
		for(Produto product : produtos) {
			System.out.println(product);
		}
	}
}
