package Aplicacion;

import java.util.Locale;
import java.util.Scanner;

import Utilidades.Calculadora;

public class Executor {
	
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
	//	Calculadora calcula = new Calculadora();// Instanciou o objeto
		
		System.out.println("Digite o raio: ");
		double raio = sc.nextDouble();
		
		double circ = Calculadora.circunf(raio);
		
		double vol = Calculadora.volume(raio);
		
		System.out.printf("Circunferência: %.2f%n", circ);
		System.out.printf("Volume: %.2f%n", vol);
		System.out.printf("PI: %.2f%n", Calculadora.ESSE_E_O_PI);
		
		
		sc.close();
	}
	
}
