package Secao6;

import java.util.Locale;
import java.util.Scanner;

public class p55DoWhile {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		char resp; // Declara fora do bloco estrutura e apenas use dentro
		do {
			System.out.print("Digite a temperatura em Celsius: ");
			double C = sc.nextDouble();
			double F = 9.0 * C / 5.0 + 32.0;
			System.out.printf("Equivalente em Fahrenheit: %.1f%n", F);
			
			System.out.println("Deseja repetir (s/n)? ");
			resp = sc.next().charAt(0);
			
		} while (resp == 's'); // ou resp != n
		
		
		
		sc.close();
	}

}
