package Xadrez.Pecas;

import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import Xadrez.Cor;
import Xadrez.PecaXadrez;

public class Peao extends PecaXadrez {
	
	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro,cor);
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] malha = new boolean [getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao posi = new Posicao(0,0);
		if(getCor() == Cor.BRANCO) {
			posi.setValor(posicao.getLinha() -1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(posi) && !getTabuleiro().haUmaPeca(posi)) {
				malha[posi.getLinha()][posi.getColuna()] = true;
			}
			posi.setValor(posicao.getLinha() - 2, posicao.getColuna());
			Posicao posiInitial = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
			if(getTabuleiro().posicaoExiste(posi) && !getTabuleiro().haUmaPeca(posi) && getTabuleiro().posicaoExiste(posiInitial) && !getTabuleiro().haUmaPeca(posi) && getContadorMovimentos()==0) {
				malha[posi.getLinha()][posi.getColuna()] = true;
			}
			posi.setValor(posicao.getLinha() - 1,posicao.getColuna() - 1);
			if(getTabuleiro().posicaoExiste(posi) && getTabuleiro().haUmaPeca(posi)) {
				malha[posi.getLinha()][posi.getColuna()] = true;
			}
			posi.setValor(posicao.getLinha() - 1,posicao.getColuna() + 1);
			if(getTabuleiro().posicaoExiste(posi) && getTabuleiro().haUmaPeca(posi)) {
				malha[posi.getLinha()][posi.getColuna()] = true;
			}
		}
		else {
			posi.setValor(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(posi) && !getTabuleiro().haUmaPeca(posi)) {
				malha[posi.getLinha()][posi.getColuna()] = true;
			}
			posi.setValor(posicao.getLinha() + 2, posicao.getColuna());
			Posicao posiInitial = new Posicao(posicao.getLinha() + 1, posicao.getColuna());
			if(getTabuleiro().posicaoExiste(posi) && !getTabuleiro().haUmaPeca(posi) && getTabuleiro().posicaoExiste(posiInitial) && !getTabuleiro().haUmaPeca(posi) && getContadorMovimentos()==0) {
				malha[posi.getLinha()][posi.getColuna()] = true;
			}
			posi.setValor(posicao.getLinha() + 1,posicao.getColuna() - 1);
			if(getTabuleiro().posicaoExiste(posi) && getTabuleiro().haUmaPeca(posi)) {
				malha[posi.getLinha()][posi.getColuna()] = true;
			}
			posi.setValor(posicao.getLinha() + 1,posicao.getColuna() + 1);
			if(getTabuleiro().posicaoExiste(posi) && getTabuleiro().haUmaPeca(posi)) {
				malha[posi.getLinha()][posi.getColuna()] = true;
			}
		}
		
		return malha;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
