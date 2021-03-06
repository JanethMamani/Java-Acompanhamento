package Aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Xadrez.ExceptionXadrez;
import Xadrez.Partida;
import Xadrez.PecaXadrez;
import Xadrez.PosicaoXadrez;

public class Jogo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Partida partida = new Partida();
		List<PecaXadrez> capturados = new ArrayList<>();
		
		while(!partida.getXequemate()) {
			try {
				UI.clearScreen();
				UI.imprimirPartida(partida, capturados);;
				System.out.println();
				System.out.print("Origem: ");
				PosicaoXadrez origem = UI.LerPosicao(sc);
				
				boolean[][] moviPossiveis = partida.movimentosPossiveis(origem);
				UI.clearScreen();
				UI.printTabuleiro(partida.getPecas(), moviPossiveis);
				System.out.println();
				System.out.print("Destino: ");
				PosicaoXadrez destino = UI.LerPosicao(sc);
				
				PecaXadrez pecaCapturada = partida.moverPecaXadrez(origem, destino);
				
				if (pecaCapturada != null) {
					capturados.add(pecaCapturada);
				}
				
				if (partida.getPromocao() != null) {
					System.out.print("Entre com a peca para promocao(B/C/T/Q): ");
					String tipo = sc.nextLine().toUpperCase();
					while (!tipo.equals("B") && !tipo.equals("C") && !tipo.equals("T") & !tipo.equals("Q")) {
						System.out.print("Tipo invalido! Entre com tipo para promocao (B/C/T/Q): ");
						tipo = sc.nextLine().toUpperCase();
					}
					partida.trocarPecaPromovida(tipo);
				}
			}
			catch(ExceptionXadrez exc) {
				System.out.println(exc.getMessage());
				sc.nextLine();
			}catch(InputMismatchException entrErro) {
				System.out.println(entrErro.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.imprimirPartida(partida, capturados);

	}

}
