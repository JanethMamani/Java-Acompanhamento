package Xadrez.Pecas;

import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import Xadrez.Cor;
import Xadrez.PecaXadrez;

public class Rei extends PecaXadrez {

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "R";
	}

	private boolean podeMover(Posicao posicao) {
		PecaXadrez pecinha = (PecaXadrez) getTabuleiro().peca(posicao);
		return pecinha == null || pecinha.getCor() != getCor();
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] malha = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao posi = new Posicao(0, 0);

		// Acima
		posi.setValor(posicao.getLinha() - 1, posicao.getColuna());
		if (getTabuleiro().posicaoExiste(posi) && podeMover(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}
		// Abaixo
		posi.setValor(posicao.getLinha() + 1, posicao.getColuna());
		if (getTabuleiro().posicaoExiste(posi) && podeMover(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}
		// Esquerda
		posi.setValor(posicao.getLinha(), posicao.getColuna() - 1);
		if (getTabuleiro().posicaoExiste(posi) && podeMover(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}
		// Direita
		posi.setValor(posicao.getLinha(), posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExiste(posi) && podeMover(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}
		// NO
		posi.setValor(posicao.getLinha() - 1, posicao.getColuna() - 1);
		if (getTabuleiro().posicaoExiste(posi) && podeMover(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}
		// NE
		posi.setValor(posicao.getLinha() - 1, posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExiste(posi) && podeMover(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}
		// SO
		posi.setValor(posicao.getLinha() + 1, posicao.getColuna() - 1);
		if (getTabuleiro().posicaoExiste(posi) && podeMover(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}
		// SE
		posi.setValor(posicao.getLinha() + 1, posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExiste(posi) && podeMover(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}
		return malha;
	}

}
