package Aplicacion;

import java.util.Locale;
import java.util.Scanner;

import Entidades.Produto;

public class Executor {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Produto[] vect = new Produto[n];
		
		for (int i=0; i<vect.length; i++) {
			sc.nextLine();
			String umNome = sc.nextLine();
			double umPreco = sc.nextDouble();
			vect[i] = new Produto(umNome,umPreco);
		}
		
		double soma = 0.0;
		for (int i=0; i<n; i++) {
			soma += vect[i].getPreco();
		}
		
		double media = soma / vect.length;
		System.out.println("A média dos preços é: $ "
							+ String.format("%.2f", media));
		
		sc.close();
	}

}
