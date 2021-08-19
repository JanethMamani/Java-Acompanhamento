package Entidades;

import Entidades.enums.Cor;

public class Circulo extends Forma{
	
	private Double raio;
	
	public Circulo() {
		
	}

	public Circulo(Cor cores, Double raio) {
		super(cores);
		this.raio = raio;
	}

	public Double getRaio() {
		return raio;
	}

	public void setRaio(Double raio) {
		this.raio = raio;
	}

	@Override
	public double area() {
		return Math.PI * raio * raio;
	}

}
