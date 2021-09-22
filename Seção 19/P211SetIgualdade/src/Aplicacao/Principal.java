package Aplicacao;

import java.util.HashSet;
import java.util.Set;

import Entidades.Produto;

public class Principal {
	
	public static void main(String[] args) {
		
		Set<Produto> produtosRapidos = new HashSet<>();
		
		produtosRapidos.add(new Produto("TV", 900.0));
		produtosRapidos.add(new Produto("Notebook", 1200.0));
		produtosRapidos.add(new Produto("Tablet", 400.0));
		
		Produto clone = new Produto("Notebook", 1200.0);
		
		System.out.println(produtosRapidos.contains(clone));
	}
}
