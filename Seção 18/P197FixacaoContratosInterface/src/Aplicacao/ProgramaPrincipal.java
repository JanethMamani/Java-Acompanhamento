package Aplicacao;

import java.util.Date;
import java.util.Scanner;

public class ProgramaPrincipal {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre os dados do contrato: ");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		System.out.print("Data (dd/mm/yyyy): ");
		String data = sc.nextLine();
		Double valor = sc.nextDouble();
		}

}
