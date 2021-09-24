package Aplicacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Entidades.Produto;

public class Principal {
	
	public static void main(String[] args) {
		
		List<Produto> produtos = new ArrayList<>();
		
		produtos.add(new Produto("TV", 900.00));
		produtos.add(new Produto("Notebook", 1200.00));
		produtos.add(new Produto("Tablet", 450.00));
		
		Collections.sort(produtos);
		
		for(Produto product : produtos) {
			System.out.println(product);
		}
	}
}
