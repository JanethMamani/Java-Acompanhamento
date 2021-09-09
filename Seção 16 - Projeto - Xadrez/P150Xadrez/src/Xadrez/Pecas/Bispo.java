package Xadrez.Pecas;

import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import Xadrez.Cor;
import Xadrez.PecaXadrez;

public class Bispo extends PecaXadrez{

	public Bispo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		
	}
	
	@Override
	public String toString() {
		return "B";
	}
	
	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] malha = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao posi = new Posicao(0, 0);
		
		//Noroeste
		posi.setValor(posicao.getLinha() - 1, posicao.getColuna() - 1);
		while (getTabuleiro().posicaoExiste(posi) && !getTabuleiro().haUmaPeca(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
			posi.setValor(posi.getLinha() - 1, posi.getColuna() - 1);
		}
		if (getTabuleiro().posicaoExiste(posi) && haUmaPecaOponente(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}
		
		//Mordeste
		posi.setValor(posicao.getLinha() - 1, posicao.getColuna() + 1);
		while (getTabuleiro().posicaoExiste(posi) && !getTabuleiro().haUmaPeca(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
			posi.setValor(posi.getLinha() - 1, posi.getColuna() + 1);
		}
		if (getTabuleiro().posicaoExiste(posi) && haUmaPecaOponente(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}
		
		//Sudoeste
		posi.setValor(posicao.getLinha() + 1, posicao.getColuna() - 1);
		while (getTabuleiro().posicaoExiste(posi) && !getTabuleiro().haUmaPeca(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
			posi.setValor(posi.getLinha() + 1, posi.getColuna() - 1);
		}
		
		if (getTabuleiro().posicaoExiste(posi) && haUmaPecaOponente(posi)) {
			malha[posi.getLinha()][posi.getColuna()] = true;
		}
		
		//Sudeste
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