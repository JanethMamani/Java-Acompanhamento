package Aplicacion;

import Entidades.Conta;
import Entidades.ContaBusiness;
import Entidades.Poupanca;

public class Execucion {
	
	public static void main(String[] args) {
		
		
		/*
		Conta conti = new Conta(8002, "X", 0.0);
		ContaBusiness ContBuss = new ContaBusiness(8002, "Zero", 0.0, 1000.0);
		
		//UPCASTING - de uma subclasse para uma superclasse é perfeitamente possivel
		
		Conta conta1 = ContBuss;
		Conta conta2 = new ContaBusiness(1001, "Axl", 0.0, 500.0);
		Conta conta3 = new Poupanca(3003, "Sigma", 0.0, 0.9);
		
		//DOWNCASTING - Permitira fazer operacoes de emprestimo etc
		ContaBusiness ContBuss1 = (ContaBusiness)conta2;
		ContBuss1.emprestimo(100.0);
		
		//ContaBusiness ContBuss2 = (ContaBusiness) conta3;
		if(conta3 instanceof ContaBusiness) {
			ContaBusiness ContBuss2 = (ContaBusiness)conta3;
			ContBuss2.emprestimo(200.0);
			System.out.println("Emprestimo feito!");
			
		}
		
		if( conta3 instanceof Poupanca ) {
			Poupanca ContBuss2 = (Poupanca)conta3;
			ContBuss2.atualizaSaldo();
			System.out.println("Conta Atualizada!");
		}
		*/
		
		
		Conta conta1 = new Conta(1001, "X", 2000.0);
		conta1.saque(100.0);
		System.out.println(conta1.getSaldo());
		
		Conta conta2 = new Poupanca(1002, "Zero", 3000.0, 0.01);
		conta2.saque(200.0);
		System.out.println(conta2.getSaldo());
		
		Conta conta3 = new ContaBusiness(1003, "Axl", 2000.0, 500.0);
		conta3.saque(200.0);
		System.out.println(conta3.getSaldo());
	}

}
