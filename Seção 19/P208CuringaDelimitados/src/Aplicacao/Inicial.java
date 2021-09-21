package Aplicacao;

import java.util.ArrayList;
import java.util.List;

import Entidades.Circulo;
import Entidades.Forma;
import Entidades.Retangulo;

public class Inicial {
	
	public static void main(String[] args) {
		
		List<Forma> formas = new ArrayList<>();
		formas.add(new Retangulo(3.0, 2.0));
		formas.add(new Circulo(2.0));
		
		System.out.println("Area total: " + areaTotal(formas));
		
		 //Lista com subtipo circulos
		
		List<Circulo> circulos = new ArrayList<>();
		circulos.add(new Circulo(2.0));
		circulos.add(new Circulo(3.0));
		
		System.out.println("Area total: " + areaTotal(circulos));
	}
	
	public static double areaTotal(List<? extends Forma> listinha) {
		double soma = 0.0;
		for(Forma figura : listinha) {
			soma += figura.area();
		}
		return soma;
	}

}
