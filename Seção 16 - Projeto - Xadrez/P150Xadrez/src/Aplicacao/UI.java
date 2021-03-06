package Aplicacao;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Xadrez.Cor;
import Xadrez.Partida;
import Xadrez.PecaXadrez;
import Xadrez.PosicaoXadrez;

public class UI {
	
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

		public static final String ANSI_RESET = "\u001B[0m";
		public static final String ANSI_BLACK = "\u001B[30m";
		public static final String ANSI_RED = "\u001B[31m";
		public static final String ANSI_GREEN = "\u001B[32m";
		public static final String ANSI_YELLOW = "\u001B[33m";
		public static final String ANSI_BLUE = "\u001B[34m";
		public static final String ANSI_PURPLE = "\u001B[35m";
		public static final String ANSI_CYAN = "\u001B[36m";
		public static final String ANSI_WHITE = "\u001B[37m";

		public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
		public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
		public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
		public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
		public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
		public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
		public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
		public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
		
		// https://stackoverflow.com/questions/2979383/java-clear-the-console
		public static void clearScreen() {
			System.out.print("\033[H\033[2J");
			System.out.flush();
		}	
		
	public static PosicaoXadrez LerPosicao(Scanner sc) {
		try {
			String pos = sc.nextLine();
			char coluna = pos.charAt(0);
			int linha = Integer.parseInt(pos.substring(1));
			return new PosicaoXadrez(coluna, linha);
		}
		catch(RuntimeException excep) {
			throw new InputMismatchException("Erro ao ler posi??o do xadrez.");
		}
	}
	
	public static void imprimirPartida(Partida partida, List<PecaXadrez> capturados) {
		printTabuleiro(partida.getPecas());
		System.out.println();
		imprimirPecaCapturada(capturados);
		System.out.println();
		System.out.println("Turno: "+ partida.getTurno());
		
		if (!partida.getXequemate()) {
			System.out.println("Esperando Jogador: " + partida.getJogador());
			if (partida.getCheque()) {
				System.out.println("Xeque!");
			}
		}
		else {
			System.out.println("Xequemate!");
			System.out.println("Vencedor: " + partida.getJogador());
		}
	}
	
	public static void printTabuleiro(PecaXadrez[][] pecas) {
		for (int i=0; i<pecas.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j=0; j<pecas.length; j++) {
				printPeca(pecas[i][j], false);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	public static void printTabuleiro(PecaXadrez[][] pecas, boolean[][] movePossiveis) {
		for (int i=0; i<pecas.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j=0; j<pecas.length; j++) {
				printPeca(pecas[i][j], movePossiveis[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	public static void printPeca(PecaXadrez peca, boolean fundo) {
		if(fundo) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
		if (peca == null) {
			System.out.print("-" + ANSI_RESET);
		}
		else {
			if(peca.getCor() == Cor.BRANCO) {
				System.out.print(ANSI_WHITE + peca +ANSI_RESET);
			}
			else{
				System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
			}
		}
		System.out.print(" ");
	}
	
	private static void imprimirPecaCapturada(List<PecaXadrez> capturados) {
		List<PecaXadrez> brancos = capturados.stream().filter(x -> x.getCor() == Cor.BRANCO).collect(Collectors.toList());
		List<PecaXadrez> pretos = capturados.stream().filter(x -> x.getCor() == Cor.PRETO).collect(Collectors.toList());
		System.out.println("Pe?as capturadas: ");
		System.out.print("Branco: ");
		System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(brancos.toArray()));
		System.out.print(ANSI_RESET);
		System.out.print("Preto: ");
		System.out.print(ANSI_YELLOW);
		System.out.println(Arrays.toString(pretos.toArray()));
		System.out.print(ANSI_RESET);
	}

}