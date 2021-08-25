package Xadrez;

import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import Xadrez.Pecas.Rei;
import Xadrez.Pecas.Torre;

public class Partida {
	
	private Tabuleiro tabua;
	
	public Partida() {
		tabua = new Tabuleiro(8, 8);
		setupInicial();
	}
	
	public PecaXadrez[][] getPecas(){
		PecaXadrez[][] malha = new PecaXadrez[tabua.getLinhas()][tabua.getColunas()];
		for (int i=0; i<tabua.getLinhas(); i++) {
			for(int j=0; j<tabua.getColunas(); j++) {
				malha[i][j] = (PecaXadrez) tabua.peca(i, j);
			}
		}
		return malha;
	}
	
	private void setupInicial() {
		tabua.colocarPeca(new Torre(tabua, Cor.PRETO), new Posicao(0,0));
		tabua.colocarPeca(new Rei(tabua, Cor.PRETO), new Posicao(0,4));
		tabua.colocarPeca(new Rei(tabua, Cor.BRANCO), new Posicao(7,4));
	}
}
