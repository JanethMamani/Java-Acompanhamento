package Aplicacao;

import java.util.Scanner;

import Entidades.Conta;
import Excecao.ExceptionValor;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Entre com os dados da conta: ");
			System.out.print("Número da conta: ");
			Integer number = sc.nextInt();
			sc.nextLine();
			System.out.print("Proprietário: ");
			String nome = sc.nextLine();
			System.out.print("Saldo inicial: ");
			Double saldo = sc.nextDouble();
			System.out.print("Limite de saque: ");
			Double limiteSaque = sc.nextDouble();
			
			Conta acc = new Conta(number, nome, saldo, limiteSaque);
			System.out.print("Entre com o valor para saque: ");
			Double saque = sc.nextDouble();
			acc.saque(saque);
			System.out.print("Saldo da conta: " 
							+ String.format("%.2f", acc.getSaldo()));
			}
		catch(ExceptionValor ValorErro) {
			System.out.println("Erro ao realizar saque: " + ValorErro.getMessage());
		}
		catch(RuntimeException entradaInv) {//Cuidado com a ordem, esse é o ultimo
			System.out.println("Cuidado ao digitar! Erro na entrada!");
		}
		
		
		
		sc.close();

	}

}
