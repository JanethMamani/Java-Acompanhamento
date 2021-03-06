package Aplicacion;

import java.util.Locale;
import java.util.Scanner;

import Entidade.Estudante;

public class Executor {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Quantos quartos v?o ser alugados? ");
		int totalQuartos = sc.nextInt();
		sc.nextLine();
		
		//Vetor com objetos aluno com total de Quartos como tamanho
		Estudante [] aluno= new Estudante [9];
		
		
		for(int i=0;i<totalQuartos;i++) {
			System.out.printf("Aluguel #%d:%n",i+1);
			System.out.print("Nome: ");
			String enterNome = sc.nextLine();
			System.out.print("Email: ");
			String enterEmail = sc.nextLine();
			System.out.print("Quarto: ");
			int quarto = sc.nextInt();
			sc.nextLine();
			aluno [quarto] = new Estudante(enterNome, enterEmail, quarto);
			System.out.println();
		}
		
		System.out.println("Quartos ocupados:");
		for(int x=0;x<9;x++) {
			if(aluno[x] != null) {
				System.out.println(aluno[x].getQuarto()
									+ ": "
									+ aluno[x].getNome()
									+ ", "
									+ aluno[x].getEmail());
			}
		}
		
		
		sc.close();
	}

}
