package Aplicacao;

import Entidades.FormaAbstrata;
import Enumeradores.Cor;
import Formas.Circulo;
import Formas.Retangulo;

public class ProgramaPrincipal {
	
	public static void main(String[] args) {
		
		FormaAbstrata forma1 = new Circulo(Cor.PRETO, 2.0);
		FormaAbstrata forma2 = new Retangulo(Cor.BRANCO, 3.0, 4.0);
		
		System.out.println("Cor do circulo:" + forma1.getCor());
		System.out.println("Area do circulo: " + String.format("%.2f", forma1.area()));
		System.out.println("Cor do retângulo: " + forma2.getCor());
		System.out.println("Area do retângulo: " + String.format("%.2f", forma2.area()));
	}

}
