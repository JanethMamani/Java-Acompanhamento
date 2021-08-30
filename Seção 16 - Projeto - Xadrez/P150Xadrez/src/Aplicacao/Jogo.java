package Aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import Xadrez.ExceptionXadrez;
import Xadrez.Partida;
import Xadrez.PecaXadrez;
import Xadrez.PosicaoXadrez;

public class Jogo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Partida partida = new Partida();
		
		while(true) {
			try {
				UI.clearScreen();
				UI.printTabuleiro(partida.getPecas());
				System.out.println();
				System.out.print("Origem: ");
				PosicaoXadrez origem = UI.LerPosicao(sc);
				
				System.out.println();
				System.out.print("Destino: ");
				PosicaoXadrez destino = UI.LerPosicao(sc);
				
				PecaXadrez pecaCapturada = partida.moverPecaXadrez(origem, destino);
			}
			catch(ExceptionXadrez exc) {
				System.out.println(exc.getMessage());
				sc.nextLine();
			}catch(InputMismatchException entrErro) {
				System.out.println(entrErro.getMessage());
				sc.nextLine();
			}
		}

	}

}
