package Xadrez.Pecas;

import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import Xadrez.Cor;
import Xadrez.Partida;
import Xadrez.PecaXadrez;

public class Peao extends PecaXadrez {
	
	private Partida partida;
	
	public Peao(Tabuleiro tabuleiro, Cor cor, Partida partida) {
		super(tabuleiro,cor);
		this.partida = partida;
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
			if(getTabuleiro().posicaoExiste(posi) && getTabuleiro().haUmaPeca(posi) && !(getCor() == Cor.PRETO)) {
				malha[posi.getLinha()][posi.getColuna()] = true;
			}
			posi.setValor(posicao.getLinha() - 1,posicao.getColuna() + 1);
			if(getTabuleiro().posicaoExiste(posi) && getTabuleiro().haUmaPeca(posi) && !(getCor() == Cor.PRETO)) {
				malha[posi.getLinha()][posi.getColuna()] = true;
			}
			
			//En passant
			if(posicao.getLinha() == 3) {
				Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
				if (getTabuleiro().posicaoExiste(esquerda) && haUmaPecaOponente(esquerda) && getTabuleiro().peca(esquerda) == partida.getEnPassantVulneravel()) {
					malha[esquerda.getLinha() - 1][esquerda.getColuna()] = true;
				}
				Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
				if (getTabuleiro().posicaoExiste(direita) && haUmaPecaOponente(direita) && getTabuleiro().peca(direita) == partida.getEnPassantVulneravel()) {
					malha[direita.getLinha() - 1][direita.getColuna()] = true;
				}
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
			if(getTabuleiro().posicaoExiste(posi) && getTabuleiro().haUmaPeca(posi) && !(getCor() == Cor.BRANCO)) {
				malha[posi.getLinha()][posi.getColuna()] = true;
			}
			posi.setValor(posicao.getLinha() + 1,posicao.getColuna() + 1);
			if(getTabuleiro().posicaoExiste(posi) && getTabuleiro().haUmaPeca(posi) && !(getCor() == Cor.BRANCO)) {
				malha[posi.getLinha()][posi.getColuna()] = true;
			}
			
			//En passant
			if(posicao.getLinha() == 4) {
				Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
				if (getTabuleiro().posicaoExiste(esquerda) && haUmaPecaOponente(esquerda) && getTabuleiro().peca(esquerda) == partida.getEnPassantVulneravel()) {
					malha[esquerda.getLinha() + 1][esquerda.getColuna()] = true;
				}
				Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
				if (getTabuleiro().posicaoExiste(direita) && haUmaPecaOponente(direita) && getTabuleiro().peca(direita) == partida.getEnPassantVulneravel()) {
					malha[direita.getLinha() + 1][direita.getColuna()] = true;
				}
			}
		}
		
		return malha;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
