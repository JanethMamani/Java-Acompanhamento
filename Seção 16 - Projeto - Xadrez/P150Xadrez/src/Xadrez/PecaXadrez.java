package Xadrez;

import Tabuleiro.Peca;
import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca{
	
	private Cor cor;
	private int contadorMovimentos;

	public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}
	
	public Cor getCor() {
		return cor;
	}
	
	public int getContadorMovimentos() {
		return contadorMovimentos;
	}
	
	public void incrementaContadorMovimentos() {
		contadorMovimentos++;
	}
	
	public void decrementaContadorMovimentos() {
		contadorMovimentos--;
	}
	
	public PosicaoXadrez getPosicaoXadrez() {
		return PosicaoXadrez.daPosicao(posicao);
	}
	
	protected boolean haUmaPecaOponente(Posicao posicao) {
		PecaXadrez pecinha = (PecaXadrez)getTabuleiro().peca(posicao);
		return pecinha != null && pecinha.getCor() != cor;
	}
}
