package Xadrez.Pecas;

import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import Xadrez.Cor;
import Xadrez.PecaXadrez;

public class Queen extends PecaXadrez {

	public Queen(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);

	}

	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] malha = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao posi = new Posicao(0, 0);

		// Acima
		posi.setValor(posicao.getLinha() - 1, posicao.getColuna());
		while (getTabuleiro().posicaoExiste(posi) && !getTabuleiro().haUmaPeca(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
			posi.setLinha(posi.getLinha() - 1);
		}
		if (getTabuleiro().posicaoExiste(posi) && haUmaPecaOponente(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}

		// Esquerda
		posi.setValor(posicao.getLinha(), posicao.getColuna() - 1);
		while (getTabuleiro().posicaoExiste(posi) && !getTabuleiro().haUmaPeca(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
			posi.setColuna(posi.getColuna() - 1);
			;
		}
		if (getTabuleiro().posicaoExiste(posi) && haUmaPecaOponente(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}

		// Direita
		posi.setValor(posicao.getLinha(), posicao.getColuna() + 1);
		while (getTabuleiro().posicaoExiste(posi) && !getTabuleiro().haUmaPeca(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
			posi.setColuna(posi.getColuna() + 1);
			;
		}

		if (getTabuleiro().posicaoExiste(posi) && haUmaPecaOponente(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}

		// Abaixo
		posi.setValor(posicao.getLinha() + 1, posicao.getColuna());
		while (getTabuleiro().posicaoExiste(posi) && !getTabuleiro().haUmaPeca(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
			posi.setLinha(posi.getLinha() + 1);
		}
		if (getTabuleiro().posicaoExiste(posi) && haUmaPecaOponente(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}

		// Noroeste
		posi.setValor(posicao.getLinha() - 1, posicao.getColuna() - 1);
		while (getTabuleiro().posicaoExiste(posi) && !getTabuleiro().haUmaPeca(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
			posi.setValor(posi.getLinha() - 1, posi.getColuna() - 1);
		}
		if (getTabuleiro().posicaoExiste(posi) && haUmaPecaOponente(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}

		// Mordeste
		posi.setValor(posicao.getLinha() - 1, posicao.getColuna() + 1);
		while (getTabuleiro().posicaoExiste(posi) && !getTabuleiro().haUmaPeca(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
			posi.setValor(posi.getLinha() - 1, posi.getColuna() + 1);
		}
		if (getTabuleiro().posicaoExiste(posi) && haUmaPecaOponente(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}

		// Sudoeste
		posi.setValor(posicao.getLinha() + 1, posicao.getColuna() - 1);
		while (getTabuleiro().posicaoExiste(posi) && !getTabuleiro().haUmaPeca(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
			posi.setValor(posi.getLinha() + 1, posi.getColuna() - 1);
		}

		if (getTabuleiro().posicaoExiste(posi) && haUmaPecaOponente(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}

		// Sudeste
		posi.setValor(posicao.getLinha() + 1, posicao.getColuna() + 1);
		while (getTabuleiro().posicaoExiste(posi) && !getTabuleiro().haUmaPeca(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
			posi.setValor(posi.getLinha() + 1, posi.getColuna() + 1);
		}
		if (getTabuleiro().posicaoExiste(posi) && haUmaPecaOponente(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}

		return malha;
	}

}