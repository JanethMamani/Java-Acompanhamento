package Entidades;

public class Circulo implements Forma{
	
	private double raio;
	
	public Circulo(double radius) {
		raio = radius;//Passando radius para raio hehe
	}
	
	public double getRaio() {
		return raio;
	}
	
	public void setRaio(double radius) {
		raio = radius;
	}
	
	@Override
	public double area() {
		return Math.PI * raio * raio;
	}
}
