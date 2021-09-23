package Aplicacao;

import java.util.Set;
import java.util.TreeSet;

import Entidades.Produto;

public class Principal {
	
	public static void main(String[] args) {
		
		Set<Produto> arvoreRubra = new TreeSet<>();
		
		arvoreRubra.add(new Produto("TV", 900.0));
		arvoreRubra.add(new Produto("Notebook", 1200.0));
		arvoreRubra.add(new Produto("Tablet", 400.0));
		
		for (Produto item : arvoreRubra) {
			System.out.println(item);
		}
	}
}
