package Aplicacao;

import java.util.Locale;
import java.util.Scanner;

import Servicos.InteresseServico;
import Servicos.InteresseServicoBrasil;

public class Programa {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Valor: ");
		double valor = sc.nextDouble();
		System.out.print("Meses: ");
		int meses =  sc.nextInt();
		sc.nextLine();
		
		InteresseServico atual = new InteresseServicoBrasil(2.0);
		double montante = atual.pagamento(valor, meses);
		
		System.out.print("Pagamento depois de " + meses + " meses: ");
		System.out.println(String.format("%.2f", montante));
		
		sc.close();
	}

}
