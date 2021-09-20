package Aplicacao;

import java.util.Scanner;

import Servicos.ServicoImpressao;

public class Aplicacao {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ServicoImpressao<String> servPrint = new ServicoImpressao<>();
		
		System.out.print("Quantos valores? ");
		int quant = sc.nextInt();
		
		for (int i = 0; i< quant; i++) {
			String valor = sc.next();
			servPrint.adicionarValor(valor);
		}
		servPrint.imprimir();
		System.out.println("Primeiro: " + servPrint.primeiro());
		
		sc.close();
	}

}
