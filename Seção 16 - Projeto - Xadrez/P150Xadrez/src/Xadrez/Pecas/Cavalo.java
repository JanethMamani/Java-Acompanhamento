package Xadrez.Pecas;

import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import Xadrez.Cor;
import Xadrez.PecaXadrez;

public class Cavalo extends PecaXadrez {

	public Cavalo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "C";
	}

	private boolean podeMover(Posicao posicao) {
		PecaXadrez pecinha = (PecaXadrez) getTabuleiro().peca(posicao);
		return pecinha == null || pecinha.getCor() != getCor();
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] malha = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao posi = new Posicao(0, 0);

		
		posi.setValor(posicao.getLinha() - 1, posicao.getColuna() - 2);
		if (getTabuleiro().posicaoExiste(posi) && podeMover(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}
		
		posi.setValor(posicao.getLinha() - 2, posicao.getColuna() - 1);
		if (getTabuleiro().posicaoExiste(posi) && podeMover(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}
		
		posi.setValor(posicao.getLinha() - 2, posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExiste(posi) && podeMover(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}
		
		posi.setValor(posicao.getLinha() - 1, posicao.getColuna() + 2);
		if (getTabuleiro().posicaoExiste(posi) && podeMover(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}
		
		posi.setValor(posicao.getLinha() + 1, posicao.getColuna() + 2);
		if (getTabuleiro().posicaoExiste(posi) && podeMover(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}
		
		posi.setValor(posicao.getLinha() + 2, posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExiste(posi) && podeMover(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}
		
		posi.setValor(posicao.getLinha() + 2, posicao.getColuna() - 1);
		if (getTabuleiro().posicaoExiste(posi) && podeMover(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}
		
		posi.setValor(posicao.getLinha() + 1, posicao.getColuna() - 2);
		if (getTabuleiro().posicaoExiste(posi) && podeMover(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}
		return malha;
	}

}