package Xadrez.Pecas;

import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import Xadrez.Cor;
import Xadrez.Partida;
import Xadrez.PecaXadrez;

public class Rei extends PecaXadrez {
	
	private Partida partida;

	public Rei(Tabuleiro tabuleiro, Cor cor, Partida partida) {
		super(tabuleiro, cor);
		this.partida = partida;
	}

	@Override
	public String toString() {
		return "R";
	}

	private boolean podeMover(Posicao posicao) {
		PecaXadrez pecinha = (PecaXadrez) getTabuleiro().peca(posicao);
		return pecinha == null || pecinha.getCor() != getCor();
	}
	
	private boolean testeRoque(Posicao posicao) {
		PecaXadrez pecinha = (PecaXadrez)getTabuleiro().peca(posicao);
		return pecinha != null && pecinha instanceof Torre && pecinha.getCor() == getCor() && pecinha.getContadorMovimentos() == 0;
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
		
		// Special Roque
		if(getContadorMovimentos() == 0 && !partida.getCheque()) {
			//KingSide
			Posicao posi1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 3);
			if(testeRoque(posi1)) {
				Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
				Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() + 2);
				if(getTabuleiro().peca(p1) == null && getTabuleiro().peca(p2) == null) {
					malha[posicao.getLinha()][posicao.getColuna() + 2] = true;
				}
			}
			//QueenSide
			Posicao posi2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 4);
			if(testeRoque(posi2)) {
				Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
				Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 2);
				Posicao p3 = new Posicao(posicao.getLinha(), posicao.getColuna() - 3);
				if(getTabuleiro().peca(p1) == null && getTabuleiro().peca(p2) == null && getTabuleiro().peca(p3) == null) {
					malha[posicao.getLinha()][posicao.getColuna() - 2] = true;
				}
			}
		}
		return malha;
	}

}
