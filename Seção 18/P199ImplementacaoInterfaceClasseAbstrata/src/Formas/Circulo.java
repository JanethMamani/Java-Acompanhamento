package Formas;

import Entidades.FormaAbstrata;
import Enumeradores.Cor;

public class Circulo extends FormaAbstrata {
	
	private Double raio;

	public Circulo(Cor cor, Double raio) {
		super(cor);
		this.raio = raio;
	}

	@Override
	public double area() {
	    double CirArea = raio*raio*3.1415;
		return CirArea;
	}
}
