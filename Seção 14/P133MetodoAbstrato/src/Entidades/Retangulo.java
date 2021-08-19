package Entidades;

import Entidades.enums.Cor;

public class Retangulo extends Forma{
	
	private Double altura;
	private Double largura;
	
	public Retangulo() {
		super();
	}
	
	public Retangulo(Cor cores, Double altura, Double largura) {
		super(cores);
		this.altura = altura;
		this.largura = largura;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	@Override
	public double area() {
		return altura*largura;
	}

}
