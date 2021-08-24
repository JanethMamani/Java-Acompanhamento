package Xadrez;

import Tabuleiro.Tabuleiro;

public class Partida {
	
	private Tabuleiro tabua;
	
	public Partida() {
		tabua = new Tabuleiro(8, 8);
	}
	
	public PecaXadrez[][] preenchePeca(){
		PecaXadrez[][] malha = new PecaXadrez[tabua.getLinhas()][tabua.getColunas()];
		for (int i=0; i<tabua.getLinhas();i++) {
			for(int j=0; j<tabua.getColunas();j++) {
				malha[i][j] = (PecaXadrez) tabua.colocarPeca(i, j);
			}
		}
		return malha;
	}
}
