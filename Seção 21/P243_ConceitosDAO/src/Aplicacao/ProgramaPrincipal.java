package Aplicacao;

import java.util.Date;

import Entidades.Departamento;
import Entidades.Vendedor;

public class ProgramaPrincipal {
	
	public static void main(String[] args) {
		
		Departamento livros = new Departamento(1, "Livros");
		System.out.println(livros);
		
		Vendedor mercador = new Vendedor(21, "Mercador", "mercador@gmail.com", new Date(), 3000.0, livros);
		System.out.println(mercador);
	}

}
