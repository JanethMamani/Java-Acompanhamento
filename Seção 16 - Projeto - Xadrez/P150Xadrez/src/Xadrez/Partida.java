package Xadrez;

import Tabuleiro.Peca;
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
	
	public PecaXadrez moverPecaXadrez(PosicaoXadrez origem, PosicaoXadrez destino) {
		Posicao orig = origem.paraPosicao();
		Posicao dest = destino.paraPosicao();
		validarPosicaoOrigem(orig);
		Peca pecaCapturada = facaMover(orig,dest);
		return (PecaXadrez)pecaCapturada;
	}
	
	private Peca facaMover(Posicao origem, Posicao destino) {
		Peca pecinha = tabua.removerPeca(origem);
		Peca pecaCapturada = tabua.removerPeca(destino);
		tabua.colocarPeca(pecinha, destino);
		return pecaCapturada;
	}
	
	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabua.haUmaPeca(posicao)) {
			throw new ExceptionXadrez("Não há essa posição no tabuleiro de xadrez");
		}
		if(!tabua.peca(posicao).haUmPossivelMovimento()) {
			throw new ExceptionXadrez("Não há movimentos possíveis para a peça escolhida.");
		}
	}
	
	private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabua.colocarPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
	}
	
	private void setupInicial() {
		colocarNovaPeca('e', 8, new Rei(tabua, Cor.BRANCO));
		colocarNovaPeca('a', 8, new Torre(tabua, Cor.BRANCO));
		colocarNovaPeca('h', 8, new Torre(tabua, Cor.BRANCO));
		colocarNovaPeca('e', 1, new Rei(tabua, Cor.PRETO));
		colocarNovaPeca('a', 1, new Torre(tabua, Cor.PRETO));
		colocarNovaPeca('h', 1, new Torre(tabua, Cor.PRETO));
	}
}
