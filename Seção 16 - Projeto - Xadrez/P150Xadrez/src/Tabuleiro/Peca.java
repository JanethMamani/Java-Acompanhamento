package Tabuleiro;

public class Peca {
	
	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null;//Por padrao ja vem nulo
	}
	
	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

}
