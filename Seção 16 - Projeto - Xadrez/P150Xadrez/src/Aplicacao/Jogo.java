package Aplicacao;

import java.util.Scanner;

import Xadrez.Partida;
import Xadrez.PecaXadrez;
import Xadrez.PosicaoXadrez;

public class Jogo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Partida partida = new Partida();
		
		while(true) {
			UI.printTabuleiro(partida.getPecas());
			System.out.println();
			System.out.print("Origem: ");
			PosicaoXadrez origem = UI.LerPosicao(sc);
			
			System.out.println();
			System.out.print("Destino: ");
			PosicaoXadrez destino = UI.LerPosicao(sc);
			
			PecaXadrez pecaCapturada = partida.moverPecaXadrez(origem, destino);
		}

	}

}
